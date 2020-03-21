package com.ctoeyes.basicwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ctoeyes.basicwebservice.pojo.entity.AccountEntity;
import com.ctoeyes.basicwebservice.service.AccountService;
import com.ctoeyes.basicwebservice.pojo.response.Response;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/account")
public class AccountController extends BaseController{
    @Autowired
    private AccountService accountService;

    /**
      注册
     */
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public Response register(@RequestBody AccountEntity account, HttpServletResponse response) {
        return accountService.register(account);
    }

    /**
      登录
    */
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Response login(@RequestBody AccountEntity account, HttpServletResponse response) {
        return accountService.login(account);
    }

}
