package pageObjects;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestGrid {
	static WebDriver driver;
	static String nodeUrl;
	public static void main() {
		try {
		nodeUrl ="http://192.168.1.3:4444/wd/hub";
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WINDOWS);
		
			driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		

	}

}
