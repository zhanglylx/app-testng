package com.cxb.cxb_object;

import com.ZLYUtils.ZLYPropertyUtils;

import java.util.Properties;

public class App_HeadersPropertyUtils {
    private static Properties properties;

    static {
        properties = ZLYPropertyUtils.getProperties("config/interface/App_Headers");
    }

    public static Properties getProperties() {
        return (Properties) properties.clone();
    }


    public static String getAppName() {
        return ZLYPropertyUtils.getPropertyStr(properties, "appName");
    }

    public static String getModel() {
        return ZLYPropertyUtils.getPropertyStr(properties, "model");
    }

    public static String getImsi() {
        return ZLYPropertyUtils.getPropertyStr(properties, "imsi");
    }

    public static String getWv() {
        return ZLYPropertyUtils.getPropertyStr(properties, "wv");
    }

    public static int getOscode() {
        return ZLYPropertyUtils.getPropertyInteger(properties, "oscode");
    }

    public static int getUid() {
        return ZLYPropertyUtils.getPropertyInteger(properties, "uid");
    }

    public static String getVersion() {
        return ZLYPropertyUtils.getPropertyStr(properties, "version");
    }

    public static String getUmeng() {
        return ZLYPropertyUtils.getPropertyStr(properties, "umeng");
    }

    public static String getBrand() {
        return ZLYPropertyUtils.getPropertyStr(properties, "brand");
    }

    public static String getOther() {
        return ZLYPropertyUtils.getPropertyStr(properties, "other");
    }

    public static String getImei() {
        return ZLYPropertyUtils.getPropertyStr(properties, "imei");
    }

    public static int getVcode() {
        return ZLYPropertyUtils.getPropertyInteger(properties, "vcode");
    }

    public static int getCnid() {
        return ZLYPropertyUtils.getPropertyInteger(properties, "cnid");
    }

    public static String getPlatform() {
        return ZLYPropertyUtils.getPropertyStr(properties, "platform");
    }

    public static String getMac() {
        return ZLYPropertyUtils.getPropertyStr(properties, "mac");
    }

    public static String getUserAgent() {
        return ZLYPropertyUtils.getPropertyStr(properties, "user_agent");
    }

    public static String getTokenKey(){return ZLYPropertyUtils.getPropertyStr(properties, "token_key");};

    public static void main(String[] args) {
        getProperties().clear();
        Properties propertiess = getProperties();

        System.out.println(propertiess.getProperty("cnid"));
    }

}
