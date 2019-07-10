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

            String actualResult = mainPage.getTotalPrice();
            String expectedResult = "$18.51";

            Assert.assertEquals("If test failed then total price was changed", expectedResult, actualResult);
        }
        @Test
    public void myFirstPattern() {
            By formCart = By.xpath("//*[@id='list']/a"); //list
            mainPage.enterSomeBody_andClick("Blouse", formCart);
            mainPage.addCartClick(); //Add to cart
            mainPage.proceedtoCheckoutClick(); //Proceed to checkout
          /*  mainPage.plusClick(); //click Plus*/
            mainPage.pTotalProducts(); //Total products	$27.00
            mainPage.pTotalShipping(); //Total shipping=$2.00
            mainPage.pTotalSumm(); //Total =$56.00
          /*  mainPage.pTotalTax(); //Tax =$00.00*/
            mainPage.pTotalFinish(); //finish TOTAL=$56.00
            mainPage.pIconTrash(); //icon-trash
           // mainPage.pIconTrashEmpty(); //Your shopping cart is empty
            //boolean b = mainPage.isPresent(pIconTrashEmpty);
            //*[@id='center_column']/p[1]
            //System.out.println(b);
            //Assert.assertEquals("If test failed then total price was changed", expectedResult, actualResult); //Your shopping cart is empty.


            String actualResult = mainPage.getTotalPrice();
            String expectedResult = "$29.00";
            Assert.assertEquals("If test failed then total price was changed", expectedResult, actualResult);
        }
    }

