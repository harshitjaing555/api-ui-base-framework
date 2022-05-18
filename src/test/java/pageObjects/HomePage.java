package pageObjects;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

	public static By computerName = By.cssSelector("[href='/computers/355']");
	public static By deletedMessage = By.cssSelector("[class='alert-message warning']");
	public static By searchFilter = By.cssSelector("#searchbox");
	public static By submitSearchFilter = By.id("searchsubmit");
	public static By pageHeader = By.cssSelector("section>h1");
	public static By addANewComputer = By.id("add");
	public static By nextPagination = By.cssSelector("#pagination .next");

	public void selectComputer() {
		clickOnElement(computerName);
	}

	public String getComputerIsDeletedMsg() {
		return getMessage(deletedMessage);
	}

	public void userSearchForDeletedComputer() {
		getElement(searchFilter).sendKeys("ARRA");
		clickOnElement(submitSearchFilter);
	}

	public String getPageHeader() {
		return getMessage(pageHeader);
	}

	public boolean verifyFieldsOnHomePage() {
		return (elementIsDisplayed(searchFilter) && elementIsDisplayed(submitSearchFilter)
				&& elementIsDisplayed(addANewComputer) && elementIsDisplayed(nextPagination));
	}

	public void selectAddANewComputerBtn() {
		clickOnElement(addANewComputer);
	}

}
