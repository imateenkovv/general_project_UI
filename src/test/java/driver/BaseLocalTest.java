package driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import utils.Attachments;

import static helpers.Constants.BASE_URL;

/**
 * @author mateenkov
 */

abstract public class BaseLocalTest {

    @Step("Установка и настройка драйвера")
    @BeforeAll
    public static  void setUp() {
        Configuration.baseUrl = BASE_URL;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";

    }

    @AfterEach
    public void addAttachments(){
        Attachments.attachScreenshot();
        Attachments.addVideo();
    }

    @Step("Очистка и закрытие драйвера")
    @AfterAll
    public static  void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

}
