package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

/**
 * @author mateenkov
 */

public class MainPage {

    private final SelenideElement inputSearch = $("[type='search']");
    private final SelenideElement changeLanguageButton = $("[id='language_pulldown']");
    private final SelenideElement buttonDownloadSteam = $("[class='header_installsteam_btn_content']");
    @Step("Поиск игры")
    public MainPage searchItem(String value) {
        inputSearch.setValue(value);
        inputSearch.pressEnter();
        return this;
    }
    @Step("Открытие страницы")
    public MainPage openPage(String url) {
        open(url);
        webdriver().shouldHave(url(url));
        return this;
    }
    @Step("Открыть меню переключения языка")
    public MainPage openChangeLanguage() {
        changeLanguageButton.click();
        return this;
    }
    @Step("Задать язык")
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
