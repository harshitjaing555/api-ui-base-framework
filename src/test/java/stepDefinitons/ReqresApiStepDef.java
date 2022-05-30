package stepDefinitons;

import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.ReqresRestApi;

public class ReqresApiStepDef extends BasePage {

	@When("User hits the post request using end point {string} with {string} and {string}")
	public void post_request(String uri,String name ,String job)
	{
	 response = ReqresRestApi.post(uri,name,job);
	}

	@When("User hits the put request using end point {string} with {string} and {string}")
	public void put_request(String uri,String name ,String job)
	{
		response = ReqresRestApi.put(uri,name,job);
	}

	@When("User hits the patch request using end point {string} with {string} and {string}")
	public void patch_request(String uri,String name ,String job)
	{
		response = ReqresRestApi.patch(uri,name,job);
	}

	@When("User hits the delete request using end point {string}")
	public void delete_request(String uri)
	{
		response = ReqresRestApi.delete(uri);
	}

}
