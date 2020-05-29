package com.cxb.cxb_object.app_client_enum_impl.boutique_page;

import com.cxb.cxb_interface.enum_interface.WEMIF;
import com.AppiumUtils.AppByUtils;

public class BoutiquePageHomeEnumInterfaceImpl extends WEMIF {
    public static WEMIF BOOK_NAME = new BoutiquePageHomeEnumInterfaceImpl(AppByUtils.idJointAppName("search_result_title_view"));
    public static WEMIF BOOK_AUTHOR = new BoutiquePageHomeEnumInterfaceImpl(AppByUtils.idJointAppName("search_result_author_view"));
    public static WEMIF BOOK_SUMMARY = new BoutiquePageHomeEnumInterfaceImpl(AppByUtils.idJointAppName("search_result_author_view"));


    private BoutiquePageHomeEnumInterfaceImpl(Object by) {
        super(by);
    }
}
