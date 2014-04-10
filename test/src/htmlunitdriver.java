import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class htmlunitdriver {
     private WebDriver driver;
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }
    public void testSelenium() throws Exception {
        driver.get("http://google.fr");
         
    }
        @SuppressWarnings("deprecation")
        @Test
        public void htmlUnitTest() throws Exception {
            driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_6);
            testSelenium();
        }
}