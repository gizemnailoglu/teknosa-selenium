import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;


import static org.junit.jupiter.api.Assertions.assertFalse;


public class BaseStep extends BaseTest {

    final static Logger logger = Logger.getLogger(String.valueOf(BaseTest.class));

    public static void homePage_Check(WebDriver driver) {

        WebElement homePage = driver.findElement(By.cssSelector("[data-src='https://img-teknosa-sap.mncdn.com/_ui/responsive/theme-teknosa/assets/images/logo.svg']"));
        homePage.getText();
        Assert.assertTrue("Anasayfa gelmedi", homePage.isDisplayed());
        logger.info("Anasayfa açıldı...");
    }


    public static void clickGiris_uyeol(WebDriver driver) {

            WebElement loginElement = driver.findElement(By.cssSelector("a[class='btn-user']"));
            loginElement.click();
            Assert.assertTrue("Giriş yap/Üye ol butonuna tıklanamadı" , loginElement.isDisplayed());
            logger.info("Giriş yap/Üye ol butonuna tıklandı..");

    }

    public static void clickUyeOl(WebDriver driver) {


            WebElement loginElement2 = driver.findElement(By.cssSelector("a[title='Üye Ol']>span"));

            Assert.assertEquals("Üye Ol" , loginElement2.getText());
            loginElement2.click();
            logger.info("Üye ol seçeneği seçildi..");

    }

    public static void sendKeys_uyeOl(WebDriver driver) {
        WebElement registerElement = driver.findElement(By.id("register.firstName"));
        registerElement.sendKeys("İlker");
        logger.info("Ad  bilgisi girildi...");

        WebElement registerElement2 = driver.findElement(By.id("register.lastName"));
        registerElement2.sendKeys("Nailoğlu");
        logger.info("Soyad  bilgisi girildi...");

        WebElement registerElement3 = driver.findElement(By.id("register.email"));
        registerElement3.sendKeys("ilker.capt@gmail.com");
        logger.info("Mail  bilgisi girildi...");

        WebElement registerElement4 = driver.findElement(By.cssSelector("[name='mobileNumber']"));
        registerElement4.click();
        registerElement4.sendKeys("55370770763");
        logger.info("Telefon  bilgisi girildi...");

        WebElement registerElement5 = driver.findElement(By.id("password"));
        registerElement5.sendKeys("Nabi1747");
        logger.info("Şifre bilgisi girildi...");
    }

    public static void JavaScriptClick(WebDriver driver) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.cssSelector("[name='consentKvkk']"));
        Duration.ofSeconds(10);
        jse.executeScript("arguments[0].scrollIntoView();", Element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Element);
        logger.info("Üyelik için ilk checkbox işaretlendi");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element2 = driver.findElement(By.cssSelector("[name='communicationConstentForm']"));
        Duration.ofSeconds(10);
        js.executeScript("arguments[0].scrollIntoView();", element2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
        logger.info("Üyelik için ikinci checkbox işaretlendi");

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        WebElement element3 = driver.findElement(By.cssSelector("[class='lazy entered loaded']"));
        Duration.ofSeconds(10);
        jsx.executeScript("arguments[0].scrollIntoView();", element3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);
        logger.info("Anasayfa butonuna tıklanır...");

    }

    public static void click_login(WebDriver driver) {

        WebElement clickLogin = driver.findElement(By.cssSelector("[class='btn btn-secondary homeCallLogin secondCallLogin']"));
        clickLogin.click();

    }

    public static void sendKeys_Login(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='j_username']")));

        WebElement loginUser_name = driver.findElement(By.cssSelector("input[id='j_username']"));
        loginUser_name.sendKeys("gizem.nailoglu@gmail.com");

        WebElement login_Password = driver.findElement(By.cssSelector("input[id='j_password']"));
        login_Password.sendKeys("Nabi1747");
        logger.info("Login bilgileri girilir...");
    }

    public static void clickGiris_Yap(WebDriver driver) {

        WebElement giris_yap = driver.findElement(By.id("customerLoginButton"));
        giris_yap.click();
        logger.info("Giriş yap butonuna tıklanır....");

    }

    public static void search_Sendkey(WebDriver driver) {

        Duration.ofSeconds(2);
        WebElement search_Locator = driver.findElement(By.cssSelector("[class='search-button js_search_button sbx-fake btn-search']"));
        search_Locator.click();
        logger.info("Arama çubuğuna gidilir......");
    }

    public static void click_product(WebDriver driver) {

        WebElement click_Product = driver.findElement(By.cssSelector("a[href='https://www.teknosa.com/arama/?s=laptop']"));
        click_Product.click();
        logger.info("laptop seçeneği seçilir....");

    }

    public static void randomSelect(WebDriver driver) {

        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        List<WebElement> allProducts = driver.findElements(By.id("product-item"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        System.out.println("size " + allProducts.size());
        System.out.println("name " + allProducts.get(randomProduct).getText());
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("product-item")));
        // allProducts.get(randomProduct).click();
        jsc.executeScript("arguments[0].click();", allProducts.get(randomProduct));
        logger.info("Random ürün seçilir........");

    }

    public static void addToBasket(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(70));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("addToCartButton")));
        WebElement product_Locator = driver.findElement(By.id("addToCartButton"));
        product_Locator.click();
        logger.info("Ürün sepete eklenir..........");

    }

    public static void goToBasket(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(50));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='pac-buttons']/a[@class='btn btn-secondary']")));
        WebElement basket_Locator = driver.findElement(By.xpath("//div[@class='pac-buttons']/a[@class='btn btn-secondary']"));
        basket_Locator.click();
        logger.info("Sepete gidilir.....");
    }

    public static void basketProcess(WebDriver driver) {

        WebElement product_add = driver.findElement(By.cssSelector("[class='plus  quantity-right-plus']"));
        product_add.click();
        logger.info("Sepetteki ürün sayısı arttırılır.......");
    }

    public static void click_finishShopping(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(50));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href=\"/sepet/checkout\"]")));
        WebElement finish_click = driver.findElement(By.cssSelector("a[href=\"/sepet/checkout\"]"));
        finish_click.click();
    }

    public static void confirm_Button(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(50));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("paymentButtonSearch")));
        WebElement confirm_button = driver.findElement(By.id("paymentButtonSearch"));
        confirm_button.click();
        logger.info("Ödeme butonuna tıklanır....");

    }

    public static void read_text(WebDriver driver) {

        WebElement text_locator = driver.findElement(By.id("terms1Error"));
        text_locator.getText();
        logger.info("Text okunur..");

    }
}
