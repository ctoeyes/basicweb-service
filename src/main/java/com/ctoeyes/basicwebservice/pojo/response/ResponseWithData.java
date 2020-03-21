package com.ctoeyes.basicwebservice.pojo.response;

public class ResponseWithData extends Response{
    private Object data;

    public ResponseWithData() {
        super();
    }

    public ResponseWithData(ResponseMsg msg) {
        super(msg);
    }

    public ResponseWithData(Object data) {
        this.data = data;
    }

    public ResponseWithData(String code, String msg) {
        super(code, msg);
    }

    public ResponseWithData(String code, String msg, Object data) {
        super(code, msg);
        this.data = data;
    }

    public ResponseWithData(ResponseMsg msg, Object data) {
        super(msg);
        this.data = data;
    }

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

}