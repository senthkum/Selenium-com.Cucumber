package objectRep;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PaymentMethod 
{
	WebDriver driver;
	public PaymentMethod(WebDriver driver)
	{
		this.driver = driver;
		
	}

	By CashonDelivery = By.id("paymentmethod_0");
	By MoneyOrder = By.id("paymentmethod_1");
	By CreditCard = By.id("paymentmethod_2");
	By PurchaseOrder = By.id("paymentmethod_3");	
	By BAContinue = By.xpath("//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']");
	By SAContinue = By.xpath("//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']");
	By SMContinue = By.className("shipping-method-next-step-button");
	By PMContinue = By.className("payment-method-next-step-button");
	By Billing = By.xpath("//*[contains(@id,'opc')]/div[1]/h2");
	
	  public WebElement CashonDelivery() 
	  {
		 return driver.findElement(CashonDelivery);
	  }
	  
	  public WebElement MoneyOrder() 
	  {
		  return driver.findElement(MoneyOrder);
	  }
	  
	  public WebElement CreditCard() 
	  {
		  return driver.findElement(CreditCard);
	  }
	  public WebElement PurchaseOrder() 
	  {
		  return driver.findElement(PurchaseOrder);
	  }
	  public WebElement BAContinue() 
	  {
		  return driver.findElement(BAContinue);
	  }

	  public WebElement SAContinue() 
	  {
		  return driver.findElement(SAContinue);
	  }

	  public WebElement SMContinue() 
	  {
		  return driver.findElement(SMContinue);
	  }

	  public WebElement PMContinue() 
	  {
		  return driver.findElement(PMContinue);
	  }
	  public List<WebElement> Billing() 
	  {
		  return driver.findElements(Billing);
	  }
	  
}
