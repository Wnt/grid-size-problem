package myapplication;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.CssLayoutElement;

public class MyTest extends TestBenchTestCase {

	public static final String baseUrl = "http://localhost:8080/";

	@Before
	public void setUp() throws Exception {

		// Create a new Selenium driver - it is automatically extended to work
		// with TestBench
		// PHANTOMJS_EXECUTABLE_PATH_PROPERTY
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.phantomjs();
		desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/home/jonni/Documents/Kemira/phantomjs-2.0.0/bin/phantomjs");
		setDriver(new PhantomJSDriver(desiredCapabilities));

		// Open the test application URL with the ?restartApplication URL
		// parameter to ensure Vaadin provides us with a fresh UI instance.
		getDriver().get(baseUrl + "?restartApplication");

		// If you deploy using WTP in Eclipse, this will fail. You should
		// update baseUrl to point to where the app is deployed.
		String pageSource = getDriver().getPageSource();
		String errorMsg = "Application is not available at " + baseUrl + ". Server not started?";
		 assertFalse(errorMsg, pageSource.contains("HTTP Status 404")
		 || pageSource.contains("can't establish a connection to the server"));
	}

	@Test
	public void testOnePlusTwo() throws Exception {

		ButtonElement tButton = $(ButtonElement.class).caption("T").first();
		tButton.click();

		// Verify the expected result
		CssLayoutElement cssLayout1 = $$(CssLayoutElement.class).first();
		String attribute = cssLayout1.getAttribute("class");
		
		assertTrue(attribute.contains("nav-expanded"));
		
	}
    @After
    public void tearDown() throws Exception {

        // Calling quit() on the driver closes the test browser.
        // When called like this, the browser is immediately closed on _any_
        // error. If you wish to take a screenshot of the browser at the time
        // the error occurred, you'll need to add the ScreenshotOnFailureRule
        // to your test and remove this call to quit().
        getDriver().quit();
}
}
