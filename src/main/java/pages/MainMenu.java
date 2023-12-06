package pages;

import errors.InvalidMenuItemException;
import keywords.Keyword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitFor;

public class MainMenu {

    @FindBy(css = "div.desktop-navLink a[href='/shop/kids']")
    public WebElement kidsMenuItem;

    @FindBy(css= "div[class='desktop-categoryContainer'][data-group='kids']")
    public WebElement kidsMenuFlyOut;

    @FindBy(css = "div.desktop-navLink a[href='/shop/men']")
    public WebElement mensMenuItem;

    @FindBy(css = "div[class='desktop-categoryContainer'][data-group='men']")
    public WebElement mensMenuFlyOut;

    @FindBy(linkText= "Shorts")
    public WebElement menuItemShorts;

    @FindBy(css= "a[href='/men-jeans']")
    public WebElement menuItemMenJeans;

    @FindBy(css= "a[href='/men-jackets']")
    public WebElement menuItemMenJackets;

    @FindBy(css= "a[href='/men-tshirts']")
    public WebElement menuItemMenTShirts;

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
            case "men":
                keyword.hoverOn(mensMenuItem);
                WaitFor.waitForElementToPresent(mensMenuFlyOut);
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
            case "jeans":
                menuItemMenJeans.click();
                break;
            case "jackets":
                menuItemMenJackets.click();
                break;
            default:
                throw new InvalidMenuItemException(menuItem);
        }
    }
}
