package com.cxb.cxb_object.app_client_enum_impl.bookrack;

import com.AppiumUtils.AppiumElementUtils;
import com.cxb.cxb_interface.enum_interface.EnumBookList;
import com.cxb.entity.AppBook;

import java.util.List;


/**
 * 书架获取全部书籍
 */
public enum BookRackEnumBookListImpl implements EnumBookList {
    BOOK_RACK_ENUM_BOOK_LIST;

    @Override
    public List<AppBook> getCurrentPageBooks() {
        return AppiumElementUtils.setBookInfo(
                BookRackWEMIFImpl.BOOK_NAME
                , BookRackWEMIFImpl.BOOK_AUTHOR, null);
    }
}
