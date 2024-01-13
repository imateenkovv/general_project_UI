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

public class AddItemToCartTest extends BaseLocalTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    GamePage gamePage = new GamePage();
    CartPage cartPage = new CartPage();
    static FakerUtils faker = new FakerUtils();
    private static final String NAME_GAME = faker.getGameName();

    @Test
    @DisplayName("Добавление игры в корзину")
    void addItemToCartTest() {
        open(BASE_URL);

        mainPage.searchItem(NAME_GAME);
        searchResultPage.openFoundItem(NAME_GAME);
        gamePage.checkNameGame(NAME_GAME)
                .addGameToCart();
        cartPage.checkTitleCartPage(TITLE_PLACEHOLDER_CART)
                .checkCounterItemInCart(COUNT_ONE_IN_CART)
                .checkNameGame(NAME_GAME)
                .checkEnableButtonsPurchase();

    }
}
