package com.cxb.cxb_object.app_client_enum_impl.bookrack;

import com.cxb.cxb_interface.enum_interface.WEMIF;
import com.AppiumUtils.AppByUtils;

/**
 * 书籍管理
 */
public class BooksOnManagermentWEMIFImpl extends WEMIF {
    //移动按钮
    public static WEMIF MOVE_BUTTON = new BooksOnManagermentWEMIFImpl(AppByUtils.idJointAppName("tab_move_tv"));
    //删除按钮
    public static WEMIF DELETE_BUTTON = new BooksOnManagermentWEMIFImpl(AppByUtils.idJointAppName("tab_delete_tv"));
    //完成按钮
    public static WEMIF ACCOMPLIST_BUTTON = new BooksOnManagermentWEMIFImpl(AppByUtils.idJointAppName("cancle"), 1);
    //选中状态按钮(√)
    public static WEMIF BOOK_SELECT_CHECKBOX = new BooksOnManagermentWEMIFImpl(AppByUtils.idJointAppName("book_select_checkbox"));
    //全选/全不选按钮
    public static WEMIF CHECK_ALL_BUTTON = new BooksOnManagermentWEMIFImpl(AppByUtils.idJointAppName("cancle"), 0);
    //同时删除源文件复选框
    public static WEMIF DELETE_SOURCE_FILE = new BooksOnManagermentWEMIFImpl(AppByUtils.idJointAppName("ygz_common_bottom_check"));
    //删除取消按钮
    public static WEMIF DELETE_CANCEL_BUTTON = new BooksOnManagermentWEMIFImpl(AppByUtils.idJointAppName("ygz_common_bottom_cancel"));
    //删除确定按钮
    public static WEMIF DELETE_SURE_BUTTON = new BooksOnManagermentWEMIFImpl(AppByUtils.idJointAppName("ygz_common_bottom_sure"));


    private BooksOnManagermentWEMIFImpl(Object by, int number) {
        super(by, number);
    }

    private BooksOnManagermentWEMIFImpl(Object object) {
        super(object);
    }

}
