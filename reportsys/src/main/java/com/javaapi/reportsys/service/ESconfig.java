package com.javaapi.reportsys.service;

import com.javaapi.reportsys.entity.EsgorProperties;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;


import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ESconfig {
    @Autowired
    private EsgorProperties esgorProperties;

    @Bean
    public TransportClient elClient() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();// 集群名
        //创建client
        TransportClient
        client  = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(esgorProperties.getGorip()), esgorProperties.getGorport()));

      return client;
    }



}
