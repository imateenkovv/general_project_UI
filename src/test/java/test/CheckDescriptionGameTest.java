package test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.GamePage;
import pages.MainPage;
import pages.SearchResultPage;

/**
 * @author mateenkov
 */

public class CheckDescriptionGameTest extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    GamePage gamePage = new GamePage();
    private static final String FIREWATCH = "Firewatch";
    private static final String TRUCK = "Euro Truck Simulator 2";
    private static final String CS = "Counter-Strike: Source";
    private static final String FIREWATH_DESCRIPTION = "Firewatch is a single-player first-person mystery set in the Wyoming wilderness, where your only emotional lifeline is the person on the other end of a handheld radio.";
    private static final String TRUCK_DESCRIPTION = "Travel across Europe as king of the road, a trucker who delivers important cargo across impressive distances! With dozens of cities to explore, your endurance, skill and speed will all be pushed to their limits.";
    private static final String CS_DESCRIPTION = "Counter-Strike: Source blends Counter-Strike's award-winning teamplay action with the advanced technology of Source™ technology.";
    @ParameterizedTest
    @Tag("Web")
    @DisplayName("Проверка соответствия описания игры")
    @Severity(SeverityLevel.CRITICAL)
    @CsvSource(value = {
            FIREWATCH + ", " + FIREWATH_DESCRIPTION,
            TRUCK + ", " + TRUCK_DESCRIPTION,
            CS + ", " + CS_DESCRIPTION})
    void checkDescriptionGameTest(String nameGame, String description) {
        mainPage.openPage()
                .searchItem(nameGame);
        searchResultPage.openFoundItem(nameGame);
        gamePage.checkDescription(description);
    }
}
