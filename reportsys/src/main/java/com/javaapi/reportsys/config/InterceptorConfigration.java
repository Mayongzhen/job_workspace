package com.javaapi.reportsys.config;

import com.javaapi.reportsys.interceptor.LoginInterceptor;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.InetAddress;
import java.net.UnknownHostException;


@Configuration
public class InterceptorConfigration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

     registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
               .excludePathPatterns("/","/login")
                .excludePathPatterns("/","/user")
               .excludePathPatterns("/","/queryAll")
               /* .excludePathPatterns("/","/addcase")

               /* .excludePathPatterns("/","/findallCases")
                .excludePathPatterns("/","/SelectCase")
                .excludePathPatterns("/","/UpdateCase")
                .excludePathPatterns("/","/DeleteCase")*/
               .excludePathPatterns(
                       "/**/*.html", //html静态资源
                       "/**/*.js",//js静态资源
                     "/**/*.jpg",  //css静态资源
                      "/**/*.css");

    }




}