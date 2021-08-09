package com.javaapi.reportsys.controller;

import com.javaapi.reportsys.entity.User;
import com.javaapi.reportsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.AddressingFeature;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/user", method = RequestMethod.POST)
    public String getLoginCl( final HttpServletRequest request,@RequestParam("phone") String phone, @RequestParam("password") String password){
        User user;
        user= userService.finduser(phone,password); //调用service层的方法
        System.out.println(phone);
        System.out.println(password);
        if(user==null){
           return "redirect:login";
        }
        request.getSession().setAttribute("islogin","OK");
        return "redirect:home";
    }
    @RequestMapping(value = "/home")
    public String home() {
        return "main3";
    }
    @RequestMapping(value="/login")
    public String login(){
       return "login";
    }
    @RequestMapping(value="/loginout",method=RequestMethod.GET)
    public String LoginOut(HttpServletRequest request){
        request.getSession().removeAttribute("islogin");
             return "redirect:/login";
    }
    @RequestMapping(value = "/apitest")
    public String apitest() {
        return "apitest";
    }
    @RequestMapping(value = "/flowdatareplay")
    public String grafanaurl() {
        return "flowdatareplay";
    }
    @RequestMapping(value = "/replayanddiff")
    public String replay() {
        return "ReplayAndDiff";
    }
}
