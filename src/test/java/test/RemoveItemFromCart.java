package test;

import driver.BaseLocalTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.GamePage;
import pages.MainPage;
import pages.SearchResultPage;
import utils.FakerUtils;

import static com.codeborne.selenide.Selenide.open;
import static helpers.Constants.*;

/**
 * @author mateenkov
 */

public class RemoveItemFromCart extends BaseLocalTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    GamePage gamePage = new GamePage();
    CartPage cartPage = new CartPage();
    static FakerUtils faker = new FakerUtils();
    private final static String NAME_GAME = faker.getGameName();


    @Test
    @DisplayName("Удаление игры из корзины")
    void removeItemFromCartTest() {
        open(BASE_URL);

        mainPage.searchItem(NAME_GAME);
        searchResultPage.openFoundItem(NAME_GAME);
        gamePage.addGameToCart();
        cartPage.removeSingleItemFromCart()
                .checkStatusCartRemoveItem(MESSAGE_REMOVE_SINGLE_ITEM)
                .checkPriceAnEmptyCart(AMOUNT_EMPTY_CART);

    }

}
