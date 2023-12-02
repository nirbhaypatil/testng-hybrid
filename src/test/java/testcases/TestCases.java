package testcases;


import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainMenu;
import pages.ProductItemDetailsPage;
import pages.SearchResultsPage;

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

    @Test
    public void verifySelectedProductGetsAddedInBag() throws InterruptedException {

        MainMenu menu = new MainMenu();
        //go to kids -> shorts menu
        menu.hoverOn("MEN");
        menu.clickOnMenuItem("Jeans");

        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.selectFirstProduct();
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        //Choose size of product
        productItem.selectDefaultSize();
        productItem.addToBag();
        //Choose size of product
        Assert.assertEquals(productItem.isItemAddedInBag(),"1");
    }

}
