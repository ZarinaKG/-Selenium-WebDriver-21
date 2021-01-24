import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class ProductPage extends Page{
  public ProductPage(WebDriver driver) {
    super(driver);
  }

  public void checkProductPageOpen(String productName){
    String productHeader = driver.findElement(cssSelector("#box-product h1")).getText();
    assertTrue(productHeader.contains(productName));

  }

  public void addToCart() throws InterruptedException {
    WebElement classQuantity = driver.findElement(cssSelector("td.quantity"));

    try {

      driver.manage().timeouts()
              .implicitlyWait(0, TimeUnit.SECONDS);
      Select productSize = new Select(driver.findElement(cssSelector("select[name='options[Size]']")));
      productSize.selectByIndex(2);

    } catch (Exception e) {

    }
    driver.manage().timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
    WebElement addCart = classQuantity.findElement(cssSelector("[name=add_cart_product]"));
    Thread.sleep(2000);
    addCart.click();
  }

  public void checkProductCount(int count){
    WebElement itemsQuantity = driver.findElement(cssSelector("#cart .quantity"));
    wait.until(textToBePresentInElement(itemsQuantity, count+""));
  }

  public int countProductsInCart(){
    String quantity = driver.findElement(cssSelector("#cart .quantity")).getAttribute("textContent");
    return Integer.parseInt(quantity);
  }
}
