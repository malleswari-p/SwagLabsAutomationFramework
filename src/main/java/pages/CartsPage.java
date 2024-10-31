package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

import java.util.List;

public class CartsPage {

    private WebDriver driver;
    ElementUtils elementUtils;

    public CartsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(css = ".btn_secondary.cart_button")
    private  List<WebElement> removeCartBtn;

    @FindBy(xpath = "//a[contains(text(),'Continue Shopping')]")
    private WebElement continueShoppingBtn;

    @FindBy(css = ".btn_action.checkout_button")
    private WebElement checkOutBtn;

    @FindBy(xpath = "//*[contains(text(),'Your Cart')]")
    private WebElement yourCartHeading;

    public List<WebElement> clickOnRemoveCartBtn(){
        return removeCartBtn;
    }

    public void clickOnContinueShoppingBtn(){
        elementUtils.clickOnElement(continueShoppingBtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnCheckOutBtn(){
        elementUtils.clickOnElement(checkOutBtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public boolean verifyYourCartHeading(){
        return elementUtils.displayStatusOfElement(yourCartHeading,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

}
