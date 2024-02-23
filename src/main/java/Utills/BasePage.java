package Utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasePage {
	public static WebDriver driver;

	String ChromeDriverPath = System.getProperty("user.dir") + "/BrowserDrivers/chromedriver.exe";
	String EdgeDriverPath = System.getProperty("user.dir") + "/BrowserDrivers/msedgedriver.exe";
	String appCongigFilPath = System.getProperty("user.dir") + "/PropertiesFile/appConfig.properties";
	FileInputStream fi;
	Properties prop;

	public void invokeBrowser() throws IOException {

		fi = new FileInputStream(appCongigFilPath);
		prop = new Properties();
		prop.load(fi);

		String driverFlag = prop.getProperty("Browser");
		String URL = prop.getProperty("URL");
		String chromeDriverPath = prop.getProperty("chromeDriverValue");
		String edgeDriverPath = prop.getProperty("edhgeDriverValue");

		switch (driverFlag) {

		case "Chrome":
			ChromeOptions options = new ChromeOptions();
			System.setProperty(chromeDriverPath, ChromeDriverPath);
			options.addArguments("incognito");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			driver.get(URL);

			break;

		case "Edge":

			System.setProperty(edgeDriverPath, EdgeDriverPath);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get(URL);
			break;

		default:

			System.out.println("No Browser Value For Driver Flag");
			break;

		}

	}

	public void closeBrowser() {
		driver.quit();
	}

}
