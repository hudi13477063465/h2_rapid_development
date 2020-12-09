package com.boot.security.server.model;

/**
 * @Title: 题目
 * @Description:
 * @Company:
 * @Author: hudi9
 * @Create: Date:2020年10月24日
 */
public class Subject {

    private Integer sort;

    private Integer id;

    private Integer type;

    private String subjectContent;

    private String sharedQuestion;

    private String rightAnswer;

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

    public String getSharedQuestion() {
        return sharedQuestion;
    }

    public void setSharedQuestion(String sharedQuestion) {
        this.sharedQuestion = sharedQuestion;
    }
}
