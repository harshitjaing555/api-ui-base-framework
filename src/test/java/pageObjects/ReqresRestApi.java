package pageObjects;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.PropFileHandler;

public class ReqresRestApi extends BasePage {
	static PropFileHandler propFileHandler = new PropFileHandler();
	static JSONObject request = new JSONObject();
	public static String REQRES_API_BASE_URL = propFileHandler.readProperty("reqresApiUrl").toString();
	@Test
	public static Response post(String uri,String name,String job)
	{
		request.put("name",name);
		request.put("job",job);

		return	response = RestAssured.given().
				body(request).
				when().
				post(REQRES_API_BASE_URL+uri);
	}
	@Test
	public static Response put(String uri,String name,String job)
	{

		request.put("name",name);
		request.put("job",job);

		return response = RestAssured.given().
		body(request).
		when().
		put(REQRES_API_BASE_URL+uri);
	
	}

	@Test
	public static Response patch(String uri,String name,String job)
	{
		request.put("name",name);
		request.put("job",job);

		return response = RestAssured.given().
		body(request).
		when().
		put(REQRES_API_BASE_URL+uri);
		
	}
	@Test
	public static Response delete(String uri)
	{
		return response = RestAssured.given().
		when().
		delete(REQRES_API_BASE_URL+uri);
	}

}
