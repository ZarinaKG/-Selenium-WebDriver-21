import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Zadanie19{
  private Application app;


  @Before
  public void start() throws InterruptedException {
    app = new Application();


  }

  @After
  public void stop() {
    app.quit();
  }


  @Test

  public void addRemoveProductsTest() throws InterruptedException {

    int tCount = app.countProductsInCart();
    for (; tCount < 3; ) {
      app.addProductToCart(tCount + 1);
      tCount = app.countProductsInCart();

    }


    System.out.println(app.countProductsInCart());
    while (!app.isCartEmpty()) {
      app.deleteProductFromCart();
    }

    System.out.println(app.countProductsInCart());


  }
}

