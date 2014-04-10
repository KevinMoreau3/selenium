

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class remotecontrol {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://www.google.fr/");
		selenium.start();
	}

	@Test
	public void testRemotecontrol() throws Exception {
		selenium.open("www.google.fr");
		selenium.click("css=em");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=searchInput", "selenium");
		selenium.click("id=searchButton");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
