package com.boot.security.server.controller;

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

import com.boot.security.server.mapper.SubjectMapper;
import com.boot.security.server.mapper.SubjectOptionMapper;
import com.boot.security.server.model.Subject;
import com.boot.security.server.model.SubjectOption;
import com.boot.security.server.util.ReturnUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


/**
 * @author hudi9
 */
@RestController
@RequestMapping("/files")
public class FileController {


    @Resource
    private SubjectMapper subjectMapper;

    @Resource
    private SubjectOptionMapper subjectOptionMapper;

    private static final String UPLOAD_SUB_PATH = "/uploadFile";

    private static final String[] keyWords = {"单选题", "多选题", "参考答案", "共享题干题"};

    @SuppressWarnings("unchecked")
    @PostMapping("/upload")
    public Map<String, Object> uploadFile(MultipartFile file)
            throws Exception {
        File dest = null;
        FileInputStream fileInputStream = null;
        try {
            // 在eclipse中是项目根路径
            String fileName = file.getOriginalFilename();
            String path = System.getProperty("user.dir") + UPLOAD_SUB_PATH;
            File p = new File(path);
            if (!p.exists()) {
                p.mkdirs();
            }
            dest = new File(path + "/" + fileName);
            // 保存文件
            file.transferTo(dest);
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(dest), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            //初始化题
            String data = doSubjectSave(bufferedReader);
            dest.delete();
        } finally {
            if (dest != null) {
                dest.delete();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
                fileInputStream = null;
            }
        }
        return ReturnUtils.success();
    }

    @Transactional(rollbackFor = Exception.class)
    public String doSubjectSave(BufferedReader bufferedReader) throws IOException {
        String line = null;
        StringBuilder sb = new StringBuilder();
        int type = 1;
        List<Subject> subjects = new ArrayList<>();
        List<SubjectOption> options = new ArrayList<>();
        Map<Integer, String> answerMap = new HashMap<>();
        Map<Integer, String> sharedQuestionMap = new HashMap<>();
        Integer sort = 0;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();
            sb.append(line);
            if (StringUtils.isBlank(line)) {
                continue;
            }
            if (line.contains(keyWords[1])) {
                type = 2;
            }
            if (isStartWithNumber(line)) {
                //题目和答案
                sort = Integer.valueOf(line.substring(0, line.indexOf(".")));
                if (line.indexOf("。") != -1) {
                    Subject subject = new Subject();
                    subject.setSubjectContent(line.substring(line.indexOf(".") + 1));
                    subject.setType(type);
                    subject.setSort(sort);
                    subjects.add(subject);
                } else {
                    //正确答案
                    answerMap.put(sort, line.substring(line.indexOf(".") + 1).trim());
                }
            } else if (isStartWithLetter(line)) {
                //选项
                SubjectOption subjectOption = new SubjectOption();
                String code = String.valueOf(line.charAt(0));
                subjectOption.setCode(code);
                subjectOption.setOptionContent(line.replace(code, ""));
                subjectOption.setSubjectSort(sort);
                options.add(subjectOption);
            } else if (line.startsWith("#")) {
                //共享题干题
                sharedQuestionMap.put(sort, line.substring(line.indexOf("#") + 1).trim());
            }
        }
        for (Subject subject : subjects) {
            String answer = answerMap.get(subject.getSort());
            String shardQuestion = sharedQuestionMap.get(subject.getSort()-1);
            if (answer != null) {
                subject.setRightAnswer(answer.trim());
            }
            if (shardQuestion != null) {
                subject.setSharedQuestion(shardQuestion.trim());
            }
        }
        subjectMapper.batchInsert(subjects);
        subjectOptionMapper.batchInsert(options);
        return sb.toString();
    }

    //判断字符串是不是以数字开头
    public static boolean isStartWithNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str.charAt(0) + "");
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    //判断字符串是不是以大写字母开头
    public static boolean isStartWithLetter(String str) {
        Pattern pattern = Pattern.compile("[A-Z]*");
        Matcher isNum = pattern.matcher(str.charAt(0) + "");
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

//    public static void main(String[] args) throws Exception {
//        File file = new File("C:\\Users\\hudi9\\Desktop\\1.txt");
//
//        InputStreamReader read = new InputStreamReader(
//                new FileInputStream(file), "UTF-8");
//        BufferedReader bufferedReader = new BufferedReader(read);
//        String line = null;
//        int index = 0;
//        while ((line = bufferedReader.readLine()) != null) {
//            line = line.trim();
//            if (line.contains("参考答案")) {
//                index++;
//                line = line.replace("参考答案", index + ".");
//                System.out.println(line);
//            }
//        }


    //}
}
