package objectRep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;

public class BillingAddress 
{
	WebDriver driver;
	public BillingAddress(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	 By billCountry = By.xpath("//select[@id='BillingNewAddress_CountryId']");
	 By newAddress = By.name("billing_address_id"); 
	 By Country = By.name("BillingNewAddress.CountryId");
	 By billState = By.name("BillingNewAddress.StateProvinceId");
	 By billCity = By.name("BillingNewAddress.City");
	 By billAddress = By.name("BillingNewAddress.Address1");
	 By billPostcode = By.name("BillingNewAddress.ZipPostalCode");
	 By billPhoneNum = By.name("BillingNewAddress.PhoneNumber");
	 By billBA = By.className("new-address-next-step-button");

	 
	 By billContinue = By.xpath("//input[@title='Continue']");
	 By shipAddContinue = By.xpath("//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']");
	 By shipMethodContinue = By.xpath("//input[@class='button-1 shipping-method-next-step-button']");
	 By ground = By.id("shippingoption_0");
	 By onAir = By.id("shippingoption_1");
	 By secondDay = By.id("shippingoption_2");
	 

	public WebElement billBA()
	{
		return driver.findElement(billBA);
	}
		
		
	public WebElement billCountry()
	{
		return driver.findElement(billCountry);
	}

	public WebElement newAddress()
	{
		return driver.findElement(newAddress);
	}
	
	public WebElement billState()
	{
		return driver.findElement(billState);
	}
	
	
	public WebElement billCity()
	{
		return driver.findElement(billCity);
	}

	public WebElement billAddress()
	{
		return driver.findElement(billAddress);
	}
	
	public WebElement billPostcode()
	{
		return driver.findElement(billPostcode);
	}
	
	public WebElement billPhoneNum()
	{
		return driver.findElement(billPhoneNum);
	}
	
	public WebElement billContinue()
	{
		return driver.findElement(billContinue);
	}
	
	public WebElement shipAddContinue()
	{
		return driver.findElement(shipAddContinue);
	}

	public WebElement ground()
	{
		return driver.findElement(ground);
	}
	
	public WebElement onAir()
	{
		return driver.findElement(onAir);
	}
	
	public WebElement secondDay()
	{
		return driver.findElement(secondDay);
	}
	public WebElement shipMethodContinue()
	{
		return driver.findElement(shipMethodContinue);
	}
	
	
	
}
