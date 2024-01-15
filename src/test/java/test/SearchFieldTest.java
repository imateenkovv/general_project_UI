package test;

import driver.BaseLocalTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Проверка поисковой  выдачи в Steam")
    void searchFieldTest() {
        mainPage.openPage(BASE_URL)
                .searchItem(GAME);
        searchResultPage.checkSearchResult(GAME);
    }

}
