package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class HomeSteps extends CommonUtility{

	POMFactory factory = new POMFactory();

	// Verify Shop by Department sidebar
	
	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.retailHomePage().allOptions);
		logger.info("The user clicked on All section button successfully"); 
		
	}
	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> shopByDepartment = dataTable.asLists(String.class);
		for(int i = 0; i < shopByDepartment.get(0).size(); i++) {
			Assert.assertTrue(isElementDisplayed(
					getDriver().findElement(By.xpath("//div[@class='sidebar__content']//span[text()='"+shopByDepartment.get(0).get(i)+"']"))));
			logger.info("Option " + shopByDepartment.get(0).get(i) + " is displayed");
		} 
		
	}
	
	//Verify department sidebar options
	@When("User on {string}")
	public void userOn(String department) {
		List<WebElement> departmens = factory.retailHomePage().sideBarOptions;
		for (int i = 0; i < departmens.size(); i++) {
			if (departmens.get(i).getText().equalsIgnoreCase(department)) {
				departmens.get(i).click();
				break;
			}
			logger.info("User is on All Department");
		}

	}
	
	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> departmentOptions = dataTable.asLists(String.class);
		List<WebElement> options = factory.retailHomePage().sidebarAllOptions;
		
		for(int i = 0; i < departmentOptions.get(0).size(); i++) {
			for(WebElement elements : options) {
				if(elements.getText().equalsIgnoreCase(departmentOptions.get(0).get(i))) {
					Assert.assertTrue(elements.isDisplayed());
					logger.info("The option " + elements.getText() + " is present");;
				}
			}
		}
		
	}
}
