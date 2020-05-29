package com.AppiumUtils;

public class AppiumUiSelectorUtils {

    public static String textUiSelector(String text) {
        return newUiSelector("text", text);
    }

    public static String textContainsUiSelector(String text) {
        return newUiSelector("textContains", text);
    }

    public static String textMatchesUiSelector(String text) {
        return newUiSelector("textMatches", text);
    }

    public static String textStartsWithUiSelector(String text) {
        return newUiSelector("textStartsWith", text);
    }

    public static String descriptionUiSelector(String desc) {
        return newUiSelector("description", desc);
    }

    public static String descriptionContainsUiSelector(String desc) {
        return newUiSelector("descriptionContains", desc);
    }

    public static String descriptionMatchesUiSelector(String desc) {
        return newUiSelector("descriptionMatches", desc);
    }

    public static String descriptionStartsWithUiSelector(String desc) {
        return newUiSelector("descriptionStartsWith", desc);
    }

    /**
     * 类的孩子
     *
     * @param UiSelector
     * @return
     */
    public static String childSelectorUiSelector(String UiSelector) {
        return newUiSelector("childSelector", UiSelector);
    }

    /**
     * 通过类名查找
     *
     * @param className
     * @return
     */
    public static String classNameUiSelector(String className) {
        return newUiSelector("className", className);
    }


    public static String newUiSelector(String key, String values) {
        return "new UiSelector()." + key.trim() + "(\"" + values.trim() + "\")";
    }
}
