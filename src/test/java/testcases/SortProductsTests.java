package testcases;

import base.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainMenu;
import pages.SearchResultsPage;

import java.util.List;

public class SortProductsTests extends TestBase {
    @Test(enabled = false)
    public void VerifyPriceSortingHighToLow()  {
        MainMenu menu = new MainMenu();
        menu.hoverOn("MEN");
        menu.clickOnMenuItem("T-Shirts");

        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.sortByPrices("hightolow");

        List<Integer> prices =  searchResults.getPrices();
        SoftAssert softly = new SoftAssert();
        for( int i =0 ; i< prices.size()-1;i++ ){
            softly.assertFalse(prices.get(i).compareTo(prices.get(i+1)) < 0,"Prices not in high to low order.");
        }
        softly.assertAll();
    }

    @Test
    public void VerifyPriceSortingLowToHigh()  {
        MainMenu menu = new MainMenu();
        menu.hoverOn("MEN");
        menu.clickOnMenuItem("T-Shirts");

        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.sortByPrices("lowtohigh");

        List<Integer> prices =  searchResults.getPrices();
        SoftAssert softly = new SoftAssert();
        for( int i =0 ; i< prices.size()-1;i++ ){
            softly.assertFalse(prices.get(i).compareTo(prices.get(i+1)) > 0,"Prices not in low to high order.");
        }
        softly.assertAll();
    }
}
