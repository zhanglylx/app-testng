package com.cxb.cxb_object.app_client_enum_impl.bookrack.ReadingRecord;

import com.cxb.cxb_interface.enum_interface.WEMIF;
import com.AppiumUtils.AppByUtils;

/**
 * 阅读记录
 */
public class ReadingRecordWEMIFlmpl extends WEMIF {
    public static WEMIF BOOK_NAME = new ReadingRecordWEMIFlmpl(AppByUtils.idJointAppName("search_result_title_view"));
    public static WEMIF BOOK_AUTHOR = new ReadingRecordWEMIFlmpl(AppByUtils.idJointAppName("search_result_author_view"));
    public static WEMIF BOOK_READ_DATE = new ReadingRecordWEMIFlmpl(AppByUtils.idJointAppName("search_read_last_time"));
    //加入书架 或者 开始阅读按钮
    public static WEMIF BOOK_ADD_BOOK_RACJ = new ReadingRecordWEMIFlmpl(AppByUtils.idJointAppName("tv_add_shelf"));
    //阅读进度
    public static WEMIF BOOK_READ_SCHEDULE = new ReadingRecordWEMIFlmpl(AppByUtils.idJointAppName("com.mianfeizs.book:id/tv_add_shelf"));

    private ReadingRecordWEMIFlmpl(Object object) {
        super(object);
    }
}
