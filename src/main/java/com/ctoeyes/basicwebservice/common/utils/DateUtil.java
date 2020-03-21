package com.ctoeyes.basicwebservice.common.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public final static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前时间
     */
    public static Timestamp getCurrentTime() {
        return Timestamp.valueOf(df.format(new Date()));
    }

}
