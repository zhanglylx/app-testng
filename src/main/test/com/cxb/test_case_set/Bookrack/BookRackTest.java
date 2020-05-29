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

public class BookRackTest extends BaseTestModule {
    @Override
    public void checkCurrentPage(AppBook appBook) {
        AppAssert.assertTrue(BookRackWEMIFImpl.BOOK_RACK.getWEMAttribute().getSelected());
    }

    @Test
    public void deleteAllBook() {
        BookRackWEMIFImpl.BOOK_MANAGEMENT_BOOK_MANAGEMENT.click();
    }

    @Override
    protected void enterThisModule() {
        this.resetInterfaceEntry();
    }

    /**
     * 测试用例预置条件
     */
    @BeforeClass
    @Override
    protected void classPresetConditions() {

    }

    @Override
    protected EnumBookList getCurrentPageBooks() {
        return BookRackEnumBookListImpl.BOOK_RACK_ENUM_BOOK_LIST;
    }


}
