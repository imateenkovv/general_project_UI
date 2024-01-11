package test;

import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.GamePage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static helpers.Constants.*;

/**
 * @author mateenkov
 */

public class AddItemToCartTest {
    MainPage mainPage = new MainPage();
    GamePage gamePage = new GamePage();
    CartPage cartPage = new CartPage();
    public static final String NAME_GAME = "Firewatch";

    @Test
    void addItemToCartTest() {
        open(BASE_URL);

        mainPage.searchItem(NAME_GAME)
                .openFoundItem(NAME_GAME);
        gamePage.checkNameGame(NAME_GAME)
                .addGameToCart();
        cartPage.checkTitleCartPage(TITLE_PLACEHOLDER_CART)
                .checkCounterItemInCart(COUNT_ONE_IN_CART)
                .checkNameGame(NAME_GAME)
                .checkEnableButtonsPurchase();

    }
}
