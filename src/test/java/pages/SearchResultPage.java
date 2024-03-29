package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * @author mateenkov
 */

public class SearchResultPage {

    private final ElementsCollection gameItem = $$("[class='responsive_search_name_combined']");

    @Step("Переход на страницу найденной игры")
    public SearchResultPage openFoundItem(String nameGame) {
        $x("//div/span[text() = '" + nameGame + "']").click();
        return this;
    }

    @Step("Проверка результата поиска игры")
    public SearchResultPage checkSearchResult(String nameGame) {
        gameItem.filterBy(Condition.visible).first().shouldHave(Condition.text(nameGame));
        return this;
    }

}
