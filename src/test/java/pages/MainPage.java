package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * @author mateenkov
 */

public class MainPage {

    private final SelenideElement inputSearch = $("[type='search']");

    public MainPage searchItem(String value) {
        inputSearch.setValue(value);
        inputSearch.pressEnter();
        return this;
    }

    public MainPage openFoundItem(String nameGame) {
        $x("//div/span[text() = '" + nameGame + "']").click();
        return this;
    }

}
