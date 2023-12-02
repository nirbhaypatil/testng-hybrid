package pages;

import keywords.Keyword;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import waits.WaitFor;

public class ProductItemDetailsPage {

    @FindBy(css="div.pdp-add-to-bag.pdp-button")
    public WebElement addToBag;

    @FindBy(css="span.size-buttons-size-error-message")
    public WebElement errProductItem;

    @FindBy(css="div.size-buttons-tipAndBtnContainer:first-child button")
    public WebElement defaultSizeButton;

    @FindBy(css="a.desktop-cart span.desktop-badge")
    public WebElement cart;

    @FindBy(css="div.emptyCart-base-mainContainer")
    public WebElement emptyCart;

    @FindBy(css="a.pdp-goToCart")
    public WebElement btnGoToBag;

    @FindBy(css="div.itemComponents-base-toolTipCTA")
    public WebElement itemComponentsToolTip;

    @FindBy(css="button.bulkActionStrip-desktopBulkRemove")
    public WebElement btnRemove;

    @FindBy(css="div.bulkActionStrip-confirmationModalDesktop")
    public WebElement dlgRemoveItem;

    @FindBy(css="div.bulkActionStrip-confirmationModalDesktop div:first-child button")
    public WebElement dlgBtnRemove;

    public ProductItemDetailsPage(){
        PageFactory.initElements(Keyword.getDriver(),this);
    }

    /**
     *  Adds selected item to bag.
     */
    public void addToBag(){
        WaitFor.waitForElementToBeClickable(addToBag);
        addToBag.click();
    }

    public String getProductItemError(){
        WaitFor.waitForElementToPresent(errProductItem);
        return errProductItem.getText();
    }

    /**
     *  Selects default size shown on page
     */
    public void selectDefaultSize() {
        WaitFor.waitForElementToBeClickable(defaultSizeButton);
        defaultSizeButton.click();
    }

    /**
     * Returns no of items in bag.
     *
     * @return String
     */
    public String getItemAddedInBag(){
        WaitFor.waitForElementToContainText(cart,"1");
        System.out.println("no of Items in the bag: "+cart.getText());
        return cart.getText();
    }

    /**
     *  Clicks on GO TO BAG button after adding item in cart.
     */
    public void goToBag() {
        WaitFor.waitForElementToBeClickable(btnGoToBag);
        btnGoToBag.click();
    }

    public void removeItemFromBag() {
        WaitFor.waitForElementToBeClickable(itemComponentsToolTip);
        itemComponentsToolTip.click();
        WaitFor.waitForElementToBeClickable(btnRemove);
        btnRemove.click();
        WaitFor.waitForElementToPresent(dlgRemoveItem);
        dlgBtnRemove.click();
    }

    public boolean isCartEmpty() {
        WaitFor.waitForElementToPresent(emptyCart);
        return emptyCart.getText().contains("There is nothing in your bag. Let's add some items.");
    }
}
