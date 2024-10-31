package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    ElementUtils elementUtils;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(className = "product_label")
    private WebElement productsHeading;

    @FindBy(className = "bm-burger-button")
    private WebElement sideMenuBtn;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(className = "product_sort_container")
    private WebElement sortProductsOption;

    @FindBy(xpath = "//*[@class='inventory_item']")
    private List<WebElement> productNames;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productTitle;

    @FindBy(xpath = "//div[@class='inventory_details_name']")
    private WebElement prodFullView;

    @FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
    private List<WebElement> addToCartbtn;

    @FindBy(xpath = "//button[contains(text(),'REMOVE')]")
    private List<WebElement> removeBtn;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartBadge;

    @FindBy(className = "inventory_item_img")
    private List<WebElement> imageList;

    @FindBy(className = "inventory_item_price" )
    private List<WebElement> priceList;

    @FindBy(className = "inventory_details_back_button")
    private WebElement backBtn;

    public boolean displayProductsHeadingText(){
        return elementUtils.displayStatusOfElement(productsHeading,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void clickOnSideMenuBtn(){
        elementUtils.clickOnElement(sideMenuBtn,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void clickOnLogoutLink(){
        elementUtils.clickOnElement(logoutLink,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public String getProductText(){
        return elementUtils.getAttributeTextFromElement(productsHeading, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public boolean checkProductsSort(){
        return elementUtils.displayStatusOfElement(sortProductsOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public WebElement selectSortOptionFromDropdown(){
        return sortProductsOption;
    }

    public List<WebElement> checkInventoryItems(){
        return productNames;

    }
    public WebElement shoppingCartBadge(){
        return cartBadge;
    }
    public List<WebElement> clickOnAddToCartBtn(){
        return addToCartbtn;
    }
    public List<WebElement> clickOnRemoveBtn(){
        return removeBtn;
    }
    public List<WebElement> getProductTitle(){
        return productTitle;
    }

    public List<WebElement> getImageList(){
        return imageList;
    }
    public List<WebElement> getPriceList(){
        return priceList;
    }
    public WebElement getProdFullView(){
        return prodFullView;
    }
    public void clickOnBackBtn(){
        elementUtils.clickOnElement(backBtn,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
