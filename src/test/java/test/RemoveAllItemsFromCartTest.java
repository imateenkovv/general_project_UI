package test;

import driver.BaseLocalTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.GamePage;
import pages.MainPage;
import pages.SearchResultPage;
import utils.FakerUtils;

import static helpers.Constants.*;

/**
 * @author mateenkov
 */

public class RemoveAllItemsFromCartTest extends BaseLocalTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    GamePage gamePage = new GamePage();
    CartPage cartPage = new CartPage();
    FakerUtils faker = new FakerUtils();
    private final String NAME_GAME_ONE = faker.getGameName();
    private final String NAME_GAME_TWO = faker.getGameName();

    @Test
    @Tag("Web")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление сразу всех игр из корзины")
    void removeAllItemsFromCartTest() {

        mainPage.openPage(BASE_URL)
                .searchItem(NAME_GAME_ONE);
        searchResultPage.openFoundItem(NAME_GAME_ONE);
        gamePage.addGameToCart();
        mainPage.searchItem(NAME_GAME_TWO);
        searchResultPage.openFoundItem(NAME_GAME_TWO);
        gamePage.addGameToCart();
        cartPage.removeAllItems()
                .checkPriceAnEmptyCart(AMOUNT_EMPTY_CART)
                .checkStatusCartRemoveAllItem(TITLE_PLACEHOLDER_CART);

    }

}
