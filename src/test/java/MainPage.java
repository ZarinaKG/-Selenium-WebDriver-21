import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MainPage extends Page{

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public void open(){
    String homePage = "http://localhost/litecart";
    driver.get(homePage);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait.until(titleIs("Online Store | My Store"));
  }

 public String chooseFirstProduct() throws InterruptedException {
   WebElement firstProduct = driver.findElement(cssSelector("ul.listing-wrapper li:first-child"));
   WebElement firstProductLink = firstProduct.findElement(tagName("a"));
   String productName = firstProduct.getAttribute("title");
   Thread.sleep(1000);
   firstProductLink.click();
   return productName;
 }
}
