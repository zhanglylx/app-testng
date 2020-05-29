package com.ZLYUtils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ZLYDateUtils {

    /**
     * 获取系统时间
     *
     * @param format 指定的格式
     * @return
     */
    public static String getDate(String format) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取系统时间，默认时间格式:yyyy-MM-dd HH:mm:ss
     *
     * @return date
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取文件名称日期
     *
     * @return
     */
    public static String getDateFileName() {
        return getDate("yyyy-MM-dd HH-mm-ss");
    }

}
