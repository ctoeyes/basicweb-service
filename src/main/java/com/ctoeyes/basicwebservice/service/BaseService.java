package com.ctoeyes.basicwebservice.service;

import com.ctoeyes.basicwebservice.pojo.response.Response;
import com.ctoeyes.basicwebservice.pojo.response.ResponseMsg;
import com.ctoeyes.basicwebservice.pojo.response.ResponseWithData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseService {
    protected Logger logger =  LoggerFactory.getLogger(this.getClass());

    protected Response response(){
        return new Response();
    }
    protected Response response(ResponseMsg msg){
        return new Response(msg);
    }

    protected ResponseWithData responseWithData(){
        return new ResponseWithData();
    }
    protected ResponseWithData responseWithData(ResponseMsg msg){
        return new ResponseWithData(msg);
    }
    protected ResponseWithData responseWithData(ResponseMsg msg, Object data){
        return new ResponseWithData(msg,data);
    }

}
