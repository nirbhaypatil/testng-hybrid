package base;

import errors.InvalidBrowserError;
import keywords.Keyword;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Scanner;

public class TestBase {

    Keyword keyword = new Keyword();

    @BeforeMethod
    public void setUp() throws InvalidBrowserError {

        keyword.openBrowser(Config.getBrowserName());
        keyword.maximizeBrowser();
        keyword.openUrl(Config.getAppUrl("uat"));
    }

    @AfterMethod
    public void tearDown(){
        keyword.quitAllWindows();
    }
}
