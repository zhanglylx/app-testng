package com.properties;

import com.ZLYUtils.ZLYPropertyUtils;

import java.util.Properties;

public class AppClent {
    private static Properties properties = ZLYPropertyUtils.getProperties("config/AppClent");

    public static String getAppPackage() {
        return ZLYPropertyUtils.getPropertyStr(properties, "APP_PACKAGE");
    }

    public static String getAppActitvity() {
        return ZLYPropertyUtils.getPropertyStr(properties, "APP_ACTIVITY");
    }
}
