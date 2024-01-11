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

public class RemoveItemFromCart {
    MainPage mainPage = new MainPage();
    GamePage gamePage = new GamePage();
    CartPage cartPage = new CartPage();
    private final static String NAME_GAME = "Detroit: Become Human";


    @Test
    void removeItemFromCartTest() {
        open(BASE_URL);

        mainPage.searchItem(NAME_GAME)
                .openFoundItem(NAME_GAME);
        gamePage.addGameToCart();
        cartPage.removeSingleItemFromCart()
                .checkStatusCartRemoveItem(MESSAGE_REMOVE_SINGLE_ITEM)
                .checkPriceAnEmptyCart(AMOUNT_EMPTY_CART);

    }

}
