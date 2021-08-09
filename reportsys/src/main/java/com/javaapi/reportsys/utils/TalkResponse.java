package com.javaapi.reportsys.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TalkResponse  extends HashMap<String,Object> {
    private static final long serialVersionUID = -7612074692707358252L;
    private static final SerializeConfig mapping = new SerializeConfig();
    private static final ConcurrentHashMap<String, SerializeConfig> config;

    public static SerializeConfig getMapping() {
        return mapping;
    }

    public TalkResponse() {
        this("0", "success");
    }

    public TalkResponse(String code, String message) {
        this.put("code", code);
        this.put("message", message);
        this.put("timestamp", System.currentTimeMillis());
    }

    public TalkResponse(String code, String message, Object res) {
        this(code, message);
        this.setRes(res);
    }

    public TalkResponse(String code, String message, Integer total) {
        this(code, message);
        this.setTotal(total);
    }

    public TalkResponse(Object res) {
        this();
        this.setRes(res);
    }

    public TalkResponse(Integer total) {
        this();
        this.setTotal(total);
    }

    public String getCode() {
        return this.getString("code");
    }

    public TalkResponse setCode(String code) {
        this.put("code", code);
        return this;
    }

    public String getMessage() {
        return this.getString("message");
    }

    private String getString(String key) {
        if (key == null) {
            return null;
        } else {
            Object value = this.get(key);
            if (value == null) {
                return null;
            } else {
                return value instanceof String ? (String)value : value.toString();
            }
        }
    }

    public TalkResponse setMessage(String message) {
        this.put("message", message);
        return this;
    }

    public TalkResponse setTotal(Long total) {
        this.put("total", total);
        return this;
    }

    public TalkResponse setTotal(Integer total) {
        this.put("total", total);
        return this;
    }

    public TalkResponse setRes(Object value) {
        this.put("res", value);
        return this;
    }

    public <T> TalkResponse setRes(Collection<T> list, boolean withTotal) {
        if (list != null) {
            this.setRes(list);
        } else {
            this.setRes(Collections.emptyList());
        }

        if (withTotal) {
            this.setTotal(list == null ? 0 : list.size());
        }

        return this;
    }

/*    public <T> TalkResponse setPage(Page<T> page) {
        if (page == null) {
            return this.setRes(Collections.emptyList()).setTotal(0);
        } else {
            return page.getList() == null ? this.setRes(Collections.emptyList()).setTotal(page.getCount()) : this.setRes(page.getList()).setTotal(page.getCount());
        }
    }*/

    private SerializeConfig getFormat(String format) {
        if (format != null && format.length() >= 0 && !"yyyy-MM-dd HH:mm:ss".equals(format)) {
            SerializeConfig cfg = (SerializeConfig)config.get(format);
            if (cfg == null) {
                cfg = new SerializeConfig();
                cfg.put(Date.class, new SimpleDateFormatSerializer(format));
                config.put(format, cfg);
            }

            return cfg;
        } else {
            return mapping;
        }
    }

    public String toJson() {
        return JSON.toJSONString(this, mapping, new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect});
    }

    public String toJson(String dateFormat) {
        return dateFormat != null && dateFormat.length() >= 0 ? JSON.toJSONString(this, this.getFormat(dateFormat), new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect}) : JSON.toJSONString(this, mapping, new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect});
    }

    public String toJson(SerializeConfig format) {
        return JSON.toJSONString(this, format, new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect});
    }

    public static <T> TalkResponse list(Object value, Integer total) {
        return (new TalkResponse()).setRes(value).setTotal(total);
    }

    public static TalkResponse emptyPage() {
        return (new TalkResponse()).setRes(Collections.emptyList()).setTotal(0);
    }

    public static <T> TalkResponse list(Object value, Long total) {
        return (new TalkResponse()).setRes(value).setTotal(total);
    }

    public static <T> TalkResponse list(Collection<T> list) {
        return list(list, false);
    }

    public static <T> TalkResponse list(Collection<T> list, boolean withTotal) {
        return (new TalkResponse()).setRes(list, withTotal);
    }

    /*public static <T> TalkResponse page(Page<T> page) {
        return (new TalkResponse()).setPage(page);
    }

    public static TalkResponse error(Throwable exception) {
        if (exception == null) {
            return new TalkResponse("11000", "system exception");
        } else {
            if (exception instanceof Exception) {
                Exception de = (Exception)exception;
                if (de.getCode() != null) {
                    return new TalkResponse(de.getCode(), de.getCodeMsg());
                }
            }

            return new TalkResponse("11000", "系统异常");
        }
    }*/

/*    public static TalkResponse error(String code, String message) {
        return message == null && ErrorCode.contains(code) ? new TalkResponse(code, ErrorCode.getMsg(code)) : new TalkResponse(code, message);
    }*/

    public static TalkResponse error(String message) {
        return new TalkResponse("10013", message);
    }

    public static TalkResponse error(String message, Object res) {
        return (new TalkResponse("10013", message)).setRes(res);
    }

    public static TalkResponse success() {
        return new TalkResponse();
    }

    public static TalkResponse value(Object value) {
        return (new TalkResponse()).setRes(value);
    }

    public static TalkResponse value(Object value, boolean canEmptyCode) {
        return canEmptyCode && value == null ? new TalkResponse("10006", "暂无数据") : (new TalkResponse()).setRes(value);
    }

/*    public static TalkResponse value(Object value, String nullCode) {
        return value == null ? code(nullCode) : (new TalkResponse()).setRes(value);
    }*/

    public static TalkResponse empty() {
        return new TalkResponse("10006", "暂无数据");
    }

    public static TalkResponse emptyList() {
        return new TalkResponse("10004", "暂无数据");
    }

 /*   public static TalkResponse code(String code) {
        return ErrorCode.contains(code) ? new TalkResponse(code, ErrorCode.getMsg(code)) : new TalkResponse(code, "unknown error");
    }*/

    public static TalkResponse code(String code, String message) {
        return new TalkResponse(code, message);
    }

    public TalkResponse addSelf(String key, Object value) {
        this.put(key, value);
        return this;
    }

    static {
        mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        config = new ConcurrentHashMap();
    }

}
