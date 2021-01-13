import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Zadanie14{
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("unhandledPromptBehavior", "dismiss");
    driver = new ChromeDriver(caps);
    wait = new WebDriverWait(driver, 10);
    System.out.println(((HasCapabilities) driver).getCapabilities());

    driver.get(" http://localhost/litecart/admin/.");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement username = driver.findElement(name("username"));
    username.sendKeys("admin");
    WebElement password = driver.findElement(name("password"));
    password.sendKeys("admin");
    WebElement loginBtn = driver.findElement(name("login"));
    loginBtn.click();
    wait.until(titleIs("My Store"));
  }

  @Test
  public void myTest() throws InterruptedException {
    driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    String countryHeader = driver.findElement(cssSelector("#content h1")).getText();
    assertTrue(countryHeader.contains("Countries"));

    String newWindow ="";
    WebElement countryAndorra = driver.findElement(linkText("Andorra"));
    Thread.sleep(1000);
    countryAndorra.click();

    String originalWindow = driver.getWindowHandle();
    System.out.println(originalWindow );
    Set<String> existingWindows = driver.getWindowHandles();


   List<WebElement> links = driver.findElements(xpath("//i[contains(@class, 'fa fa-external-link')]"));
    for (WebElement tLink: links ) {
      WebElement linkElement = tLink.findElement(By.xpath("./.."));

      Thread.sleep(1000);
      linkElement.click();

      newWindow = wait.until(anyWindowOtherThan(existingWindows));
      driver.switchTo().window(newWindow);
      driver.close();
      driver.switchTo().window(originalWindow);
    }
  }

  public ExpectedCondition<String> anyWindowOtherThan (Set<String> oldWindows ){
       return new ExpectedCondition<String>() {
          public String apply(WebDriver driver) {
            Set<String> handles = driver.getWindowHandles();
            handles.removeAll(oldWindows);
            return handles.size () > 0 ? handles.iterator ().next():null;
          }
      };
  }
  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}
