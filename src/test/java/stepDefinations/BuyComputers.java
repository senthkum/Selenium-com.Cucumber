package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import commonFunctions.commonFunction;
import commonFunctions.commonModulesCode;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import objectRep.BillingAddress;
import objectRep.CheckOut;
import objectRep.Commonlinks;
import objectRep.LoginPage;
import objectRep.PaymentInformation;
import objectRep.ProductDetails;
import webdriver.webDriver;

@RunWith(Cucumber.class)
public class BuyComputers extends webDriver
{

	@Before
	public void beforeExe() throws Throwable {
		driver = initializeDriver();
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Given("^Launch the Demo Webshop Application$")
	public void launch_the_demo_webshop_application() throws Throwable 
	{
		commonModulesCode comCode = new commonModulesCode();
		comCode.Launch();
	}

	@When("^Enter the Username (.+), password (.+) and validate$")
	public void enter_the_username_password_and_validate(String username, String password) throws Throwable 
	{
		commonModulesCode comCode = new commonModulesCode();
		comCode.Login(username, password);
	}

    @And("^Click on the (.+) and (.+) by mouserover event$")
    public void click_on_the_and_by_mouserover_event(String categories, String product) throws Throwable 
    {
    	commonFunction comFun = new commonFunction(driver);	    	
    	comFun.ClickonTopMenu(categories, product);    	
    }
    
    @When("^Select the product (.+) from the table$")
    public void select_the_product_from_the_table(String subproduct) throws Throwable
    {
    	commonModulesCode comCode = new commonModulesCode();
    	comCode.SelectsubProduct(subproduct);
    	
    }
    
	@And("^Enter the user (.+) and (.+) details and click Add To Cart$")
	public void enter_the_user_and_details_and_click_add_to_cart(String recpname, String recpemail) throws Throwable {
		commonModulesCode comCode = new commonModulesCode();
		comCode.EnterUserDetails(recpname, recpemail);
	}

	@And("^Click on shippingcart link$")
	public void click_on_shippingcart_link() throws Throwable {
		commonModulesCode comCode = new commonModulesCode();
		comCode.ClickonShoppingLink();

	}

	@And("^Verify the product (.+) price$")
	public void verify_the_product_price(String product) throws Throwable {
		commonModulesCode comCode = new commonModulesCode();
		comCode.VerifyProductPrice(product);
	}

	@And("^Click on the terms and condition and Checkout$")
	public void click_on_the_terms_and_condition_and_checkout() throws Throwable {
		commonModulesCode comCode = new commonModulesCode();
		comCode.AcceptTermsandCondition();
	}

    @And("^Enter or chose the billing (.+)$")
    public void enter_or_chose_the_billing(String address) throws Throwable {

		commonModulesCode comCode = new commonModulesCode();
		comCode.BillingAddress(address);
	}

	@And("^Select the mode (.+) of payment$")
	public void select_the_mode_of_payment(String mode) throws Throwable {

		commonFunction comFun = new commonFunction(driver);

		comFun.modeofPayment(mode);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@And("^Check the payment information$")
	public void check_the_payment_information() throws Throwable {
		commonModulesCode comCode = new commonModulesCode();
		comCode.PaymentInformation();
	}

	@And("^Verify the product price and click on confirm button$")
	public void verify_the_product_price_and_click_on_confirm_button() throws Throwable {
		commonModulesCode comCode = new commonModulesCode();
		comCode.ConfirmOrder();
	}

	@Then("^Captured the order number generated$")
	public void captured_the_order_number_generated() throws Throwable {
		commonModulesCode comCode = new commonModulesCode();
		comCode.CaptureOrderNumber();
	}
}
