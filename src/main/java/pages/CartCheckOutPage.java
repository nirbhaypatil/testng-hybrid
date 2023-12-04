package pages;

import keywords.Keyword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitFor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartCheckOutPage {

    @FindBy(css="div.emptyCart-base-mainContainer")
    public WebElement emptyCart;

    @FindBy(css="div.priceDetail-base-row span.priceDetail-base-value.priceDetail-base-action")
    public WebElement linkApplyCoupon;

    @FindBy(css="button.bulkActionStrip-desktopBulkRemove")
    public WebElement btnRemove;

    @FindBy(css="div.bulkActionStrip-confirmationModalDesktop")
    public WebElement dlgRemoveItem;

    @FindBy(css="div.bulkActionStrip-confirmationModalDesktop div:first-child button")
    public WebElement dlgBtnRemove;

    @FindBy(css="div#priceBlock div.priceDetail-base-row")
    public List<WebElement> priceDetails;

    public CartCheckOutPage(){
        PageFactory.initElements(Keyword.getDriver(),this);
    }
    public boolean isCartEmpty() {
        WaitFor.waitForElementToPresent(emptyCart);
        return emptyCart.getText().contains("There is nothing in your bag. Let's add some items.");
    }


    public void applyCoupon() {
        if(linkApplyCoupon.isDisplayed()){
            linkApplyCoupon.click();
        }
    }
    public void removeItemFromBag() {
        WaitFor.waitForElementToBeClickable(btnRemove);
        btnRemove.click();
        WaitFor.waitForElementToPresent(dlgRemoveItem);
        dlgBtnRemove.click();
    }

    public void isCouponApplied(){
        Pattern pattern = Pattern.compile("Coupon Discount(\\s)*(\\-)(\\?)[0-9]+");
        Matcher matcher = null;
        boolean found = false;

        for ( WebElement prices: priceDetails
             ) {
            String priceItem = prices.getText();
            matcher = pattern.matcher(priceItem);
            System.out.println(priceItem);
            if(matcher.find()){
                System.out.println("I found the text "+matcher.group()+" starting at index "+
                        matcher.start()+" and ending at index "+matcher.end());
                found= true;
            }
            if(found)
                break;
        }
    }

}
