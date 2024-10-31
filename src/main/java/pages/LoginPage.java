package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

    private WebDriver driver;
    ElementUtils elementUtils;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement loginPageLogo;

    @FindBy(xpath = "//*[@id='login_button_container']//h3")
    private WebElement warningMessage;

    public void enterUsername(String usernameText){
        elementUtils.typeTextIntoElement(usernameField,usernameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterPassword(String passwordText){
        elementUtils.typeTextIntoElement(passwordField,passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnLoginButton() {

        elementUtils.clickOnElement(loginButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getWarningMessageText() {
        return elementUtils.getAttributeTextFromElement(warningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public boolean verifyLoginPageLogo(){
        return elementUtils.displayStatusOfElement(loginPageLogo,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
