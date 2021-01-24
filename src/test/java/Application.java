import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {

  private WebDriver driver;

  private CartPage cartPage;
  private MainPage mainPage;
  private ProductPage productPage;

  public Application() {
    driver = new ChromeDriver();
    cartPage = new CartPage(driver);
    mainPage = new MainPage(driver);
    productPage = new ProductPage(driver);

  }

  public void addProductToCart(int expectedProductCount) throws InterruptedException {
    mainPage.open();
    String product = mainPage.chooseFirstProduct();
    productPage.checkProductPageOpen(product);
    productPage.addToCart();
    productPage.checkProductCount(expectedProductCount);

  }

  public int countProductsInCart(){
    mainPage.open();
   return productPage.countProductsInCart();
  }

  public void deleteProductFromCart() throws InterruptedException {
    cartPage.open();
    if(!cartPage.isCartEmpty()){
      cartPage.removeProduct();
    }
  }

  public boolean isCartEmpty() throws InterruptedException {
    cartPage.open();
    return cartPage.isCartEmpty();
  }

  public void quit(){
    driver.quit();
  }

}
