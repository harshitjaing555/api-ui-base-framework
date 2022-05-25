package pageObjects;

import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropFileHandler;

public class BasePage {

	static PropFileHandler propFileHandler = new PropFileHandler();
	//	public String BASE_URL = propFileHandler.readProperty("appUrl").toString();
	//	private static String BASE_URL ="https://computer-database.gatling.io/computers";
	private static String BASE_URL ="https://fakerestapi.azurewebsites.net";

	RequestSpecification requestSpecification;
	Response response;

	public static WebDriver driver;
	public static String browser;
	public static String timeout;

	public static void initializeBrowser() {
		System.out.println("**************************************** Session Started *****************************************");
		timeout=propFileHandler.readProperty("timeOut");
		browser=propFileHandler.readProperty("browser").toUpperCase();
		if(browser.equals("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Integer.valueOf(timeout), TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

	}

	public static byte[] takeScreenshot()
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public static void closeSession()
	{
		if(driver!=null)
		{
			driver.quit();
			System.out.println("*************************************** Session Closed **************************************");
		}
	}

	public void launchApplication() {
		driver.get(BASE_URL);

	}

	public WebElement getElement(By elementToken) {
		return driver.findElement(elementToken);
	}

	public boolean elementIsDisplayed(By elementToken) {
		return getElement(elementToken).isDisplayed();
	}

	public void clickOnElement(By elementToken) {
		getElement(elementToken).click();
	}

	public String getMessage(By elementToken) {
		return getElement(elementToken).getText();
	}

	public void clickOnElementViaJS(By elementToken) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getElement(elementToken));
	}

	public String returnCssValue(By elementToken, String attribute) {
		return getElement(elementToken).getCssValue(attribute);
	}

	public Response getRequest(String uri) {
		System.out.println("Inside get request" + "URL:" + BASE_URL);
		RestAssured.baseURI = BASE_URL.toString();
		response = RestAssured.given().when().get(uri);
		return response;
	}

	public Response getRequest() {
		RestAssured.baseURI = BASE_URL;
		return RestAssured.given().when().get();
	}

	public Response postRequest(String uri) {
		RestAssured.baseURI = BASE_URL;
		return RestAssured.given().when().post(uri);
	}

	public Response postRequest(JSONObject payload) {
		RestAssured.baseURI = BASE_URL;
		return RestAssured.given().when().body(payload.toString()).post();
	}
}
