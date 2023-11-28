package testcases;


import Keywords.Keyword;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import waits.WaitFor;
import java.time.Duration;
import java.util.List;

public class TestCases extends TestBase {

    //@Test
    public void sauceLogin(){
        RemoteWebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");
        webDriver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        webDriver.findElement(By.name("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.id("login-button")).click();


        webDriver.quit();
    }

    //@Test
    public void searchPoloShirtsWithKeywords(){
        Keyword keyword = new Keyword();

        keyword.enterText("class","desktop-searchBar","Polo Shirts", Keys.ENTER);
        WaitFor.waitForElementToPresent("class","results-base");
        List<String> productTitles = keyword.getTexts("css","h3.product-brand");

        SoftAssert softly = new SoftAssert();
        for(String productTitle : productTitles){
            System.out.println(productTitle);
            softly.assertTrue(productTitle.contains("U.S. Polo Assn"));
        }
        softly.assertAll();
        keyword.quitAllWindows();
    }

    @Test
    public void verifyErrorMessageKidsShortsToBag() throws InterruptedException {
        Keyword keyword = new Keyword();
        keyword.hoverOn("css","div.desktop-navLink a[href='/shop/kids']");
        WaitFor.waitForElementToPresent("css","div[class='desktop-categoryContainer'][data-group='kids']");
        keyword.clickOn("linktext","Shorts");
        WaitFor.waitForElementToPresent("css","ul.results-base");
        keyword.clickOn("css","ul.results-base li.product-base:first-child");
        keyword.switchToNewTab();
        WaitFor.waitForElementToPresent("css","div.pdp-add-to-bag.pdp-button");
        keyword.clickOn("css","div.pdp-add-to-bag.pdp-button");
        //Write Assertion here.
        String error = keyword.getText("css","span.size-buttons-size-error-message");
        Assert.assertEquals(error,"Please select a size");

        keyword.quitAllWindows();
    }
}
