import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Zadanie7{
  private WebDriver driver;
  private WebDriverWait wait;

  public boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (InvalidSelectorException ex) {
      throw ex;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  @Before
  public void start() {
    ChromeOptions options = new ChromeOptions();
    // options.addArguments("start-fullscreen");
    // driver = new ChromeDriver(options);
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("unexpectedAlertBehaviour", "dismiss");
    driver = new ChromeDriver(caps);
    wait = new WebDriverWait(driver, 3);
  }

  @Test
  public void myTest() throws InterruptedException {
    driver.get(" http://localhost/litecart/admin/.");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement username = driver.findElement(name("username"));
    username.sendKeys("admin");
    WebElement password = driver.findElement(name("password"));
    password.sendKeys("admin");
    WebElement loginBtn = driver.findElement(name("login"));
    loginBtn.click();
    wait.until(titleIs("My Store"));


    WebElement menu = driver.findElement(cssSelector("ul#box-apps-menu"));
    List<WebElement> elementsInMenu = menu.findElements(By.tagName("a"));
    System.out.println(elementsInMenu.size());

    List<WebElement> elements = ((ChromeDriver) driver).findElementByCssSelector(("ul#box-apps-menu ")).findElements(cssSelector("li"));
    for (int i = 1; i <= elementsInMenu.size(); i++) {
      System.out.println("i = " + i);
      Thread.sleep(100);
      WebElement mainNavigation = driver.findElement(xpath(".//ul[@id='box-apps-menu']/li[" + i + "]"));
      WebElement mainLink = mainNavigation.findElement(cssSelector("a[href^=http]"));
      mainLink.click();
      Thread.sleep(500);
      assertTrue(isElementPresent(By.tagName("h1")));
      mainNavigation = driver.findElement(xpath(".//ul[@id='box-apps-menu']/li[" + i + "]"));

      driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      List<WebElement> catalogPointsLink = mainNavigation.findElements(xpath("./ul/*"));
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      System.out.println("catalogPointsLink.size() " + catalogPointsLink.size());
      for (int j = 0; j < catalogPointsLink.size(); j++) {
        mainNavigation = driver.findElement(xpath(".//ul[@id='box-apps-menu']/li[" + i + "]"));
        catalogPointsLink = mainNavigation.findElements(xpath("./ul/*"));
        WebElement catalogElementLink = catalogPointsLink.get(j).findElement(cssSelector("a[href^=http]"));
        catalogElementLink.click();
        Thread.sleep(500);
        assertTrue(isElementPresent(By.tagName("h1")));
        System.out.println(catalogPointsLink.size());
      }
    }
  }

  @After
  public void stop() {
   driver.quit();
  }
}
