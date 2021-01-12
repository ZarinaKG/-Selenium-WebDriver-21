import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Zadanie12{
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() throws InterruptedException {
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


  }
  
  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

  @Test
  public void checkCountriesA() throws InterruptedException {
    String urlCatalog= "http://localhost/litecart/admin/?app=catalog";
    WebElement menu = driver.findElement(cssSelector("ul#box-apps-menu"));
    WebElement catalog = menu.findElement(By.linkText("Catalog"));
    Thread.sleep(1000);
    catalog.click();
    wait.until(titleIs("Catalog | My Store"));

    WebElement content = driver.findElement(cssSelector("#content"));
    WebElement addProduct = content.findElement(linkText("Add New Product"));
        Thread.sleep(1000);
    addProduct.click();
    wait.until(titleIs("Add New Product | My Store"));

    WebElement tabs = driver.findElement(cssSelector(".tabs"));
    WebElement general = tabs.findElement(linkText("General"));
    Thread.sleep(1000);
    general.click();

    WebElement radioBtnEnabled = driver.findElement(cssSelector("label [type=radio]:first-child"));
    Thread.sleep(1000);
    radioBtnEnabled.click();
    String productName = "Duck in Paris";
    WebElement nameOfProduct = driver.findElement(cssSelector(".input-wrapper [name*=name]"));
    Thread.sleep(1000);
    nameOfProduct.sendKeys(productName);

    WebElement codeOfProduct = driver.findElement(cssSelector("[name=code]"));
    Thread.sleep(1000);
    codeOfProduct.sendKeys("34567");

    WebElement quantityOfProduct = driver.findElement(cssSelector("[name=quantity]"));
    Thread.sleep(1000);
    quantityOfProduct.clear();
    quantityOfProduct.sendKeys("1");

    Select soldOutStatus = new Select(driver.findElement(cssSelector("select[name=sold_out_status_id]")));
    Thread.sleep(1000);
    soldOutStatus.selectByIndex(2);

    File imgDuck = new File("src/test/java/lilalu.jpg");
    String absPath= imgDuck.getAbsolutePath();

    WebElement uploadBtn = driver.findElement(cssSelector("[name*=new_images]"));
    Thread.sleep(1000);
   // uploadBtn.click();
    uploadBtn.sendKeys(absPath);


    WebElement dateFrom = driver.findElement(cssSelector("[name=date_valid_from]"));
    Thread.sleep(1000);
    dateFrom.sendKeys("10.01.2021");
    WebElement dateTo = driver.findElement(cssSelector("[name=date_valid_to]"));
    Thread.sleep(1000);
    dateTo.sendKeys("10.12.2021");

   /* WebElement saveBtn = driver.findElement(cssSelector(".button-set [name=save]"));
    saveBtn.click();


   WebElement product = driver.findElement(linkText(productName));
    Thread.sleep(1000);
    product.click();
    wait.until(titleIs("Edit Product: "+productName+" | My Store"));

    */



    WebElement information = driver.findElement(linkText("Information"));
    Thread.sleep(1000);
    information.click();

    Select manufacturerID = new Select(driver.findElement(cssSelector("select[name=manufacturer_id]")));
    Thread.sleep(1000);
    manufacturerID.selectByIndex(1);

    WebElement shortDescription = driver.findElement(cssSelector("[name='short_description[en]']"));
    Thread.sleep(1000);
    shortDescription.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sollicitudin ante massa, eget ornare libero porta congue.");

    WebElement description = driver.findElement(cssSelector("[name='description[en]']"));
    Thread.sleep(1000);
    description.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sollicitudin ante massa, eget ornare libero porta congue. Cras scelerisque dui non consequat sollicitudin. Sed pretium tortor ac auctor molestie. Nulla facilisi. Maecenas pulvinar nibh vitae lectus vehicula semper. Donec et aliquet velit. Curabitur non ullamcorper mauris. In hac habitasse platea dictumst. Phasellus ut pretium justo, sit amet bibendum urna. Maecenas sit amet arcu pulvinar, facilisis quam at, viverra nisi. Morbi sit amet adipiscing ante. Integer imperdiet volutpat ante, sed venenatis urna volutpat a. Proin justo massa, convallis vitae consectetur sit amet, facilisis id libero.");
/*
    WebElement informationSaveBtn = driver.findElement(cssSelector(".button-set [name=save]"));
    Thread.sleep(1000);
    informationSaveBtn.click();
*/


    WebElement prices = tabs.findElement(linkText("Prices"));
    Thread.sleep(1000);
    prices.click();

    WebElement purchasePrice = driver.findElement(cssSelector("[name=purchase_price]"));
    Thread.sleep(1000);
    purchasePrice.clear();
    purchasePrice.sendKeys("1.5");

    Select purchasePriceCurrencyCode = new Select(driver.findElement(cssSelector("select[name=purchase_price_currency_code]")));
    purchasePriceCurrencyCode.selectByIndex(2);



    WebElement price = driver.findElement(cssSelector("[name='prices[EUR]']"));
    Thread.sleep(1000);
    price.clear();
    price.sendKeys("2.5");

    WebElement saveBtn = driver.findElement(cssSelector(".button-set [name=save]"));
    saveBtn.click();

    driver.get(urlCatalog);
    WebElement catalogHeader = driver.findElement(By.tagName("h1"));
    String catalogString = catalogHeader.getText();
    assertTrue(catalogString.contains("Catalog"));

    Assert.assertTrue(driver.findElement(By.linkText(productName)).isDisplayed());
    Integer productlinks = driver.findElements((By.linkText(productName))).size();
    assertTrue (productlinks==1);











  }
}
