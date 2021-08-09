package com.javaapi.reportsys.entity;

public class FlowReBean {
    @Override
    public String toString() {
        return "FlowReBean{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", responese='" + responese + '\'' +
                ", responset='" + responset + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public FlowReBean(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public String getResponset() {
        return responset;
    }

    public void setResponset(String responset) {
        this.responset = responset;
    }

    public FlowReBean() {
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResponese() {
        return responese;
    }

    public void setResponese(String responese) {
        this.responese = responese;
    }

    String id;
    String url;
    String method;
    String responese;
    String responset;
}
