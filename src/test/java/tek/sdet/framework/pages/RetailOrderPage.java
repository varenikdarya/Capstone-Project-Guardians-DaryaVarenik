package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.sdet.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup {

	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// add item

	@FindBy(id = "search")
	public WebElement allDepartmentDropdown;

	@FindBy(id = "searchInput")
	public WebElement searchInputField;

	@FindBy(id = "searchBtn")
	public WebElement searchBttn;

	@FindBy(xpath = "//img[@alt='Kasa Outdoor Smart Plug']")
	public WebElement itemkasaoutdoorsmartplug;

	@FindBy(xpath = "//select[starts-with(@class,'product')]")
	public WebElement qtyDropdown;

	@FindBy(id = "addToCartBtn")
	public WebElement addToCartBttn;

	@FindBy(xpath = "//span[@id='cartQuantity']")
	public WebElement cartItemQty;

	@FindBy(xpath = "//span[text()='Delete']")
	public List<WebElement> deleteAllFromCart;

// add item to the cart and place order
	@FindBy(id = "cartBtn")
	public WebElement cartBttn;

	@FindBy(id = "proceedBtn")
	public WebElement proceedToCheckoutBttn;

	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBttn;

	@FindBy(xpath = "//div[text()='Order Placed Successfully']")
	public WebElement orderPlacedSuccessMssg;

	@FindBy(xpath = "//img[starts-with(@alt,'Apex Legends')]")
	public WebElement apexLegendsItem;

	// cancel order

	@FindBy(id = "orderLink")
	public WebElement orderLink;

	@FindBy(xpath = "//div[@class='order']//descendant::p[7]")
	public List<WebElement> listOfOrders;

	@FindBy(xpath = "//button[text()='Cancel The Order']")
	public List<WebElement> cancelOrderBttn;

	@FindBy(id = "reasonInput")
	public WebElement reasonForCancelation;

	@FindBy(id = "orderSubmitBtn")
	public WebElement cancelationSubmitBttn;

	@FindBy(xpath = "//p[text()='Your Order Has Been Cancelled']")
	public WebElement orderCancelledSuccessMssg;

	// return order

	@FindBy(id = "returnBtn")
	public WebElement returnItemsBtn;

	@FindBy(id = "reasonInput")
	public WebElement reasonOfReturnInput;

	@FindBy(id = "dropOffInput")
	public WebElement dropOffInput;

	@FindBy(xpath = "//button[@id='orderSubmitBtn']")
	public WebElement orderReturnAndSubmitBtn;

	@FindBy(xpath = "//p[text() = 'Return was successfull']")
	public WebElement orderReturnedSuccessMssg;

	// add review
	
	@FindBy(xpath = "//button[@id='reviewBtn']")
	public WebElement reviewBttn;
	
	@FindBy(xpath = "//input[@id='headlineInput']")
	public WebElement headlineInputField;
	
	@FindBy(xpath = "//textarea[@name='comment']")
	public WebElement commentField;
	
	@FindBy(xpath = "//button[@id='reviewSubmitBtn']")
	public WebElement reviewSubmitBtn;
	
	@FindBy(xpath = "//div[text()='Your review was added successfully']")
	public WebElement reviewSuccessMssg;

}
