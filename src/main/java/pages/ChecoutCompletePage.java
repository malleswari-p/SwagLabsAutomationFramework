package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

public class ChecoutCompletePage {

    private WebDriver driver;
    ElementUtils elementUtils;

    public ChecoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Finish')]")
    private WebElement finishHeading;

    @FindBy(xpath = "//*[@id='checkout_complete_container']//h2")
    private WebElement successMsg;

    @FindBy(xpath = "//div[@class='complete-text']")
    private WebElement orderDispatchInfo;

    public boolean verifyFinishHeadingText(){
        return elementUtils.displayStatusOfElement(finishHeading, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String verifySuccessMsgText(){
        return elementUtils.getTextFromElement(successMsg,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String verifyOrderDispatchInfo(){
        return elementUtils.getTextFromElement(orderDispatchInfo,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
