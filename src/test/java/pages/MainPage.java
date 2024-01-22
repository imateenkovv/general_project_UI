package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/**
 * @author mateenkov
 */

public class MainPage {

    private final SelenideElement inputSearch = $("[type='search']");
    private final SelenideElement changeLanguageButton = $("[id='language_pulldown']");
    private final SelenideElement buttonDownloadSteam = $("[class='header_installsteam_btn_content']");
    private final SelenideElement buttonAcceptCookies = $("[id='acceptAllButton']");
    @Step("Поиск игры")
    public MainPage searchItem(String value) {
        inputSearch.setValue(value);
        inputSearch.pressEnter();
        return this;
    }
    @Step("Открытие страницы")
    public MainPage openPage() {
        open("https://store.steampowered.com/");
        return this;
    }
    @Step("Открытие меню переключения языка")
    public MainPage openChangeLanguage() {
        changeLanguageButton.click();
        return this;
    }
    @Step("Выбор языка")
    public MainPage setLanguage(String language) {
        $x("//a[contains(text(),'" + language + "')]").click();
        return this;
    }
    @Step("Проверка смененного языка")
    public MainPage checkChangeLanguage(String expectedResult){
        buttonDownloadSteam.shouldHave(Condition.text(expectedResult));
        return this;
    }

}
