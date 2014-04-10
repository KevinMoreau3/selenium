import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.commands.Close;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;


public class TestChrome {

	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\k.moreau\\Downloads\\IEDriverServer_x64_2.41.0\\IEDriverServer.exe");
    }
	

	@After
	public void tearDown() throws Exception {
    
	}

	
	public void testPageLogin(WebDriver driver) throws InterruptedException {
	
		driver.get("http://www169.ratp.fr/fr/");
	//	assertEquals("m@cci - Identification", driver.getTitle());
	
		
	} 
	
	public void testLogin(WebDriver driver) 
	{
		
		driver.findElement(By.className("stdChampLogin")).sendKeys("admin");
		driver.findElement(By.className("stdChampMdp")).sendKeys("admin");
		driver.findElement(By.className("stdBtnRouge")).click();
		assertEquals("m@cci - CCI - Portail JSP Collection > Accueil", driver.getTitle());
	}
	
	public void testGabaritEmploi(WebDriver driver) throws Exception {
		
		
		 driver.findElement(By.partialLinkText("RESPONSABLE")).click();
		 assertTrue(IsElementPresent(By.className("detailOffre"), driver));
		 assertTrue(IsElementPresent(By.className("headerOffre"), driver));
		 assertTrue(IsElementPresent(By.className("introList"), driver));
		 assertTrue(IsElementPresent(By.className("contentDetail"), driver));
		 assertTrue(IsElementPresent(By.className("btnPostuler"), driver));
		 assertTrue(IsElementPresent(By.className("btnOffres"), driver));
		 
	}
	
	public void testApplication(WebDriver driver) throws Exception{
		String att= driver.findElement(By.linkText("Lien 2")).getAttribute("href");
		driver.findElement(By.linkText("Lien 2")).click();

		String parentWindow= driver.getWindowHandle();
	String act = null;
	try {

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
            act = driver.getCurrentUrl();
            act = act.replace("https", "http");
            
        }
        }catch(Exception e){
       System.out.println(e.getMessage());
        }
	assertEquals(att, act);
	driver.close();
	driver.switchTo().window(parentWindow);
	driver.findElement(By.linkText("Recherche avanc�e")).click();
		
		
	}
	
	
	private boolean IsElementPresent(By by, WebDriver driver) {
		 try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
	}

	@Test
	public void SuiteTest() throws Exception 
	{
		WebDriver driver = new ChromeDriver();
		 //WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().setSize(new Dimension(320, 480));
        testPageLogin(driver);
		/*testLogin(driver);
		testGabaritEmploi(driver);
		testApplication(driver);*/
	}

}
