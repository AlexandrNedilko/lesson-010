package secondhand;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import secondhand.pages.MainPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            mainPage.plusClick(); //click Plus
//
            List <String> expected = new ArrayList<String>();
            String expected_pTotalProducts= "$54.00";
            String expected_pTotalShipping= "$2.00";
            String expected_pTotalSum= "$56.00";
            String expected_pTotalTax= "$0.00";
            String expected_pTotalFinish= "$56.00";
            expected.add(expected_pTotalProducts);
            expected.add(expected_pTotalShipping);
            expected.add(expected_pTotalSum);
            expected.add(expected_pTotalTax);
            expected.add(expected_pTotalFinish);

            List <String> actual = new ArrayList<String>();
            actual= (mainPage.getAllTotals(actual));


            Assert.assertEquals(expected, actual);


            mainPage.pIconTrash(); //icon-trash



         //   actual.add(mainPage.pTotalProducts()); //Total products	$54.00
           // System.out.println(actual);

          /*  actual.add(mainPage.pTotalShipping()); //Total shipping=$2.00
            mainPage.pTotalSumm(); //Total =$56.00
            mainPage.pTotalTax(); //Tax =$00.00
            mainPage.pTotalFinish(); //finish TOTAL=$56.00


            mainPage.pIconTrash(); //icon-trash*/


            /*mainPage.pIconTrashEmpty(); //Your shopping cart is empty
            //boolean b = mainPage.isPresent();
            //*[@id='center_column']/p[1]
            //System.out.println(b);
            String actualResult = mainPage.getTotalPrice();
            String expectedResult = "Your shopping cart is empty";
            Assert.assertEquals("If test failed then total price was changed", expectedResult, actualResult); //Your shopping cart is empty.
*/

            /*List expected = new ArrayList();
            List actual = new ArrayList();

            String expected_pTotalProducts= "$54.00";
            String expected_pTotalShipping= "$2.00";
            String expected_pTotalSumm= "$56.00";
            String actual_price = "$54.00";
            String actual_price1 = "$2.00";
            String actual_price2 = "$26.00";


            expected.add(expected_pTotalProducts);
            expected.add(expected_pTotalShipping);
            expected.add(expected_pTotalSumm);
            actual.add(actual_price);
            actual.add(actual_price1);
            actual.add(actual_price2);
            Assert.assertEquals(actual,expected);*/



/*


            /*String actualResult = mainPage.getTotalPrice();
            String expectedResult = "$29.00";
            Assert.assertEquals("If test failed then total price was changed", expectedResult, actualResult);*/
        }
    }

