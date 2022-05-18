package stepDefinitons;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddComputerPage;
import pageObjects.BasePage;
import pageObjects.EditComputerPage;
import pageObjects.HomePage;

public class UiStepDef {

	BasePage basePage = new BasePage();
	HomePage homePage = new HomePage();
	EditComputerPage editComputerPage = new EditComputerPage();
	AddComputerPage addComputerPage = new AddComputerPage();

	@Given("user is on computer database home page")
	public void user_is_on_computer_database_home_page() {
		basePage.launchApplication();
	}

	@When("user selects any computer from computer name list")
	public void user_selects_any_computer_from_computer_name_list() {
		homePage.selectComputer();
	}

	@Then("user lands on Edit computer page")
	public void user_lands_on_edit_computer_page() {
		Assert.assertTrue("Use is not present on Edit Computer page",
				editComputerPage.verifyUserIsOnEditComputerPage());
	}

	@When("user click on delete this computer button")
	public void user_click_on_delete_this_computer_button() {
		editComputerPage.clickOnDeleteButton();
	}

	@Then("following message should be displayed")
	public void following_message_should_be_displayed(String docString) {
		Assert.assertEquals("Computer Deleted Message doesn't match", docString, homePage.getComputerIsDeletedMsg());
	}

	@When("user tries to filter the deleted computer name")
	public void user_tries_to_filter_the_deleted_computer_name() {
		homePage.userSearchForDeletedComputer();
	}

	@Then("following page heading should be displayed")
	public void following_page_heading_should_be_displayed(String docString) {
		Assert.assertEquals("Computer is not successfully deleted", docString, homePage.getPageHeader());
	}

	@When("user clicks on Add a new computer button")
	public void user_clicks_on_add_a_new_computer_button() {
		homePage.selectAddANewComputerBtn();
	}

	@Then("user verifies fields, buttons present on home page")
	public void user_verifies_fields_buttons_present_on_home_page() {
		Assert.assertTrue("Few fields are not appearing on Home Page", homePage.verifyFieldsOnHomePage());
	}

	@Then("user verifies fields, buttons present on add a computer page")
	public void user_verifies_fields_buttons_present_on_add_a_computer_page() {
		Assert.assertTrue("Few fields are not appearing on Add a computer Page",
				addComputerPage.verifyFieldsOnHomePage());
	}

	@When("user clicks on Create this computer button")
	public void user_clicks_on_create_this_computer_button() {
		addComputerPage.selectCreateThisComputerBtn();
	}
	
	@When("user enters computer name and invalid introduction date")
	public void user_enters_computer_name_and_invalid_introduction_date() {
		addComputerPage.enterValidComputerNameAndInvalidIntroDate();
	}

	@Then("following error message should be displayed")
	public void following_error_message_should_be_displayed(String errorMsg) {
		Assert.assertEquals("Error message is not displayed", errorMsg, addComputerPage.getErrorMsg());
	}

	@Then("Error message should be in red color")
	public void error_message_should_be_in_red_color() {
		Assert.assertEquals("Error message is not displayed in red background color", "#9d261d",
				addComputerPage.getColorOfErrorMsg());
	}
}
