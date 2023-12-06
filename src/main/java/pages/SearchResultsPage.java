package pages;

import keywords.Keyword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {
    @FindBy(css="ul.results-base li.product-base:first-child")
    public WebElement firstItem;

    @FindBy(css ="ul.results-base")
    public WebElement searchResult;

    @FindBy(css ="ul.results-base div.product-price")
    public List<WebElement> itemPrices;

    public SearchResultsPage(){
        PageFactory.initElements(Keyword.getDriver(),this);
    }

    public void selectFirstProduct(){
        Keyword keyword = new Keyword();
        firstItem.click();
        keyword.switchToNewTab();
    }

    public List<Integer> getPrices(){
        List<Integer> prices = new ArrayList<>() ;
        for ( WebElement itemPrice : itemPrices ) {
            prices.add( Integer.parseInt(itemPrice.getText());
        }
       return prices;
    }
}
