package com.ZLYUtils;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ZLYRandNumberUtils {
    /**
     * 获取随机数
     *
     * @param min
     * @param max
     * @return
     */

    public static int getRandomNumbers(int min, int max) {
        if (min > max) throw new IllegalArgumentException("min > max");
        return new SecureRandom().nextInt(max) % (max - min) + min;
    }

    /**
     * 获取指定位数的随机串
     *
     * @param lenth
     * @return
     */
    public static long getRandomSpecifyNumbers(int lenth) {
        if (lenth < 1) throw new IllegalArgumentException("lenth 小于0，lenth :" + lenth);
        if (lenth > 19) throw new IllegalArgumentException("lenth 大于19位数，lenth :" + lenth);
        return (long) ((Math.random() * 9 + 1) * Math.pow(10, lenth - 1));
    }

    /**
     * 获取集合的随机内容
     * @param o
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getRandomArray(Object o) {
        if (o instanceof List) return (T) ((List) o).get(getRandomNumbers(0, ((List) o).size()));
        if (o instanceof Map) return (T) ((Map) o).get(getRandomNumbers(0, ((Map) o).size()));
        if (o.getClass().isArray()) return (T) Array.get(o, Array.getLength(o));
        return null;

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("2222");
        System.out.println(Objects.requireNonNull(getRandomArray(list)).toString());;
    }
}
