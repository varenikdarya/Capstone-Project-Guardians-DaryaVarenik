package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String category) {
		selectByVisibleText(factory.retailOrderPage().allDepartmentDropdown, category);
		logger.info("The Category was selected successfully");

	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String kasaOutdoorSmartPlug) {
		sendText(factory.retailOrderPage().searchInputField, kasaOutdoorSmartPlug);
		logger.info("The Item name was entered successfully");

	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.retailOrderPage().searchBttn);
		logger.info("The Search button was clicked successfully");

	}

	@When("User click on item")
	public void userClickOnItem() {
		click(factory.retailOrderPage().itemkasaoutdoorsmartplug);
		logger.info("The Item was clicked successfully");

	}

	@When("User select quantity {string}")
	public void userSelectQuantity(String itemQty) {
		selectByVisibleText(factory.retailOrderPage().qtyDropdown, itemQty);
		logger.info("The Item quantity was selected succcessfully");

	}

	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.retailOrderPage().addToCartBttn);
		logger.info("The Add item to the cart button was clicked successfully");

	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String itemQtyInTheCart) {
		Assert.assertEquals(itemQtyInTheCart, factory.retailOrderPage().cartItemQty.getText());
		logger.info("The Item qty in the cart was validated successfully");
	}

	@Then("the cart should be emty")
	public void theCartShouldBeEmty() throws InterruptedException {
		click(factory.retailOrderPage().cartBttn);
		List<WebElement> deleteBttns = factory.retailOrderPage().deleteAllFromCart;

		for (WebElement deleteBttn : deleteBttns) {
			click(deleteBttn);
		}
		Thread.sleep(2000);
		logger.info("The items deleted from shopping cart successfully");
	}

	// add item to the cart and place order

	@Then("User change the category to {string} Apex Legends")
	public void userChangeTheCategoryToApexLegends(String electronics) {
		selectByVisibleText(factory.retailOrderPage().allDepartmentDropdown, electronics);
		logger.info("Category changed to electronics successfully");
	}

	@Then("User search for an item {string} Apex Legends")
	public void userSearchForAnItemApexLegends(String apexLegends) {
		sendText(factory.retailOrderPage().searchInputField, apexLegends);
		logger.info("Item name was entered successfully");
	}

	@Then("User click on item Apex Legends")
	public void userClickOnItemApexLegends() {
		click(factory.retailOrderPage().apexLegendsItem);
		logger.info("Item Apex Legends was clicked successfully");
	}

	@When("User select quantity {string} Apex Legends")
	public void userSelectQuantityApexLegends(String apexLegendsQty) {
		selectByVisibleText(factory.retailOrderPage().qtyDropdown, apexLegendsQty);
		logger.info("Apex Legends qty was changed successfully");
	}

	@Then("the cart icon quantity should change to {string} Apex Legends")
	public void theCartIconQuantityShouldChangeToApexLegends(String itemQtyInTheCart) {
		Assert.assertEquals(itemQtyInTheCart, factory.retailOrderPage().cartItemQty.getText());
		logger.info("Item qty in the cart was validated successfully");
	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.retailOrderPage().cartBttn);
		logger.info("Cart Button was clicked successfully");
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.retailOrderPage().proceedToCheckoutBttn);
		logger.info("Proceed to check out button was clicked successfully");
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.retailOrderPage().placeOrderBttn);
		logger.info("Place your order button was clicked successfully");
	}

	@Then("a confirmation message should be displayed {string}")
	public void aConfirmationMessageShouldBeDisplayed(String confirmationMessage) {
		waitTillPresence(factory.retailOrderPage().orderPlacedSuccessMssg);
		Assert.assertEquals(confirmationMessage, factory.retailOrderPage().orderPlacedSuccessMssg.getText());
		logger.info("Cancelation success message was verified successfully");
	}

	// Cancel order

	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.retailOrderPage().orderLink);
		logger.info("The Order link was clicked successfully");
	}

	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		List<WebElement> listOfOrder = factory.retailOrderPage().listOfOrders;
		for (int i = 0; i < listOfOrder.size(); i++) {
			if (listOfOrder.get(i).getText().equalsIgnoreCase("Hide Details")) {

			} else if (listOfOrder.get(i).getText().equalsIgnoreCase("Show Details")) {
				click(factory.retailOrderPage().listOfOrders.get(i));
			}
		}
		logger.info("The First order in the list was clicked successfully");
	}

	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		List<WebElement> cancelBttns = factory.retailOrderPage().cancelOrderBttn;
		click(cancelBttns.get(0));
		logger.info("The Order Cancel button was clicked ");
	}

	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String cancelationReason) {
		selectByVisibleText(factory.retailOrderPage().reasonForCancelation, cancelationReason);
		logger.info("The Cancelation reason was selected successfully");
	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.retailOrderPage().cancelationSubmitBttn);
		logger.info("The Cancel Submit Button was clicked successfully");
	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String CancelationSuccessMssg) {
		Assert.assertEquals(CancelationSuccessMssg, factory.retailOrderPage().orderCancelledSuccessMssg.getText());
		logger.info("The Cancelation message was verified successfully");
	}

	// return order

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(factory.retailOrderPage().returnItemsBtn);
		logger.info("The Order Return button was clicked successfully");

	}

	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String reason) {
		selectByVisibleText(factory.retailOrderPage().reasonOfReturnInput, reason);
		logger.info("The return reason was selected successfully");
	}

	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String dropOff) {
		selectByVisibleText(factory.retailOrderPage().dropOffInput, dropOff);
		logger.info("The drop off service was selected successfully");
	}

	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.retailOrderPage().orderReturnAndSubmitBtn);
		logger.info("The ruturn order submission button was clicked successfully");
	}

	@Then("the returning message should be displayed {string}")
	public void theReturningMessageShouldBeDisplayed(String returnMessage) {
		waitTillPresence(factory.retailOrderPage().orderReturnedSuccessMssg);
		Assert.assertEquals(returnMessage, factory.retailOrderPage().orderReturnedSuccessMssg.getText());
		logger.info("The Returning message was verified successfully");
	}

	// review order

	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.retailOrderPage().reviewBttn);
		logger.info("The Review button was clicked successfully");
	}

	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headline, String written) {
		sendText(factory.retailOrderPage().headlineInputField, headline);
		sendText(factory.retailOrderPage().commentField, written);
		logger.info("The headline and written added successfully");
	}

	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.retailOrderPage().reviewSubmitBtn);
		logger.info("The Review button was clicked successfully");
	}

	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String reviewMessage) {
		waitTillPresence(factory.retailOrderPage().reviewSuccessMssg);
		Assert.assertEquals(reviewMessage, factory.retailOrderPage().reviewSuccessMssg.getText());
		logger.info("The Review message was verified successfully");
	}

}