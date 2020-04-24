package commonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import objectRep.BillingAddress;
import objectRep.CheckOut;
import objectRep.Commonlinks;
import objectRep.LoginPage;
import objectRep.PaymentInformation;
import objectRep.ProductDetails;
import webdriver.webDriver;

public class commonModulesCode extends webDriver
{

	public void Launch()
	{
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();		
	}
	
	public void Login(String username, String password)
	{
		Commonlinks comLink = new Commonlinks(driver);
		LoginPage LP = new LoginPage(driver);

		comLink.login().click();

		LP.Email().sendKeys(username);
		LP.Password().sendKeys(password);
		LP.Submit().click();

		try {
			String strVal = driver.findElement(By.className("ico-logout")).getText();
			Assert.assertEquals(strVal, "Log out");
		} catch (Exception e) {
			String strErrormsg = driver.findElement(By.className("validation-summary-errors")).getText();
			System.out.println(strErrormsg);
//			Assert.assertEquals(strErrormsg, "Login was unsuccessful. Please correct the errors");
		}			
	}
	
	public void SelectProduct(String categories, String product)
	{
		ProductDetails findProd = new ProductDetails(driver);
		commonFunction comFun = new commonFunction(driver);

		comFun.clickonLink(categories);

		int cCnt = findProd.prodItem().size();
		for (int i = 0; i < cCnt; i++) {
			String bookNames = findProd.prodItem().get(i).getText();
			if (bookNames.contains(product)) {
				findProd.prodItem().get(i).click();
				break;
			}
		}

	
	}
	
	public void SelectsubProduct(String subproduct)
	{
		ProductDetails findProd = new ProductDetails(driver);

		int cCnt = findProd.prodItem().size();
		for (int i = 0; i < cCnt; i++) {
			String prodNames = findProd.prodItem().get(i).getText();
			if (prodNames.contains(subproduct)) {
				findProd.prodItem().get(i).click();
				break;
			}
		}	    
	 }

	public void EnterUserDetails(String recpname, String recpemail)
	{
		ProductDetails findProd = new ProductDetails(driver);

		try
		{
			findProd.RecipientName().sendKeys(recpname);	
		}catch (Exception e) {
			System.out.println("Could not find the email id element");
		}	
		
		try {
			findProd.RecipientEmail().sendKeys(recpemail);
		} catch (Exception e) {
			System.out.println("Could not find the email id element");
		}
		try {
			findProd.Quantity().clear();
			findProd.Quantity().sendKeys("1");		
		}catch (Exception e) {
			System.out.println("Could not find the email id element");
		}
		
		findProd.addToCart().click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);		
	}
	
	
	public void ClickonShoppingLink()
	{
		ProductDetails findProd = new ProductDetails(driver);
		findProd.shopCartLink().click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);		
	}

	public void VerifyProductPrice(String product)
	{
		ProductDetails findProd = new ProductDetails(driver);
		SoftAssert sa = new SoftAssert();

		int roCnt = findProd.shopingCartTable().findElements(By.xpath("//table[@class='cart']//tr")).size();
		int coCnt = findProd.shopingCartTable().findElements(By.xpath("//table[@class='cart']//tbody//tr//td")).size();

		for (int i = 1; i < roCnt; i++) {
			String products = driver.findElement(By.xpath("//table[@class='cart']//tbody//tr[" + i + "]//td[3]//a"))
					.getText();
			System.out.println(products);

			if (products.equalsIgnoreCase(product)) {

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
	
	public void AcceptTermsandCondition()
	{
		ProductDetails findProd = new ProductDetails(driver);

		findProd.terms().click();
		findProd.checkOut().click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	
	public void BillingAddress(String address)
	{
		BillingAddress BA = new BillingAddress(driver);

		WebElement nAdrs = BA.newAddress();
		Select newAdrs = new Select(nAdrs);
		newAdrs.selectByVisibleText(address);
//		newAdrs.selectByVisibleText("tarun boy, fjh, hhjff 122, Albania");
	}
	
	
	public void PaymentInformation()
	{
		PaymentInformation PI = new PaymentInformation(driver);

		PI.payInfoContinue().click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);		
	}
	
	
	public void ConfirmOrder()
	{
		CheckOut CO = new CheckOut(driver);

		CO.ConfirmContinue().click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);		
	}
	
	
	public void CaptureOrderNumber()
	{
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
