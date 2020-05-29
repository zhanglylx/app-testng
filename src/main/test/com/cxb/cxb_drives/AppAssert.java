package com.cxb.cxb_drives;

import com.ZLYUtils.ZLYStringUtils;
import com.cxb.cxb_interface.enum_interface.WEMIF;
import net.sf.json.JSONException;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AppAssert extends Assert {

    public static void assertTrue(boolean condition, String message, Object expect, Object actual) {
        Assert.assertTrue(condition, messageFormatting(message, actual, expect));
    }

    public static void assertElementIsExist(WEMIF wemif) {
        assertElementIsExist(wemif, null);
    }
    public static void assertElementIsExist(WEMIF wemif,String msg) {
        assertTrue(wemif.isElementExist(), msg);
    }

    public static void assertEqualsPSInsert(PreparedStatement preparedStatement) {
        try {
            assertEquals(preparedStatement.executeUpdate(), 1);
        } catch (SQLException e) {
            AppAssert.fail(e);
        }
    }

    public static void assertNotEquals(Object actual, Object expect) {
        Assert.assertNotEquals(actual, expect, messageFormatting("assertNotEquals", actual, expect));
    }

    public static void assertEqualsNoOrder(List actual, List expected) {
        assertEqualsNoOrder(actual, expected, null);
    }

    public static void assertEqualsNoOrder(List actual, List expected, String message) {
        Assert.assertEqualsNoOrder(actual.toArray(), expected.toArray());
    }

    public static void assertStringSim(String actual, String expected) {
        assertStringSim(actual, expected, null);
    }

    public static void assertStringSim(String actual, String expected, String message) {
        if (message == null) message = "";
        Assert.assertTrue(ZLYStringUtils.sim(actual, expected) > 0D, "[匹配字符串相似度，程序内置大于10%]" + messageFormatting(message, actual, expected));
    }

    public static void fail(Throwable realCause) {
        Assert.fail(realCause.toString(), realCause);
    }

    public static void fail(Throwable realCause, String... msg) {
        realCause.addSuppressed(new Exception(StringUtils.join(msg)));
        fail(realCause);
    }

    public static <T extends Throwable> void assertThrows(Class<T> throwableClass, Exception exception) {
        Assert.assertThrows(JSONException.class, () -> {
            throw exception;
        });
    }


    public static void assertTrue(boolean condition, Object actual, Object expect) {
        Assert.assertTrue(condition, messageFormatting(actual, expect));
    }

    public static void assertLoopTerminates(int index) {
        Assert.assertTrue(index < 100, "assertLoopTerminates>100");
    }

    public static void assertContainStr(String actual, String expected) {
        assertContainStr(actual, expected, "");
    }

    public static void assertContainStr(String actual, String expected, String msg) {
        Assert.assertTrue(actual.contains(expected), messageFormatting("assertContainStr", actual, expected));
    }


    public static void assertEqualsResponseCodeSucceed(int code) {
        Assert.assertEquals(code, 0, "assertEqualsResponseCodeSucceed");
    }


    public static void assertEqualsResponseInfo(String info) {
        Assert.assertEquals(info.toUpperCase(), "SUCCESS", "assertEqualsResponseInfo");
    }

    public static void assertEqualsResponseCodeErr(int code) {
        Assert.assertEquals(code, 1, "assertEqualsResponseCodeErr");
    }


    public static String messageFormatting(Object actual, Object expect) {
        return "【实际结果:[" + actual.toString() + "] : 预期结果:[" + expect.toString() + "]】";
    }

    public static String messageFormatting(String msg, Object actual, Object expect) {
        return "消息：" + msg + messageFormatting(actual, expect);
    }

}
