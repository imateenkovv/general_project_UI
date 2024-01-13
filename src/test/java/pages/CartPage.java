package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * @author mateenkov
 */

public class CartPage {

    private final SelenideElement titleNameGame = $("[class='cart_item_desc']");
    private final SelenideElement titleCart = $("[class='pageheader']");
    private final SelenideElement counterItemInCart = $("[id='cart_item_count_value']");
    private final SelenideElement buttonPurchaseSelf = $("[id='btn_purchase_self']");
    private final SelenideElement buttonPurchaseGift = $("[id='btn_purchase_gift']");
    private final SelenideElement linkRemoveSingleItem = $x("//div/a[text() = 'Удалить']");
    private final SelenideElement linkRemoveAllItems = $("[class='remove_ctn']");
    private final SelenideElement cartStatusMessage = $("[class='cart_status_message']");
    private final SelenideElement cartStatusMessageAfterRemoveAllItems = $("[class='pageheader']");
    private final SelenideElement price = $("[class='price']");
    private final SelenideElement buttonConfirmRemoveAllItem = $("[class='btn_green_steamui btn_medium']");

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

    public CartPage removeSingleItemFromCart(){
        linkRemoveSingleItem.click();
        return this;
    }

    public CartPage checkStatusCartRemoveItem(String message){
        cartStatusMessage.shouldHave(Condition.text(message));
        return this;
    }

    public CartPage checkStatusCartRemoveAllItem(String message){
        cartStatusMessageAfterRemoveAllItems.shouldHave(Condition.text(message));
        return this;
    }

    public CartPage checkPriceAnEmptyCart(String value){
        price.shouldHave(Condition.text(value));
        return this;
    }

    public CartPage removeAllItems(){
        linkRemoveAllItems.click();
        buttonConfirmRemoveAllItem.click();
        return this;
    }
}
