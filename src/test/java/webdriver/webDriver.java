package webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriver {
	
	public static WebDriver driver;
	public Properties prop;

	
	public WebDriver initializeDriver() throws IOException
	{
//		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
//		return driver;
		
        prop = new Properties();
		FileInputStream fis =  new FileInputStream("C:\\Users\\senthkum\\eclipse-workspace\\cucum.mave.project\\resource\\BrowserData.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\senthkum\\eclipse-workspace\\cucum.mave.project\\Drivers\\1chromedriver.exe");			
			driver = new ChromeDriver();
		}
		return driver;	

		
	}

//	public void getScreenShot(String result) throws IOException 
//	{
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File("C:\\Users\\senthkum\\eclipse-workspace\\cucum.mave.project\\results" + result + "screenshot.png"));
//	}	
	
}
