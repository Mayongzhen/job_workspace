package com.javaapi.reportsys.entity;

import java.util.List;

public class TestCaseType {
    int code;
    int count;
    String msg;
    List<TestCase> data;
    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "TestCaseType{" +
                "code=" + code +
                ", count=" + count +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
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

    public List<TestCase> getData() {
        return data;
    }

    public void setData(List<TestCase> data) {
        this.data = data;
    }




}
