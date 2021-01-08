import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Zadanie_9{
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() {
    ChromeOptions options = new ChromeOptions();
    // options.addArguments("start-fullscreen");
    // driver = new ChromeDriver(options);
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
    driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
  }
  
  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

  @Test
  public void checkCountriesA() throws InterruptedException {
    WebElement table = driver.findElement(cssSelector("table.dataTable"));
    List<WebElement> rows = table.findElements(cssSelector("tr.row"));
    System.out.println(rows.size());
    for (int i = 0; i < rows.size(); i++) {
      WebElement row = rows.get(i);
      List<WebElement> cells = row.findElements(tagName("td"));
      String countryNameNow = cells.get(4).getText().trim();

      if (i < rows.size() - 1) {
        WebElement rowNext = rows.get(i + 1);
        List<WebElement> cellsNext = rowNext.findElements(tagName("td"));
        String countryNameNext = cellsNext.get(4).getText().trim();
        assertTrue(countryNameNow.compareTo(countryNameNext) <= 0);

      }

      WebElement zone = row.findElement(cssSelector("td:nth-child(6)"));
      String regionAmount = zone.getText().trim();
      if (!regionAmount.equals("0")) {
        System.out.println(regionAmount);
        WebElement countryElementLink = row.findElement(cssSelector("a[href^=http]"));
        Thread.sleep(1000);
        countryElementLink.click();
        WebElement btnCancel = driver.findElement(cssSelector("button[name=cancel]"));
        Thread.sleep(1000);
        WebElement regionTable = driver.findElement(cssSelector("table.dataTable"));
        List<WebElement> regionRows = regionTable.findElements(cssSelector("tr"));

        for (int j = 1; j < regionRows.size() - 2; j++) {
          WebElement row2 = regionRows.get(j);
          List<WebElement> regiobColumn = row2.findElements(tagName("td"));
          String regionNow = regiobColumn.get(2).getText().trim();
          WebElement regionRowNext = regionRows.get(j + 1);
          List<WebElement> regiobColumnext = regionRowNext.findElements(tagName("td"));
          String regionNext = regiobColumnext.get(2).getText().trim();
          assertTrue(regionNow.compareTo(regionNext) <= 0);
        }
        btnCancel.click();
        table = driver.findElement(cssSelector("table.dataTable"));
        rows = table.findElements(cssSelector("tr.row"));
      }

    }
  }

  @Test
  public void checkCountriesZoneB() throws InterruptedException {
    driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

    WebElement table = driver.findElement(cssSelector("table.dataTable"));
    List<WebElement> rows = table.findElements(cssSelector("tr.row"));
    // System.out.println(rows.size());
    for (int i = 0; i < rows.size(); i++) {
      WebElement countryElementLink = rows.get(i).findElement(tagName("a"));
      countryElementLink.click();
      WebElement geozone = driver.findElement(cssSelector("table.dataTable"));

      List<WebElement> geozoneRows = geozone.findElements(cssSelector("td [name*=zone_code] [selected=selected]"));
      // List<WebElement> geozoneRows = geozone.findElements(cssSelector("td [name*=zone_code]"));
      for (int j = 0; j < geozoneRows.size() - 1; j++) {
        String zoneNameNow = geozoneRows.get(j).getAttribute("textContent");
        String zoneNameNext = geozoneRows.get(j + 1).getAttribute("textContent");
        System.out.println(zoneNameNow + " <= " + zoneNameNext);
        assertTrue(zoneNameNow.compareTo(zoneNameNext) <= 0);
      }

      WebElement btnCancel = driver.findElement(cssSelector("button[name=cancel]"));
      Thread.sleep(1000);
      btnCancel.click();
      table = driver.findElement(cssSelector("table.dataTable"));
      rows = table.findElements(cssSelector("tr.row"));
    }
  }
}
