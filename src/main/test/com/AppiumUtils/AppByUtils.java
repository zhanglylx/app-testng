package com.AppiumUtils;

import com.properties.AppClent;
import org.openqa.selenium.By;

public class AppByUtils {

    public static By idJointAppName(String id) {
        return new By.ById(AppClent.getAppPackage() + ":id/" + id);
    }
}
