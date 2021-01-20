import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Zadanie17{
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
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

  @After
  public void stop() {
    driver.quit();
  }

  @Test
  public void checkBrowserLogs() throws InterruptedException {

    WebElement catalog = driver.findElement(linkText("Catalog"));
    Thread.sleep(1000);
    catalog.click();
    String countryHeader = driver.findElement(cssSelector("#content h1")).getText();
    assertTrue(countryHeader.contains("Catalog"));

    List<WebElement> rows = driver.findElements(cssSelector(".row"));

    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    int counter = 0;
    while (true) {
      if (counter>= rows.size()) {
        break;
      }
      List<WebElement> folder = rows.get(counter).findElement(xpath("./td[3]")).findElements(cssSelector(".fa-folder"));
      if (folder.size() > 0) {
        rows.get(counter).findElement(xpath("./td[3]//a")).click();
        Thread.sleep(500);
      } else {
        List<WebElement> openFolder = rows.get(counter).findElement(xpath("./td[3]")).findElements(cssSelector(".fa-folder-open"));
        if (openFolder.size() > 0) {
        } else {
          int browser = driver.manage().logs().get("browser").getAll().size();
          rows.get(counter).findElement(xpath("./td[3]//a")).click();
          Thread.sleep(500);
          assertEquals(browser, driver.manage().logs().get("browser").getAll().size());
          System.out.println("browser = " + browser);
          driver.navigate().back();
        }
      }
      Thread.sleep(100);
      counter++;
      rows = driver.findElements(cssSelector(".row"));
    }
    assertEquals(0, driver.manage().logs().get("browser").getAll().size());
  }
}

