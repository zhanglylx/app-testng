package com.cxb.test_case_set.Bookrack;

import com.cxb.cxb_drives.AppAssert;
import com.cxb.cxb_interface.BaseTestModule;
import com.cxb.cxb_interface.enum_interface.EnumBookList;
import com.cxb.cxb_object.app_client_enum_impl.bookrack.BookRackEnumBookListImpl;
import com.cxb.cxb_object.app_client_enum_impl.bookrack.BookRackWEMIFImpl;
import com.cxb.cxb_object.app_client_enum_impl.bookrack.BooksOnManagermentWEMIFImpl;
import com.cxb.entity.AppBook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


/**
 * 书籍管理测试
 */
public class BooksOnManagermentTest extends BaseTestModule {

    /**
     * 删除所有书籍
     */
    @Test
    protected void deleteAllBook() {
        List<AppBook> list = new BookRackTest().getCurrentPageBooks().getCurrentPageBooks();
        if (list.size() == 0) return;
        AppAssert.assertEquals(BooksOnManagermentWEMIFImpl.CHECK_ALL_BUTTON.getText(), "全选");
        BooksOnManagermentWEMIFImpl.CHECK_ALL_BUTTON.click();
        AppAssert.assertEquals(BooksOnManagermentWEMIFImpl.CHECK_ALL_BUTTON.getText(), "全不选");
        BooksOnManagermentWEMIFImpl.DELETE_BUTTON.click();
        BooksOnManagermentWEMIFImpl.DELETE_SOURCE_FILE.click();
        BooksOnManagermentWEMIFImpl.DELETE_SURE_BUTTON.click();
        list = new BookRackTest().getCurrentPageBooks().getCurrentPageBooks();
        AppAssert.assertEquals(list.size(), 0);
        AppAssert.assertElementIsExist(BookRackWEMIFImpl.CLICK_ADD_BOOK);
    }

    public void deleteBook() {

    }

    /**
     * 检查当前页面
     *
     * @param appBook
     */
    @Override
    public void checkCurrentPage(AppBook appBook) {
        AppAssert.assertElementIsExist(BooksOnManagermentWEMIFImpl.MOVE_BUTTON);
        AppAssert.assertElementIsExist(BooksOnManagermentWEMIFImpl.DELETE_BUTTON);
        AppAssert.assertElementIsExist(BooksOnManagermentWEMIFImpl.CHECK_ALL_BUTTON);
    }

    /**
     * 进入此模块
     */
    @Override
    protected void enterThisModule() {

        BookRackWEMIFImpl.BOOK_MANAGEMENT_BOOK_MANAGEMENT.click();
    }

    /**
     * 测试用例预置条件
     */
    @BeforeClass
    @Override
    protected void classPresetConditions() {
        this.goToEnterThisModule();
    }

    /**
     * 获取当前页面的bookList
     *
     * @return
     */
    @Override
    protected EnumBookList getCurrentPageBooks() {
        return BookRackEnumBookListImpl.BOOK_RACK_ENUM_BOOK_LIST;
    }
}
