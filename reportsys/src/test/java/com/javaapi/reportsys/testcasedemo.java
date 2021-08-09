package com.javaapi.reportsys;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javaapi.reportsys.entity.TestCase;

import com.javaapi.reportsys.mapper.TestCaseMapper;
import com.javaapi.reportsys.service.TestCaseService;

import com.javaapi.reportsys.utils.HttpClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;


@RunWith(SpringRunner.class)
@SpringBootTest()
public class testcasedemo<main> {

  /*  @Autowired
    private TestCaseService testCaseService;*/

    @Test
  public  void run(){


 /*       TestCase testCase=new TestCase();
        testCase.setApiName("beijinghuanyingni");
        testCase.setProtocol("https");
        testCase.setHeader("2222222222222");
        testCase.setAssert("22");
        testCase.setParametric("2222222");*/
        //testCaseService.Save(testCase);
  /*      JSONObject.parse(str).toString();*/


    //    String json=  JSONObject.parse("{\"ServerOrIP\":\"172.16.16.58\"}").toString();
    //    String info = JSON.toJSONString(testCase);



   //   String string=HttpClientUtils.requestByPostJson("http://localhost:9999/addcase",info,5000);
    //    System.out.println(string);

      //  System.out.println(HttpClientUtils.requestByGet("http://localhost:9999/findallCases",500));

        System.out.println(HttpClientUtils.requestByGet("http://localhost:9090/queryAll",5000));

    }



}
