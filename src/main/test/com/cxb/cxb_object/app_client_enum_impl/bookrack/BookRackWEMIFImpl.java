package com.cxb.cxb_object.app_client_enum_impl.bookrack;

import com.AppiumUtils.AppiumElementUtils;
import com.cxb.cxb_interface.enum_interface.EnumGetElement;
import com.cxb.cxb_interface.enum_interface.WEMIF;
import com.cxb.cxb_interface.enum_interface.EnumScript;
import com.cxb.cxb_object.app_client_enum_impl.EnumGetElementImplTest;
import com.AppiumUtils.AppByUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 书架
 */
public class BookRackWEMIFImpl extends WEMIF {
    public static WEMIF BOOK_RACK = new BookRackWEMIFImpl(new FindBookRackButton(), By.className("android.widget.TextView"));
    //书籍名称
    public static WEMIF BOOK_NAME = new BookRackWEMIFImpl(AppByUtils.idJointAppName("txt_book_name"));
    //书籍图片
    public static WEMIF BOOK_IMG = new BookRackWEMIFImpl(AppByUtils.idJointAppName("img_book_cover"));
    //书籍作者
    public static WEMIF BOOK_AUTHOR = new BookRackWEMIFImpl(AppByUtils.idJointAppName("tv_name"));
    //书籍已读进度
    public static WEMIF BOOK_READ_PROGRESS = new BookRackWEMIFImpl(AppByUtils.idJointAppName("txt_book_desc"));
    //添加小说
    public static WEMIF BOOK_ADD_BOOK = new BookRackWEMIFImpl(new EnumGetElementImplTest("点击添加小说"), BOOK_AUTHOR);
    //书籍已下架
    public static WEMIF BOOK_SHELVES = new BookRackWEMIFImpl(AppByUtils.idJointAppName("img_shelves"));
    //书籍更新
    public static WEMIF BOOK_UPDATE = new BookRackWEMIFImpl(AppByUtils.idJointAppName("shelf_book_chapter_update_tip"));
    //签到图片
    public static WEMIF BOOK_SIGN_IN = new BookRackWEMIFImpl(AppByUtils.idJointAppName("imageView"), 0);
    //会员
    public static WEMIF BOOK_MEMBERS = new BookRackWEMIFImpl(AppByUtils.idJointAppName("imageView"), 1);
    //搜索
    public static WEMIF BOOK_SEARCH = new BookRackWEMIFImpl(AppByUtils.idJointAppName("imageView"), 2);
    //阅读记录
    public static WEMIF BOOK_READING_RECORD = new BookRackWEMIFImpl(AppByUtils.idJointAppName("imageView"), 3);
    //管理
    public static WEMIF BOOK_MANAGEMENT = new BookRackWEMIFImpl(AppByUtils.idJointAppName("imageView"), 4);
    //书籍管理文字元素
    public static WEMIF BOOK_MANAGEMENT_BOOK_MANAGEMENT = new BookRackWEMIFImpl(null, new OpenManagementEnumScriptImpl(AppByUtils.idJointAppName("item_rv3_more_title")), AppByUtils.idJointAppName("item_rv3_more_title"), 0);
    //导入本地书文字元素
    public static WEMIF BOOK_MANAGEMENT_IMPORT_LOCAL_BOOK = new BookRackWEMIFImpl(null, new OpenManagementEnumScriptImpl(AppByUtils.idJointAppName("item_rv3_more_title")), AppByUtils.idJointAppName("item_rv3_more_title"), 1);
    //点击添加小说
    public static WEMIF CLICK_ADD_BOOK = new BookRackWEMIFImpl(AppByUtils.idJointAppName("tv_name"));

    private BookRackWEMIFImpl(EnumGetElement enumGetElement, Object o) {
        this(enumGetElement, null, o, null);
    }


    private BookRackWEMIFImpl(Object by, int number) {
        this(null, null, by, number);
    }

    private BookRackWEMIFImpl(Object object) {
        this(null, null, object, null);
    }

    private BookRackWEMIFImpl(EnumGetElement enumGetElement, EnumScript enumScript, Object objectElement, Integer elementIndex) {
        super(enumGetElement, enumScript, objectElement, elementIndex);
    }

    /**
     * 查找书架按钮
     */
    private static class FindBookRackButton implements EnumGetElement {

        @Override
        public WebElement getElement(List<WebElement> webElementList) {
            return AppiumElementUtils.findWEMListText(webElementList, "书架");
        }
    }

    //获取书籍管理的元素需要先打开书籍管理
    private static class OpenManagementEnumScriptImpl implements EnumScript {
        private By by;

        OpenManagementEnumScriptImpl(By by) {
            this.by = by;
        }

        @Override
        public void run() {
            if (!AppiumElementUtils.isElementExsit(this.by))
                BookRackWEMIFImpl.BOOK_MANAGEMENT.getWebElement().click();
        }
    }

    /**
     * 添加书架元素需要做的一些判断
     */
    private static class AddBookEnumGetElementImpl implements EnumGetElement {


        @Override
        public WebElement getElement(List<WebElement> webElementList) {
            return AppiumElementUtils.findWEMListText(webElementList, "添加小说");
        }
    }
}
