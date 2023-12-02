package waits;

import errors.InvalidSelectorException;
import keywords.Keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WaitFor {

    private static FluentWait wait = null;
    static {
        wait = new FluentWait<WebDriver>(Keyword.getDriver());
        wait.pollingEvery(Duration.ofMillis(500));
        wait.withTimeout(Duration.ofSeconds(20));
        wait.ignoring(NoSuchElementException.class);
    }

    public static void waitForElementToPresent(String locatorType , String locator ){
        WebElement element = null;
        if(locatorType.equalsIgnoreCase("id")){
            element = Keyword.getDriver().findElement(By.id(locator));
        } else if(locatorType.equalsIgnoreCase("css")){
            element = Keyword.getDriver().findElement(By.cssSelector(locator));
        } else if(locatorType.equalsIgnoreCase("xpath")){
            element = Keyword.getDriver().findElement(By.xpath(locator));
        } else if(locatorType.equalsIgnoreCase("name")){
            element = Keyword.getDriver().findElement(By.name(locator));
        } else if(locatorType.equalsIgnoreCase("class")){
            element = Keyword.getDriver().findElement(By.className(locator));
        } else if(locatorType.equalsIgnoreCase("tagname")){
            element = Keyword.getDriver().findElement(By.tagName(locator));
        } else if(locatorType.equalsIgnoreCase("linktext")){
            element = Keyword.getDriver().findElement(By.linkText(locator));
        } else if(locatorType.equalsIgnoreCase("partiallinktext")){
            element = Keyword.getDriver().findElement(By.partialLinkText(locator));
        } else {
            throw new InvalidSelectorException(locatorType);
        }
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(String locatorType, String locator) {
        WebElement element = null;
        if(locatorType.equalsIgnoreCase("id")){
            element = Keyword.getDriver().findElement(By.id(locator));
        } else if(locatorType.equalsIgnoreCase("css")){
            element = Keyword.getDriver().findElement(By.cssSelector(locator));
        } else if(locatorType.equalsIgnoreCase("xpath")){
            element = Keyword.getDriver().findElement(By.xpath(locator));
        } else if(locatorType.equalsIgnoreCase("name")){
            element = Keyword.getDriver().findElement(By.name(locator));
        } else if(locatorType.equalsIgnoreCase("class")){
            element = Keyword.getDriver().findElement(By.className(locator));
        } else if(locatorType.equalsIgnoreCase("tagname")){
            element = Keyword.getDriver().findElement(By.tagName(locator));
        } else if(locatorType.equalsIgnoreCase("linktext")){
            element = Keyword.getDriver().findElement(By.linkText(locator));
        } else if(locatorType.equalsIgnoreCase("partiallinktext")){
            element = Keyword.getDriver().findElement(By.partialLinkText(locator));
        } else {
            throw new InvalidSelectorException(locatorType);
        }
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToPresent(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToContainText(WebElement cart,String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(cart,text));
    }
}
