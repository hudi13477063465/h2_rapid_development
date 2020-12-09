package com.boot.security.server.mapper;

import com.boot.security.server.model.Subject;
import com.boot.security.server.model.SubjectOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @Company:
 * @Author: hudi9
 * @Create: Date:2020年10月24日
 */
@Mapper
public interface SubjectOptionMapper {

    /**
     * 批量插入
     *
     * @param opts
     * @return
     */
    int batchInsert(@Param("opts") List<SubjectOption> opts);

    /**
     * c
     * @return
     */
    List<SubjectOption> getAll();

    /**
     * 清空
     * @return
     */
    int delete();

}
