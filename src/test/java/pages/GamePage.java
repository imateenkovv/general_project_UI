package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

/**
 * @author mateenkov
 */

public class GamePage {

    private final ElementsCollection buttonAddToCart = $$x("//span[text() = 'Add to Cart']");
    private final SelenideElement titleNameGame = $("[id='appHubAppName']");
    private static final SelenideElement descriptionGame = $("[class='game_description_snippet']");
    @Step("Добавление игры в корзину")
    public GamePage addGameToCart(){
        buttonAddToCart.first().click();
        return this;
    }
    @Step("Проверка названия игры")
    public GamePage checkNameGame(String nameGame){
        titleNameGame.shouldHave(Condition.text(nameGame));
        return this;
    }
    @Step("Проверка описания игры")
    public GamePage checkDescription(String description){
        descriptionGame.shouldHave(Condition.text(description));
        return this;
    }

}
