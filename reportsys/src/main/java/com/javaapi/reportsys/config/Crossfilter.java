package com.javaapi.reportsys.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Crossfilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse ser = (HttpServletResponse) servletResponse;
        //*号表示对所有请求都允许跨域访问
        ser.addHeader("Access-Control-Allow-Origin", "172.16.16.*:80");
        ser.addHeader("Access-Control-Allow-Methods", "*");
        ser.addHeader("Access-Control-Allow-Credentials","true");
        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {

    }
}
