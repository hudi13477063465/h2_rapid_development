package com.boot.security.server.model.vo;

import com.boot.security.server.model.SubjectOption;

import java.util.List;

/**
 * @Title: 题目
 * @Description:
 * @Company:
 * @Author: hudi9
 * @Create: Date:2020年10月24日
 */
public class SubjectVo {

    private Integer sort;

    private Integer id;

    private Integer type;

    private String subjectContent;

    private String rightAnswer;

    private String sharedQuestion;

    public String getSharedQuestion() {
        return sharedQuestion;
    }

    public void setSharedQuestion(String sharedQuestion) {
        this.sharedQuestion = sharedQuestion;
    }

    private List<SubjectOption> options;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSubjectContent() {
        return subjectContent;
    }

    public void setSubjectContent(String subjectContent) {
        this.subjectContent = subjectContent;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<SubjectOption> getOptions() {
        return options;
    }

    public void setOptions(List<SubjectOption> options) {
        this.options = options;
    }
}
