package test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchResultPage;
import utils.FakerUtils;

/**
 * @author mateenkov
 */

public class SearchFieldTest extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    FakerUtils faker = new FakerUtils();
    private final String GAME = faker.getGameName();

    @Test
    @Tag("Web")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка поисковой  выдачи в Steam")
    void searchFieldTest() {
        mainPage.openPage()
                .searchItem(GAME);
        searchResultPage.checkSearchResult(GAME);
    }

}
