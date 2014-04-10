
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class LoginTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testLogin() throws Exception {
		selenium.open("/jcms/plugins/CCIChartePlugin/front/privateLogin.jsp?redirect=http%3A%2F%2Flocalhost%3A8080%2Fjcms%2Findex.jsp");
		selenium.type("id=anonymous_element_1", "admin");
		selenium.type("id=anonymous_element_2", "admin");
		selenium.click("id=anonymous_element_3");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
