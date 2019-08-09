package com.qf.utils;

import lombok.Data;

@Data
public class DataView<T> {
    private int code;
    private String msg;
    private T data;

    public DataView() {
    }

    public DataView(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
