package com.kyle.crud.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther kyle
 * @creat 2022-07-14:17
 */
public class MsgUtil {
    private int code;
    private String msg;
    private Map<String,Object> extend = new HashMap<>();

    public static MsgUtil success(){
        MsgUtil result = new MsgUtil();
        result.setCode(100);
        result.setMsg("处理成功！");
        return result;
    }
    public static MsgUtil fail(){
        MsgUtil result = new MsgUtil();
        result.setCode(200);
        result.setMsg("处理失败！");
        return result;
    }

    public MsgUtil add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
