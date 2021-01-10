import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;

public class Zadanie10{
  private WebDriver driver;
  private WebDriverWait wait;



  @Test
  public void checkFirefox( )throws InterruptedException{
    driver = new FirefoxDriver();
    wait = new WebDriverWait(driver, 10);
    driver.get("http://localhost/litecart/en/");
    checkProductProperties(driver);
  }

  @Test
  public void checkChrome( )throws InterruptedException{
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
    driver.get("http://localhost/litecart/en/");
    checkProductProperties(driver);
  }

  @Test
  public void checkIE( )throws InterruptedException{
    driver = new InternetExplorerDriver();
    wait = new WebDriverWait(driver, 10);
    driver.get("http://localhost/litecart/en/");
    checkProductProperties(driver);
  }

  public static void checkProductProperties(WebDriver driver ) throws InterruptedException {


    WebElement firstProduct = driver.findElement(cssSelector("#box-campaigns li:first-child"));
    String nameOfProductMainPage = firstProduct.findElement(cssSelector(".name")).getAttribute("textContent");
    System.out.println(nameOfProductMainPage);

    String regularPriceMainPage = firstProduct.findElement(cssSelector(".regular-price")).getAttribute("textContent");

    String regularPriceMainPageColor = firstProduct.findElement(cssSelector(".regular-price")).getCssValue("color");
    java.awt.Color regularPriceMainPageClr = Color.fromString(regularPriceMainPageColor).getColor();
    assertTrue(regularPriceMainPageClr.getBlue()==regularPriceMainPageClr.getRed()&&regularPriceMainPageClr.getBlue()==regularPriceMainPageClr.getGreen());


    System.out.println(regularPriceMainPage);
    String regularPriceFormatMainPage = firstProduct.findElement(cssSelector(".regular-price")).getTagName();
    System.out.println(regularPriceFormatMainPage);
    String regularPriceWidthMainPage = firstProduct.findElement(cssSelector(".regular-price")).getCssValue("font-size");
    Double regularPriceSizeMP=Double.parseDouble(regularPriceWidthMainPage.replace("px",""));
    System.out.println(regularPriceSizeMP);

    String campaignPriceMainPage = firstProduct.findElement(cssSelector(".campaign-price")).getAttribute("textContent");
    System.out.println(campaignPriceMainPage);
    String campaignPriceMainPageFormat = firstProduct.findElement(cssSelector(".campaign-price")).getTagName();
    System.out.println("Format:" + campaignPriceMainPageFormat);
    String campaignPriceMainPageColor = firstProduct.findElement(cssSelector(".campaign-price")).getCssValue("color");
    java.awt.Color campaignPriceMainPageClr = Color.fromString(campaignPriceMainPageColor).getColor();
    assertTrue(campaignPriceMainPageClr.getBlue()==0&&campaignPriceMainPageClr.getRed()>0&&campaignPriceMainPageClr.getGreen()==0);

    System.out.println("Color:"+ campaignPriceMainPageColor);
    //Integer campaignPriceWidthMainPage = firstProduct.findElement(cssSelector(".campaign-price")).getSize().getWidth();
    String campaignPriceSizeMainPage = firstProduct.findElement(cssSelector(".campaign-price")).getCssValue("font-size");
    Double campaignPriceSizeMP = Double.parseDouble(campaignPriceSizeMainPage.replace("px",""));
    System.out.println("font-size:"+campaignPriceSizeMP);
    WebElement firstProductLink = firstProduct.findElement(tagName("a"));
    firstProductLink.click();
    WebElement product = driver.findElement(cssSelector("#box-product"));
    String productName = product.findElement(cssSelector("h1")).getAttribute("textContent");
    System.out.println(productName);

    String productRegularPrice = product.findElement(cssSelector(".regular-price")).getAttribute("textContent");
    System.out.println(productRegularPrice);
    String productRegularPriceFormat = product.findElement(cssSelector(".regular-price")).getTagName();
    System.out.println(productRegularPriceFormat);
    String productRegularPriceColor = product.findElement(cssSelector(".regular-price")).getCssValue("color");
    java.awt.Color productRegularPriceClr = Color.fromString(productRegularPriceColor).getColor();
    assertTrue(productRegularPriceClr.getBlue()==productRegularPriceClr.getRed()&&productRegularPriceClr.getBlue()==productRegularPriceClr.getGreen());
    System.out.println(productRegularPriceClr);

    String productRegularWidth = product.findElement(cssSelector(".regular-price")).getCssValue("font-size");
    Double productRegularSize = Double.parseDouble(productRegularWidth.replace("px",""));
    System.out.println(productRegularSize);

    String productCampaignPrice = product.findElement(cssSelector(".campaign-price")).getAttribute("textContent");
    String campaignPriceFormat =  product.findElement(cssSelector(".campaign-price")).getTagName();
    System.out.println(productCampaignPrice);
    System.out.println("Format:" + campaignPriceFormat);
    String campaignPriceColor =  product.findElement(cssSelector(".campaign-price")).getCssValue("color");
    java.awt.Color campaignPriceClr = Color.fromString(campaignPriceColor).getColor();
    assertTrue(campaignPriceClr.getBlue()==0&&campaignPriceClr.getRed()>0&&campaignPriceClr.getGreen()==0);

    String campaignPriceWidth =  product.findElement(cssSelector(".campaign-price")).getCssValue("font-size");
    Double campaignPriceSize = Double.parseDouble(campaignPriceWidth.replace("px",""));
    System.out.println(campaignPriceWidth);

    assertEquals(nameOfProductMainPage, productName);
    assertEquals(regularPriceMainPage, productRegularPrice);
    assertEquals(campaignPriceMainPage, productCampaignPrice);
    assertEquals(campaignPriceMainPageFormat, campaignPriceFormat);
    assertEquals(regularPriceMainPageColor, productRegularPriceColor);
    assertEquals(campaignPriceMainPageColor, campaignPriceColor);
    assertEquals(regularPriceFormatMainPage, productRegularPriceFormat);
    assertTrue(campaignPriceSizeMP>regularPriceSizeMP);
    assertTrue(campaignPriceSize>productRegularSize);

  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

}
