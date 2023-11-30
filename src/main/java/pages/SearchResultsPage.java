package pages;

import Keywords.Keyword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    @FindBy(css="ul.results-base li.product-base:first-child")
    public WebElement firstItem;

    @FindBy(css ="ul.results-base")
    public WebElement searchResult;

    public SearchResultsPage(){
        PageFactory.initElements(Keyword.getDriver(),this);
    }

    public void selectFirstProduct(){
        Keyword keyword = new Keyword();
        firstItem.click();
        keyword.switchToNewTab();
    }
}
