package com.javaapi.reportsys.service;





import com.alibaba.fastjson.JSON;
import com.javaapi.reportsys.entity.FlowCase;
import com.javaapi.reportsys.entity.FlowReBean;
import com.javaapi.reportsys.utils.HttpClientUtils;
import com.javaapi.reportsys.utils.TalkResponse;
import org.apache.commons.lang.StringEscapeUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin
@RestController
public class FlowDataService {
    @Autowired
    private TransportClient client;
    @GetMapping("/queryAll")
    @ResponseBody
    public Object queryAll(@RequestParam("page") int page, @RequestParam("limit") int limit,

    @RequestParam(required = false) String flowid, @RequestParam(required = false) String date

    ) {
        HashMap<String, Object> responseMap = new HashMap<>();
        List<FlowCase> resMap = new ArrayList<>();
        SearchResponse response;
        SearchHits searchHits;
        SearchRequestBuilder requestBuilder;
        int num = (page - 1) * limit;

        if (flowid != null && date != null && flowid != "" && date != "") {

            //_id and date
            QueryBuilder qb1 = QueryBuilders.matchPhraseQuery("Timestamp", date);
            QueryBuilder qb2 = QueryBuilders.matchQuery("_id",flowid);
            requestBuilder = client.prepareSearch("gor").setTypes("RequestResponse").setQuery(QueryBuilders.boolQuery().must(qb1).must(qb2));

           }else if (flowid != null && flowid != "") {
                // _id
                requestBuilder = client.prepareSearch("gor").setTypes("RequestResponse").setQuery(QueryBuilders.termQuery("_id", flowid)).addSort("Timestamp", SortOrder.DESC);
            } else if (date != null && date != "") {
                //_date
                requestBuilder = client.prepareSearch("gor").setTypes("RequestResponse").setQuery(QueryBuilders.matchPhraseQuery("Timestamp", date)).addSort("Timestamp", SortOrder.DESC);
            } else {
                //全部查询
                requestBuilder = client.prepareSearch("gor").setTypes("RequestResponse").setQuery(QueryBuilders.matchAllQuery()).addSort("Timestamp", SortOrder.DESC);

            }
            response = requestBuilder.setFrom(num).setSize(limit).execute().actionGet();
            searchHits = response.getHits();
            FlowCase flowCase;

            for (SearchHit single : searchHits) {
                flowCase = new FlowCase();
                if (single != null) {
                    System.out.println("流量总数" + "======" + searchHits.getTotalHits());
                    System.out.println("输出流量======" + single.getSourceAsString());
                    System.out.println("输出所流量===" + single.getSourceAsMap().toString());
                    flowCase.setId(single.getId());
                    if (single.getSource().get("Req_Accept") != null) {
                        flowCase.setReqAccept(single.getSource().get("Req_Accept").toString());
                    }
                    if (single.getSource().get("Req_URL") != null) {
                        flowCase.setReqURL(single.getSource().get("Req_URL").toString());
                    }
                    if (single.getSource().get("Req_Accept-Encoding") != null) {
                        flowCase.setReqAcceptEncoding(single.getSource().get("Req_Accept-Encoding").toString());
                    }
                    if (single.getSource().get("Req_Accept-Language") != null) {
                        flowCase.setReqAcceptLanguage(single.getSource().get("Req_Accept-Language").toString());

                    }
                    if (single.getSource().get("Req_Accept") != null) {
                        flowCase.setReqAccept(single.getSource().get("Req_Accept").toString());

                    }
                    if (single.getSource().get("Req_Connection") != null) {
                        flowCase.setReqConnection(single.getSource().get("Req_Connection").toString());
                    }
                    if (single.getSource().get("Req_If-Modified-Since") != null) {
                        flowCase.setReqIfModifiedSince(single.getSource().get("Req_If-Modified-Since").toString());

                    }
                    if (single.getSource().get("Req_Cookies") != null) {
                        flowCase.setReqCookies(single.getSource().get("Req_Cookies").toString());
                    }
                    if (single.getSource().get("Resp_Status") != null) {
                        flowCase.setRespStatus(single.getSource().get("Resp_Status").toString());
                    }

                    if (single.getSource().get("Resp_Status-Code") == null) {
                        flowCase.setRespStatusCode("");

                    } else {
                        flowCase.setRespStatusCode(single.getSource().get("Resp_Status-Code").toString());
                    }
                    if (single.getSource().get("Resp_Expires") == null) {
                        flowCase.setRespExpires("");
                    } else {
                        flowCase.setRespExpires(single.getSource().get("Resp_Expires").toString());
                    }
                    if (single.getSource().get("Resp_Transfer-Encoding") == null) {
                        flowCase.setRespTransferEncoding("");
                    } else {
                        flowCase.setRespTransferEncoding(single.getSource().get("Resp_Transfer-Encoding").toString());
                    }
                    if (single.getSource().get("Req_User-Agent") == null) {
                        flowCase.setReqUserAgent("");
                    } else {
                        flowCase.setReqUserAgent(single.getSource().get("Req_User-Agent").toString());
                    }
                    if (single.getSource().get("RTT") == null) {
                        flowCase.setRtt("");
                    } else {
                        flowCase.setRtt(single.getSource().get("RTT").toString());
                    }
                    if (single.getSource().get("Timestamp") == null) {
                        flowCase.setTimestamp("");
                    } else {
                        flowCase.setTimestamp(single.getSource().get("Timestamp").toString());
                    }
                    if (single.getSource().get("Req_Method") == null) {
                        flowCase.setReqMethod("");
                    } else {
                        flowCase.setReqMethod(single.getSource().get("Req_Method").toString());
                    }

                    if (single.getSource().get("Resp_Cache-Control") == null) {
                        flowCase.setRespCacheControl("");
                    } else {
                        flowCase.setRespCacheControl(single.getSource().get("Resp_Cache-Control").toString());
                    }
                    if (single.getSource().get("Resp_Content-Encoding") == null) {
                        flowCase.setRespContentEncoding("");
                    } else {
                        flowCase.setRespContentEncoding(single.getSource().get("Resp_Content-Encoding").toString());
                    }
                    if (single.getSource().get("Resp_Proto") == null) {
                        flowCase.setRespProto("");
                    } else {
                        flowCase.setRespProto(single.getSource().get("Resp_Proto").toString());
                    }
                    if (single.getSource().get("Resp_Content-Length") == null) {
                        flowCase.setRespContentLength("");
                    } else {
                        flowCase.setRespContentLength(single.getSource().get("Resp_Content-Length").toString());
                    }
                    if (single.getSource().get("Resp_Content-Type") == null) {
                        flowCase.setRespContentType("");
                    } else {
                        flowCase.setRespContentType(single.getSource().get("Resp_Content-Type").toString());
                    }
                    resMap.add(flowCase);
                }
            }

            responseMap.put("data", resMap);
            responseMap.put("msg", "");
            responseMap.put("code", 0);
            responseMap.put("count", searchHits.getTotalHits());
            return responseMap;
        }


