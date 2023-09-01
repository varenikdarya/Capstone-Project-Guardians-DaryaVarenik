package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailSignInPage extends BaseSetup {

	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// sign in
	
	@FindBy(linkText = "TEKSCHOOL")
	public WebElement tekSchoolLogo;
	
	@FindBy(id = "signinLink")
	public WebElement signinLink;

	@FindBy(id = "signinBtn")
	public WebElement signInBtn;
	
	@FindBy(id = "email")
	public WebElement emailField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(id = "loginBtn")
	public WebElement loginBtn;
	
	@FindBy(id = "logoutBtn")
	public WebElement logoutBttn;

	// create account
	
	@FindBy(id = "newAccountBtn")
	public WebElement newAccountBtn;
	
	@FindBy(id = "newCompanyAccount")
	public WebElement sellSomethingLink;
	
	@FindBy(id = "nameInput")
	public WebElement accountnameInput;
	
	@FindBy(id = "emailInput")
	public WebElement accountemailInput;
	
	@FindBy(id = "passwordInput")
	public WebElement accountpasswordInput;
	
	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPasswordInput;
	
	@FindBy(id = "signupBtn")
	public WebElement signupBtn;

	@FindBy(xpath = "//h1[text()='Your Profile']")
	public WebElement yourProfileText;
}
