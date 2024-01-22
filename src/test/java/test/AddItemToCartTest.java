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

import static com.codeborne.selenide.Selenide.open;
import static helpers.Constants.*;

/**
 * @author mateenkov
 */

public class AddItemToCartTest extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    GamePage gamePage = new GamePage();
    CartPage cartPage = new CartPage();
    FakerUtils faker = new FakerUtils();
    private final String NAME_GAME = faker.getGameName();

    @Test
    @Tag("Web")
    @Tag("Smoke")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Добавление игры в корзину")
    void addItemToCartTest() {
        mainPage.openPage()
                .searchItem(NAME_GAME);
        searchResultPage.openFoundItem(NAME_GAME);
        gamePage.checkNameGame(NAME_GAME)
                .addGameToCart();
        cartPage.checkTitleCartPage(TITLE_PLACEHOLDER_CART)
                .checkCounterItemInCart(COUNT_ONE_IN_CART)
                .checkNameGame(NAME_GAME)
                .checkEnableButtonsPurchase();

    }
}