    @GetMapping("/DeleteFlow")
    @ResponseBody
    public String deleteFlow(@RequestParam("id") String id) {
        if (id != null) {
            DeleteResponse result = client.prepareDelete("gor", "RequestResponse", id).execute().actionGet();
            System.out.println("删除操作----" + result.toString());
            if (result.getShardInfo().getSuccessful() == 1) {
                return TalkResponse.success().toJson();
            } else {
                return TalkResponse.error("删除失败").toJson();

            }

        } else {
            return TalkResponse.error("id不存在").toJson();
        }


    }

    @GetMapping("/DeleteMuiltyFlow")
    @ResponseBody
    public String deleteFlowMuiltity(@RequestParam String[] ids) {
        BulkRequestBuilder bulk = client.prepareBulk();
        // 删除请求
        DeleteRequestBuilder delete = null;
        for (String id : ids) {
            System.out.println(id);
            delete = client.prepareDelete("gor", "RequestResponse", id);
            // 加入bulk批量操作
            bulk.add(delete);
        }
        try {
            //
            // BulkResponse response = bulk.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL).get();
            // 执行
            BulkResponse response = bulk.get();
            return response.status().name();
        } catch (Exception e) {
            return "删除失败";
        }
    }

    @CrossOrigin
    @PostMapping("/RunFlowCase")
    @ResponseBody
    public String RunFlowCase(@RequestParam("method") String method, @RequestParam("url") String url) {
        if (method.equals("GET")) {
            System.out.println(HttpClientUtils.requestByGet(url, 5000));
            return HttpClientUtils.requestByGet(url, 5000);
        } else {
            return TalkResponse.code("10000","暂不支持post请求").toJson();
        }

    }
    @CrossOrigin
    @RequestMapping(value="/RunFlowCaseMulity",consumes = "application/json")
    @ResponseBody
    public String RunFlowMulitCases(@RequestBody List<FlowCase> flowCases,@RequestHeader(name = "IpHeader") String myHeader) {
        FlowReBean flowReBean;
        List<FlowReBean> list = new ArrayList<>();
        if (flowCases != null) {
            for (FlowCase flowCase : flowCases) {
                flowReBean = new FlowReBean();
                flowReBean.setId(flowCase.getId());
                flowReBean.setMethod(flowCase.getReqMethod());
                if(myHeader!=null&&myHeader!=null){
                    flowReBean.setUrl(myHeader+""+flowCase.getReqURL());
                }
                if (flowCase.getReqMethod().equals("GET")) {
                    int starttime = (int) System.currentTimeMillis();
                    String result = HttpClientUtils.requestByGet(flowReBean.getUrl(), 5000);
                    if (result != "" && result != null) {
                        String tmp = StringEscapeUtils.unescapeJavaScript(result);
                        flowReBean.setResponese(tmp);
                        int endtime = (int) System.currentTimeMillis();
                        flowReBean.setResponset((endtime - starttime )+ "毫秒");
                    }

                } else {
                    flowReBean.setResponese("");
                    flowReBean.setResponset("no毫秒");
                }
                list.add(flowReBean);
            }

        }
      return JSON.toJSON(list).toString();
    }

}