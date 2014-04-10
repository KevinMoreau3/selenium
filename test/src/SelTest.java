

import com.thoughtworks.selenium.*;
import com.thoughtworks.selenium.webdriven.commands.IsTextPresent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.lift.find.Finder;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import static org.junit.Assert.*;


import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class SelTest {
	private Selenium selenium =null;
	private static WebDriver driver;
	private WebElement element=null;
	private Finder find;
	
	@Before
	public void setUp() throws Exception {
		
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/jcms");
		selenium.start();

		
	}


	public void testPageLogin() throws Exception {
		selenium.open("http://localhost:8080/jcms");
		//selenium.waitForPageToLoad("30000");
		assertEquals("m@cci - Identification", selenium.getTitle());
		assertTrue(selenium.isElementPresent("name=JCMS_opLogin"));
	}
	


public void testLogin() throws Exception {
	selenium.type("name=JCMS_login", "admin");
	selenium.type("name=JCMS_password", "admin");
	selenium.click("name=JCMS_opLogin");
	//assertEquals("m@cci - CCI - Portail JSP Collection > Accueil", selenium.getTitle());
	verifyEquals("m@cci - CCI - Portail JSP Collection > Accueil", selenium.getTitle());
}
public void testGabaritEmploi() throws Exception {
	
	// selenium.open("http://localhost:8080/jcms/jcms/j_6/fr/accueil");
	 System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	 selenium.click("link=RESPONSABLE");
	 //selenium.click("link=UN RESPONSABLE PÔLE FORMATION CONTINU -CEL & CHARGÉ(E) DU DEVELOPPEMENT COMMERCIAL DU PÔLE)"); 

}

   

private boolean verifyEquals(String string, String title) {
	// TODO Auto-generated method stub
	if (string == title){
		return true;		
}
	return false;
}
@Test 
public void SuiteTest() throws Exception
{
	
	testPageLogin();
	testLogin();
	testGabaritEmploi();
}
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}

}

