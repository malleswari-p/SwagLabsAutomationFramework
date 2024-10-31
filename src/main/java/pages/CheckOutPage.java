package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

import java.util.List;

public class CheckOutPage {

    private WebDriver driver;
    ElementUtils elementUtils;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Checkout: Your Information')]")
    private WebElement checkOutInfo;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continueBtn;

    @FindBy(css = ".cart_cancel_link.btn_secondary")
    private WebElement cancelBtn;

    @FindBy(xpath = "//div[contains(text(),'Checkout: Overview')]")
    private WebElement checkoutOverviewHeader;

    @FindBy(xpath = "//*[@id='checkout_info_container']//h3")
    private WebElement warningMsgText;

    @FindBy(css = ".btn_action.cart_button")
    private WebElement finishBtn;

    @FindBy(xpath = "//*[@class='summary_info']//*[starts-with(@class,'summary_')]")
    private List<WebElement> summaryInfo;

    @FindBy(xpath = "//*[@class='cart_list']//div")
    private List<WebElement> productInfo;

    @FindBy(xpath = "//div[@class='summary_quantity']")
    private List<WebElement> prodQuantity;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> prodName;

    @FindBy(xpath = "//*[@class='summary_subtotal_label']")
    private WebElement itemTot;

    @FindBy(xpath = "//*[@class='summary_tax_label']")
    private WebElement taxLab;

    @FindBy(xpath = "//*[@class='summary_total_label']")
    private WebElement totalLab;

    public boolean verifyCheckoutInfo(){
        return elementUtils.displayStatusOfElement(checkOutInfo, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public WebElement enterFirstName(){
        return firstNameField;
    }

    public WebElement enterLastName(){
        return lastNameField;
    }

    public WebElement enterPostalCode(){
        return postalCodeField;
    }

    public void clickContinueBtn(){
        elementUtils.clickOnElement(continueBtn,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnCancelBtn(){
        elementUtils.clickOnElement(cancelBtn,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public boolean verifyCheckOutOverviewHeading(){
        return elementUtils.displayStatusOfElement(checkoutOverviewHeader,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnFinishBtn(){
        elementUtils.clickOnElement(finishBtn,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getWarningMsgText(){
        return elementUtils.getAttributeTextFromElement(warningMsgText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public List<WebElement> getSummaryInfo(){
        return summaryInfo;
    }

    public List<WebElement> getProductInfo(){
        return productInfo;
    }

    public List<WebElement> getProductQuantity(){
        return prodQuantity;
    }

    public List<WebElement> getProductSummary(){
        return prodName;
    }

    public WebElement getItemTotal(){
        return itemTot;
    }

    public WebElement getTaxValue(){
        return taxLab;
    }

    public WebElement getTotalPrice(){
        return totalLab;
    }
}
