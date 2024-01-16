package test;

import driver.BaseRemoteTest;
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

import static com.codeborne.selenide.Selenide.open;
import static helpers.Constants.*;

/**
 * @author mateenkov
 */

public class RemoveItemFromCart extends BaseRemoteTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    GamePage gamePage = new GamePage();
    CartPage cartPage = new CartPage();
    FakerUtils faker = new FakerUtils();
    private final String NAME_GAME = faker.getGameName();


    @Test
    @Tag("Web")
    @Tag("Smoke")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Удаление игры из корзины")
    void removeItemFromCartTest() {
        mainPage.openPage(BASE_URL)
                .searchItem(NAME_GAME);
        searchResultPage.openFoundItem(NAME_GAME);
        gamePage.addGameToCart();
        cartPage.removeSingleItemFromCart()
                .checkStatusCartRemoveItem(MESSAGE_REMOVE_SINGLE_ITEM)
                .checkPriceAnEmptyCart(AMOUNT_EMPTY_CART);

    }

}
