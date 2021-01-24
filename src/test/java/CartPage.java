import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class CartPage extends Page{

  public CartPage(WebDriver driver) {
    super(driver);
  }

  public void open() throws InterruptedException {
    if(driver.getCurrentUrl().endsWith("/checkout")){
      return;
    }
    WebElement cartWrapper = driver.findElement(cssSelector("#cart-wrapper"));
    WebElement checkOutLink = cartWrapper.findElement(cssSelector(".link"));
    Thread.sleep(1000);
    checkOutLink.click();
  }

  public boolean isCartEmpty(){

    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    try {
      return driver.findElements(cssSelector("[name=remove_cart_item]")).size() == 0;
    }finally{
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
  }

  public void removeProduct() throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    List<WebElement> itemsInCart = driver.findElements(cssSelector("li.shortcut"));
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    System.out.println(itemsInCart.size());
    WebElement tableElem = driver.findElement(cssSelector(".dataTable"));
    List<WebElement> prodcodes = tableElem.findElements(cssSelector(".sku"));
    WebElement firstProduct = prodcodes.get(1);

    if (itemsInCart.size() > 1) {
      itemsInCart.get(0).click();
      Thread.sleep(500);
    }

   WebElement removeItem = driver.findElement(cssSelector("[name=remove_cart_item]"));
    wait.until(elementToBeClickable(removeItem));

    removeItem.click();
    wait.until(stalenessOf(firstProduct));
  }
}
