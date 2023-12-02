package base;

import errors.InvalidBrowserError;
import keywords.Keyword;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Scanner;

public class TestBase {

    Keyword keyword = new Keyword();

    @BeforeTest
    public void setUp() throws InvalidBrowserError {

        keyword.openBrowser(Config.getBrowserName());
        keyword.maximizeBrowser();
        keyword.openUrl(Config.getAppUrl("uat"));
    }

    @AfterTest
    public void tearDown(){
        keyword.quitAllWindows();
    }
}
