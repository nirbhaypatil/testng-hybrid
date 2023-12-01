package testcases;


import keywords.Keyword;
import base.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainMenu;
import pages.ProductItemDetailsPage;
import pages.SearchResultsPage;
import waits.WaitFor;

import java.util.List;

public class TestCases extends TestBase {

    @Test
    public void verifyNoKidsShortsInBag() throws InterruptedException {

        MainMenu menu = new MainMenu();
        //go to kids -> shorts menu
        menu.hoverOn("kids");
        menu.clickOnMenuItem("Shorts");

        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.selectFirstProduct();
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        productItem.addToBag();

        //Assert error message before adding item to bag
        String error = productItem.getProductItemError();
        Assert.assertEquals(error,"Please select a size");

    }
}
