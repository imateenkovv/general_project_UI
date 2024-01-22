package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverProvider;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Attachments;

import java.util.Map;

/**
 * @author mateenkov
 */

abstract public class BaseTest {
    @BeforeAll
    public static void setUp() {
        WebDriverProvider.configuration();
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void addAttachments() {
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
