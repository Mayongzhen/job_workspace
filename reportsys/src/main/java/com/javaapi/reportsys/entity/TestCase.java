package com.javaapi.reportsys.entity;

import java.io.Serializable;

public class TestCase implements Serializable {



    private int id;
    private String protocol;
    private String ServerOrIP;
    private String port;

    public String getParamter() {
        return Paramter;
    }

    public void setParamter(String paramter) {
        Paramter = paramter;
    }

    private int method;
    private String Path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String Header;
    private String Encode;
    private String Parametric;
    private String Paramter;
    private String Assert;
    private String ApiName;

    @Override
    public String toString() {
        return "TestCase{" +
                "caseid=" + id +
                ", protocol='" + protocol + '\'' +
                ", ServerOrIP='" + ServerOrIP + '\'' +
                ", port='" + port + '\'' +
                ", method=" + method +
                ", Path='" + Path + '\'' +
                ", Header='" + Header + '\'' +
                ", Encode='" + Encode + '\'' +
                ", Parametric='" + Parametric + '\'' +
                ", Paramter='" + Paramter + '\'' +
                ", Assert='" + Assert + '\'' +
                ", ApiName='" + ApiName + '\'' +
                '}';
    }



    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getServerOrIP() {
        return ServerOrIP;
    }

    public void setServerOrIP(String serverOrIP) {
        ServerOrIP = serverOrIP;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public String getEncode() {
        return Encode;
    }

    public void setEncode(String encode) {
        Encode = encode;
    }

    public String getParametric() {
        return Parametric;
    }

    public void setParametric(String parametric) {
        Parametric = parametric;
    }


    public String getAssert() {
        return Assert;
    }

    public void setAssert(String anAssert) {
        Assert = anAssert;
    }

    public String getApiName() {
        return ApiName;
    }

    public void setApiName(String apiName) {
        ApiName = apiName;
    }


}