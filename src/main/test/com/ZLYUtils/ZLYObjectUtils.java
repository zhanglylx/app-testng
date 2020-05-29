package com.ZLYUtils;

public class ZLYObjectUtils {

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) throws ClassCastException {
        return (T) obj;
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj, T t) throws ClassCastException {
        return cast(obj);
    }
}
