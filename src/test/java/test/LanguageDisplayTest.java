package test;

import driver.BaseLocalTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;

import static helpers.Constants.BASE_URL;

/**
 * @author mateenkov
 */

public class LanguageDisplayTest extends BaseLocalTest {
    MainPage mainPage = new MainPage();

    @ParameterizedTest
    @DisplayName("Проверка отображения текста при смене языка")
    @CsvSource(value = {
            "Italiano, Installa Steam",
            "Deutsch, Steam installieren",
            "Norsk, Installer Steam"
    })
    void correctLanguageDisplayTest2(String language, String expectedResult) {
        mainPage.openPage(BASE_URL)
                .openChangeLanguage()
                .setLanguage(language)
                .checkChangeLanguage(expectedResult);

    }

}
