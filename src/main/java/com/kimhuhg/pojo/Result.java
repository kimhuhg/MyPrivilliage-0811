package com.kimhuhg.pojo;

/**
 * Created by kimhuhg@163.com on 2017/8/4.
 * 返回结果的格式化类
 */
public class Result<T> {
    private Integer status = 1;
    private String msg = "请求成功!";
    private T response;

    public Result() {
    }

    public Result(T response) {
        this.response = response;
    }

    public Result(Integer status, T response) {
        this.status = status;
        this.msg = "请求失败!";
        this.response = response;
    }

    public Result(Integer status, String msg, T response) {
        this.status = status;
        this.msg = msg;
        this.response = response;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
