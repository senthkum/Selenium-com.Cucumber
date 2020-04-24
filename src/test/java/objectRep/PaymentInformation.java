package objectRep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentInformation 
{
		WebDriver driver;
		public PaymentInformation(WebDriver driver)
		{
			this.driver = driver;
		}
		
		By payInfoContinue = By.className("payment-info-next-step-button");
		By CreditCardType = By.name("CreditCardType");
		By CardholderName = By.id("CardholderName");
		By CardNumber = By.name("CardNumber");
		By ExpireMonth = By.name("ExpireMonth");
		By ExpireYear = By.id("ExpireYear");
		By CardCode = By.name("CardCode");
		By PurchaseOrderNumber = By.name("PurchaseOrderNumber");		
		
		public WebElement payInfoContinue() 
		{
		   return driver.findElement(payInfoContinue);
		}	
		
		public WebElement CreditCardType()
		{
			return driver.findElement(CreditCardType);			
		}

		public WebElement CardholderName()
		{
			return driver.findElement(CardholderName);
		}
		public WebElement CardNumber()
		{
			return driver.findElement(CardNumber);
		}
		public WebElement ExpireMonth()
		{
			return driver.findElement(ExpireMonth);
		}
		public WebElement ExpireYear()
		{
			return driver.findElement(ExpireYear);
		}
		public WebElement CardCode()
		{
			return driver.findElement(CardCode);
		}
		public WebElement PurchaseOrderNumber()
		{
			return driver.findElement(PurchaseOrderNumber);
		}
		
		
}
