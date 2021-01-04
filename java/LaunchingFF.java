import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LaunchingFF{
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver,10);
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

    WebElement appearence = driver.findElement(cssSelector("ul#box-apps-menu li:first-child"));
    WebElement appearenceLink= appearence.findElement(cssSelector("a[href*=appearance]"));
   // Thread.sleep(1000);
    appearenceLink.click();

    WebElement catalog = driver.findElement(cssSelector("ul#box-apps-menu li:nth-child(1)"));
    Thread.sleep(1000);
    WebElement catalogLink = catalog.findElement(By.linkText("Catalog"));
    //WebElement catalogLink = catalog.findElement(cssSelector("a[href*=Catalog]"));;
    Thread.sleep(1000);
    catalogLink.click();
    wait.until(titleIs("Catalog | My Store"));
  }

}
