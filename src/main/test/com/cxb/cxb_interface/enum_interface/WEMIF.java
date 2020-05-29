package com.cxb.cxb_interface.enum_interface;

import com.AppiumUtils.AppiumElementUtils;
import com.ZLYUtils.ATAUtils;
import com.cxb.cxb_drives.CXBAppiumDrive;
import com.cxb.cxb_interface.array_traversal.WebElementArrayTraversal;
import com.cxb.entity.WEMAttribute;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;


/**
 * 元素接口
 */
public abstract class WEMIF {

    private EnumGetElement enumGetElement;
    private EnumScript enumScript;
    private Object objectElement;
    private Integer elementIndex;


    protected WEMIF(EnumGetElement enumGetElement, Object o) {
        this(enumGetElement, null, o, null);
    }


    protected WEMIF(Object by, int number) {
        this(null, null, by, number);
    }

    protected WEMIF(EnumScript enumScript, Object by) {
        this(null, enumScript, by, null);
    }

    protected WEMIF(Object object) {
        this(null, null, object, null);
    }

    protected WEMIF(EnumGetElement enumGetElement, EnumScript enumScript, Object objectElement, Integer elementIndex) {
        this.enumGetElement = enumGetElement;
        this.enumScript = enumScript;
        this.objectElement = objectElement;
        this.elementIndex = elementIndex;
    }


    public boolean isElementExist() {
        return AppiumElementUtils.isElementExsit(this.objectElement);
    }


    public WebElement getWebElement() {
        if (this.enumGetElement != null) {
            return this.enumGetElement.getElement(getListWebElement());
        }
        runEnumScript();
        if (this.elementIndex != null) {
            return CXBAppiumDrive.getInstance().findElementList(this.objectElement).get(this.elementIndex);
        } else {
            return CXBAppiumDrive.getInstance().findElement(this.objectElement);
        }
    }

    public void click() {
        this.getWebElement().click();
    }

    public String getText() {
        return this.getWebElement().getText();
    }

    public List<WebElement> getListWebElement() {
        runEnumScript();
        return CXBAppiumDrive.getInstance().findElementList(this.objectElement);
    }

    private void runEnumScript() {
        if (this.enumScript != null) this.enumScript.run();
    }

    public WEMAttribute getWEMAttribute() {
        return new WEMAttribute(this.getWebElement());
    }

    public Object getObjectElement() {
        return objectElement;
    }


}

