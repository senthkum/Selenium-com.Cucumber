package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import objectRep.BillingAddress;
import objectRep.ProductDetails;
import objectRep.CheckOut;
import objectRep.Commonlinks;
import objectRep.LoginPage;
import objectRep.PaymentInformation;
import webdriver.webDriver;
import java.util.concurrent.TimeUnit;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import commonFunctions.commonFunction;
import commonFunctions.commonModulesCode;

@RunWith(Cucumber.class)
public class BuyGiftCard extends webDriver {


	@Before
	public void beforeExe() throws Throwable {
		driver = initializeDriver();
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Given("^Launch the Demo Webshop Application$")
	public void launch_the_demo_webshop_application() throws Throwable {

		commonModulesCode comCode = new commonModulesCode();
		comCode.Launch();
	}

	@When("^Enter the Username (.+), password (.+) and validate$")
	public void enter_the_username_password_and_validate(String username, String password) throws Throwable {		
		commonModulesCode comCode = new commonModulesCode();
		comCode.Login(username, password);
	}

	@And("^Click on the (.+) and select the product (.+)$")
	public void click_on_the_and_select_the_product(String categories, String product) throws Throwable {
		commonModulesCode comCode = new commonModulesCode();
		comCode.SelectProduct(categories, product);				
	}

   
	@And("^Enter the user (.+) and (.+) details and click Add To Cart$")
	public void enter_the_user_and_details_and_click_add_to_cart(String recpname, String recpemail) throws Throwable {

		ProductDetails findProd = new ProductDetails(driver);

		findProd.RecipientName().sendKeys(recpname);
		try {
			findProd.RecipientEmail().sendKeys(recpemail);
		} catch (Exception e) {
			System.out.println("Could not find the email id element");
		}

		//		findProd.Quantity().clear();
		//		findProd.Quantity().sendKeys("1");		
		findProd.addToCart().click();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@And("^Click on shippingcart link$")
	public void click_on_shippingcart_link() throws Throwable {

		ProductDetails findProd = new ProductDetails(driver);
		findProd.shopCartLink().click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@And("^Verify the product (.+) price$")
	public void verify_the_product_price(String product) throws Throwable {

		ProductDetails findProd = new ProductDetails(driver);
		SoftAssert sa = new SoftAssert();

		int roCnt = findProd.shopingCartTable().findElements(By.xpath("//table[@class='cart']//tr")).size();
		int coCnt = findProd.shopingCartTable().findElements(By.xpath("//table[@class='cart']//tbody//tr//td")).size();

		for (int i = 1; i < roCnt; i++) {
			String products = driver.findElement(By.xpath("//table[@class='cart']//tbody//tr[" + i + "]//td[3]//a"))
					.getText();
			System.out.println(products);

			if (products.equalsIgnoreCase(product)) {
				/*
				 * driver.findElement(By.xpath("//table[@class='cart']//tbody//tr[" + i +
				 * "]//td[5]/input")).clear();
				 * driver.findElement(By.xpath("//table[@class='cart']//tbody//tr[" + i +
				 * "]//td[5]/input")).sendKeys("3");
				 * driver.findElement(By.xpath("//table[@class='cart']//tbody//tr[" + i +
				 * "]//td[5]/input")).sendKeys(Keys.ENTER);
				 */

				String price = driver
						.findElement(By.xpath("//table[@class='cart']//tbody//tr[" + i + "]//td[4]//span[2]"))
						.getText();
				Double iprice = Double.parseDouble(price);

				String qty = driver
						.findElement(By.xpath("//table[@class='cart']//tbody//tr[" + i + "]//td[5]//input[" + i + "]"))
						.getAttribute("value");
				double iqty = Double.parseDouble(qty);

				String totalp = driver.findElement(By.xpath("//table[@class='cart']//tbody//tr[" + i + "]//td[6]"))
						.getText();
				double itotalp = Double.parseDouble(totalp);

				double itotal = iprice * iqty;
				sa.assertEquals(itotal, itotalp, "verified the price with quantity");

			}
		}

	}

	@And("^Click on the terms and condition and Checkout$")
	public void click_on_the_terms_and_condition_and_checkout() throws Throwable {

		ProductDetails findProd = new ProductDetails(driver);

		findProd.terms().click();
		findProd.checkOut().click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@And("^Enter or chose the billing address$")
	public void enter_or_chose_the_billing_address() throws Throwable {

		BillingAddress BA = new BillingAddress(driver);

		WebElement nAdrs = BA.newAddress();
		Select newAdrs = new Select(nAdrs);
		newAdrs.selectByVisibleText("tarun boy, fjh, hhjff 122, Albania");

	}

	@And("^Select the mode (.+) of payment$")
	public void select_the_mode_of_payment(String mode) throws Throwable {

		commonFunction comFun = new commonFunction(driver);

		comFun.modeofPayment(mode);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	@And("^Check the payment information$")
	public void check_the_payment_information() throws Throwable {

		PaymentInformation PI = new PaymentInformation(driver);

		PI.payInfoContinue().click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@And("^Verify the product price and click on confirm button$")
	public void verify_the_product_price_and_click_on_confirm_button() throws Throwable {

		CheckOut CO = new CheckOut(driver);

		CO.ConfirmContinue().click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Then("^Captured the order number generated$")
	public void captured_the_order_number_generated() throws Throwable {

		CheckOut CO = new CheckOut(driver);

		String Message = CO.Message().getText();
		Assert.assertEquals(Message, "Your order has been successfully processed!");

		int oCnt = CO.OrdNumber().size();
		for (int i = 0; i < oCnt; i++) {
			String Onumber = CO.OrdNumber().get(i).getText();
			if (Onumber.contains("Order number: ")) {
				String[] strON = Onumber.split(":");
				System.out.println("Order Number Captured is : " + strON[1]);
			}
		}

	}

}