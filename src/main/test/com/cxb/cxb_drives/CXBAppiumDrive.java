package com.cxb.cxb_drives;

import com.ZLYUtils.JavaUtils;
import com.ZLYUtils.ZLYObjectUtils;
import com.cxb.cxb_interface.BaseTest;
import com.cxb.cxb_interface.enum_interface.EnumBookList;
import com.properties.AppClent;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * appium驱动
 */
public class CXBAppiumDrive {
    private AndroidDriver<WebElement> driver;
    private static CXBAppiumDrive appiumDrive;

    private CXBAppiumDrive() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("automationName", "Appium");// appium做自动化
        desiredCapabilities.setCapability("deviceName", MobileDrive.getInstance().getDriveName());// 设备名称
        desiredCapabilities.setCapability("platformVersion", MobileDrive.getInstance().getMobileVersion()); // 安卓操作系统版本
        desiredCapabilities.setCapability("platformName", "Android"); // 安卓自动化还是IOS自动化
        desiredCapabilities.setCapability("appPackage", AppClent.getAppPackage());// 被测app的包名
        desiredCapabilities.setCapability("appActivity", AppClent.getAppActitvity());// 被测app的入口Activity名称
        desiredCapabilities.setCapability("unicodeKeyboard", true); // 支持中文输入
        desiredCapabilities.setCapability("resetKeyboard", true); // 支持中文输入，必须两条都配置
        desiredCapabilities.setCapability("noSign", true); // 不重新签名apk
        desiredCapabilities.setCapability("noReset", true); // 不需要清理数据，避免重新安装的问题
        desiredCapabilities.setCapability("newCommandTimeout", "600000"); // 没有新命令，appium秒退出
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        try {
            this.driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            // 隐式等待,元素未找到时等待的时间
            this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            JavaUtils.sleepSecond(10);
        } catch (MalformedURLException e) {
            AppAssert.fail(e);
        } catch (org.openqa.selenium.remote.UnreachableBrowserException e) {
            AppAssert.fail(e, "您可能还没有启动appium！或者自己查查问题");
        } catch (org.openqa.selenium.SessionNotCreatedException e) {
            AppAssert.fail(e, "这个设备好像不支持或者没有解锁或者自己查查问题");
        } catch (org.openqa.selenium.WebDriverException e) {
            AppAssert.fail(e, "有可能包名或app启动Activity配置不正确");
        }
    }

    public static CXBAppiumDrive getInstance() {
        if (appiumDrive == null) {
            appiumDrive = new CXBAppiumDrive();
//            for (int i = 0; i < 3; ++i) {
//                appiumDrive.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
//            }
//            appiumDrive.findElement(By.id("com.mianfeizs.book:id/tv_agree")).click();
        }
        return appiumDrive;
    }

    public WebElement findElement(Object object) {
        if (object instanceof String) {
            return driver.findElementByAndroidUIAutomator(ZLYObjectUtils.cast(object));
        } else {
            return driver.findElement(ZLYObjectUtils.cast(object));
        }
    }

    public List<WebElement> findElementList(Object object) {
        if (object instanceof String) {
            return driver.findElementsByAndroidUIAutomator(ZLYObjectUtils.cast(object));
        } else {
            return driver.findElements(ZLYObjectUtils.cast(object));
        }
    }


    public AndroidDriver<WebElement> getDriver() {
        return driver;
    }

    public int getWidth() {
        return driver.manage().window().getSize().getWidth();
    }

    public int getHeight() {
        return driver.manage().window().getSize().getHeight();
    }


}
