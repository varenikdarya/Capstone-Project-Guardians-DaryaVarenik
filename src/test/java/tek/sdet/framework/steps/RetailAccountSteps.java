package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGenerator;

public class RetailAccountSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	// update PI

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.retailAccountPage().accountBttn);
		logger.info("Account button was clicked successfully");

	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phone) {
		factory.retailAccountPage().nameInputField.clear();
		sendText(factory.retailAccountPage().nameInputField, DataGenerator.addressGenerator(name));
		logger.info("Name was entered successfully");
		factory.retailAccountPage().phoneInputField.clear();
		sendText(factory.retailAccountPage().phoneInputField, DataGenerator.addressGenerator(phone));
		logger.info("User name and Phone number are entered successfully");

	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.retailAccountPage().accountUpdtBttn);
		logger.info("The ypdate button was clicked successfully");

	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.retailAccountPage().PIupdateMsg);
		Assert.assertTrue(factory.retailAccountPage().PIupdateMsg.isDisplayed());
		logger.info("Account information was updated successfully");

	}

	// add payment method

	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.retailAccountPage().addPaymentlink);
		logger.info("Add Payment link was clicked successfully");

	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> paymentCardInf = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < paymentCardInf.size(); i++) {
			sendText(factory.retailAccountPage().cardNumberField,
					DataGenerator.addressGenerator(paymentCardInf.get(0).get("cardNumber")));
			sendText(factory.retailAccountPage().nameOnCardField,
					DataGenerator.addressGenerator(paymentCardInf.get(0).get("nameOnCard")));
			sendText(factory.retailAccountPage().expMonthInput, paymentCardInf.get(0).get("expirationMonth"));
			sendText(factory.retailAccountPage().expYearInput, paymentCardInf.get(0).get("expirationYear"));
			sendText(factory.retailAccountPage().securityCodeInput, paymentCardInf.get(0).get("securityCode"));
		}

		logger.info("The Card information was filled successfully");

	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.retailAccountPage().paymentSubmitBttn);
		logger.info("The Add card button was clicked successfully");
	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMessage) {
		if (expectedMessage.contains("Payment Method added")) {
			waitTillPresence(factory.retailAccountPage().paymentAddedMssg);
			Assert.assertEquals(expectedMessage, factory.retailAccountPage().paymentAddedMssg.getText());
			logger.info("Expected Message: " + expectedMessage);
		} else if (expectedMessage.contains("Address Added")) {
			waitTillPresence(factory.retailAccountPage().addressSuccessMssg);
			Assert.assertEquals(expectedMessage, factory.retailAccountPage().addressSuccessMssg.getText());
			logger.info("Expected Message: " + expectedMessage);
		} else if (expectedMessage.contains("Address Updated")) {
			waitTillPresence(factory.retailAccountPage().addressUpdatedSuccessMssg);
			Assert.assertEquals(expectedMessage, factory.retailAccountPage().addressUpdatedSuccessMssg.getText());
			logger.info("Expected Message: " + expectedMessage);
		}
	}
	// edit Debit/Credit card information

	@And("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.retailAccountPage().selectCard);
		click(factory.retailAccountPage().editCardBttn);
		logger.info("The Payment edit button was clicked successfully");
	}

	@And("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < cardInfo.size(); i++) {
			factory.retailAccountPage().cardNumberField.clear();
			sendText(factory.retailAccountPage().cardNumberField,
					DataGenerator.addressGenerator(cardInfo.get(0).get("cardNumber")));
			factory.retailAccountPage().nameOnCardField.clear();
			sendText(factory.retailAccountPage().nameOnCardField,
					DataGenerator.addressGenerator(cardInfo.get(0).get("nameOnCard")));
			sendText(factory.retailAccountPage().expMonthInput, cardInfo.get(0).get("expirationMonth"));
			sendText(factory.retailAccountPage().expYearInput, cardInfo.get(0).get("expirationYear"));
			factory.retailAccountPage().securityCodeInput.clear();
			sendText(factory.retailAccountPage().securityCodeInput, cardInfo.get(0).get("securityCode"));
		}

		logger.info("The Payment information was edited");
	}

	@And("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.retailAccountPage().updatePaymentBttn);
		logger.info("The Update payment button clicked successfully");
	}

	@Then("update message should be displayed {string}")
	public void UpdateMessageShouldBeDisplayed(String expectMessage) {
		waitTillPresence(factory.retailAccountPage().updatePaymentSuccessMssg);
		Assert.assertEquals(expectMessage, factory.retailAccountPage().updatePaymentSuccessMssg.getText());
		logger.info("The payment success message displayed successfully");
	}

	// remove card

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.retailAccountPage().selectCard);
		click(factory.retailAccountPage().removeCardBttn);
		logger.info("The Remove card button was clicked successfully");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertTrue(factory.retailAccountPage().addCardHeader.isDisplayed());
		logger.info("The payment card was removed successfully");
	}

	// add address

	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.retailAccountPage().addAddressLink);
		logger.info("The Add Address Link was clicked successfully");
	}

	@When("user fill address form with below information")
	public void userFillAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.retailAccountPage().AddressCountryDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("country")));
		sendText(factory.retailAccountPage().addressNameField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
		sendText(factory.retailAccountPage().addressPhoneField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
		sendText(factory.retailAccountPage().addressStreetField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
		sendText(factory.retailAccountPage().addressApartmentNum,
				DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
		sendText(factory.retailAccountPage().addressCityField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
		selectByVisibleText(factory.retailAccountPage().addressStateDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
		sendText(factory.retailAccountPage().addressZipCodeField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));

		logger.info("Address form was filled out successfully");
	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.retailAccountPage().addressAddBttn);
		logger.info("The Add Address Button was clicked successfully");
	}

     //edit address
	
	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.retailAccountPage().editAddressBtn);
		logger.info("The Edit Address button was clicked successfully");

	}

	@When("User fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {

		List<Map<String, String>> updateAddress = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.retailAccountPage().AddressCountryDropdown,
				DataGenerator.addressGenerator(updateAddress.get(0).get("country")));
		clearTextUsingSendKeys(factory.retailAccountPage().addressNameField);
		sendText(factory.retailAccountPage().addressNameField,
				DataGenerator.addressGenerator(updateAddress.get(0).get("fullName")));
		clearTextUsingSendKeys(factory.retailAccountPage().addressPhoneField);
		sendText(factory.retailAccountPage().addressPhoneField,
				DataGenerator.addressGenerator(updateAddress.get(0).get("phoneNumber")));
		clearTextUsingSendKeys(factory.retailAccountPage().addressStreetField);
		sendText(factory.retailAccountPage().addressStreetField,
				DataGenerator.addressGenerator(updateAddress.get(0).get("streetAddress")));
		clearTextUsingSendKeys(factory.retailAccountPage().addressApartmentNum);
		sendText(factory.retailAccountPage().addressApartmentNum,
				DataGenerator.addressGenerator(updateAddress.get(0).get("apt")));
		clearTextUsingSendKeys(factory.retailAccountPage().addressCityField);
		sendText(factory.retailAccountPage().addressCityField,
				DataGenerator.addressGenerator(updateAddress.get(0).get("city")));
		clearTextUsingSendKeys(factory.retailAccountPage().addressStateDropdown);
		sendText(factory.retailAccountPage().addressStateDropdown,
				DataGenerator.addressGenerator(updateAddress.get(0).get("state")));
		clearTextUsingSendKeys(factory.retailAccountPage().addressZipCodeField);
		sendText(factory.retailAccountPage().addressZipCodeField,
				DataGenerator.addressGenerator(updateAddress.get(0).get("zipCode")));

		logger.info("The new address information was filled out successfully");
	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.retailAccountPage().updateAddressBtn);
		logger.info("User clicked on update address button");
	}

	// remove address

	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.retailAccountPage().removeAddressBttn);
		logger.info("The remove button was clicked successfully");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		if (!isElementDisplayed(factory.retailAccountPage().addressBox)) {
			logger.info("address details removed");
		}
	}
}
