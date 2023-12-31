package testcases;


import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.List;

public class BagTests extends TestBase {

    @Test(enabled = false)
    public void verifyErrorMessageForNoKidsShortsInBag() throws InterruptedException {

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

    @Test(enabled = false)
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
        Assert.assertEquals(productItem.getItemAddedInBag(),"1");
    }

    @Test(enabled = false)
    public void verifyProductRemovalFromBag() throws InterruptedException {

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
        Assert.assertEquals(productItem.getItemAddedInBag(),"1");
        productItem.goToBag();
        CartCheckOutPage bagPage = new CartCheckOutPage();
        //Choose size of product
        bagPage.removeItemFromBag();
        Assert.assertTrue(bagPage.isCartEmpty());
    }

    @Test(enabled = false)
    public void VerifyOnlySingleSizesIsSelectedForMenJeans() {
        MainMenu menu = new MainMenu();
        menu.hoverOn("MEN");
        menu.clickOnMenuItem("Jeans");

        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.selectFirstProduct();
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        //Choose size of product
        productItem.selectAllSizes();
        //Verify only single size is selected.
        Assert.assertEquals(productItem.getTotalSizesSelected(),1);
    }

    @Test(enabled = false)
    public void VerifyApplyCouponOnTotalPrice() throws InterruptedException {
        MainMenu menu = new MainMenu();
        menu.hoverOn("MEN");
        menu.clickOnMenuItem("Jeans");

        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.selectFirstProduct();
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        //Choose size of product
        productItem.selectDefaultSize();
        productItem.addToBag();
        productItem.goToBag();
        CartCheckOutPage bagPage = new CartCheckOutPage();
        bagPage.applyCoupon();
        ApplyCouponPage coupon = new ApplyCouponPage();
        coupon.clickApplyCoupon();
        Assert.assertTrue(bagPage.isCouponApplied());
    }

    @Test(enabled = false)
    public void VerifyPinCodeEntry() throws InterruptedException {
        MainMenu menu = new MainMenu();
        menu.hoverOn("MEN");
        menu.clickOnMenuItem("Jackets");

        SearchResultsPage searchResults = new SearchResultsPage();
        searchResults.selectFirstProduct();
        ProductItemDetailsPage productItem = new ProductItemDetailsPage();
        //Choose size of product
        productItem.selectDefaultSize();
        productItem.addToBag();
        productItem.goToBag();
        CartCheckOutPage bagPage = new CartCheckOutPage();
        bagPage.enterPinCode("411027");
        Assert.assertTrue(bagPage.getDeliverToPinCode().contains("411027"));
    }


}