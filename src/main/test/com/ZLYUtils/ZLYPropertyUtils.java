package com.ZLYUtils;


import com.cxb.cxb_drives.AppAssert;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static com.ZLYUtils.ZLYStringUtils.replaceFilePathSymbol;

public class ZLYPropertyUtils {
    /**
     * 获取Properties配置
     *
     * @param path
     * @return
     */
    public static Properties getProperties(String path) {
        if (path == null || StringUtils.isBlank(path)) throw new NullPointerException();
        path = StringUtils.trim(path);
        if (!path.endsWith(".properties")) path += ".properties";
        path = replaceFilePathSymbol(path);
        InputStreamReader propertiesInput = null;
        InputStream inputStream;
        try {
            inputStream = ZLYPropertyUtils.class.
                    getClassLoader().
                    getResourceAsStream(path);
            if (inputStream == null) {
                inputStream = new FileInputStream(new File(path));
            }
            propertiesInput = new InputStreamReader((inputStream), StandardCharsets.UTF_8);
            Properties properties = new Properties();
            properties.load(propertiesInput);
            return properties;
        } catch (Exception e) {
            AppAssert.fail(e);
        } finally {
            if (propertiesInput != null) {
                try {
                    propertiesInput.close();
                } catch (IOException e) {
                    AppAssert.fail(e);
                }
            }
        }
        return null;
    }

    public static String getPropertyStr(final Properties properties, final String str) {
        if (properties == null) throw new NullPointerException();
        if (StringUtils.isEmpty(str)) throw new NullPointerException();
        String s = properties.getProperty(str).trim();
        AppAssert.assertNotNull(s);
        return s;
    }

    public static int getPropertyInteger(final Properties properties, final String str) {
        return Integer.parseInt(getPropertyStr(properties, str));
    }

    public static double getPropertyDouble(final Properties properties, final String str) {
        return Double.parseDouble(getPropertyStr(properties, str));
    }

}
