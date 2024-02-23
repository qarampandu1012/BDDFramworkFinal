package StepDefinations;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.Scenario;
import Utills.AppUtills;
import Utills.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hooks extends BasePage {

	AppUtills appUtills = new AppUtills();

	@Before
	public void invoke() throws IOException {
		invokeBrowser();
	}

	@AfterStep
	public void takeScreenShot(Scenario scenario) throws IOException {

		String testcasesName = scenario.getName().replaceAll(" ", "_");
		byte[] surce = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(surce, "image/.png", testcasesName);

	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			appUtills.getScreenShotForFailed(scenario.getName());
		} else {
			appUtills.getScreenShotForSuccess(scenario.getName());
		}
		closeBrowser();
	}

}
