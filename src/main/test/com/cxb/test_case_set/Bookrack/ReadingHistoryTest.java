package com.cxb.test_case_set.Bookrack;

import com.cxb.cxb_drives.AppAssert;
import com.cxb.cxb_drives.MobileDrive;
import com.cxb.cxb_interface.BaseTestModule;
import com.cxb.cxb_interface.enum_interface.EnumBookList;
import com.cxb.cxb_object.app_client_enum_impl.bookrack.BookRackEnumBookListImpl;
import com.cxb.cxb_object.app_client_enum_impl.bookrack.BookRackWEMIFImpl;
import com.cxb.cxb_object.app_client_enum_impl.bookrack.BooksOnManagermentWEMIFImpl;
import com.cxb.entity.AppBook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 阅读历史记录测试用例
 */
public class ReadingHistoryTest extends BaseTestModule {
    @Test
    public void sss() {
        BookRackTest bookRackTest = new BookRackTest();
        bookRackTest.enterThisModule();
    }


    @Override
    protected EnumBookList getCurrentPageBooks() {
        return null;
    }

    @Override
    public void checkCurrentPage(AppBook appBook) {
        AppAssert.assertTrue(BooksOnManagermentWEMIFImpl.MOVE_BUTTON.isElementExist());

    }


    @Override
    protected void enterThisModule() {
        BookRackWEMIFImpl.BOOK_READING_RECORD.getWebElement().click();
    }

    /**
     * 测试用例预置条件
     */
    @BeforeClass
    @Override
    protected void classPresetConditions() {
    }


}
