package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	public WebDriver driver;
	public OfferPage offerPage;
	// public String productName;
	TestContextSetup testcontextsetup;
	PageObjectManager pageObjectmanager;

	public OfferPageStepDefinition(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
		offerPage = testcontextsetup.pageObjectmanager.getofferPage();
	}

	@Then("user click on {string} icon")
	public void user_click_on_icon(String value) {

		offerPage.icon(value).click();
	}

	@Then("assert {string} is displayed in section Learn more about {string}")
	public void assert_is_displayed_in_section_Learn_more_about(String name, String section) {

		String actualValue = offerPage.learnMoreAbout(section, name).getText();
		assertEquals(name, actualValue);
	}

	@When("user click on {string} dropdown")
	public void user_click_on_something(String object) throws InterruptedException {
		offerPage.select(object).click();
	}

	@Then("user search for {string} shortname in offer page to check if products exist {string}")
	public void user_search_for_shortname_in_offer_page_to_check_if_products_exist(String name, String path)
			throws InterruptedException {
		testcontextsetup.genericUtils.SwitchWindowToChild();
				Thread.sleep(3000);		
	}

	@Then("^user search for (.+) shortname in offer page to check if products exist \"([^\"]*)\" exp$")
	public void user_search_for_shortname_in_offer_page_to_check_if_products_exist_something_exp(String names,
			String path) throws Throwable {
		OfferPage offerPage = testcontextsetup.pageObjectmanager.getofferPage();
		testcontextsetup.genericUtils.SwitchWindowToChild();
	}

	@Then("user hOver on {string}")
			public void user_hOver_on(String path) {
		//testcontextsetup.genericUtils.actions(path).build().perform();
		testcontextsetup.genericUtils.actions(path);
				
			}
	@Then("user select date")
	public void user_select_date() {
//testcontextsetup.genericUtils.actions(path).build().perform();
String num=testcontextsetup.genericUtils.todayDate();
offerPage.dateSelection(num).click();
	}
}
