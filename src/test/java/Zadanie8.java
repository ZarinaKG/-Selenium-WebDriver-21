import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Zadanie8{
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() {
    ChromeOptions options = new ChromeOptions();
    // options.addArguments("start-fullscreen");
    // driver = new ChromeDriver(options);
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void myTest() throws InterruptedException {
    driver.get(" http://localhost/litecart/");
    wait.until(titleIs("Online Store | My Store"));

    List<WebElement> products = driver.findElements(cssSelector("li.product"));
    int failureCounter = 0;
    for (int i = 0; i < products.size(); i++) {
      Thread.sleep(1000);
           if(products.get(i).findElements(cssSelector(".sticker")).size()==1){
             System.out.println("This product with index: " +i+" has exactly one sticker");
           }
           else{
             failureCounter++;
           }
    }
    assertEquals(0, failureCounter);
  }
  @After
  public void stop(){
    driver.quit();
  }
}
