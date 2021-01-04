import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Zadanie_7_4{
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
    for (int i = 1; i <= products.size(); i++) {
      Thread.sleep(1000);
      products.get(i).findElement(cssSelector(".sticker"));
    }
  }
}
