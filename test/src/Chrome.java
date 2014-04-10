import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Chrome {
WebDriver driver ;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\k.moreau\\Downloads\\IEDriverServer_x64_2.41.0\\IEDriverServer.exe");

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		driver = new InternetExplorerDriver();
		driver.get("http://google.fr");
		
	}

}
