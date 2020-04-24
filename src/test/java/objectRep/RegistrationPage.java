package objectRep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage 
{

	WebDriver driver;
	public RegistrationPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By gender = By.xpath("//input[@id='gender-male']");
	By firstName = By.xpath("//input[@id='FirstName']");
	By lastName = By.xpath("//input[@id='LastName']");
	By eMail = By.xpath("//input[@id='Email']");
	By password = By.xpath("//input[@id='Password']");
	By conPassword = By.xpath("//input[@id='ConfirmPassword']");
	By regButton = By.xpath("//input[@id='register-button']");
	
	public WebElement gender()
	{
		return driver.findElement(gender);
	}
	
	public WebElement firstName()
	{
		return driver.findElement(firstName);
	}
	
	public WebElement lastName()
	{
		return driver.findElement(lastName);
	}
	
	public WebElement eMail()
	{
		return driver.findElement(eMail);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement conPassword()
	{
		return driver.findElement(conPassword);
	}
	
	public WebElement regButton()
	{
		return driver.findElement(regButton);
	}
	
}
