package driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Attachments;

import java.util.Map;

import static helpers.Constants.BASE_URL;

/**
 * @author mateenkov
 */

abstract public class BaseRemoteTest {
    @BeforeAll
    public static void setUp() {
        String browser = System.getProperty("browser", "chrome");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String browserVersion = System.getProperty("browserVersion", "100.0");
        String remoteUrl = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        Configuration.baseUrl = BASE_URL;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = browserVersion;
        Configuration.remote = remoteUrl;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments(){
        Attachments.attachScreenshot();
        Attachments.addVideo();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
