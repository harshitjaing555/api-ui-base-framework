package pageObjects;

import org.openqa.selenium.By;

public class EditComputerPage extends BasePage {

	public static By editComputer = By.xpath("//h1[text()='Edit computer']");
	public static By deleteThisComputer = By.cssSelector("[value='Delete this computer']");

	public void clickOnDeleteButton() {
		clickOnElement(deleteThisComputer);
	}

	public boolean verifyUserIsOnEditComputerPage() {
		return elementIsDisplayed(editComputer);
	}

}