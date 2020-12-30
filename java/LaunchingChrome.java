import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.*;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LaunchingChrome{
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
    ChromeOptions options = new ChromeOptions();
   // options.addArguments("start-fullscreen");
   // driver = new ChromeDriver(options);
    driver = new ChromeDriver();
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

      WebElement menu = driver.findElement(cssSelector("ul#box-apps-menu"));
      WebElement appearence = menu.findElement(By.linkText("Appearence"));
      Thread.sleep(1000);
      appearence.click();
      wait.until(titleIs("Template | My Store"));
     WebElement templateHeader = driver.findElement(By.tagName("h1"));
     String templateString = templateHeader.getText();
     assertTrue(templateString.contains("Template"));

      WebElement logotype = driver.findElement(cssSelector("ul.docs"));
      WebElement logotypeLink = logotype.findElement(By.linkText("Logotype"));
      Thread.sleep(1000);
      logotypeLink.click();
      wait.until(titleIs("Logotype | My Store"));
      WebElement logotypeHeader = driver.findElement(By.tagName("h1"));
      String logotypeString = logotypeHeader.getText();
      assertTrue(logotypeString.contains("Logotype"));

      WebElement catalogLink = driver.findElement(By.linkText("Catalog"));
      Thread.sleep(1000);
      catalogLink.click();
      wait.until(titleIs("Catalog | My Store"));
      WebElement catalogHeader = driver.findElement(By.tagName("h1"));
      String catalogString = catalogHeader.getText();
      assertTrue(catalogString.contains("Catalog"));

     WebElement productGroupLink = driver.findElement(By.linkText("Product Groups"));
     Thread.sleep(1000);
     productGroupLink.click();
     wait.until(titleIs("Product Groups | My Store"));
     WebElement productGroupsHeader = driver.findElement(By.tagName("h1"));
     String productGroupsString = productGroupsHeader.getText();
     assertTrue(productGroupsString.contains("Product Groups"));

    WebElement optionGroupLink = driver.findElement(By.linkText("Option Groups"));
    Thread.sleep(1000);
    optionGroupLink.click();
    wait.until(titleIs("Option Groups | My Store"));
    WebElement optionGroupHeader = driver.findElement(By.tagName("h1"));
    String optionGroupString = optionGroupHeader.getText();
    assertTrue(optionGroupString.contains("Option Groups"));

    WebElement manufacturersLink = driver.findElement(By.linkText("Manufacturers"));
    Thread.sleep(1000);
    manufacturersLink.click();
    wait.until(titleIs("Manufacturers | My Store"));
    WebElement manufacturersHeader = driver.findElement(By.tagName("h1"));
    String manufacturersString = manufacturersHeader.getText();
    assertTrue(manufacturersString.contains("Manufacturers"));

    WebElement suppliersLink = driver.findElement(By.linkText("Suppliers"));
    Thread.sleep(1000);
    suppliersLink.click();
    wait.until(titleIs("Suppliers | My Store"));
    WebElement suppliersHeader = driver.findElement(By.tagName("h1"));
    String suppliersString = suppliersHeader.getText();
    assertTrue(suppliersString.contains("Suppliers"));

    WebElement deliveryStatusesLink = driver.findElement(By.linkText("Delivery Statuses"));
    Thread.sleep(1000);
    deliveryStatusesLink.click();
    wait.until(titleIs("Delivery Statuses | My Store"));
    WebElement deliveryStatusesHeader = driver.findElement(By.tagName("h1"));
    String deliveryStatusesString = deliveryStatusesHeader.getText();
    assertTrue(deliveryStatusesString.contains("Delivery Statuses"));

    WebElement  soldOutStatusesLink = driver.findElement(By.linkText("Sold Out Statuses"));
    Thread.sleep(1000);
    soldOutStatusesLink.click();
    wait.until(titleIs("Sold Out Statuses | My Store"));
    WebElement soldOutStatusesHeader = driver.findElement(By.tagName("h1"));
    String soldOutStatusesString = soldOutStatusesHeader.getText();
    assertTrue(soldOutStatusesString.contains("Sold Out Statuses"));

    WebElement quantityUnitsLink = driver.findElement(By.linkText("Quantity Units"));
    Thread.sleep(1000);
    quantityUnitsLink.click();
    wait.until(titleIs("Quantity Units | My Store"));
    WebElement quantityUnitsHeader = driver.findElement(By.tagName("h1"));
    String quantityUnitsString = quantityUnitsHeader.getText();
    assertTrue(quantityUnitsString.contains("Quantity Units"));

    WebElement CSVImportExportCatalogLink = driver.findElement(By.linkText("CSV Import/Export"));
    Thread.sleep(1000);
    CSVImportExportCatalogLink.click();
    wait.until(titleIs("CSV Import/Export | My Store"));
    WebElement CSVImportExportCatalogHeader = driver.findElement(By.tagName("h1"));
    String CSVImportExportCatalogString = CSVImportExportCatalogHeader.getText();
    assertTrue(CSVImportExportCatalogString.contains("CSV Import/Export"));

    WebElement countriesLink = driver.findElement(By.linkText("Countries"));
     Thread.sleep(1000);
     countriesLink.click();
     wait.until(titleIs("Countries | My Store"));
    WebElement countriesHeader = driver.findElement(By.tagName("h1"));
    String countriesString = countriesHeader.getText();
    assertTrue(countriesString.contains("Countries"));

    WebElement currenciesLink = driver.findElement(By.linkText("Currencies"));
    Thread.sleep(1000);
    currenciesLink.click();
    wait.until(titleIs("Currencies | My Store"));
    WebElement currenciesHeader = driver.findElement(By.tagName("h1"));
    String currenciesString = currenciesHeader.getText();
    assertTrue(currenciesString.contains("Currencies"));

    WebElement customersLink = driver.findElement(By.linkText("Customers"));
    Thread.sleep(1000);
    customersLink.click();
    wait.until(titleIs("Customers | My Store"));
    WebElement customersHeader = driver.findElement(By.tagName("h1"));
    String customersString = customersHeader.getText();
    assertTrue(customersString.contains("Customers"));

    WebElement CSVImportExportLink  = driver.findElement(By.linkText("CSV Import/Export"));
    Thread.sleep(1000);
    CSVImportExportLink.click();
    wait.until(titleIs("CSV Import/Export | My Store"));
    WebElement CSVImportExportLinkHeader = driver.findElement(By.tagName("h1"));
    String CSVImportExportLinkString =  CSVImportExportLinkHeader.getText();
    assertTrue(CSVImportExportLinkString.contains("CSV Import/Export"));

    WebElement newsletterLink  = driver.findElement(By.linkText("Newsletter"));
    Thread.sleep(1000);
    newsletterLink.click();
    wait.until(titleIs("Newsletter | My Store"));
    WebElement newsletterHeader = driver.findElement(By.tagName("h1"));
    String newsletterString =  newsletterHeader.getText();
    assertTrue(newsletterString.contains("Newsletter"));

    WebElement geoZonesLink  = driver.findElement(By.linkText("Geo Zones"));
    Thread.sleep(1000);
    geoZonesLink.click();
    wait.until(titleIs("Geo Zones | My Store"));
    WebElement geoZonesHeader = driver.findElement(By.tagName("h1"));
    String geoZonesString =  geoZonesHeader.getText();
    assertTrue(geoZonesString.contains("Geo Zones"));

    WebElement languagesLink  = driver.findElement(By.linkText("Languages"));
    Thread.sleep(1000);
    languagesLink.click();
    wait.until(titleIs("Languages | My Store"));
    WebElement languagesHeader = driver.findElement(By.tagName("h1"));
    String languagesHeaderString =  languagesHeader.getText();
    assertTrue(languagesHeaderString.contains("Languages"));

    WebElement storageEncodingLink  = driver.findElement(By.linkText("Storage Encoding"));
    Thread.sleep(1000);
    storageEncodingLink.click();
    wait.until(titleIs("Storage Encoding | My Store"));
    WebElement storageEncodingHeader = driver.findElement(By.tagName("h1"));
    String storageEncodingHeaderString =  storageEncodingHeader.getText();
    assertTrue(storageEncodingHeaderString.contains("Storage Encoding"));

    WebElement modulesLink  = driver.findElement(By.linkText("Modules"));
    Thread.sleep(1000);
    modulesLink.click();
    wait.until(titleIs("Job Modules | My Store"));
    WebElement modulesHeader = driver.findElement(By.tagName("h1"));
    String modulesHeaderString =  modulesHeader.getText();
    assertTrue(modulesHeaderString.contains("Job Modules"));

    WebElement customerLink  = driver.findElement(By.linkText("Customer"));
    Thread.sleep(1000);
    customerLink.click();
    wait.until(titleIs("Customer Modules | My Store"));
    WebElement customerHeader = driver.findElement(By.tagName("h1"));
    String customerHeaderString =  customerHeader.getText();
    assertTrue(customerHeaderString.contains("Customer Modules"));


    WebElement shippingLink  = driver.findElement(By.linkText("Shipping"));
    Thread.sleep(1000);
    shippingLink.click();
    wait.until(titleIs("Shipping Modules | My Store"));
    WebElement shippingHeader = driver.findElement(By.tagName("h1"));
    String shippingHeaderString =  shippingHeader.getText();
    assertTrue(shippingHeaderString.contains("Shipping Modules"));

    WebElement paymentLink  = driver.findElement(By.linkText("Payment"));
    Thread.sleep(1000);
    paymentLink.click();
    wait.until(titleIs("Payment Modules | My Store"));
    WebElement paymentHeader = driver.findElement(By.tagName("h1"));
    String paymentHeaderString =  paymentHeader.getText();
    assertTrue(paymentHeaderString.contains("Payment Modules"));


    WebElement orderTotalModules  = driver.findElement(By.linkText("Order Total"));
    Thread.sleep(1000);
    orderTotalModules.click();
    wait.until(titleIs("Order Total Modules | My Store"));
    WebElement orderTotalModulesHeader = driver.findElement(By.tagName("h1"));
    String orderTotalModulesString =  orderTotalModulesHeader.getText();
    assertTrue(orderTotalModulesString.contains("Order Total Modules"));

    WebElement orderSuccessModules  = driver.findElement(By.linkText("Order Success"));
    Thread.sleep(1000);
    orderSuccessModules.click();
    wait.until(titleIs("Order Success Modules | My Store"));
    WebElement orderSuccessModulesHeader = driver.findElement(By.tagName("h1"));
    String orderSuccessModulesString =  orderSuccessModulesHeader.getText();
    assertTrue(orderSuccessModulesString.contains("Order Success Modules"));


    WebElement orderActionModules  = driver.findElement(By.linkText("Order Action"));
    Thread.sleep(1000);
    orderActionModules.click();
    wait.until(titleIs("Order Action Modules | My Store"));
    WebElement orderActionModulesHeader = driver.findElement(By.tagName("h1"));
    String orderActionModulesString =  orderActionModulesHeader.getText();
    assertTrue(orderActionModulesString.contains("Order Action Modules"));

    WebElement orders  = driver.findElement(By.linkText("Orders"));
    Thread.sleep(1000);
    orders.click();
    wait.until(titleIs("Orders | My Store"));
    WebElement ordersHeader = driver.findElement(By.tagName("h1"));
    String ordersHeaderString =  ordersHeader.getText();
    assertTrue(ordersHeaderString.contains("Orders"));

    WebElement ordersStatuses  = driver.findElement(By.linkText("Order Statuses"));
    Thread.sleep(1000);
    ordersStatuses.click();
    wait.until(titleIs("Order Statuses | My Store"));
    WebElement ordersStatusesHeader = driver.findElement(By.tagName("h1"));
    String ordersStatusesHeaderString =  ordersStatusesHeader.getText();
    assertTrue(ordersStatusesHeaderString.contains("Order Statuses"));

    WebElement pagesLink  = driver.findElement(By.linkText("Pages"));
    Thread.sleep(1000);
    pagesLink.click();
    wait.until(titleIs("Pages | My Store"));
    WebElement pagesLinkHeader = driver.findElement(By.tagName("h1"));
    String pagesLinkHeaderString =  pagesLinkHeader.getText();
    assertTrue(pagesLinkHeaderString.contains("Pages"));

    WebElement reportsLink  = driver.findElement(By.linkText("Reports"));
    Thread.sleep(1000);
    reportsLink.click();
    wait.until(titleIs("Monthly Sales | My Store"));
    WebElement reportsLinkHeader = driver.findElement(By.tagName("h1"));
    String reportsLinkHeaderString =  reportsLinkHeader.getText();
    assertTrue(reportsLinkHeaderString.contains("Monthly Sales"));

    WebElement mostSoldProductsLink  = driver.findElement(By.linkText("Most Sold Products"));
    Thread.sleep(1000);
    mostSoldProductsLink.click();
    wait.until(titleIs("Most Sold Products | My Store"));
    WebElement mostSoldProductsHeader = driver.findElement(By.tagName("h1"));
    String mostSoldProductsString =  mostSoldProductsHeader.getText();
    assertTrue(mostSoldProductsString.contains("Most Sold Products"));

    WebElement mostShoppingCustomersLink  = driver.findElement(By.linkText("Most Shopping Customers"));
    Thread.sleep(1000);
    mostShoppingCustomersLink.click();
    wait.until(titleIs("Most Shopping Customers | My Store"));
    WebElement mostShoppingCustomersHeader = driver.findElement(By.tagName("h1"));
    String mostShoppingCustomersString =  mostShoppingCustomersHeader.getText();
    assertTrue(mostShoppingCustomersString.contains("Most Shopping Customers"));

    WebElement settingsLink  = driver.findElement(By.linkText("Settings"));
    Thread.sleep(1000);
    settingsLink.click();
    wait.until(titleIs("Settings | My Store"));
    WebElement settingsCustomersHeader = driver.findElement(By.tagName("h1"));
    String settingsCustomersHeaderString =  settingsCustomersHeader.getText();
    assertTrue(settingsCustomersHeaderString.contains("Settings"));

    WebElement storeInfoLink  = driver.findElement(By.linkText("Store Info"));
    Thread.sleep(1000);
    storeInfoLink.click();
    wait.until(titleIs("Settings | My Store"));
    WebElement storeInfoLinkHeader = driver.findElement(By.tagName("h1"));
    String storeInfoLinkHeaderString =  storeInfoLinkHeader.getText();
    assertTrue(storeInfoLinkHeaderString.contains("Settings"));

    WebElement defaultsLink  = driver.findElement(By.linkText("Defaults"));
    Thread.sleep(1000);
    defaultsLink.click();
    wait.until(titleIs("Settings | My Store"));
    WebElement defaultsLinkHeader = driver.findElement(By.tagName("h1"));
    String defaultsLinkHeaderString =  defaultsLinkHeader.getText();
    assertTrue(defaultsLinkHeaderString.contains("Settings"));

    WebElement generalLink  = driver.findElement(By.linkText("General"));
    Thread.sleep(1000);
    generalLink.click();
    wait.until(titleIs("Settings | My Store"));
    WebElement generalLinkHeader = driver.findElement(By.tagName("h1"));
    String generalLinkHeaderString =  generalLinkHeader.getText();
    assertTrue(generalLinkHeaderString.contains("Settings"));

    WebElement listingsLink  = driver.findElement(By.linkText("Listings"));
    Thread.sleep(1000);
    listingsLink.click();
    wait.until(titleIs("Settings | My Store"));
    WebElement listingsLinkHeader = driver.findElement(By.tagName("h1"));
    String listingsLinkHeaderString =  listingsLinkHeader.getText();
    assertTrue(listingsLinkHeaderString.contains("Settings"));

    WebElement imagesLink  = driver.findElement(By.linkText("Images"));
    Thread.sleep(1000);
    imagesLink.click();
    wait.until(titleIs("Settings | My Store"));
    WebElement imagesLinkHeader = driver.findElement(By.tagName("h1"));
    String imagesLinkHeaderString =  imagesLinkHeader.getText();
    assertTrue(imagesLinkHeaderString.contains("Settings"));

    WebElement checkoutLink  = driver.findElement(By.linkText("Checkout"));
    Thread.sleep(1000);
    checkoutLink.click();
    wait.until(titleIs("Settings | My Store"));
    WebElement checkoutHeader = driver.findElement(By.tagName("h1"));
    String checkoutHeaderString =  checkoutHeader.getText();
    assertTrue(checkoutHeaderString.contains("Settings"));

    WebElement advancedLink  = driver.findElement(By.linkText("Advanced"));
    Thread.sleep(1000);
    advancedLink.click();
    wait.until(titleIs("Settings | My Store"));
    WebElement advancedHeader = driver.findElement(By.tagName("h1"));
    String advancedHeaderString =  advancedHeader.getText();
    assertTrue(advancedHeaderString.contains("Settings"));

    WebElement securityLink  = driver.findElement(By.linkText("Security"));
    Thread.sleep(1000);
    securityLink.click();
    wait.until(titleIs("Settings | My Store"));
    WebElement securityHeader = driver.findElement(By.tagName("h1"));
    String securityHeaderString =  securityHeader.getText();
    assertTrue(securityHeaderString.contains("Settings"));


    WebElement slidesLink  = driver.findElement(By.linkText("Slides"));
    Thread.sleep(1000);
    slidesLink.click();
    wait.until(titleIs("Slides | My Store"));
    WebElement slidesHeader = driver.findElement(By.tagName("h1"));
    String slidesHeaderString =  slidesHeader.getText();
    assertTrue(slidesHeaderString.contains("Slides"));

    WebElement taxClassesLink  = driver.findElement(By.linkText("Tax"));
    Thread.sleep(1000);
    taxClassesLink .click();
    wait.until(titleIs("Tax Classes | My Store"));
    WebElement taxClassesHeader = driver.findElement(By.tagName("h1"));
    String taxClassesHeaderString =  taxClassesHeader.getText();
    assertTrue(taxClassesHeaderString.contains("Tax Classes"));

    WebElement taxRatesLink  = driver.findElement(By.linkText("Tax Rates"));
    Thread.sleep(1000);
    taxRatesLink.click();
    wait.until(titleIs("Tax Rates | My Store"));
    WebElement taxRatesHeader = driver.findElement(By.tagName("h1"));
    String taxRatesHeaderString =  taxRatesHeader.getText();
    assertTrue(taxRatesHeaderString.contains("Tax Rates"));

    WebElement searchTranslations  = driver.findElement(By.linkText("Translations"));
    Thread.sleep(1000);
    searchTranslations.click();
    wait.until(titleIs("Search Translations | My Store"));
    WebElement searchTranslationsHeader = driver.findElement(By.tagName("h1"));
    String searchTranslationsHeaderString =  searchTranslationsHeader.getText();
    assertTrue(searchTranslationsHeaderString.contains("Search Translations"));

    WebElement scanFilesLink  = driver.findElement(By.linkText("Scan Files"));
    Thread.sleep(1000);
    scanFilesLink.click();
    wait.until(titleIs("Scan Files For Translations | My Store"));
    WebElement scanFilesLinkHeader = driver.findElement(By.tagName("h1"));
    String scanFilesLinkHeaderString =  scanFilesLinkHeader .getText();
    assertTrue(scanFilesLinkHeaderString.contains("Scan Files For Translations"));

    WebElement CSVImportExport  = driver.findElement(By.linkText("CSV Import/Export"));
    Thread.sleep(1000);
    CSVImportExport.click();
    wait.until(titleIs("CSV Import/Export | My Store"));
    WebElement CSVImportExportHeader = driver.findElement(By.tagName("h1"));
    String CSVImportExportHeaderString =  CSVImportExportHeader.getText();
    assertTrue(CSVImportExportHeaderString.contains("CSV Import/Export"));

    WebElement UsersLink  = driver.findElement(By.linkText("Users"));
    Thread.sleep(1000);
    UsersLink.click();
    wait.until(titleIs("Users | My Store"));
    WebElement UsersLinkHeader = driver.findElement(By.tagName("h1"));
    String UsersLinkHeaderString =  UsersLinkHeader.getText();
    assertTrue(UsersLinkHeaderString.contains("Users"));

    WebElement vQmodsLink  = driver.findElement(By.linkText("vQmods"));
    Thread.sleep(1000);
    vQmodsLink.click();
    wait.until(titleIs("vQmods | My Store"));
    WebElement vQmodsLinkHeader = driver.findElement(By.tagName("h1"));
    String vQmodsLinkHeaderString =  vQmodsLinkHeader .getText();
    assertTrue(vQmodsLinkHeaderString.contains("vQmods"));
  }
}
