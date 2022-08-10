import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class BaseTest {

    static WebDriver driver;
    final static Logger logger = Logger.getLogger(String.valueOf(BaseTest.class));




    @Before
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        String browserUrl = "https://www.teknosa.com/";
        logger.info("Test başladı.......");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");
        options.addArguments("--disable-site-isolation-trials");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(browserUrl);


    }


    @Test
    public void sampleTest() {

        BaseStep.homePage_Check(driver);
        BaseStep.clickGiris_uyeol(driver);
        BaseStep.clickUyeOl(driver);
        BaseStep.sendKeys_uyeOl(driver);
        BaseStep.JavaScriptClick(driver);
        BaseStep.clickGiris_uyeol(driver);
        BaseStep.click_login(driver);
        BaseStep.sendKeys_Login(driver);
        BaseStep.clickGiris_Yap(driver);
        BaseStep.search_Sendkey(driver);
        BaseStep.click_product(driver);
        BaseStep.randomSelect(driver);
        BaseStep.addToBasket(driver);
        BaseStep.goToBasket(driver);
        BaseStep.basketProcess(driver);
        BaseStep.click_finishShopping(driver);
        BaseStep.confirm_Button(driver);
        BaseStep.read_text(driver);


    }

    @After
    public void finishScenario(){

    driver.quit();
    logger.info("Test sonlandırıldı...........");
    }
}

