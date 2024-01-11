package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

/**
 * @author mateenkov
 */

public class MainPage {

    private final SelenideElement inputSearch = $("[type='search']");
    private final SelenideElement changeLanguageButton = $("[id='language_pulldown']");
    private final SelenideElement buttonDownloadSteam = $("[class='header_installsteam_btn_content']");

    public MainPage searchItem(String value) {
        inputSearch.setValue(value);
        inputSearch.pressEnter();
        return this;
    }

    public MainPage openPage(String url) {
        open(url);
        webdriver().shouldHave(url(url));
        return this;
    }

    public MainPage openChangeLanguage() {
        changeLanguageButton.click();
        return this;
    }

    public MainPage setLanguage(String language) {
        $x("//a[contains(text(),'" + language + "')]").click();
        return this;
    }

    public MainPage checkChangeLanguage(String expectedResult){
        buttonDownloadSteam.shouldHave(Condition.text(expectedResult));
        return this;
    }

}
