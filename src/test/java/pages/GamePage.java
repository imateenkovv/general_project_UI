package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

/**
 * @author mateenkov
 */

public class GamePage {

    private final ElementsCollection buttonAddToCart = $$x("//span[text() = 'В корзину']");
    private final SelenideElement titleNameGame = $("[id='appHubAppName']");
    private static final SelenideElement descriptionGame = $("[class='game_description_snippet']");

    public GamePage addGameToCart(){
        buttonAddToCart.first().click();
        return this;
    }

    public GamePage checkNameGame(String nameGame){
        titleNameGame.shouldHave(Condition.text(nameGame));
        return this;
    }

    public GamePage checkDescription(String description){
        descriptionGame.shouldHave(Condition.text(description));
        return this;
    }

}
