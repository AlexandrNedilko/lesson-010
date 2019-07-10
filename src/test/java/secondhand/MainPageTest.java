package secondhand;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import secondhand.pages.MainPage;

public class MainPageTest extends BaseTest {

        private MainPage mainPage;

        @Before
        public void setupMainPage(){
            mainPage = new MainPage(driver);
        }


        @Test
        public void canCheckTotalPriceForTShirt(){
            mainPage.clickTShirtTab();
            mainPage.scrollToItem();
            mainPage.navigateToItemView();
            mainPage.clickAddToCart();
            mainPage.clickProceedToCheckout();
            ////////////////
            mainPage.addCartClick();

            String actualResult = mainPage.getTotalPrice();
            String expectedResult = "$18.51";

            Assert.assertEquals("If test failed then total price was changed", expectedResult, actualResult);
        }
        @Test
    public void myFirstPattern() {
            By formCart = By.xpath("//*[@id='list']/a"); //list
            mainPage.enterSomeBody_andClick("Blouse", formCart, addCart);
        }
    }

