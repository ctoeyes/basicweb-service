package com.ctoeyes.basicwebservice.pojo.response;

public class Response {
    private String code="000000";
    private String msg="操作成功";

    public Response() {}

    public Response(ResponseMsg msg){
        this.code=msg.getCode();
        this.msg=msg.getMsg();
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
