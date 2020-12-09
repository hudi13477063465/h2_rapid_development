package com.boot.security.server.controller;

import com.boot.security.server.mapper.SubjectMapper;
import com.boot.security.server.mapper.SubjectOptionMapper;
import com.boot.security.server.model.Subject;
import com.boot.security.server.model.SubjectOption;
import com.boot.security.server.model.vo.SubjectVo;
import com.boot.security.server.util.ReturnUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * @author hudi9
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {


    @Resource
    private SubjectMapper subjectMapper;

    @Resource
    private SubjectOptionMapper subjectOptionMapper;


    @SuppressWarnings("unchecked")
    @GetMapping("/getAll")
    public Map<String, Object> getAll(@Param("type") Integer type)
            throws Exception {
        List<SubjectVo> subjects = subjectMapper.getAllByType(type);
        List<SubjectOption> options = subjectOptionMapper.getAll();
        Map<Integer, List<SubjectOption>> groupBy = options.stream().collect(Collectors.groupingBy(SubjectOption::getSubjectSort));
        for (SubjectVo subject : subjects) {
            subject.setOptions(groupBy.get(subject.getSort()));
        }
        return ReturnUtils.success("subjects", subjects);
    }


    @GetMapping("/clear")
    public Map<String, Object> clear() {
        if (subjectMapper.delete() >= 0) {
            subjectOptionMapper.delete();
            return ReturnUtils.success();
        }
        return ReturnUtils.fail();
    }

}
