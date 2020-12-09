package com.boot.security.server.model;

/**
 * @Title: 题目选项
 * @Description:
 * @Company:
 * @Author: hudi9
 * @Create: Date:2020年10月24日
 */
public class SubjectOption {

    private Integer subjectSort;

    private String code;

    private String optionContent;

    private Integer id;

    public Integer getSubjectSort() {
        return subjectSort;
    }

    public void setSubjectSort(Integer subjectSort) {
        this.subjectSort = subjectSort;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
