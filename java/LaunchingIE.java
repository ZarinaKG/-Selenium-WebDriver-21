import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LaunchingIE{
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
    driver = new InternetExplorerDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver,10);
  }
  @Test
   public void myTest(){
    driver.navigate().to("http://www.google.com");
  }

}
