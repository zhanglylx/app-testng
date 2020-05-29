package com.ZLYUtils;

import com.cxb.cxb_drives.AppAssert;
import net.sf.json.JSONObject;

public class RedisUtils {
    /**
     * 清除redis
     */
    public static void clearRedis() {
        clearRedis(3000);
    }

    public static void clearRedis(long sleepTime) {
        //这里是李明明的接口
        String msg = HttpUtils.doGet(HttpUtils.getURI("http://automation-platform.cread.com:8093/api/cleanRedis/", ""));
        JSONObject jsonObject = JSONObject.fromObject(msg);
        AppAssert.assertEquals(jsonObject.getInt("status"), 200);
        AppAssert.assertEquals(jsonObject.getString("message"), "clean redis success");
        //这是清理黑名单缓存
        String msg1 = HttpUtils.doGet(HttpUtils.getURI("http://manage-cx-qa.ikanshu.cn/book/blacklist/redis", ""));
        AppAssert.assertEquals(msg1, HttpUtils.errCodeFormat(302));
        JavaUtils.sleep(sleepTime);
    }

}
