package com.javaapi.reportsys.entity;

public enum MethordType {
    GET("GET",1), HEAD("HEAD", 2), POST("POST", 3), PUT("PUT", 4), PATCH("PATCH",5),DELETE("DELETE",6),OPTIONS("OPTIONS",7),TRACE("TRACE",8);

    MethordType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 成员变量
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    private int index;

}
