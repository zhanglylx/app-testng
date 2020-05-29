package com.cxb.entity;

import org.openqa.selenium.WebElement;

import java.io.Serializable;

public class WEMAttribute implements Serializable {
    private WebElement webElement;

    public WEMAttribute(WebElement webElement) {
        this.webElement = webElement;
    }

    public Boolean getSelected() {
        return Boolean.parseBoolean(this.webElement.getAttribute("selected"));
    }

    public int getX() {
        return this.webElement.getLocation().getX();
    }

    public int getY() {
        return this.webElement.getLocation().getY();
    }


}
