package com.cxb.cxb_object.app_client_enum_impl;

import com.cxb.cxb_interface.enum_interface.EnumGetElement;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EnumGetElementImplTest implements EnumGetElement {
    private String text;

    public EnumGetElementImplTest(String text) {
        this.text = text;
    }

    @Override
    public WebElement getElement(List<WebElement> webElementList) {
        return null;
    }
}
