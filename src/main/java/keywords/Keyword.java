package keywords;

import errors.InvalidBrowserError;
import errors.InvalidSelectorException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Keyword {

    private static RemoteWebDriver driver = null;


    /**
     * This method return driver instance
     *  Make sure before calling this method one should call
     * {@code openBrowser(String browseName)} so that driver instance get initiated.
     */
    public static RemoteWebDriver getDriver(){
        return driver;
    }

    public void openBrowser(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        else{
            System.out.println("Invalid browser name");
            throw new InvalidBrowserError(browserName);
        }

    }

    /**
     * Launches url
     * @param url String
     */
    public  void openUrl(String url){
        driver.get(url);
        System.out.println("Launching url");
    }

    /**
     * This method searches element in page with
     * locatorType and locator
     *
     * @param locatorType String
     * @param locator String
     * @return WebElement
     */
    public WebElement getElement(String locatorType,String locator){
        if(locatorType.equalsIgnoreCase("id")){
            return driver.findElement(By.id(locator));
        } else if(locatorType.equalsIgnoreCase("css")){
            return driver.findElement(By.cssSelector(locator));
        } else if(locatorType.equalsIgnoreCase("xpath")){
            return driver.findElement(By.xpath(locator));
        } else if(locatorType.equalsIgnoreCase("name")){
            return driver.findElement(By.name(locator));
        } else if(locatorType.equalsIgnoreCase("class")){
            return driver.findElement(By.className(locator));
        } else if(locatorType.equalsIgnoreCase("tagname")){
            return driver.findElement(By.tagName(locator));
        } else if(locatorType.equalsIgnoreCase("linktext")){
            return driver.findElement(By.linkText(locator));
        } else if(locatorType.equalsIgnoreCase("partiallinktext")){
            return driver.findElement(By.partialLinkText(locator));
        } else {
            throw new InvalidSelectorException(locatorType);
        }
    }

    public List<WebElement> getElements(String locatorType,String locator){
        if(locatorType.equalsIgnoreCase("id")){
            return driver.findElements(By.id(locator));
        } else if(locatorType.equalsIgnoreCase("css")){
            return driver.findElements(By.cssSelector(locator));
        } else if(locatorType.equalsIgnoreCase("xpath")){
            return driver.findElements(By.xpath(locator));
        } else if(locatorType.equalsIgnoreCase("name")){
            return driver.findElements(By.name(locator));
        } else if(locatorType.equalsIgnoreCase("class")){
            return driver.findElements(By.className(locator));
        } else if(locatorType.equalsIgnoreCase("tagname")){
            return driver.findElements(By.tagName(locator));
        } else if(locatorType.equalsIgnoreCase("linktext")){
            return driver.findElements(By.linkText(locator));
        } else if(locatorType.equalsIgnoreCase("partiallinktext")){
            return driver.findElements(By.partialLinkText(locator));
        } else {
            throw new InvalidSelectorException(locatorType);
        }
    }


    /**
     * Enters text in textarea of text field
     *
     * @param locatorType String
     * @param locator String
     */
    public void enterText(String locatorType, String locator,CharSequence...seq){
        getElement(locatorType,locator).sendKeys(seq);
    }

    public void clickOn(String locatorType, String locator){
        getElement(locatorType,locator).click();
    }

    /**
     * hovers over a element
     *
     * @param locatorType String
     * @param locator String
     */
    public void hoverOn(String locatorType, String locator){
        Actions action = new Actions(Keyword.getDriver());
        action.moveToElement(getElement(locatorType,locator)).perform();
    }

    public String getText(String locatorType, String locator){
        WebElement element = getElement(locatorType,locator);
        return element.getText();
    }

    public List<String> getTexts(String locatorType, String locator){

        List<String> texts = new ArrayList<>();
        List<WebElement> elements =  getElements(locatorType,locator);
        for ( WebElement element :elements ) {
           texts.add(element.getText());
        }
        return texts;
    }

    /**
     *  Close current browser
     */
    public  void closeBrowser(){
        driver.close();
    }

    /**
     * Quit all open windows
     */
    public void quitAllWindows(){
        driver.quit();
    }

    public void maximizeBrowser() {
        getDriver().manage().window().maximize();
    }

    /**
     * If a new tab is opened by click action
     * driver need to be switched to it.
     */
    public void switchToNewTab() {
        Set<String> handles = Keyword.getDriver().getWindowHandles();
        String currenthandle = Keyword.getDriver().getWindowHandle();
        for (String handle :handles
             ) {
            if(!handle.equalsIgnoreCase(currenthandle)){
                driver.switchTo().window(handle);
            }
        }
    }

    public void hoverOn(WebElement menu) {
        Actions action = new Actions(Keyword.getDriver());
        action.moveToElement(menu).perform();
    }
}
