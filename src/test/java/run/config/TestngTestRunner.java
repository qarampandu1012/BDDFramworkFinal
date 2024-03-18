package run.config;

import io.cucumber.testng.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(

		features = "C:\\Users\\veera\\OneDrive\\Desktop\\8AM AUTOMATION\\8am workspace\\BDDFramwork8Am\\src\\test\\java\\Features", glue = "StepDefinations", dryRun = false,

		plugin = { "pretty", "summary",

				"html:TestReport/CucumberReportHtml/Report.html" },

		//tags = "@sanity" 
		tags="@Regresion"
)

public class TestngTestRunner extends AbstractTestNGCucumberTests {

	
	
	
	
	
}
