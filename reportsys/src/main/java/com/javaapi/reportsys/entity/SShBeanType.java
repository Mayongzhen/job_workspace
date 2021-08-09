package com.javaapi.reportsys.entity;

import java.util.List;

public class SShBeanType {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SShBean> getData() {
        return data;
    }

    public void setData(List<SShBean> data) {
        this.data = data;
    }

    int code;
    int count;
    String msg;
    List<SShBean> data;

}
