import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Zadanie13{
  private WebDriver driver;
  private WebDriverWait wait;



  @Before
  public void start() throws InterruptedException {
    ChromeOptions options = new ChromeOptions();
    // options.addArguments("start-fullscreen");
    // driver = new ChromeDriver(options);
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
   // driver.get("http://localhost/litecart");
   // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   // wait.until(titleIs("Online Store | My Store"));


  }
  
  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

  @Test
  public void checkCountriesA() throws InterruptedException {
    for (int i=1; i<4; i++) {
      Integer items = i;
      System.out.println(items);
      String homePage = "http://localhost/litecart";
      driver.get(homePage);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      wait.until(titleIs("Online Store | My Store"));

      WebElement firstProduct = driver.findElement(cssSelector("ul.listing-wrapper li:first-child"));
      WebElement firstProductLink = firstProduct.findElement(tagName("a"));
      String productName = firstProduct.getAttribute("title");
      Thread.sleep(1000);
      firstProductLink.click();

      String productHeader = driver.findElement(cssSelector("#box-product h1")).getText();
      assertTrue(productHeader.contains(productName));

      WebElement classQuantity = driver.findElement(cssSelector("td.quantity"));

  try{

    driver.manage().timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
          Select productSize=new Select(driver.findElement(cssSelector("select[name='options[Size]']")));
          productSize.selectByIndex(2);

     }catch(Exception e){

      }
      driver.manage().timeouts()
              .implicitlyWait(5, TimeUnit.SECONDS);
      WebElement addCart = classQuantity.findElement(cssSelector("[name=add_cart_product]"));
      Thread.sleep(2000);
      addCart.click();
      WebElement itemsQuantity = driver.findElement(cssSelector("#cart .quantity"));
      wait.until(textToBePresentInElement(itemsQuantity, items.toString()));
      String quantity = driver.findElement(cssSelector("#cart .quantity")).getAttribute("textContent");
      System.out.println(quantity);

    }
    WebElement cartWrapper = driver.findElement(cssSelector("#cart-wrapper"));
    WebElement checkOutLink = cartWrapper.findElement(cssSelector(".link"));
    Thread.sleep(1000);
    checkOutLink.click();

    List<WebElement> itemsInCart= driver.findElements(cssSelector("li.shortcut"));

    Integer numberOfItems = itemsInCart.size();
    System.out.println("Number of Items in Cart: " +numberOfItems);

    for (int i =0; i< numberOfItems; i++) {
      Thread.sleep(1000);

      WebElement item = driver.findElement(cssSelector("ul.items li:first-child"));
      WebElement removeItem = item.findElement(cssSelector("[name=remove_cart_item]"));
      Thread.sleep(1000);
      wait.until(elementToBeClickable(removeItem));
      removeItem.click();

      WebElement tableElem = driver.findElement(cssSelector(".dataTable"));

      List<WebElement> prodcodes = tableElem.findElements(cssSelector(".sku"));
      wait.until(numberOfElementsToBeLessThan(cssSelector(".sku"),numberOfItems+1-i));


    }


  }
}
