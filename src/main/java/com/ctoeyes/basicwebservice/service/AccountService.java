package com.ctoeyes.basicwebservice.service;

import com.ctoeyes.basicwebservice.pojo.entity.AccountEntity;
import com.ctoeyes.basicwebservice.pojo.response.ResponseWithData;

public interface AccountService {

    ResponseWithData register(AccountEntity account);
    ResponseWithData login(AccountEntity account);

}
