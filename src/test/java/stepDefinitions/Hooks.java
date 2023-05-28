package stepDefinitions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	public TestContextSetup testcontextsetup;

	public Hooks(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
	}

	// Below method is used for deleting old Report files
	@BeforeAll
	public static void clearOldFiles() throws IOException {

		File file = new File(System.getProperty("user.dir") + "/test-output/Reports");
		FileUtils.deleteDirectory(file);
		file.delete();
	}

	@After
	public void afterScenario() throws IOException {
		testcontextsetup.testBase.WebDriverManager().quit();
	}

	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException {
		WebDriver driver = testcontextsetup.testBase.WebDriverManager();
		File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "testimage");
	}
}
