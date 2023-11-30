package pages;

import Keywords.Keyword;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import waits.WaitFor;

public class ProductItemDetailsPage {


    @FindBy(css="div.pdp-add-to-bag.pdp-button")
    public WebElement addToBag;

    @FindBy(css="span.size-buttons-size-error-message")
    public WebElement errProductItem;


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
}
