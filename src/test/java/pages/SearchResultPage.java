package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * @author mateenkov
 */

public class SearchResultPage {

    private final ElementsCollection gameItem = $$("[class='search_result_row ds_collapse_flag  app_impression_tracked']");


    public SearchResultPage openFoundItem(String nameGame) {
        $x("//div/span[text() = '" + nameGame + "']").click();
        return this;
    }

    public SearchResultPage checkSearchResult(String nameGame){
        gameItem.first().shouldHave(Condition.text(nameGame));
        return this;
    }

}
