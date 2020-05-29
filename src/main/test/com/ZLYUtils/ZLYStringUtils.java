package com.ZLYUtils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ZLYUtils.ZLYRandNumberUtils.getRandomNumbers;

public class ZLYStringUtils {
    /**
     * 将字符串路径替换成系统路径
     *
     * @param path
     * @return
     */
    public static String replaceFilePathSymbol(String path) {
        if (path == null) throw new NullPointerException();
        path = path.replace("\\", File.separator);
        path = path.replace("/", File.separator);
        return path;
    }


    /**
     * 常见的中文字符
     *
     * @param number 数量
     * @return
     */
    public static String generateCN(int number) {
        if (number < 1) throw new IllegalArgumentException("参数小于1");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            stringBuilder.append(generateCN());
        }
        return stringBuilder.toString();
    }

    /**
     * 常见的中文字符
     *
     * @return
     */
    public static String generateCN() {
        String str = null;
        int hightPos, lowPos; // 定义高低位
        Random random = new Random();
        hightPos = (176 + Math.abs(random.nextInt(39)));// 获取高位值
        lowPos = (161 + Math.abs(random.nextInt(93)));// 获取低位值
        byte[] b = new byte[2];
        b[0] = (new Integer(hightPos).byteValue());
        b[1] = (new Integer(lowPos).byteValue());
        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }// 转成中文
        return str;
    }

    //随机产生英文
    public static String generateEN() {
        String str = null;
        str = (char) (Math.random() * 26 + 'A') + "";
        return str;
    }

    /**
     * 随机生成指定返回随机个数的中文
     *
     * @param min
     * @param max
     * @return
     */
    public static String generateCN(int min, int max) {

        return generateCN(getRandomNumbers(min, max));
    }


    /**
     * 将字符串格式化
     *
     * @param str
     * @return
     */
    public static String strFormatting(Object... str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object s : str) {
            stringBuilder.append("【");
            stringBuilder.append(s.toString());
            stringBuilder.append("】");
        }
        return stringBuilder.toString();
    }

    /**
     * 检查字符串匹配度
     *
     * @param str1
     * @param str2
     * @return 未匹配成功数量
     */
    private static int ldStr(String str1, String str2) {
        int d[][];    //矩阵
        int n = str1.length();
        int m = str2.length();
        int i;    //遍历str1的
        int j;    //遍历str2的
        char ch1;    //str1的
        char ch2;    //str2的
        int temp;    //记录相同字符,在某个矩阵位置值的增量,不是0就是1
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++) {    //初始化第一列
            d[i][0] = i;
        }
        for (j = 0; j <= m; j++) {    //初始化第一行
            d[0][j] = j;
        }
        for (i = 1; i <= n; i++) {    //遍历str1
            ch1 = str1.charAt(i - 1);
            //去匹配str2
            for (j = 1; j <= m; j++) {
                ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                //左边+1,上边+1, 左上角+temp取最小
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
            }
        }
        return d[n][m];
    }

    /**
     * 字符串的相似度
     *
     * @param matching 匹配字符串
     * @param target   目标字符串
     * @return
     */
    public static double sim(String matching, String target, int scale) {
        if (matching == null) throw new IllegalArgumentException("matching为空");
        if (target == null) throw new IllegalArgumentException("target为空");
        int ld = ldStr(strHashAscSort(matching), strHashAscSort(target));
        double d = 1 - (double) ld / Math.max(matching.length(), target.length());
        return DoubleOperationUtils.round(d, scale);

    }

    /**
     * 字符串的相似度
     *
     * @param matching 匹配字符串
     * @param target   目标字符串
     * @return
     */
    public static double sim(String matching, String target) {
        return sim(matching, target, 1);
    }


    /**
     * 替换换行符
     *
     * @param str       替换字符串
     * @param alternate 替换内容
     * @return
     */
    public static String replaceLineBreak(String str, String alternate) {
        Pattern CRLF = Pattern.compile("(\r\n|\r|\n|\n\r)");
        Matcher m = CRLF.matcher(str);
        if (m.find()) {
            str = m.replaceAll(alternate);
        }
        return str;
    }

    /**
     * 编辑距离算法
     * 编辑距离的两字符串相似度
     *
     * @author jianpo.mo
     */

    private static int min(int one, int two, int three) {
        int min = one;
        if (two < min) {
            min = two;
        }
        if (three < min) {
            min = three;
        }
        return min;
    }


    /**
     * 字符串通过哈希升序排序
     *
     * @param str
     * @return
     */
    public static String strHashAscSort(String str) {
        if (str.length() <= 1) return str;       //如果只有一个元素就不用排序了
        char[] arr = str.toCharArray();
        boolean flag;
        for (int i = 0; i < str.length(); ++i) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            flag = false;
            for (int j = 0; j < str.length() - i - 1; ++j) {        //此处你可能会疑问的j<n-i-1，因为冒泡是把每轮循环中较大的数飘到后面，
                // 数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if (arr[j] > arr[j + 1]) {        //即这两个相邻的数是逆序的，交换
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }

            if (!flag) break;//没有数据交换，数组已经有序，退出排序

        }
        return String.valueOf(arr);
    }


    /**
     * @param preNumber 前缀
     * @param index     序列
     * @return
     */
    public static String getUserNo(int preNumber, Long index) {
        //  （1）第一个%d代表整数类型（十进制），是preNumber的占位符，拼接字符串的时候会用preNumber的值进行替换。
        //  （2）第二个%010d，前面第一个0代表：数字前面补0；后面的10代表字符总长度为10，d代表整数类型。这个表达式的整体含义就是，用index的值来替换此处表达式，如果index的长度不足10位，则在index的前面用0补齐。
        return String.format("%d%010d", preNumber, index);
    }


    public static byte[] getMd5Byte(Object... str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
        char[] charArray = StringUtils.join(str).toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }

        return md5.digest(byteArray);
    }

    public static String getMD5Str(Object... str) {
        return getMD5Str(false, str);
    }

    /**
     * 生成md5
     *
     * @param str
     * @param urlEndecode 是否需要url转码
     * @return
     */
    public static String getMD5Str(boolean urlEndecode, Object... str) {
        try {
            String string = StringUtils.join(str);
            if (urlEndecode) string = HttpUtils.getEncoderString(string, StandardCharsets.UTF_8);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(string.getBytes(StandardCharsets.UTF_8));
            byte[] messageDigest = md5.digest();
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < messageDigest.length; i++) {
                String t = Integer.toHexString(0xFF & messageDigest[i]);
                if (t.length() == 1) {
                    hexString.append("0").append(t);
                } else {
                    hexString.append(t);
                }
            }
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println("--'");
        System.out.println(getUserNo(333333553, 233333333333333L));
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getRandonStr() {
        return JavaUtils.currentTimeMillisString() + getUUID();
    }

}
