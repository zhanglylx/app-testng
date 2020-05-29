package com.cxb.cxb_interface;

import com.AppiumUtils.AppiumElementUtils;
import com.ZLYUtils.JavaUtils;
import com.cxb.cxb_drives.AppAssert;
import com.cxb.cxb_drives.CXBAppiumDrive;
import com.cxb.cxb_interface.enum_interface.EnumBookList;
import com.cxb.cxb_object.app_client_enum_impl.bookrack.BookRackWEMIFImpl;
import com.AppiumUtils.AppByUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.Serializable;

public abstract class BaseTest implements Serializable {
    /**
     * 启动程序，初始化Driver
     */
    @BeforeClass
    protected final void init() {
        getDriver();
    }

    @AfterClass
    public void resetInterfaceEntry() {
//        //残忍退出按钮
//        By by = AppByUtils.idJointAppName("btn_left");
//        //
//        int i = 0;
//        do {
//            this.getDriver().navigate().back();
//            if (isElementExsit(by)) {
//                if ("残忍退出".equals(this.getDriver().findElement(by).getText())) {
//                    this.getDriver().navigate().back();
//                    break;
//                }
//            }
//            //判断书架按钮是否存在，存在则判断书架按钮是否是点击状态，因为书架有很多弹窗，所以在返回5次后关闭
//            if (i > 3) {
//                if (BookRackWEMIFImpl.BOOK_RACK.isElementExist()) {
//                    break;
//                }
//            }
//            AppAssert.assertLoopTerminates(i++);
//        } while (true);

    }


    /**
     * 验证元素是否存在
     *
     * @param elemnt
     * @return
     */
    protected boolean isElementExsit(By elemnt) {
        return AppiumElementUtils.isElementExsit(elemnt);
    }


    @AfterMethod
    protected void errTestImgSave(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("错误的用例：" + iTestResult.getMethod().getMethodName());
        }
    }

    /**
     * 获取当前页面的bookList
     *
     * @return
     */
    protected abstract EnumBookList getCurrentPageBooks();


    protected final AndroidDriver<WebElement> getDriver() {
        return CXBAppiumDrive.getInstance().getDriver();
    }

    protected final void sleep(){
        JavaUtils.sleep(3000);
    }
}
