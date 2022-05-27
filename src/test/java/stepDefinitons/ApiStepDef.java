package stepDefinitons;

import org.json.JSONObject;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pageObjects.BasePage;

public class ApiStepDef {
	Response response;
	JSONObject jsonObject;
	BasePage basePage = new BasePage();

	@When("User hits the application url")
	public void user_hits_get_request() {
		response = basePage.getRequest();
	}

	@When("User hits the get api using end point {string}")
	public void user_hits_get_request(String uri) {
		response = basePage.getRequest(uri);
	}
	@When("User hits the get api with parameter {string} {string}")
	public void user_hits_get_request_with_parameters(String uri, String parameter) {
		String args = uri.toString()+parameter.toString();
		response = basePage.getRequest(args);
	}

	@When("User hits the delete api using end point {string}")
	public void user_hits_delete_request(String uri) {
		response = basePage.postRequest(uri);
	}

	@Then("User validate response code as {int}")
	public void user_validate_response_code_as(int code) {
		Assert.assertEquals("The response code is not " + code + ". It is >> " + response.getStatusCode(), code,
				response.getStatusCode());
	}

	@Then("Response body should contain {string}")
	public void user_validate_response_code_as(CharSequence text) {
		Assert.assertTrue("The response body doesn't contains >> " + text,
				response.getBody().asString().contains(text));
	}

	@Given("User have a payload for adding new computer")
	public void user_have_a_payload_for_adding_new_computer() {
		jsonObject = new JSONObject();
		jsonObject.put("name", "pooja");
		jsonObject.put("introduced", "2021-06-13");
		jsonObject.put("discontinued", "2021-06-14");
		jsonObject.put("company", "1");
	}

	@Given("User have invalid format of dates in payload for adding new computer")
	public void User_have_invalid_format_of_dates_in_payload_for_adding_new_computer() {
		jsonObject = new JSONObject();
		jsonObject.put("name", "pooja");
		jsonObject.put("introduced", "20-06-2022");
		jsonObject.put("discontinued", "06-20-2010");
		jsonObject.put("company", "1");
	}

	@When("User hits the post api request")
	public void user_hits_the_post_api_request() {
		response = basePage.postRequest(jsonObject);
	}

	@When("user hits the post api call to add new computer with empty payload")
	public void user_hits_the_post_api_call_to_add_new_computer_with_empty_payload() {
		jsonObject = new JSONObject();
		response = basePage.postRequest(jsonObject);
	}


}
