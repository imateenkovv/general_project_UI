package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/**
 * @author mateenkov
 */

public class CommunityPage {

    private final SelenideElement inputSearchFriend = $("[id='SearchPlayers']");
    private final SelenideElement personalInfoFoundFriend = $("[class='searchPersonaInfo']");
    @Step("Поиск друга")
    public CommunityPage searchFriend(String loginFriend){
        inputSearchFriend.setValue(loginFriend).pressEnter();
        return this;
    }

    @Step("Открытие страницы")
    public CommunityPage openPage() {
        open("https://steamcommunity.com/");
        return this;
    }
    @Step("Проверка результата поиска друга")
    public CommunityPage checkFoundFriend(String loginFriend){
        personalInfoFoundFriend.shouldHave(Condition.text(loginFriend));
        return this;
    }

}
