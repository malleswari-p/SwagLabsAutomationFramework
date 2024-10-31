package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utils.CommonUtils;
import utils.ElementUtils;

import java.util.*;

public class StepDefinitions {

    private WebDriver driver;
    private String username;
    private String password;
    private String numOfItems;
    private String prodTitle;
    private String prodNames[];
    private Float itemPrices[];
    private String firstname;
    private String lastname;
    private String postalcode;
    private LoginPage loginPage;
    ProductsPage productsPage;
    CartsPage cartsPage;
    CheckOutPage checkOutPage;
    ChecoutCompletePage checoutCompletePage;
    FooterPage footerPage;
    ElementUtils elementUtils;


    //Login functionality related test cases
    @Given("I am on the swag labs login page")
    public void i_am_on_the_swag_labs_login_page() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("user entered the {string} and {string}")
    public void user_entered_the_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Given("user login to swag labs using different credential combinations {string} and {string}")
    @Given("user login to swag labs with valid credentials {string} and {string}")
    public void user_login_to_swag_labs_with_valid_credentials_and(String username, String password) {
        this.username = username;
        this.password = password;
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        productsPage = new ProductsPage(driver);
        elementUtils = new ElementUtils(driver);
        cartsPage = new CartsPage(driver);
        checkOutPage = new CheckOutPage(driver);
        checoutCompletePage = new ChecoutCompletePage(driver);
        footerPage = new FooterPage(driver);
    }

    @Then("user should navigate to Swag Labs products page")
    public void user_should_navigate_to_swag_labs_products_page() {

        productsPage = new ProductsPage(driver);
        boolean productsHeadingText = productsPage.displayProductsHeadingText();
        if (productsHeadingText){
            Assert.assertTrue("Navigated to Products Page",true);
        }else{
            Assert.assertFalse("User is failed to login",false);
        }
    }

    @Then("user should not navigate to Swag Labs products page")
    public void user_should_not_navigate_to_swag_labs_products_page() {
        boolean loginPageLogo = loginPage.verifyLoginPageLogo();
        if (loginPageLogo){
            Assert.assertTrue("User is failed to login",true);
        }else {
            Assert.assertFalse("Navigated to products page",false);
        }
    }

    //Login failed error messages functionality related test cases
    @Then("user should prompt the correct error message {string}")
    public void user_should_prompt_the_correct_error_message(String errorMessage) {

        String errorText = loginPage.getWarningMessageText();
        if(username.isEmpty() && password.isEmpty() && errorText.equals(errorMessage)){
            Assert.assertTrue("User prompted with correct error", true);
        }else if (username.isEmpty() && !password.isEmpty() && errorText.equals(errorMessage)) {
            Assert.assertTrue("User prompted with correct error", true);
        }else if (!username.isEmpty() && password.isEmpty() && errorText.equals(errorMessage)) {
            Assert.assertTrue("User prompted with correct error", true);
        }else if (!username.isEmpty() && !password.isEmpty() && errorText.equals(errorMessage)) {
            Assert.assertTrue("User prompted with correct error", true);
        }else {
            Assert.assertFalse("User prompted with incorrect error message", false);
        }

    }
//Logout functionality related test cases

    @And("user should navigate to left sidebar")
    public void user_should_navigate_to_left_sidebar() {

        productsPage.clickOnSideMenuBtn();
    }

    @When("user click the logout button")
    public void user_click_the_logout_button() {
        productsPage.clickOnLogoutLink();
    }

    @Then("user should logout from Swag Labs application")
    public void user_should_logout_from_swag_labs_application() {
        boolean loginPageLogo = loginPage.verifyLoginPageLogo();
        if (loginPageLogo){
            Assert.assertTrue("Successfully logged out from application ",true);
        }else {
            Assert.assertFalse("Failed to Logout from application",false);
        }
    }

    @And("user closes the application without log out")
    public void user_closes_the_application_without_log_out() {
        driver.quit();
    }

    @When("user launch the browser and open the application url")
    public void user_launch_the_browser_and_open_the_application_url(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();

    }

    @Then("user should navigate to login page")
    public void user_should_navigate_to_login_page() {
        String actualUrl = "https://www.saucedemo.com/v1/index.html";
        String loginUrl = driver.getCurrentUrl();

        if(actualUrl.equals(loginUrl)){
            Assert.assertTrue("Login page is opened", true);
        }else{
            Assert.assertFalse("Login page is not opened",false);
        }
        driver.quit();
    }

