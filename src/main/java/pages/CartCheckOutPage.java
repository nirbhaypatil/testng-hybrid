package pages;

import keywords.Keyword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitFor;

public class CartCheckOutPage {

    @FindBy(css="div.emptyCart-base-mainContainer")
    public WebElement emptyCart;

    public CartCheckOutPage(){
        PageFactory.initElements(Keyword.getDriver(),this);
    }
    public boolean isCartEmpty() {
        WaitFor.waitForElementToPresent(emptyCart);
        return emptyCart.getText().contains("There is nothing in your bag. Let's add some items.");
    }
}
