package com.cxb.test_case_set.operation;

import com.AppiumUtils.AppiumElementUtils;
import com.AppiumUtils.AppiumOperatingUtils;
import com.AppiumUtils.AppiumUiSelectorUtils;
import com.cxb.cxb_drives.CXBAppiumDrive;
import com.cxb.cxb_interface.BaseTestModule;
import com.cxb.cxb_interface.enum_interface.EnumBookList;
import com.cxb.entity.AppBook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationTreasureTest extends BaseTestModule {


    @Test
    public void demo() throws InterruptedException {
        final String appname = "免费电子书";
        this.getDriver().findElement(By.id("com.tencent.android.qqdownloader:id/awt")).click();//        点击搜索框
        this.sleep();//加载内容需要等待
        this.getDriver().findElement(By.id("com.tencent.android.qqdownloader:id/yv")).sendKeys(appname);//        输入搜索内容
        this.getDriver().findElement(By.id("com.tencent.android.qqdownloader:id/a5t")).click();//        点击搜索按钮
        this.sleep();//加载内容需要等待
        Objects.requireNonNull(AppiumElementUtils.findWEMListText(
                this.getDriver().findElementsByAndroidUIAutomator(AppiumUiSelectorUtils.textUiSelector(appname)), appname, 1
        )).click();//点击名称为appname相同的元素第2个
        String text;
        int number = 0;
        for (WebElement element : this.getDriver().findElements(By.className("android.widget.TextView"))) {
            text = element.getText();
            if (text != null && text.trim().startsWith("评价")) {
                element.click();
                Matcher matcher = Pattern.compile("\\d+").matcher(text);
                if (!matcher.find()) throw new RuntimeException("No evaluation quantity was found:" + text);
                number = Integer.parseInt(matcher.group());
                break;
            }
        }
        System.out.println("评价数量:" + number);
        this.sleep();
        AppiumOperatingUtils.swipeBottomToTop();
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Map<Integer, Map<String, String>> mapMap = new LinkedHashMap<>();
        int finalNumber = number;
        ScheduledFuture<?> future = service.scheduleAtFixedRate(() -> {
            List<WebElement> elements = getDriver()
                    .findElement(By.id("com.tencent.android.qqdownloader:id/xi"))
                    .findElements(By.className("android.widget.RelativeLayout"));
            for (WebElement element : elements) {
                try {
                    if (AppiumElementUtils.isElementExsit(element, By.id("com.tencent.android.qqdownloader:id/st"))) {
                        Map<String, String> map = new LinkedHashMap<>();
                        map.put("姓名", element.findElement(By.id("com.tencent.android.qqdownloader:id/ek")).getText());
                        map.put("评分", element.findElement(By.id("com.tencent.android.qqdownloader:id/rs")).getText());
                        map.put("版本", element.findElement(By.id("com.tencent.android.qqdownloader:id/z3")).getText());
                        map.put("评论", element.findElement(By.id("com.tencent.android.qqdownloader:id/st")).getText());
                        map.put("日期", element.
                                findElement(By.id("com.tencent.android.qqdownloader:id/z6")).getText());
                        map.put("点赞", element.findElement(By.id("com.tencent.android.qqdownloader:id/ss")).getAttribute("content-desc"));
                        if (!mapMap.containsValue(map)) mapMap.put(mapMap.size(), map);
                        if (mapMap.size() >= finalNumber) {
                            System.out.println("关闭");
                            countDownLatch.countDown();
                        }
                        System.out.println(mapMap);
                    }
                } catch (NoSuchElementException ignored) {
                    break;
                }
            }
            AppiumOperatingUtils.swipeBottomToTop();
        }, 0, 1, TimeUnit.SECONDS);
        countDownLatch.await();
        future.cancel(true);
        service.shutdown();
    }


    @Override
    public void checkCurrentPage(AppBook appBook) {

    }

    @Override
    protected void enterThisModule() {

    }

    @BeforeClass
    @Override
    protected void classPresetConditions() {

    }

    @Override
    protected EnumBookList getCurrentPageBooks() {
        return null;
    }


}