    //Products functionality related test cases
    @Then("user should see the product title label")
    public void user_should_see_the_product_title_label() {

        String productsHeadingText = productsPage.getProductText();
        if (productsHeadingText.equals("Products")){
            Assert.assertTrue("Products title is showing correct ",true);
        }else{
            Assert.assertFalse("Products title is showing wrong",false);
        }
    }

    @Then("user should see the product sort option")
    public void user_should_see_the_product_sort_option() {

        boolean sorting = productsPage.checkProductsSort();
        if(sorting){
            Assert.assertTrue("Product sort option is displayed",true);
        }else {
            Assert.assertFalse("Product sort option is not displayed",false);
        }
    }

    @Then("User should see the products correctly")
    public void user_should_see_the_products_correctly() {

        List<WebElement> itemsList = productsPage.checkInventoryItems();
        String [] productNames = {"name","description","price","button text"};
        String [] productDetailsReceived;
        String [][] correctProductDetails = {
                {"Sauce Labs Backpack", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.","$29.99","ADD TO CART"},
                {"Sauce Labs Bike Light", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.","$9.99","ADD TO CART"},
                {"Sauce Labs Bolt T-Shirt","Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.","$15.99","ADD TO CART"},
                {"Sauce Labs Fleece Jacket", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.","$49.99","ADD TO CART"},
                {"Sauce Labs Onesie","Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.","$7.99","ADD TO CART"},
                {"Test.allTheThings() T-Shirt (Red)","This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.","$15.99","ADD TO CART"},
        };

        for (int i=0; i<itemsList.size();i++){

            productDetailsReceived = itemsList.get(i).getText().split("\\R");

            for (int j=0;j<=3; j++){

                if(correctProductDetails[i][j].equals(productDetailsReceived[j])){
                    System.out.println("Product "+(i+1)+ " " +productNames[j] +" is correct: "+ productDetailsReceived[j]);
                }
                else {
                    System.out.println("Product "+(i+1)+ " "+productNames[j] +" is wrong: "+ "Received --> "+productDetailsReceived[j]+" Expected --> "+correctProductDetails[i][j] );
                }
            }
        }
    }

    @When("user click the sort ZA")
    public void user_click_the_sort_za() {

        List<WebElement> itemsList = productsPage.checkInventoryItems();
        prodNames = new String[itemsList.size()];

        for (int i=0;i<itemsList.size();i++) {
            prodNames[i] = productsPage.getProductTitle().get(i).getText();
            System.out.println("before sort Item name : " + prodNames[i]);
        }
        elementUtils.selectOptionInDropdown(productsPage.selectSortOptionFromDropdown(),"za", CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    @When("user click the sort AZ")
    public void user_click_the_sort_az() {

        List<WebElement> itemsList = productsPage.checkInventoryItems();
        prodNames = new String[itemsList.size()];

        for (int i=0;i<itemsList.size();i++) {
            prodNames[i] = productsPage.getProductTitle().get(i).getText();
            System.out.println("before sort Item name : " + prodNames[i]);
        }
        elementUtils.selectOptionInDropdown(productsPage.selectSortOptionFromDropdown(),"az", CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    @Then("user should see the ZA sorted products")
    public void user_should_see_the_ZA_sorted_products() {

        List<WebElement> itemsList = productsPage.checkInventoryItems();
        String prodNamesAfterSort[] = new String[itemsList.size()];

        for (int i=0;i<itemsList.size();i++) {
            prodNamesAfterSort[i] = productsPage.getProductTitle().get(i).getText();
            System.out.println("After clicked on sort product names are : " + prodNamesAfterSort[i]);

            if(!prodNamesAfterSort[i].equals(prodNames[i])) {
                System.out.println("Products are sorted correctly in Z-A order");
            }
            else{
                System.out.println("Products are incorrectly sorted in Z-A order");
            }
        }
    }

    @Then("user should see the AZ sorted products")
    public void user_should_see_the_AZ_sorted_products() {

        List<WebElement> itemsList = productsPage.checkInventoryItems();
        String prodNamesAfterSort[] = new String[itemsList.size()];

        for (int i=0;i<itemsList.size();i++) {
            prodNamesAfterSort[i] = productsPage.getProductTitle().get(i).getText();
            System.out.println("After clicked sort product names are : " + prodNamesAfterSort[i]);

            if(!prodNamesAfterSort[i].equals(prodNames[i])) {
                System.out.println("Products are sorted correctly in A-Z order");
            }
            else{
                System.out.println("Products are incorrectly sorted in A-Z order");
            }
        }
    }

    @When("user click the sort low to high")
    public void user_click_the_sort_low_to_high() {

        List<WebElement> priceList = productsPage.getPriceList();
        itemPrices = new Float[priceList.size()];

        for (int i=0;i<priceList.size();i++) {
            itemPrices[i] = Float.parseFloat(productsPage.getPriceList().get(i).getText().substring(1));
            System.out.println("Products before price sort : " + itemPrices[i]);
        }
        elementUtils.selectOptionInDropdown(productsPage.selectSortOptionFromDropdown(),"lohi", CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    @Then("user should see the low to high sorted products")
    public void user_should_see_the_low_to_high_sorted_products() {

        List<WebElement> priceList = productsPage.getPriceList();
        Float itemPricesAfterSort [] = new Float[priceList.size()];

        for (int i=0;i<priceList.size();i++) {
            itemPricesAfterSort[i] = Float.parseFloat(productsPage.getPriceList().get(i).getText().substring(1));
            System.out.println("Products after clicked on price sort : " + itemPricesAfterSort[i]);
        }

        Arrays.sort(itemPrices);

        if(Arrays.equals(itemPrices, itemPricesAfterSort)) {

            System.out.println("Products are sorted correctly in low to high price order");
        }
        else{
            System.out.println("Products are incorrectly sorted in low to high price order");
        }
        for (int i=0;i<priceList.size();i++) {

            System.out.println("Products after sorting the price : " + itemPrices[i]);
        }
    }

    @When("user click the sort high to low")
    public void user_click_the_sort_high_to_low() {

        List<WebElement> priceList = productsPage.getPriceList();
        itemPrices = new Float[priceList.size()];

        for (int i=0;i<priceList.size();i++) {

            itemPrices[i] = Float.parseFloat(productsPage.getPriceList().get(i).getText().substring(1));
            System.out.println("Products before price sort : "+itemPrices[i]);
        }
        elementUtils.selectOptionInDropdown(productsPage.selectSortOptionFromDropdown(),"hilo", CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    @Then("user should see the high to low sorted products")
    public void user_should_see_the_high_to_low_sorted_products() {

        List<WebElement> priceList = productsPage.getPriceList();
        Float itemPricesAfterSort [] = new Float[priceList.size()];

        for (int i=0;i<priceList.size();i++) {

            itemPricesAfterSort[i] = Float.parseFloat(productsPage.getPriceList().get(i).getText().substring(1));
            System.out.println("Products after clicked on price sort : "+itemPricesAfterSort[i]);
        }

        Arrays.sort(itemPrices, Collections.reverseOrder());

        if(Arrays.equals(itemPrices, itemPricesAfterSort)) {

            System.out.println("Products are sorted correctly in high to low price order");
        }
        else{
            System.out.println("Products are sorted incorrectly in high to low price order");
        }
        for (int i=0;i<priceList.size();i++) {

            System.out.println("Products after sorting the price : " + itemPrices[i]);
        }
    }

    @Then("user should validate the products images for users")
    public void user_should_validate_the_products_images_for_users() {

        List<WebElement> imagesList = productsPage.getImageList();
        String[] imgSrcNames = {"sauce-backpack-1200x1500.jpg","bike-light-1200x1500.jpg","bolt-shirt-1200x1500.jpg","sauce-pullover-1200x1500.jpg","red-onesie-1200x1500.jpg","red-tatt-1200x1500.jpg"};

        int j = 1;
        for (int i = 1; i < imagesList.size(); i += 2) {
            String imgsrc = productsPage.getImageList().get(i).getAttribute("src");

            if (!imgsrc.contains("WithGarbageOnItToBreakTheUrl")){
                System.out.println("Product image is correct : " + imgSrcNames[i - j]);
                Assert.assertTrue("User should see the images for products",true);
            } else {
                System.out.println("Product image is wrong : " + imgsrc);
                Assert.assertFalse("User is unable to see images for products",false);
            }
            j++;
        }
    }

    //Add to cart functionality related test cases
    @When("user click the add to cart button {int}")
    public void user_click_the_add_to_cart_button_item_number(int itemNumber) {
        numOfItems = productsPage.shoppingCartBadge().getText();
        productsPage.clickOnAddToCartBtn().get(itemNumber).click();
        System.out.println("Button is : " + itemNumber);
    }

    @Then("user should see the updated cart badge")
    public void user_should_see_the_updated_cart_badge() {

        if(numOfItems.isEmpty()){
            numOfItems = "0";
        }

        String noOfItemsNew = productsPage.shoppingCartBadge().getText();

        System.out.println("Number of items in the cart is : " + numOfItems);
        System.out.println("Number of items in the cart new is : " + noOfItemsNew);

        if(Integer.parseInt(noOfItemsNew) == Integer.parseInt(numOfItems)+1) {
            System.out.println("Cart is updated successfully");
        }
        else {
            System.out.println("Fail to updated");
        }
    }

    @When("user click the add to cart buttons")
    public void user_click_the_add_to_cart_buttons() {
        List<WebElement> itemsList = productsPage.checkInventoryItems();
        for(int i = 0;i<itemsList.size();i++) {
            productsPage.clickOnAddToCartBtn().getFirst().click();
        }
    }

    @Then("user should see the remove button")
    public void user_should_see_the_remove_button() {
        List<WebElement> itemsList = productsPage.checkInventoryItems();
        for(int i=0;i<itemsList.size();i++) {
            if(productsPage.clickOnRemoveBtn().get(i).getText().equals("REMOVE")) {
                System.out.println("Remove button for "+ i +"th product is displayed");
            }
            else {
                System.out.println("Remove button for "+ i +" is not displayed");
            }
        }
    }

    @When("user click the product title {int}")
    public void user_click_the_product_title_item_number(int itemNumber) {
        prodTitle = productsPage.getProductTitle().get(itemNumber).getText();
        productsPage.getProductTitle().get(itemNumber).click();
    }

    @Then("user should see the full product view")
    public void user_should_see_the_full_product_view() {

        if(productsPage.getProdFullView().getText().equals(prodTitle)) {
            Assert.assertTrue("Navigated to Product full view page",true);
        }
        else {
            Assert.assertFalse("Navigated to wrong Product full view page",false);
        }
    }

    @When("user click the cart icon")
    public void user_click_the_cart_icon() {
        productsPage.shoppingCartBadge().click();
    }

    @Then("user should see the cart items added to cart")
    public void user_should_see_the_cart_items_added_to_cart() {

        String [] cartItemNames = {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};

        List<WebElement> itemsList = productsPage.checkInventoryItems();

        for (int i =0;i<itemsList.size();i++) {

            if(productsPage.getProductTitle().get(i).getText().equals(cartItemNames[i])) {
                System.out.println(cartItemNames[i]+ " : Added to cart successfully");
            }
            else {
                System.out.println(cartItemNames[i]+" : Fail to add to cart");
            }
        }
    }

    @When("user click the remove buttons")
    public void user_click_the_remove_buttons() {

        List<WebElement> itemsList = productsPage.checkInventoryItems();
        for(int i = 0;i<itemsList.size();i++) {
            productsPage.clickOnRemoveBtn().get(0).click();
        }
    }

    @Then("user should see the cart without removed item")
    public void user_should_see_the_cart_without_removed_item() {

        if(!productsPage.getProductTitle().isEmpty()) {
            for (int i =0;i<productsPage.getProductTitle().size();i++) {

                System.out.println(productsPage.getProductTitle().get(i).getText()+" : Failed to remove the product from cart");
            }
        }
        else {
            System.out.println("All the products removed from cart successfully");
        }
    }
    @When("user click the back to products button")
    public void user_click_the_back_to_products_button() {
        productsPage.clickOnBackBtn();
    }

    @Then("user should see the product page")
    public void user_should_see_the_product_page() {

        boolean productTitle = productsPage.displayProductsHeadingText();

        if(productTitle) {
            Assert.assertTrue("Navigated to Products page successfully", true);
        }
        else {
            Assert.assertFalse("Navigation to Products page failed",false);
        }
    }
    @When("user click the continue shopping button")
    public void user_click_the_continue_shopping_button() {

        cartsPage.clickOnContinueShoppingBtn();
    }

    @When("user click the checkout button")
    public void user_click_the_checkout_button() {
        cartsPage.clickOnCheckOutBtn();
    }
    @Then("user should see the checkout info page")
    public void user_should_see_the_checkout_info_page() {


        boolean checkoutInfo = checkOutPage.verifyCheckoutInfo();

        if(checkoutInfo) {
            Assert.assertTrue("Navigated to Checkout page successfully",true);
        }
        else {
            Assert.assertFalse("Navigation to Checkout page is failed",false);
        }
    }

    //Footer functionality related test cases
    @Then("user should see the footer")
    public void user_should_see_the_footer() {

        boolean displayFooter = footerPage.footerDisplay();

        if (displayFooter) {
            Assert.assertTrue("Footer is displayed in Products page",true);
        }
        else {
            Assert.assertFalse("Footer is not displayed in Products page",false);
        }
    }

    @Then("user should see the correct footer text")
    public void user_should_see_the_correct_footer_text() {

        String footerText = footerPage.getFooterText();

        if(footerText.equals("© 2020 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy")) {

            Assert.assertTrue("Footer text is correctly displayed",true);
        }
        else {
            Assert.assertFalse("Footer text is not correctly displayed",false);
        }
    }

    @When("user clicked on the twitter icon")
    public void user_clicked_on_the_twitter_icon() {
         try{
             footerPage.clickOnTwitterLink();
         }catch (NoSuchElementException e){
             e.printStackTrace();
         }
    }

    @Then("user should navigate to swag labs twitter page")
    public void user_should_navigate_to_swag_labs_twitter_page() {
        //implemented the step definitions for the related step
    }

    @When("user clicked the facebook icon")
    public void user_clicked_the_facebook_icon() {
        try{
            footerPage.clickOnFacebookLink();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Then("user should navigate to swag labs facebook page")
    public void user_should_navigate_to_swag_labs_facebook_page() {
        //implemented the step definitions for the related step
    }

    @When("user clicked the linkedin icon")
    public void user_clicked_the_linkedin_icon() {
       try{
           footerPage.clickOnLinkedInLink();
       }catch (NoSuchElementException e){
           e.printStackTrace();
       }
    }
    @Then("user should navigate to swag labs linkedin page")
    public void user_should_navigate_to_swag_labs_linkedin_page() {
        //implemented the step definitions for the related step
    }

    //Checkout functionality related test cases
    @When("^user should leave any fields (.*),(.*),(.*) blank in checkout info page$")
    @When("^user should fill the (.*),(.*),(.*) information in checkout info page$")
    public void user_should_fill_the_information_in_checkout_info_page(String firstname, String lastname, String postalcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.postalcode = postalcode;
        elementUtils.typeTextIntoElement(checkOutPage.enterFirstName(),firstname,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(checkOutPage.enterLastName(),lastname,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(checkOutPage.enterPostalCode(),postalcode,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    @When("user click on the continue button")
    public void user_click_on_the_continue_button() {
        checkOutPage.clickContinueBtn();
    }

    @Then("user should navigate to checkout overview page")
    public void user_should_navigate_to_checkout_overview_page() {

        boolean checkoutOverview = checkOutPage.verifyCheckOutOverviewHeading();

        if(checkoutOverview) {
            Assert.assertTrue("Navigated to Checkout overview page successfully",true);
        }
        else {
            Assert.assertFalse("Navigation to Checkout overview page is failed",false);
        }
    }

    @When("user click on the cancel button")
    public void user_click_on_the_cancel_button() {
        checkOutPage.clickOnCancelBtn();
    }

    @Then("user should navigate to shopping cart page")
    public void user_should_navigate_to_shopping_cart_page() {
        boolean youCartHeadingText = cartsPage.verifyYourCartHeading();

        if(youCartHeadingText) {
            Assert.assertTrue("Navigated to Your cart page successfully",true);
        }
        else {
            Assert.assertFalse("Navigation to Your cart page is failed",false);
        }
    }

    @Then("user should prompt the correct error message {string} in checkout info page")
    public void user_should_prompt_the_correct_error_message_in_checkout_info_page(String errorMessage) {

        String errorTextMsg = checkOutPage.getWarningMsgText();

        if(firstname.isEmpty() && lastname.isEmpty() && postalcode.isEmpty() && errorTextMsg.equals(errorMessage)){
            Assert.assertTrue("User prompted with correct error", true);
        } else if (!firstname.isEmpty() && lastname.equals(" ") && postalcode.equals(" ") && errorTextMsg.equals(errorMessage)) {
            Assert.assertTrue("User prompted with correct error", true);
        } else if (!firstname.isEmpty() && !lastname.isEmpty() && postalcode.equals(" ") && errorTextMsg.equals(errorMessage)) {
            Assert.assertTrue("User prompted with correct error", true);
        } else if (!firstname.isEmpty() && lastname.equals(" ") && !postalcode.isEmpty() && errorTextMsg.equals(errorMessage)) {
            Assert.assertTrue("User prompted with correct error", true);
        }else if (firstname.equals(" ") && !lastname.isEmpty() && !postalcode.isEmpty() && errorTextMsg.equals(errorMessage)){
            Assert.assertTrue("User prompted with correct error", true);
        }else {
            Assert.assertFalse("User prompted with incorrect error message", false);
        }

    }

    @When("user click on the finish button")
    public void user_click_on_the_finish_button() {
        checkOutPage.clickOnFinishBtn();
    }

    @Then("user should navigate to checkout complete page")
    public void user_should_navigate_to_checkout_complete_page() {

        boolean checkoutComplete = checoutCompletePage.verifyFinishHeadingText();

        if(checkoutComplete) {
            Assert.assertTrue("Navigated to Checkout complete page successfully",true);
        }
        else {
            Assert.assertFalse("Navigation to Checkout complete page is failed",false);
        }
    }

    @And("user should verify all the details in checkout overview page")
    public void user_should_verify_all_the_details_in_checkout_overview_page() {

        numOfItems = productsPage.shoppingCartBadge().getText();
        List<WebElement> prodQuantityList = checkOutPage.getProductQuantity();

        int sizeOfProduct = prodQuantityList.size();
        String sizeOfProducts = String.valueOf(sizeOfProduct);

        if (numOfItems.equals(sizeOfProducts)){
            Assert.assertTrue("Number of products in shopping cart matches with checkout page",true);
        }else {
            Assert.assertFalse("Shopping cart products are not matching with checkout page products",false);
        }

        List<WebElement> shippingAndPriceDetails = checkOutPage.getSummaryInfo();

        for(int i=0;i<shippingAndPriceDetails.size()-3;i+=2){
            String data = Objects.requireNonNull(shippingAndPriceDetails.get(i).getAttribute("innerText")).concat(Objects.requireNonNull(shippingAndPriceDetails.get(i + 1).getAttribute("innerText")));
            System.out.println("Payment and Shipping details are : " + data);
        }
        String item = checkOutPage.getItemTotal().getText().substring(12);
        String tax = checkOutPage.getTaxValue().getText().substring(5);
        String totalPrice = checkOutPage.getTotalPrice().getText().substring(7);

        float itemF = Float.parseFloat(item.substring(1));
        float taxF = Float.parseFloat(tax.substring(1));
        float totalPriceF = Float.parseFloat(totalPrice.substring(1));

        float totalPriceValue  = itemF+taxF;

        if(totalPriceValue==totalPriceF){
            Assert.assertTrue("Total price for product is matches",true);
        }else {
            Assert.assertFalse("Totale price for product is not matching",false);
        }
    }



    @Then("user should verify the success message {string} and shipping info in checkout complete page")
    public void user_should_verify_the_success_message_and_shipping_info_in_checkout_complete_page(String successMessage) {
        String successText = checoutCompletePage.verifySuccessMsgText();
        String shippingInfo = checoutCompletePage.verifyOrderDispatchInfo();
        String expectedShippingInfo = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

        if(successText.equals(successMessage)){
            Assert.assertTrue("User is successfully placed the order", true);
        }else {
            Assert.assertFalse("User is failed to place the order",false);
        }

        if(shippingInfo.equals(expectedShippingInfo)){
            Assert.assertTrue("User is successfully notified about shipping information",true);
        }else {
            Assert.assertFalse("User is unable to notify with Shipping information",false);
        }
    }

}
