package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGenerator;

public class SignInSteps extends CommonUtility {
		POMFactory factory = new POMFactory();

	// sign in
		
		@Given("User is on retail website")
		public void userIsOnRetailWebsite() {
			Assert.assertTrue(factory.retailSignInPage().tekSchoolLogo.isDisplayed());
			logger.info("TEKSCHOOL logo is displayed");
		}
		
		@When("User click on Sign in option")
		public void userClickOnSignInOption() {
			click(factory.retailSignInPage().signinLink);
			logger.info("Sign in button was clicked");
		}
		@When("User enter email {string} and password {string}")
		public void userEnterEmailAndPassword(String email, String password) {
			sendText(factory.retailSignInPage().emailField, email);
			sendText(factory.retailSignInPage().passwordField, password);
			logger.info("Email and password was entered successfully");
		}
		@When("User click on login button")
		public void userClickOnLoginButton() {
			click(factory.retailSignInPage().loginBtn);
			logger.info("Login button was clicked");
		}
		@Then("User should be logged in into Account")
		public void userShouldBeLoggedInIntoAccount() {
			Assert.assertTrue(factory.retailSignInPage().logoutBttn.isDisplayed());
			logger.info("The user has been logged in into Account");
		}


	//create account
		@And("User click on Create New Account button")
		public void userClickOnCreateNewAccountButton() {
			click(factory.retailSignInPage().newAccountBtn);
			logger.info("Create new account button was clicked successfully");
		}

		@And("User fill the signUp information with below data")
		public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
			List<Map<String, String>> accountInfo = dataTable.asMaps(String.class, String.class);
			sendText(factory.retailSignInPage().accountnameInput, accountInfo.get(0).get("name"));
			sendText(factory.retailSignInPage().accountemailInput,
					DataGenerator.addressGenerator(accountInfo.get(0).get("email")));
			sendText(factory.retailSignInPage().accountpasswordInput, accountInfo.get(0).get("password"));
			sendText(factory.retailSignInPage().confirmPasswordInput, accountInfo.get(0).get("confirmPassword"));
			logger.info("Information was filled up successfully");
		}

		@And("User click on SignUp button")
		public void userClickOnSignUpButton() {
			click(factory.retailSignInPage().signupBtn);
			logger.info("Signup button was clicked successfully");
		}

		@Then("User should be logged into account page")
		public void userShouldBeLoggedIntoAccountPage() {
			Assert.assertTrue(factory.retailSignInPage().yourProfileText.isDisplayed());
			logger.info("Account page displayed");
		}

	}

