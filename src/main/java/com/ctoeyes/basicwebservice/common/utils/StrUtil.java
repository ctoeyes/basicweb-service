package com.ctoeyes.basicwebservice.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class StrUtil {

    /**
     * 检查email邮箱格式是否合法
     */
    public static boolean isEmail(String email) {
        if (isEmpty(email)) {
            return false;
        }
        Pattern regex = Pattern
                .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher matcher = regex.matcher(email);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    /**
     * 检查用户名格式是否合法
     * 用户名长度为6-12位，由字母、数字、_、.组成
     * 并且不能以数字开头
     */
    public static boolean isAccountName(String accountName) {
        if (accountName.isEmpty()) {
            return false;
        }
        Pattern regex = Pattern.compile("^[^0-9][\\w.]{5,11}$");
        Matcher matcher = regex.matcher(accountName);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    /**
     * 检查密码格式是否合法
     * 密码长度为6-16位，可以由字母、数字、@#$%^&*()_+-=.组成
     */
    public static boolean checkPwdFormat(String password) {
        if (password.isEmpty()) {
            return false;
        }
        Pattern regex = Pattern.compile("^[\\w@#$%^&*()_+-=.]{6,16}$");
        Matcher matcher = regex.matcher(password);
        boolean isMatched = matcher.matches();
        return isMatched;
    }
}
