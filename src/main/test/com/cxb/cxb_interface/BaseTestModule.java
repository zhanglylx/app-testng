package com.cxb.cxb_interface;

import com.cxb.entity.AppBook;
import org.testng.annotations.BeforeClass;


/**
 * 模块基础类，用于进入和检查此模块，已生成了固定方法
 * 如果需要自定义模块的进入和检查方法，请直接继承BastTest类
 */
public abstract class BaseTestModule extends BaseTest {

    /**
     * 检查当前页面
     * @param appBook
     */
    public abstract void checkCurrentPage(AppBook appBook);

    public void goToEnterThisModule() {
        goToEnterThisModule(null);
    }

    public void goToEnterThisModule(AppBook appBook) {
        this.resetInterfaceEntry();
        this.enterThisModule();
        this.checkCurrentPage(appBook);
    }

    /**
     * 进入此模块
     */
    protected abstract void enterThisModule();

    /**
     * 测试用例预置条件
     */
    @BeforeClass
    protected abstract void classPresetConditions();
}
