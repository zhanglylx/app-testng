package com.AppiumUtils;

import com.cxb.cxb_drives.CXBAppiumDrive;
import com.cxb.cxb_drives.MobileDrive;
import com.cxb.cxb_interface.SetBookInfoInterface;
import com.cxb.cxb_interface.enum_interface.WEMIF;
import com.cxb.entity.AppBook;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AppiumElementUtils {
    /**
     * 验证元素是否存在
     *
     * @param elemnt
     * @return
     */
    public static boolean isElementExsit(By elemnt) {
        boolean flag = false;
        try {
            WebElement element = CXBAppiumDrive.getInstance().getDriver().findElement(elemnt);
            flag = null != element;
        } catch (NoSuchElementException ignored) {
        }
        return flag;
    }

    /**
     * 验证元素是否存在
     *
     * @param using
     * @return
     */
    public static boolean isElementExsit(String using) {
        boolean flag = false;
        try {
            WebElement element = CXBAppiumDrive.getInstance().getDriver().findElementByAndroidUIAutomator(using);
            flag = null != element;
        } catch (NoSuchElementException ignored) {
        }
        return flag;
    }

    public static boolean isElementExsit(WebElement element, By by) {
        boolean flag = false;
        try {
            WebElement e = element.findElement(by);
            flag = null != e;
        } catch (NoSuchElementException ignored) {
        }
        return flag;
    }

    public static boolean isElementExsit(Object object) {
        if (object instanceof String) {
            return isElementExsit(object.toString());
        } else {
            return isElementExsit((By) object);
        }
    }

    public static List<AppBook> setBookInfo(WEMIF nameList
            , WEMIF authorList
            , WEMIF summaryList) {
        return setBookInfo(nameList, authorList, summaryList, null);
    }

    public static List<AppBook> setBookInfo(WEMIF nameList
            , WEMIF authorList
            , WEMIF summaryList
            , SetBookInfoInterface setBookInfoInterface) {
        List<AppBook> list = new ArrayList<>();
        WebElement nameWebElement;
        for (int i = 0; i < nameList.getListWebElement().size(); ++i) {
            nameWebElement = nameList.getListWebElement().get(i);
            AppBook appBook = new AppBook();
            appBook.setName(nameWebElement.getText());
            appBook.setX(nameWebElement.getLocation().getX());
            appBook.setY(nameWebElement.getLocation().getY());
            if (authorList != null && authorList.getListWebElement().size() >= i + 1) {
                appBook.setAuthor(authorList.getListWebElement().get(i).getText());
            }
            if (summaryList != null && summaryList.getListWebElement().size() >= i + 1) {
                appBook.setSummary(summaryList.getListWebElement().get(i).getText());
            }
            if (setBookInfoInterface != null) {
                setBookInfoInterface.setBookInfo(appBook, i);
            }
            list.add(appBook);
        }
        return list;
    }

    public static WebElement findWEMListText(List<WebElement> list, String text) {
        return findWEMListText(list, text, 0);
    }

    public static WebElement findWEMListText(List<WebElement> list, String text, int index) {
        int i = 0;
        for (WebElement webElement : list) {
            if (webElement.getText().trim().equals(text.trim())) {
                if (i == index) return webElement;
                i++;
            }
        }
        return null;
    }






}
