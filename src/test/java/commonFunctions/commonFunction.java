package commonFunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import objectRep.Commonlinks;
import objectRep.PaymentMethod;
import webdriver.webDriver;

public class commonFunction extends webDriver {

	WebDriver driver;
	
	public commonFunction(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickonLink(String CategoriesName) {
		boolean strflag = false;
		List<WebElement> strTagName = driver.findElements(By.tagName("ul"));
		for (WebElement LoopTagName : strTagName) {
			if (LoopTagName.getAttribute("class").contains("list")) {
				List<WebElement> strSubTagName = driver.findElements(By.tagName("li"));
				for (WebElement LoopInnerTagName : strSubTagName) {
					if (LoopInnerTagName.getText().toLowerCase().contentEquals(CategoriesName.toLowerCase())) {
						WebElement clickOn = LoopInnerTagName.findElement(By.tagName("a"));
						clickOn.click();
						strflag = true;
						break;
					}
				}

			}
			if (strflag == true) {
				break;
			}
		}

	}

	public void ClickonTopMenu(String Product, String subProduct)
	{
		Actions act = new Actions(driver);
		Commonlinks comLinks = new Commonlinks(driver);
		boolean strflag = false;
		
		int tagCnt = comLinks.menuProduct().size();
		for(int i=0; i<tagCnt; i++)
		{
			String topMenu = comLinks.menuProduct().get(i).getText();
			System.out.println(topMenu);
			if(topMenu.equalsIgnoreCase(Product))
			{
				act.moveToElement(comLinks.menuProduct().get(i)).build().perform();
				break;
			}
		}
		
		List<WebElement> strTagName = driver.findElements(By.tagName("ul"));
		for (WebElement LoopTagName : strTagName) {
			if (LoopTagName.getAttribute("class").contains("firstLevel")) {
				List<WebElement> strSubTagName = driver.findElements(By.tagName("li"));
				for (WebElement LoopInnerTagName : strSubTagName) {
					if (LoopInnerTagName.getText().toLowerCase().contentEquals(subProduct.toLowerCase())) {
						WebElement clickOn = LoopInnerTagName.findElement(By.tagName("a"));
						clickOn.click();
						strflag = true;
						break;
					}
				}

			}
			if (strflag == true) {
				break;
			}
		}		
}
	
	
	
	public void modeofPayment(String mode) {
		PaymentMethod PM = new PaymentMethod(driver);

		for (int i = 0; i < PM.Billing().size(); i++) {
			String strHeader = PM.Billing().get(i).getText();
			switch(strHeader) {
			case "Billing Address":
				PM.BAContinue().click();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				break;

			case "Shipping Address":
				PM.SAContinue().click();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				break;

			case "Shipping Method":
				PM.SMContinue().click();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				break;
			case "Payment Method":
				if (mode.equalsIgnoreCase("COD")) {
					PM.PMContinue().click();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					break;
				}
			default:
				break;
			}

		}

	}
	
}
