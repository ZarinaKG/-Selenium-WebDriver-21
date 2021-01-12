import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.*;

public class Zadanie_11{
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
    driver.get("http://localhost/litecart/en/");

  }

  @After
  public void stop() {
   driver.quit();
   driver = null;
  }

  @Test
  public void creatAccount() throws InterruptedException {
    WebElement creatAccountLink = driver.findElement(cssSelector(".content a[href*=create_account]"));
    creatAccountLink.click();
    WebElement formular = driver.findElement(name("customer_form"));
    WebElement taxID = formular.findElement(name("tax_id"));
    Thread.sleep(1000);
    taxID.sendKeys("123456");
    WebElement company = formular.findElement(name("company"));
    Thread.sleep(1000);
    company.sendKeys("HomeOffice");

    WebElement firstname = formular.findElement(name("firstname"));
    Thread.sleep(1000);
    firstname.sendKeys("Klara");

    WebElement lastname = formular.findElement(name("lastname"));
    Thread.sleep(1000);
    lastname.sendKeys("Kolumbia");

    WebElement address1 = formular.findElement(name("address1"));
    Thread.sleep(1000);
    address1.sendKeys("Hofaeckerstrasse A");

    WebElement address2 = formular.findElement(name("address2"));
    Thread.sleep(1000);
    address2.sendKeys("Hofaeckerstrasse B");

    WebElement postcode = formular.findElement(name("postcode"));
    Thread.sleep(1000);
    postcode.sendKeys("71158");

    WebElement city = formular.findElement(name("city"));
    Thread.sleep(1000);
    city.sendKeys("New York");

    WebElement country_code = formular.findElement(cssSelector("[name=country_code]"));
    Thread.sleep(1000);
    country_code.sendKeys("United States");

    Select zone_code = new Select(driver.findElement(cssSelector("select[name=zone_code]")));
    Thread.sleep(1000);
   // zone_code.selectByValue("ME");
    zone_code.selectByIndex(2);


    String randomName = createRandomCode(8, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    System.out.println(randomName);

    WebElement email = formular.findElement(name("email"));
    Thread.sleep(1000);
    email.sendKeys(randomName + "@yahoo.com");

    WebElement phone = formular.findElement(name("phone"));
    Thread.sleep(1000);
    phone.sendKeys("+4912345678");

    WebElement password = formular.findElement(name("password"));
    Thread.sleep(1000);
    password.sendKeys("test123");

    WebElement confirmed_password = formular.findElement(name("confirmed_password"));
    Thread.sleep(1000);
    confirmed_password.sendKeys("test123");

    WebElement create_account_btn = formular.findElement(name("create_account"));
    create_account_btn.click();

    WebElement logoutLink = driver.findElement(cssSelector("#box-account li:last-child a"));
    Thread.sleep(1000);
    logoutLink.click();

    WebElement loginFormular = driver.findElement(name("login_form"));
    WebElement loginEmail = loginFormular.findElement(name("email"));
    Thread.sleep(1000);
    loginEmail.sendKeys(randomName + "@yahoo.com");

    WebElement loginPassword = loginFormular.findElement(name("password"));
    Thread.sleep(1000);
    loginPassword.sendKeys("test123");

    WebElement loginBtn = loginFormular.findElement(name("login"));
    Thread.sleep(1000);
    loginBtn.click();
    Thread.sleep(1000);
    WebElement idForLogout = driver.findElement(cssSelector("#box-account"));
    WebElement logoutBtn = idForLogout.findElement(By.linkText("Logout"));
    Thread.sleep(1000);
    logoutBtn.click();
  }

  public static String createRandomCode(int codeLength, String id) {
    return new SecureRandom()
            .ints(codeLength, 0, id.length())
            .mapToObj(id::charAt)
            .map(Object::toString)
            .collect(Collectors.joining());
  }
}
