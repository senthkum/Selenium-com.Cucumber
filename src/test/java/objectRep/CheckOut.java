package objectRep;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOut 
{
	WebDriver driver;
	public CheckOut(WebDriver driver)
	{
		this.driver = driver;
	}

	
	By ConfirmContinue  = By.className("confirm-order-next-step-button");
	By Products = By.xpath("//table[@class='cart']//tr//td");
	By TotalTable = By.xpath("//table[@class='cart-total']//tr//td//span//span");
	By Message = By.xpath("//div[@class='title']//strong");
	By OrdNumber = By.xpath("//ul[@class='details']//li");
	By CompleteContiue = By.xpath("//input[@class='button-2 order-completed-continue-button']");
	
	public WebElement ConfirmContinue()
	{
		return driver.findElement(ConfirmContinue);
	}
	
	public List<WebElement> Products()
	{
		return driver.findElements(Products);
	}
	
	public List<WebElement> TotalTable()
	{
		return driver.findElements(TotalTable);
	}	
	public WebElement Message()
	{
		return driver.findElement(Message);
	}
	
	public List<WebElement> OrdNumber()
	{
		return driver.findElements(OrdNumber);
	}
}
