package objectRep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Commonlinks 
{
	WebDriver driver;
	public Commonlinks(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By login = By.linkText("Log in");
	By logout = By.linkText("Log out");
	By register = By.linkText("Register");
	By wishlist = By.linkText("Wishlist");
		
	
	By menuProduct = By.xpath("//ul[@class='top-menu']//li");	
	public List<WebElement> menuProduct() 
	{
		return driver.findElements(menuProduct);
	}

	By subProduct = By.xpath("//ul[@class='top-menu']//li//ul");
	public List<WebElement> subProduct() 
	{
		return driver.findElements(subProduct);
	}
		
	public WebElement login() 
	{
		return driver.findElement(login);
	}
	
	public WebElement logout()
	{
		return driver.findElement(logout);
	}
	
	public WebElement register()
	{
		return driver.findElement(register);
	}
	
	public WebElement wishlist()
	{
		return driver.findElement(wishlist);
	}
	
}
