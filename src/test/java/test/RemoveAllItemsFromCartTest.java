package test;

import driver.BaseLocalTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.GamePage;
import pages.MainPage;
import pages.SearchResultPage;

import static helpers.Constants.*;
import static utils.FakerUtils.getGameName;

/**
 * @author mateenkov
 */

public class RemoveAllItemsFromCartTest extends BaseLocalTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    GamePage gamePage = new GamePage();
    CartPage cartPage = new CartPage();
    private static final String NAME_GAME_ONE = getGameName();
    private static final String NAME_GAME_TWO = getGameName();

    @Test
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
