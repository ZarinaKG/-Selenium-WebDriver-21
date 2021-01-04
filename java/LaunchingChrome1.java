import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LaunchingChrome1{
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
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
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

    for (int i = 1; i <= elementsInMenu.size(); i++) {
      Thread.sleep(1000);
      WebElement appearence = driver.findElement(cssSelector("ul#box-apps-menu li:nth-child(" + i + ")"));
      WebElement appearenceLink = appearence.findElement(cssSelector("a[href^=http]"));
      appearenceLink.click();
      assertTrue(isElementPresent(By.tagName("h1")));
    }


//Open Catalog links
    WebElement catalog = driver.findElement(cssSelector("ul#box-apps-menu li:nth-child(2)"));
    Thread.sleep(1000);
    WebElement catalogMenuLink= catalog.findElement(By.tagName("a"));
    catalogMenuLink.click();
    WebElement catalogpoints = driver.findElement(cssSelector("ul.docs"));
    List <WebElement> catalogPointsLink= catalogpoints.findElements(By.tagName("a"));
    System.out.println(catalogPointsLink.size());

    for (int j = 1; j <= catalogPointsLink.size(); j++) {
      Thread.sleep(1000);
      WebElement catalogElements = driver.findElement(cssSelector("ul.docs li:nth-child(" + j + ")"));
      WebElement catalogElementLink = catalogElements.findElement(cssSelector("a[href^=http]"));
      catalogElementLink.click();
      assertTrue(isElementPresent(By.tagName("h1")));
    }
/*
    //Open Customer links
    WebElement customer = driver.findElement(cssSelector("ul#box-apps-menu li:nth-child(5)"));
    Thread.sleep(1000);
    WebElement customerMenuLink= customer.findElement(By.tagName("a"));
    customerMenuLink.click(); */

    WebElement customersLink = driver.findElement(By.linkText("Customers"));
    Thread.sleep(1000);
    customersLink.click();
    WebElement customerpoints = driver.findElement(cssSelector("ul.docs"));
    List <WebElement> customerpointsLink= customerpoints.findElements(By.tagName("a"));
    System.out.println(customerpointsLink.size());

    for (int a = 1; a <= customerpointsLink.size(); a++) {
      Thread.sleep(1000);
      WebElement customerElements = driver.findElement(cssSelector("ul.docs li:nth-child(" + a + ")"));
      WebElement customerElementLink = customerElements.findElement(cssSelector("a[href^=http]"));
      customerElementLink.click();
      assertTrue(isElementPresent(By.tagName("h1")));
    }
  }
}
