package pages;

import Errors.InvalidMenuItemException;
import Keywords.Keyword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitFor;

public class MainMenu {

    @FindBy(css = "div.desktop-navLink a[href='/shop/kids']")
    public WebElement kidsMenuItem;

    @FindBy(css= "div[class='desktop-categoryContainer'][data-group='kids']")
    public WebElement kidsMenuFlyOut;

    @FindBy(linkText= "Shorts")
    public WebElement menuItemShorts;

    public MainMenu(){
        PageFactory.initElements(Keyword.getDriver(),this);
    }

    /**
     * This method helps to hover on menu options.
     *
     * @param menu String
     */
    public void hoverOn(String menu) {
        Keyword keyword = new Keyword();
        switch(menu.toLowerCase()){
            case "kids":
                 keyword.hoverOn(kidsMenuItem);
                 WaitFor.waitForElementToPresent(kidsMenuFlyOut);
                 break;
            default:
                 throw new InvalidMenuItemException(menu);
        }
    }

    public void clickOnMenuItem(String menuItem) {
        Keyword keyword = new Keyword();
        switch(menuItem.toLowerCase()){
            case "shorts":
                menuItemShorts.click();
                break;
            default:
                throw new InvalidMenuItemException(menuItem);
        }
    }
}
