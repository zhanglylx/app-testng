package com.cxb.cxb_interface.enum_interface;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface EnumGetElement {
    WebElement getElement(List<WebElement> webElementList);
}
