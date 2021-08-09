package com.javaapi.reportsys.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EsgorProperties {
    public String getGorip() {
        return gorip;
    }

    public void setGorip(String gorip) {
        this.gorip = gorip;
    }


    public int getGorport() {
        return gorport;
    }

    public void setGorport(int gorport) {
        this.gorport = gorport;
    }

    @Value("${gor.ip.info}")
private String gorip;
@Value("${gor.port.info}")
private int gorport;



}
