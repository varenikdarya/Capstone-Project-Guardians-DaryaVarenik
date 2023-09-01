package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// update PI
	@FindBy(id = "accountLink")
	public WebElement accountBttn;

	@FindBy(id = "nameInput")
	public WebElement nameInputField;

	@FindBy(id = "personalPhoneInput")
	public WebElement phoneInputField;

	@FindBy(id = "emailInput")
	public WebElement emailInputField;

	@FindBy(xpath = "//button[@id='personalUpdateBtn']")
	public WebElement accountUpdtBttn;

	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement PIupdateMsg;

// add payment method
	@FindBy(xpath = "//p[contains(text(),'payment')]")
	public WebElement addPaymentlink;

	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberField;

	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardField;

	@FindBy(id = "expirationMonthInput")
	public WebElement expMonthInput;

	@FindBy(id = "expirationYearInput")
	public WebElement expYearInput;

	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeInput;

	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentSubmitBttn;

	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement paymentAddedMssg;

	// edit Debit/Credit card information

	@FindBy(xpath = "//div[@class='account__payment-sub']")
	public WebElement selectCard;

	@FindBy(xpath = "//button[text()='Edit']")
	public WebElement editCardBttn;

	@FindBy(id = "paymentSubmitBtn")
	public WebElement updatePaymentBttn;

	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
	public WebElement updatePaymentSuccessMssg;

	// remove card

	@FindBy(xpath = "//button[text()='remove']")
	public WebElement removeCardBttn;

	@FindBy(xpath = "//h1[@class='account__payment-new-title']")
	public WebElement addCardHeader;

	// add address

	@FindBy(xpath = "//div[starts-with(@class,'account__address-new-')]")
	public WebElement addAddressLink;

	@FindBy(id = "countryDropdown")
	public WebElement AddressCountryDropdown;

	@FindBy(id = "fullNameInput")
	public WebElement addressNameField;

	@FindBy(id = "phoneNumberInput")
	public WebElement addressPhoneField;

	@FindBy(id = "streetInput")
	public WebElement addressStreetField;

	@FindBy(id = "apartmentInput")
	public WebElement addressApartmentNum;

	@FindBy(id = "cityInput")
	public WebElement addressCityField;

	@FindBy(name = "state")
	public WebElement addressStateDropdown;

	@FindBy(id = "zipCodeInput")
	public WebElement addressZipCodeField;

	@FindBy(id = "addressBtn")
	public WebElement addressAddBttn;

	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressSuccessMssg;

	// edit address
	
	@FindBy(xpath = "//button[@class='account__address-btn' and text()='Edit']")
	public WebElement editAddressBtn;

	@FindBy(id = "addressBtn")
	public WebElement updateAddressBtn;

	@FindBy(xpath = "//div[text()='Address Updated Successfully']")
	public WebElement addressUpdatedSuccessMssg;
	
	//remove address
	
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement removeAddressBttn;
	
	@FindBy(xpath = "//div[@class='account__address-single']")
	public WebElement addressBox;
	
	
	
}

