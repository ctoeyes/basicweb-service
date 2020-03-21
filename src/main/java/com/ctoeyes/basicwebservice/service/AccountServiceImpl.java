package com.ctoeyes.basicwebservice.service;

import com.ctoeyes.basicwebservice.common.Const;
import com.ctoeyes.basicwebservice.common.utils.Des3Util;
import com.ctoeyes.basicwebservice.pojo.entity.AccountEntity;
import com.ctoeyes.basicwebservice.pojo.response.ResponseMsg;
import com.ctoeyes.basicwebservice.pojo.response.ResponseWithData;
import com.ctoeyes.basicwebservice.repository.AccountRepository;
import com.ctoeyes.basicwebservice.common.utils.DateUtil;
import com.ctoeyes.basicwebservice.common.utils.Md5Util;
import com.ctoeyes.basicwebservice.common.utils.StrUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("AccountService")
@Transactional(readOnly = true)
public class AccountServiceImpl extends BaseService implements AccountService  {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = false)
    public ResponseWithData register(AccountEntity account) {
        try {
            if (account.getAccountName()==null || account.getAccountName().isEmpty()
                    || !StrUtil.isAccountName(account.getAccountName())) {
                return responseWithData(ResponseMsg.AccountWrongAccNameFormat);
            }

            if (account.getPassword()==null || account.getPassword().isEmpty()
                    || !StrUtil.checkPwdFormat(account.getPassword())) {
                return responseWithData(ResponseMsg.AccountWeakPwd);
            }
            //账号是否已被注册
            if (accountRepository.findByAccountName(account.getAccountName()) != null)
            {
                logger.error("账号"+account.getAccountName()+"已注册");
                return responseWithData(ResponseMsg.AccountUsed);
            } else {
                account.setRegtime(DateUtil.getCurrentTime());
                account.setLastloginTime(DateUtil.getCurrentTime());
                account.setPassword(Md5Util.encryption(account.getPassword()));
                account.setToken(UUID.randomUUID().toString().replaceAll("-",""));
                accountRepository.save(account);
                logger.info("账号"+account.getAccountName()+"注册成功");

                AccountEntity accountRecord = accountRepository.findByAccountName(account.getAccountName());

                Map<String,Object> data = new HashMap<>();
                data.put("uid", accountRecord.getUid());
                data.put("accountName", accountRecord.getAccountName());
                data.put("regTime", accountRecord.getRegtime());
                data.put("token", accountRecord.getToken());
                return responseWithData(ResponseMsg.CommSUCCESS, data);
            }
        } catch (Exception e) {
            logger.error("异常错误",e);
            return responseWithData(ResponseMsg.CommUnexpectedError);
        }
    }

    @Transactional(readOnly = false)
    public ResponseWithData login(AccountEntity account) {
        try {
            if (account.getAccountName()==null || account.getPassword()==null ||
                    account.getAccountName().isEmpty() || account.getPassword().isEmpty()) {
                return responseWithData(ResponseMsg.CommParamError);
            }

            AccountEntity accountRecord = accountRepository.findByAccountName(account.getAccountName());

            //账号是否存在
            if (accountRecord == null)
            {
                logger.error("账号"+account.getAccountName()+"不存在");
                return responseWithData(ResponseMsg.AccountNotExist);
            }
            //密码是否正确
            if (!accountRecord.getPassword().equals(Md5Util.encryption(account.getPassword())))
            {
                logger.error("账号"+account.getAccountName()+"密码错误");
                return responseWithData(ResponseMsg.AccountPwdNotMatched);
            }

            logger.info("账号"+account.getAccountName()+"登录成功");

            Map<String,Object> data = new HashMap<>();
            data.put("uid", accountRecord.getUid());
            data.put("accountName", accountRecord.getAccountName());
            data.put("regTime", accountRecord.getRegtime());
            data.put("token", accountRecord.getToken());
            return responseWithData(ResponseMsg.CommSUCCESS, data);
        } catch (Exception e) {
            logger.error("异常错误",e);
            return responseWithData(ResponseMsg.CommUnexpectedError);
        }
    }
}
