package run.config;

import org.junit.runner.RunWith;

import io.cucumber.core.backend.CucumberBackendException;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "C:\\Users\\veera\\OneDrive\\Desktop\\8AM AUTOMATION\\8am workspace\\BDDFramwork8Am\\src\\test\\java\\Features", glue = "StepDefinations", dryRun = false,

		plugin = { "pretty", "summary",

				"html:TestReport/CucumberReportHtml/Report.html" },

		//tags = "@sanity" 
		tags="@Regresion"
)
public class JunitTestRunner {
	

}
