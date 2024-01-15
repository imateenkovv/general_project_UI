package test;

import driver.BaseLocalTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchResultPage;
import utils.FakerUtils;

import static helpers.Constants.BASE_URL;

/**
 * @author mateenkov
 */

public class SearchFieldTest extends BaseLocalTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    FakerUtils faker = new FakerUtils();
    private final String GAME = faker.getGameName();

    @Test
    @Tag("Web")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка поисковой  выдачи в Steam")
    void searchFieldTest() {
        mainPage.openPage(BASE_URL)
                .searchItem(GAME);
        searchResultPage.checkSearchResult(GAME);
    }

}
