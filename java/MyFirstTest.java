import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest{

  private WebDriver driver;
  private WebDriverWait wait;

  @Before
   public void start(){
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver,10);
  }

  @Test
  public void myFirstTest(){
    //driver.navigate().to("http://www.google.com");
    System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
    driver.get(" http://localhost/litecart/admin/.");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement username = driver.findElement(name("username"));
    username.sendKeys("admin");
    WebElement password = driver.findElement(name("password"));
    password.sendKeys("admin");
    WebElement loginBtn = driver.findElement(name("login"));
    loginBtn.click();
    wait.until(titleIs("My Store"));
   // driver.findElement(By.name("q")).sendKeys("webdriver");
   // driver.findElement(By.name("btnG")).click();
   // wait.until(titleIs("webdriver - Suche in Google"));
  }
  @After
    public void stop(){
    driver.quit();
    driver = null;
  }
}
