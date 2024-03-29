package test;

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

/**
 * @author mateenkov
 */

public class RemoveItemFromCart extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    GamePage gamePage = new GamePage();
    CartPage cartPage = new CartPage();
    FakerUtils faker = new FakerUtils();
    private final String NAME_GAME = faker.getGameName();
    private static final String AMOUNT_EMPTY_CART = "0";
    private static final String MESSAGE_REMOVE_SINGLE_ITEM = "Your item has been removed!";

    @Test
    @Tag("Web")
    @Tag("Smoke")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Удаление игры из корзины")
    void removeItemFromCartTest() {
        mainPage.openPage()
                .searchItem(NAME_GAME);
        searchResultPage.openFoundItem(NAME_GAME);
        gamePage.addGameToCart();
        cartPage.removeSingleItemFromCart()
                .checkStatusCartRemoveItem(MESSAGE_REMOVE_SINGLE_ITEM)
                .checkPriceAnEmptyCart(AMOUNT_EMPTY_CART);

    }

}
