package pages;

import errors.InvalidMenuItemException;
import keywords.Keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitFor;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {
    @FindBy(css="ul.results-base li.product-base:first-child")
    public WebElement firstItem;

    @FindBy(css ="ul.results-base")
    public WebElement searchResult;

    @FindBy(css ="ul.results-base div.product-price")
    public List<WebElement> itemPrices;

    @FindBy(css="div.sort-sortBy")
    public WebElement listSortBy;

    public SearchResultsPage(){
        PageFactory.initElements(Keyword.getDriver(),this);
    }

    public void selectFirstProduct(){
        Keyword keyword = new Keyword();
        firstItem.click();
        keyword.switchToNewTab();
    }

    public List<Integer> getPrices(){
        Keyword keyword = new Keyword();
        // To avoid StaleElementException
        Keyword.getDriver().navigate().refresh();
        List<Integer> prices = new ArrayList<>() ;
        for ( WebElement itemPrice : itemPrices ) {
            prices.add( Integer.parseInt(itemPrice.getText().split("Rs. ",-1)[1]));
        }
        System.out.println(prices);
       return prices;
    }

    public void sortByPrices(String criteria) {
       Keyword keyword = new Keyword();
       keyword.hoverOn( listSortBy);

       switch(criteria.toLowerCase()){
           case "hightolow":
               List<WebElement> options = listSortBy.findElements(By.cssSelector("li label"));
               for ( WebElement option: options) {
                   if(option.getText().equalsIgnoreCase("Price: High to Low")) {
                       option.click();
                       break;
                   }
               }
               WaitFor.waitForElementToPresent(searchResult);
               break;
           default:
               throw new InvalidMenuItemException(criteria);
       }
    }
}
