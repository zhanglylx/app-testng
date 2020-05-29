package com.ZLYUtils;


import com.cxb.cxb_interface.array_traversal.BookArrayTraversal;
import com.cxb.cxb_interface.array_traversal.JSONArrayTraversal;
import com.cxb.cxb_interface.array_traversal.WebElementArrayTraversal;
import com.cxb.entity.AppBook;
import net.sf.json.JSONArray;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ATAUtils {
    public static void JSONArrayAnalysis(JSONArray jsonArray, JSONArrayTraversal jsonArrayAnalysis) {
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonArrayAnalysis.traversal(jsonArray.getJSONObject(i));
        }
    }


    public static void traversalBookList(List<AppBook> books, BookArrayTraversal traversalBookList) {
        for (AppBook book : books) {
            traversalBookList.traversal(book);
        }
    }

    public static void traversalListWebElement(List<WebElement> webElementList, WebElementArrayTraversal webElementArrayTraversal) {
        for (WebElement webElement : webElementList) {
            webElementArrayTraversal.traversal(webElement);
        }

    }

}
