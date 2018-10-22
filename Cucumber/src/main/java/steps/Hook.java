package steps;

import java.io.IOException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import wdMethods.SeMethods;

public class Hook extends SeMethods {
	
	@Before
	public void before(Scenario sc) throws IOException {
		
		startResult();
		startTestModule(sc.getId(),sc.getName());
		test = suite.createNode("Leads");
		test.assignCategory("smoke");
		test.assignAuthor("Ganesh");
		startApp("chrome","http://leaftaps.com/opentaps");
		
		
	}
	
	@After
	public void after() {
		closeAllBrowsers();
		endResult();
		
	}
}
