//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.boot.security.server.model;

public class RestResponse<T> {
    private String code;
    private String msg;
    private T data;
    private long timestamp;

    public RestResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    public RestResponse(T data) {
        this.code = "0000";
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public RestResponse(String code, T data) {
        this.code = code;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public RestResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        this.timestamp = System.currentTimeMillis();
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public boolean isSuccess() {
        return "0000".equals(this.code);
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
