package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	public WebDriver driver;
	public String productName;
	public LandingPage landingpage;
	TestContextSetup testcontextsetup;

	public LandingPageStepDefinition(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
		landingpage = testcontextsetup.pageObjectmanager.getlandingPage();
	}

	@Given("user enter {string} text into {string}")
	public void user_enter_text_into(String value, String path) {
		landingpage.textBox(path).clear();
		landingpage.textBox(path).sendKeys(value);
	}

	@When("user click on {string}")
	public void user_click_on_something(String object) throws InterruptedException {
		landingpage.clickable(object).click();
	}

	@When("user click on {string} button")
	public void user_click_on_button(String object) throws InterruptedException {
		landingpage.button(object).sendKeys(Keys.ENTER);
	}
	@Given("user enter random {int} char into {string}")
	public void user_enter_random_char_into(int num, String path) {
		String value=testcontextsetup.genericUtils.randomNumber(num);
		landingpage.textBox(path).clear();
		landingpage.textBox(path).sendKeys(value);
	}
	  @And("user click on {string} from section {string}")
	    public void user_click_on_something_from_section_something(String submenu, String menu) throws Throwable {
		  landingpage.clickWithSection(submenu, menu).click();
	    }
	  @When("user click on {string} color")
		public void user_click_on_color(String color) throws InterruptedException {
			landingpage.Colorclick(color).click();
		}
}
