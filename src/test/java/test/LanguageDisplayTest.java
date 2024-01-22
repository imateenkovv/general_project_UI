package test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;

/**
 * @author mateenkov
 */

public class LanguageDisplayTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @ParameterizedTest
    @Tag("Web")
    @Tag("Smoke")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка отображения текста при смене языка")
    @CsvSource(value = {
            "Italiano, Installa Steam",
            "Deutsch, Steam installieren",
            "Norsk, Installer Steam"
    })
    void correctLanguageDisplayTest2(String language, String expectedResult) {
        mainPage.openPage()
                .openChangeLanguage()
                .setLanguage(language)
                .checkChangeLanguage(expectedResult);

    }

}
