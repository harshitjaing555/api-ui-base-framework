package stepDefinitons;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.BasePage;

public class HooksStepDef {
	
	@Before("@UI")
	public void before()
	{

		BasePage.initializeBrowser();
	}

	@After("@UI")
	public void after(Scenario scenario) {
		if(scenario.isFailed()) {
			final byte[] screenshot = BasePage.takeScreenshot();
		    scenario.attach(screenshot, "image/png",scenario.getName().replace(" ","")+".png");
		} 
		BasePage.closeSession();
	}

	
}
