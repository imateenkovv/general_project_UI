package test;

import driver.BaseLocalTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.GamePage;
import pages.MainPage;
import pages.SearchResultPage;

import static helpers.Constants.*;

/**
 * @author mateenkov
 */

public class CheckDescriptionGameTest extends BaseLocalTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    GamePage gamePage = new GamePage();
    @ParameterizedTest
    @DisplayName("Проверка соответствия описания игры")
    @CsvSource(value = {
            FIREWATCH + ", " + FIREWATH_DESCRIPTION,
            DETROIT + ", " + DETROIT_DESCRIPTION,
            CS + ", " + CS_DESCRIPTION})
    void checkDescriptionGameTest(String nameGame, String description) {
        mainPage.openPage(BASE_URL)
                .searchItem(nameGame);
        searchResultPage.openFoundItem(nameGame);
        gamePage.checkDescription(description);
    }
}
