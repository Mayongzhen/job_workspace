package com.javaapi.reportsys.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.javaapi.reportsys.entity.TestCase;
import com.javaapi.reportsys.entity.TestCaseType;
import com.javaapi.reportsys.service.TestCaseService;
import com.javaapi.reportsys.utils.TalkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestCaseController {
    @Autowired
    private TestCaseService testCaseService;
    private TestCaseType testCaseType;
    @PostMapping("/addcase")
    @ResponseBody
    public String  addCase(@RequestBody TestCase testCase){
        if(testCase!=null){
            if(testCaseService.Save(testCase)==1){
                return TalkResponse.success().toJson();
            }
        }
        return TalkResponse.error("99999","新增失败").toJson();
    }
   @GetMapping("/findallCases")
    public String findAllcase(@RequestParam("page") int page, @RequestParam("limit") int limit) {
       PageInfo<TestCase> pageInfo = testCaseService.selcetall(page,limit);
             testCaseType=new TestCaseType();
             testCaseType.setCount(((int) pageInfo.getTotal()));
             testCaseType.setCode(0);
             testCaseType.setMsg("");
             testCaseType.setData(pageInfo.getList());
       return JSONObject.toJSONString(testCaseType);
   }
        @PostMapping("/UpdateCaseDO")
        @ResponseBody
        public String UpdateCase(@RequestBody TestCase testCase){
        if(testCase!=null){
            if(testCaseService.update(testCase)==1){
                return TalkResponse.success().toJson();
            }
         }
             return TalkResponse.error("修改失败").toJson();
       }

    @GetMapping("/DeleteCase")
    @ResponseBody
    public String UpdateCase(@RequestParam("caseid")int caseid){

        if(testCaseService.selectone(caseid)!=null){

            if( testCaseService.delete(caseid)==1){

                return TalkResponse.success().toJson();
            }else{
                return TalkResponse.error("删除失败").toJson();
            }
        }else{
            return TalkResponse.error("id不存在").toJson();
        }

    }
    @GetMapping("/SelectCase")
    @ResponseBody
    public String selectCase(@RequestParam("caseid") int caseid){

        if(testCaseService.selectone(caseid)!=null){
            return TalkResponse.value(testCaseService.selectone(caseid)).toJson();
        }else{
            return TalkResponse.error("id不存在").toJson();
        }

    }


}







