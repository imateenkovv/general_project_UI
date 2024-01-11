package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author mateenkov
 */

public class CommunityPage {

    private final SelenideElement inputSearchFriend = $("[id='SearchPlayers']");
    private final SelenideElement personalInfoFoundFriend = $("[class='searchPersonaInfo']");

    public CommunityPage searchFriend(String loginFriend){
        inputSearchFriend.setValue(loginFriend).pressEnter();
        return this;
    }

    public CommunityPage checkFoundFriend(String loginFriend){
        personalInfoFoundFriend.shouldHave(Condition.text(loginFriend));
        return this;
    }

}
