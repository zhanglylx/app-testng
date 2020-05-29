package com.AppiumUtils;


import com.ZLYUtils.AdbUtils;
import com.ZLYUtils.JavaUtils;
import com.cxb.cxb_drives.CXBAppiumDrive;
import com.cxb.cxb_drives.MobileDrive;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.ArrayUtils;

import java.time.Duration;

public class AppiumOperatingUtils {


    /**
     * 通过坐标点击元素
     *
     * @param x x坐标
     * @param y y坐标
     * @author zly
     * @date 2020-05-29
     */
    public static void clickScreen(int x, int y) {
        AndroidTouchAction action = new AndroidTouchAction(CXBAppiumDrive.getInstance().getDriver());
        action.tap(ElementOption.point(x, y)).perform().release();
    }

    /**
     * This Method for swipe up
     * 从下往上滑 执行完成后默认等待1秒时间
     *
     * @author zly
     * @date 2020-05-29
     */
    public static void swipeBottomToTop() {
        swipeBottomToTop(1000);
    }

    /**
     * This Method for swipe up
     * 从下往上滑
     *
     * @param waitMillisecond 执行完成后需要等待的时间
     * @author zly
     * @date 2020-05-29
     */
    public static void swipeBottomToTop(int waitMillisecond) {
        checkLessThanZero(waitMillisecond);
        int width = CXBAppiumDrive.getInstance().getWidth();
        int height = CXBAppiumDrive.getInstance().getHeight();
//        使用appium自带的不大好用
//        AndroidTouchAction touchAction = new AndroidTouchAction(CXBAppiumDrive.getInstance().getDriver());
//        touchAction.waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitMillisecond)));
//        touchAction.press(ElementOption.point(width / 2,
//                height * 3 / 4));
//        touchAction.moveTo(ElementOption.point(width / 2, height / 4));
//        touchAction.release();
//        touchAction.perform();
        swipe(width / 2, (int) (height * 0.9), width / 2, (int) (height * 0.8), waitMillisecond);
    }

    /**
     * 滑动屏幕
     *
     * @param startX          起始点x坐标
     * @param startY          起始点y坐标
     * @param endX            滑动到终点x坐标
     * @param endY            滑动到终点y坐标
     * @param waitMillisecond 滑动结束后等待时间
     * @date 2020-05-29
     */
    public static void swipe(int startX, int startY, int endX, int endY, int waitMillisecond) {
        checkLessThanZero(startX, startY, endX, endY, waitMillisecond);
        if (AdbUtils.executeAdbCommand(String.format("shell input swipe %d %d %d %d", startX, startY, endX, endY)).size() != 0) {
            throw new RuntimeException();
        } else {
            JavaUtils.sleep(waitMillisecond);
        }
    }

    private static void checkLessThanZero(int... number) {
        for (int n : number) {
            if (n < 0)
                throw new IllegalArgumentException("This array has Numbers less than 0:" + ArrayUtils.toString(number));
        }

    }


}
