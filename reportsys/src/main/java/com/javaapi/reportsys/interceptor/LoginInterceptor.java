package com.javaapi.reportsys.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
 //获取色素session里的登录状态值
    String  islogin= (String) request.getSession().getAttribute("islogin");
       if(islogin!=null){
          return true;
       }else{
           try {
               response.sendRedirect("/login");
           }catch ( Exception e){
               System.out.println(e.getMessage());
           }
           return false;
       }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
