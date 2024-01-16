package test;

import driver.BaseRemoteTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.GamePage;
import pages.MainPage;
import pages.SearchResultPage;

import static helpers.Constants.*;

/**
 * @author mateenkov
 */

public class CheckDescriptionGameTest extends BaseRemoteTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    GamePage gamePage = new GamePage();
    @ParameterizedTest
    @Tag("Web")
    @DisplayName("Проверка соответствия описания игры")
    @Severity(SeverityLevel.CRITICAL)
    @CsvSource(value = {
            FIREWATCH + ", " + FIREWATH_DESCRIPTION,
            TRUCK + ", " + TRUCK_DESCRIPTION,
            CS + ", " + CS_DESCRIPTION})
    void checkDescriptionGameTest(String nameGame, String description) {
        mainPage.openPage(BASE_URL)
                .searchItem(nameGame);
        searchResultPage.openFoundItem(nameGame);
        gamePage.checkDescription(description);
    }
}
