package pages;

import keywords.Keyword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitFor;

public class ApplyCouponPage {

    @FindBy(css="button#applyCoupon")
    public WebElement btnApplyCoupon;

    public ApplyCouponPage(){
        PageFactory.initElements(Keyword.getDriver(), this );
    }

    public void clickApplyCoupon(){
        WaitFor.waitForElementToPresent(btnApplyCoupon);
        btnApplyCoupon.click();
        

    }
}
