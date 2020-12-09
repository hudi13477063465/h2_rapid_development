package com.boot.security.server.mapper;

import com.boot.security.server.model.Subject;
import com.boot.security.server.model.vo.SubjectVo;
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
public interface SubjectMapper {

    /**
     * 批量插入
     *
     * @param subs
     * @return
     */
    int batchInsert(@Param("subs") List<Subject> subs);

    /**
     * 查询
     *
     * @param type
     * @return
     */
    List<SubjectVo> getAllByType(@Param("type") Integer type);

    /**
     * 清空
     * @return
     */
    int delete();

    /**
     * 修改答案
     *
     * @param sub
     * @return
     */
    int updateAnswer(Subject sub);
}
