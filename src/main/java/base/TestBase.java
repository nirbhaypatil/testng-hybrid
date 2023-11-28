package base;

import Keywords.Keyword;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    Keyword keyword = new Keyword();

    @BeforeTest
    public void setUp() throws Exception{

        keyword.openBrowser("Chrome");
        keyword.maximizeBrowser();
        keyword.openUrl("https://www.myntra.com/");
    }

    @AfterTest
    public void tearDown(){
        keyword.quitAllWindows();
    }
}
