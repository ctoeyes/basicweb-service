package com.ctoeyes.basicwebservice.pojo.response;

public enum ResponseMsg {
    //公用Msg
    CommSUCCESS("000000", "操作成功"),
    CommUnexpectedError("000001", "异常错误"),
    CommParamError("000002", "参数错误"),
    CommFAILED("999999", "操作失败"),

    //账号服务Msg
    AccountUsed("001001","账号已被注册"),
    AccountWeakPwd("001002","密码强度不够"),
    AccountWrongAccNameFormat("001003","用户名格式不正确"),
    AccountNotExist("001004","账号不存在"),
    AccountPwdNotMatched("001005","密码错误"),
    ;

    private ResponseMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
