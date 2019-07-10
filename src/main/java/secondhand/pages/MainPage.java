/*Імплементувати домашку з попереднього уроку використовуючи патерни.*/

package secondhand.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    private final static String TITLE_PROCEED_TO_CHECKOUT = "//*[@title='Proceed to checkout']";

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    private WebElement womenTab;

    @FindBy(css = "#block_top_menu > ul > li.sfHoverForce > a")
    private WebElement dressesTab;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    private WebElement tShirtTab;

    @FindBy(xpath = "//*[@id='searchbox']/button")
    private WebElement search;

    @FindBy(xpath = "//*[@id='search_query_top']")
    private WebElement formSearch;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@class='product-image-container']")
    private WebElement itemView;

    @FindBy(className = "icon-th-list")
    private WebElement listView;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addCartButton;

    @FindBy(xpath = "//*[@id='list']/a")
    private WebElement getListView;

    @FindBy(xpath = TITLE_PROCEED_TO_CHECKOUT)
    private WebElement proceedCheckout;

    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement totalSum;


    @FindBy(xpath = "//*[contains(@href,'controller=my-account')]")
    private WebElement singIn;

    @FindBy(xpath = "//*[@title='Contact Us']")
    private WebElement contactUs;

    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement sizeLcheckbox;
//////////////////////////////////////////////////////
    @FindBy(xpath = "//*[@id='center_column']/ul/li/div/div/div[3]/div/div[2]/a[1]/span")
    private WebElement tShirtCart;

    public MainPage addCartClick() {
        tShirtCart.click();
        return this;
    }

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
    private WebElement tProceedtoCheckout;

    public MainPage proceedtoCheckoutClick() {
        tProceedtoCheckout.click();
        return this;
    }

    /*@FindBy(xpath = "//*[@id='cart_quantity_up_2_7_0_0']/span/i")
    private WebElement tProceedtoPlus;

    public MainPage plusClick() {
        tProceedtoPlus.click();
        return this;
    }*/

    @FindBy(xpath = "//*[@id='total_product']")
    private WebElement tTotalProducts;

    public MainPage pTotalProducts() {
        tTotalProducts.click();
        return this;
    }

    @FindBy(xpath = "//*[@id='total_shipping']")
    private WebElement tTotalShipping;

    public MainPage pTotalShipping() {
        tTotalShipping.click();
        return this;
    }

    @FindBy(xpath = "//*[@id='total_price_without_tax']")
    private WebElement tTotalSumm;

    public MainPage pTotalSumm() {
        tTotalSumm.click();
        return this;
    }

/*
    @FindBy(xpath = "//*[@id='total_tax")
    private WebElement tTotalTaxSumm;

    public MainPage pTotalTax() {
        tTotalTaxSumm.click();
        return this;
    }
*/

    @FindBy(xpath = "//*[@id='total_price']")
    private WebElement tTotalFinishSumm;

    public MainPage pTotalFinish() {
        tTotalFinishSumm.click();
        return this;
    }

    @FindBy(xpath = "//*[@id='2_7_0_0']/i")
    private WebElement tIconTrashBasket;

    public MainPage pIconTrash() {
        tIconTrashBasket.click();
        return this;
    }

    /*@FindBy(xpath = "#center_column p.alert-warning")
    private WebElement tIconTrashBasketEmpty;

    public MainPage pIconTrashEmpty() {
        tIconTrashBasketEmpty.click();
        return this;
    }

    public boolean isPresent(By isRegister) {
        return this.driver.findElement(isRegister).isEnabled();
    }*/







    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage clickWomenTab() {
        womenTab.click();
        return this;
    }

    public MainPage clickDressesTab() {
        dressesTab.click();
        return this;
    }

    public MainPage clickTShirtTab() {
        tShirtTab.click();
        return this;
    }

    public SignInPage clickSignIn(){
        singIn.click();
        return new SignInPage(driver);
    }

    public MainPage selectSizeL(){
        sizeLcheckbox.click();
        return this;
    }

    public void clickAddToCart(){
        addCartButton.click();
    }

    public void navigateToItemView () {
        Actions actions = new Actions(driver);
        actions.moveToElement(itemView).build().perform();
    }

    public void scrollToItem(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", itemView);
    }

    public void clickProceedToCheckout() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.
                        xpath(TITLE_PROCEED_TO_CHECKOUT))).click();
    }

    public String getTotalPrice(){
        return totalSum.getText();
    }

    public void enterSomeBody_andClick(String someone, By firstForm) {

        formSearch.sendKeys(someone);
        search.click();
        getListView.click();

    }
}

