package objectRep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By eMail = By.id("Email");
	By Password = By.name("Password");
	By submit = By.xpath("//input[@class='button-1 login-button']");

	public WebElement Email()
	{
		return driver.findElement(eMail);
	}
	
	public WebElement Password()
	{
		return driver.findElement(Password);
	}
	
	public WebElement Submit()
	{
		return driver.findElement(submit);
	}	
}
