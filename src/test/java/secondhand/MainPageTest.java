package secondhand;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import secondhand.pages.MainPage;
import java.util.ArrayList;
import java.util.List;

public class MainPageTest extends BaseTest {

        private MainPage mainPage;

        @Before
        public void setupMainPage(){
            mainPage = new MainPage(driver);
        }

        /*@Test
        public void canCheckTotalPriceForTShirt(){
            mainPage.clickTShirtTab();
            mainPage.scrollToItem();
            mainPage.navigateToItemView();
            mainPage.clickAddToCart();
            mainPage.clickProceedToCheckout();

            String actualResult = mainPage.getTotalPrice();
            String expectedResult = "$18.51";

            Assert.assertEquals("If test failed then total price was changed", expectedResult, actualResult);
        }*/

        @Test
         public void myFirstPattern() {

            mainPage.enterSomeBody_andClick("Blouse");
            mainPage.addCartClick(); //Add to cart
            mainPage.proceedtoCheckoutClick(); //Proceed to checkout
            mainPage.plusClick(); //click Plus

            List <String> expected = new ArrayList<String>();
            String expected_pTotalProducts= "$54.00";
            String expected_pTotalShipping= "$2.00";
            String expected_pTotalSum= "$56.00";
            String expected_pTotalTax= "$0.00";
            String expected_pTotalFinish= "$56.00";
            String expected_pIconTrashEmpty= "Your shopping cart is empty.";
            expected.add(expected_pTotalProducts);
            expected.add(expected_pTotalShipping);
            expected.add(expected_pTotalSum);
            expected.add(expected_pTotalTax);
            expected.add(expected_pTotalFinish);
            expected.add(expected_pIconTrashEmpty);

            List <String> actual = new ArrayList<String>();
            actual= (mainPage.getAllTotals(actual));
            Assert.assertEquals(expected, actual);
        }
    }

