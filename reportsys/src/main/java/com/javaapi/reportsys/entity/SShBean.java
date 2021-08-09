package com.javaapi.reportsys.entity;

public class SShBean {
private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGoreplaydir() {
        return goreplaydir;
    }

    public void setGoreplaydir(String goreplaydir) {
        this.goreplaydir = goreplaydir;
    }
    private String port;

    public int getReplaystatus() {
        return replaystatus;
    }

    public void setReplaystatus(int replaystatus) {
        this.replaystatus = replaystatus;
    }

    private String ip;
private String username;
private String password;
private String goreplaydir;
private int replaystatus;

    public String getRecodeport() {
        return recodeport;
    }

    public void setRecodeport(String recodeport) {
        this.recodeport = recodeport;
    }

    private String recodeport;



}
