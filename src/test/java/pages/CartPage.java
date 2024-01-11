package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author mateenkov
 */

public class CartPage {

    private final SelenideElement titleNameGame = $("[class='cart_item_desc']");
    private final SelenideElement titleCart = $("[class='pageheader']");
    private final SelenideElement counterItemInCart = $("[id='cart_item_count_value']");
    private final SelenideElement buttonPurchaseSelf = $("[id='btn_purchase_self']");
    private final SelenideElement buttonPurchaseGift = $("[id='btn_purchase_gift']");
    public CartPage checkNameGame(String nameGame){
        titleNameGame.shouldHave(Condition.text(nameGame));
        return this;
    }

    public CartPage checkTitleCartPage(String titleCartPage){
        titleCart.shouldHave(Condition.text(titleCartPage));
        return this;
    }

    public CartPage checkCounterItemInCart(String countItemInCart){
        counterItemInCart.shouldHave(Condition.text(countItemInCart));
        return this;
    }

    public CartPage checkEnableButtonsPurchase(){
        buttonPurchaseGift.shouldBe(Condition.visible);
        buttonPurchaseGift.shouldBe(Condition.enabled);
        buttonPurchaseSelf.shouldBe(Condition.visible);
        buttonPurchaseSelf.shouldBe(Condition.enabled);
        return this;
    }

}
