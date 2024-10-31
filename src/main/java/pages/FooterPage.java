package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

public class FooterPage {

    private WebDriver driver;
    ElementUtils elementUtils;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(xpath = "/html/body/footer")
    private WebElement footer;

    @FindBy(className = "footer_copy")
    private WebElement footerText;

    @FindBy(linkText = "Twitter")
    private WebElement twitterLink;

    @FindBy(linkText = "Facebook")
    private WebElement facebookLink;

    @FindBy(linkText = "LinkedIn")
    private WebElement linkedInLink;

    public boolean footerDisplay(){
        return elementUtils.displayStatusOfElement(footer, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getFooterText(){
        return elementUtils.getTextFromElement(footerText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnTwitterLink(){
        elementUtils.clickOnElement(twitterLink, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnFacebookLink(){
        elementUtils.clickOnElement(facebookLink,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnLinkedInLink(){
        elementUtils.clickOnElement(linkedInLink,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
