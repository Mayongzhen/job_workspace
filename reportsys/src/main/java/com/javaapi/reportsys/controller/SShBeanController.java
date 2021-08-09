package com.javaapi.reportsys.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.javaapi.reportsys.entity.EsgorProperties;
import com.javaapi.reportsys.entity.SShBean;
import com.javaapi.reportsys.entity.SShBeanType;
import com.javaapi.reportsys.service.SShBeanService;
import com.javaapi.reportsys.utils.SSH2Utils;
import com.javaapi.reportsys.utils.TalkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SShBeanController {
    @Autowired
    private EsgorProperties esgorProperties;
    @Autowired
    private SShBeanService sshBeanService;
    private SShBeanType sshbeantype;
    private SSH2Utils ssh2Utils;
    @PostMapping("/addsshbean")
    @ResponseBody
    public String  addsshBean(@RequestBody SShBean sshbean ){
        if(sshbean!=null){
            if(sshBeanService.Save(sshbean)==1){
                return TalkResponse.success().toJson();
            }
        }
        return TalkResponse.error("99999","新增失败").toJson();
    }
    @GetMapping("/querysshbeans")
    public String findAllcase(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        PageInfo<SShBean> pageInfo = sshBeanService.selcetall(page,limit);
        sshbeantype=new SShBeanType();
        sshbeantype.setCount(((int) pageInfo.getTotal()));
        sshbeantype.setCode(0);
        sshbeantype.setMsg("");
        sshbeantype.setData(pageInfo.getList());
        return JSONObject.toJSONString(sshbeantype);
    }
    @PostMapping("/UpdateSshbean")
    @ResponseBody
    public String UpdateSshbean(@RequestBody SShBean sshbean){
        if(sshbean!=null){
            if(sshBeanService.update(sshbean)==1){
                return TalkResponse.success().toJson();
            }
        }
        return TalkResponse.error("修改失败").toJson();
    }

    @GetMapping("/DeleteSshBean")
    @ResponseBody
    public String deleteSshbean(@RequestParam("id")int caseid){

        if(sshBeanService.selectone(caseid)!=null){

            if( sshBeanService.delete(caseid)==1){

                return TalkResponse.success().toJson();
            }else{
                return TalkResponse.error("删除失败").toJson();
            }
        }else{
            return TalkResponse.error("id不存在").toJson();
        }

    }
    @GetMapping("/SelectSshbean")
    @ResponseBody
    public String selectCase(@RequestParam("id") int caseid){

        if(sshBeanService.selectone(caseid)!=null){
            return TalkResponse.value(sshBeanService.selectone(caseid)).toJson();
        }else{
            return TalkResponse.error("id不存在").toJson();
        }

    }
    @PostMapping("/RunSshbean")
    @ResponseBody
    public String RunSshbean(@RequestBody SShBean sshbean) {

        if (sshbean == null) {
         return TalkResponse.empty().toJson();
        }
        ssh2Utils = new SSH2Utils(sshbean.getIp(), sshbean.getUsername(), sshbean.getPassword(), Integer.parseInt(sshbean.getPort()));
        if (sshbean.getReplaystatus() == 0) {
            sshbean.setReplaystatus(1);
           // nohup /home/zhaoyu/goreplay --input-raw :80 --input-raw-track-response --output-http http://localhost:80 --output-http-elasticsearch 172.16.0.13:9200/gor >> /home/zhaoyu/output.log 2>&1
           // String command = "cd "+sshbean.getGoreplaydir()+"&&sh goreplay_start.sh\n";
         //   String command = sshbean.getGoreplaydir() + "/goreplay --input-raw :80 --input-raw-track-response --output-http http://staging.com  --output-http-elasticsearch " + esgorProperties.getGorip() + 0":920/gor &";
            String command=  "nohup "+sshbean.getGoreplaydir()+"/goreplay --input-raw :"+sshbean.getRecodeport().trim()+" --input-raw-track-response --output-http http://localhost:"+sshbean.getRecodeport().trim()+" --output-http-elasticsearch "+esgorProperties.getGorip().trim()+":9200/gor >> "+sshbean.getGoreplaydir()+"/output.log 2>&1 &echo \"success world\"";
            System.out.println(command);
            System.out.println(""+ssh2Utils.runCommand(command));
            sshBeanService.update(sshbean);
            return TalkResponse.code("10000", "正在录制").toJson();
        } else {
            return TalkResponse.error("已开启录制").toJson();
        }

    }
    @PostMapping("/StopSshbean")
    @ResponseBody
    public String StopSshbean(@RequestBody SShBean sshbean) {

        if (sshbean == null) {
            return TalkResponse.empty().toJson();
        }
        ssh2Utils = new SSH2Utils(sshbean.getIp(), sshbean.getUsername(), sshbean.getPassword(), Integer.parseInt(sshbean.getPort()));
        if (sshbean.getReplaystatus() == 1) {
            sshbean.setReplaystatus(0);
            String command = "cd "+sshbean.getGoreplaydir()+"&&sh goreplay_stop.sh\n";
            System.out.println(""+ssh2Utils.runCommand(command));
            sshBeanService.update(sshbean);
            return TalkResponse.code("10000", "关闭录制").toJson();
        } else {
            return TalkResponse.error("未录制").toJson();
        }

    }
}
