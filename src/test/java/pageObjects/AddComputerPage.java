package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

public class AddComputerPage extends BasePage {

	public static By addAComputerHeading = By.xpath("//h1[text()='Add a computer']");
	public static By computerName = By.id("name");
	public static By introduced = By.id("introduced");
	public static By discontinued = By.id("discontinued");
	public static By company = By.id("company");
	public static By cancel = By.xpath("//a[text()='Cancel']");
	public static By createThisComputer = By.cssSelector(".btn.primary");
	public static By errorMsg = By.cssSelector(".clearfix.error span");

	public boolean verifyFieldsOnHomePage() {
		return (elementIsDisplayed(addAComputerHeading) && elementIsDisplayed(computerName)
				&& elementIsDisplayed(introduced) && elementIsDisplayed(discontinued) && elementIsDisplayed(company)
				&& elementIsDisplayed(cancel) && elementIsDisplayed(createThisComputer));
	}

	public void selectCreateThisComputerBtn() {
		clickOnElement(createThisComputer);
	}

	public String getErrorMsg() {
		return getMessage(errorMsg);
	}

	public String getColorOfErrorMsg() {
		return Color.fromString(returnCssValue(errorMsg, "color")).asHex();
	}
	
	public void enterValidComputerNameAndInvalidIntroDate() {
		getElement(computerName).sendKeys("Pooja");
		getElement(introduced).sendKeys("06-12-2022");
	}

}