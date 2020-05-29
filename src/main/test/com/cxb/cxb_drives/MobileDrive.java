package com.cxb.cxb_drives;

import com.ZLYUtils.AdbUtils;

import java.util.List;


/**
 * 手机设备信息
 */
public class MobileDrive {
    private static MobileDrive mobileDrive;

    public String getMobileVersion() {
        return mobileVersion;
    }

    private String mobileVersion;

    public String getDriveName() {
        return mobileName;
    }

    private String mobileName;

    private MobileDrive() {
        setMobileDrive();
        setMobileVersion();
    }


    /**
     * 设置设备名称
     */
    private void setMobileDrive() {
        List<String> list = AdbUtils.executeAdbCommand("devices");
        AppAssert.assertEquals(list.size(), 3, "获取设备信息");
        AppAssert.assertContainStr(list.get(1), "device");
        this.mobileName = list.get(1).replaceAll("device", "").trim();
    }

    private void setMobileVersion() {
        List<String> list = AdbUtils.executeAdbCommand("shell getprop ro.build.version.release");
        AppAssert.assertEquals(list.size(), 1);
        this.mobileVersion = list.get(0).trim().split("\\.")[0];
        AppAssert.assertTrue(Double.parseDouble(this.mobileVersion) > 6, this.mobileVersion, 6, "版本需要大于6.0");

    }

    public static MobileDrive getInstance() {
        if (mobileDrive == null) {
            mobileDrive = new MobileDrive();
        }
        return mobileDrive;
    }


}
