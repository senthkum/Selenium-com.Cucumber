package objectRep;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import objectRep.RegistrationPage;
import objectRep.ProductDetails;
import objectRep.Commonlinks;
import objectRep.LoginPage;
import objectRep.BillingAddress;
import objectRep.PaymentMethod;
import objectRep.PaymentInformation;
import objectRep.CheckOut;

public class ProductDetails 
{
	WebDriver driver;
	public ProductDetails(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkProd = By.xpath("//li[@class='inactive']");
	By sortBy = By.xpath("//select[@id='products-orderby']");
	By perPage = By.xpath("//select[@id='products-pagesize']");
	By linkTxt = By.linkText("Computing and Internet");
	By addCart = By.xpath("//input[@id='add-to-cart-button-13']");
	By Quantity = By.className("qty-input");
	By shopCartLink = By.linkText("Shopping cart");
	By prodItem = By.xpath("//div[@class='product-grid']//div//h2");
	By addToCart = By.className("add-to-cart-button");
	By wishlistButton = By.xpath("//input[@id='add-to-wishlist-button-78']");
	By shopingCartTable = By.xpath("//table[@class='cart']");
	By checkOut = By.name("checkout");
	By terms = By.name("termsofservice");
	By RecipientName = By.className("recipient-name");	
	By RecipientEmail = By.className("recipient-email");
	
	
	
	public List<WebElement> linkProd()
	{
		return driver.findElements(linkProd);
	}

	public WebElement RecipientName()
	{
		return driver.findElement(RecipientName);		
	}

	public WebElement RecipientEmail()
	{
		return driver.findElement(RecipientEmail);		
	}
	
	public WebElement sortBy()
	{
		return driver.findElement(sortBy);		
	}

	public WebElement addToCart()
	{
		return driver.findElement(addToCart);		
	}

	public WebElement perPage()
	{
		return driver.findElement(perPage);
	}
	
	public WebElement linkTxt()
	{
		return driver.findElement(linkTxt);
	}
	
	public WebElement addCart()
	{
		return driver.findElement(addCart);
	}
	
	public WebElement Quantity()
	{
		return driver.findElement(Quantity);
	}
	
	public WebElement shopCartLink()
	{
		return driver.findElement(shopCartLink);
	}

	public List<WebElement> prodItem()
	{
		return driver.findElements(prodItem);
	}	

	public WebElement wishlistButton()
	{
		return driver.findElement(wishlistButton);
	}	

	public WebElement shopingCartTable()
	{
		return driver.findElement(shopingCartTable);
	}
	
	public WebElement terms()
	{
		return driver.findElement(terms);
	}
	
	public WebElement checkOut()
	{
		return driver.findElement(checkOut);
	}
	
}
