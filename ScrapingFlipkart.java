package Sam;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ScrapingFlipkart
{
	public static String url1="https://flipkart.com/";
	public static String closebutton_path="//button[@class='_2KpZ6l _2doB4z']";
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String product_searchtextfield_path="//input[@placeholder ='Search for products, brands and more']";
	public static String productname="laptops";
	public static String searchbutton_path="//button[@type='submit']";
	public static String searchedproducts_path="//div[@class='_4rR01T']";
	public static String searchedproducts_price_path="//div[@class='_30jeq3 _1_WHN1']";
	public static String pagination_path="//nav[@class='yFHi8N']/a";
	
	@Test
	public static void open_Browser()
	{
		System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
		driver=new ChromeDriver();
		wait= new WebDriverWait(driver,5);
		driver.manage().window().maximize();
		
		driver.get(url1);
	
		
	}
	@Test(priority=1)
	public static void openFlipkart() throws InterruptedException
	{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(closebutton_path)))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(product_searchtextfield_path)))).sendKeys(productname);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(searchbutton_path)))).click();
	}
	@Test(priority=2)
	public static void scrapeflipkartdata() throws InterruptedException
	
	{
		List<WebElement> pagination = driver.findElements(By.xpath(pagination_path));
		int paginationsize = pagination.size();
		
		for (int i=1;i<1;i++)
		{
			
		
			List<WebElement> searched_products = driver.findElements(By.xpath(searchedproducts_path));
			Thread.sleep(2000);
			List<WebElement> searchedproducts_price = driver.findElements(By.xpath(searchedproducts_price_path));
			Thread.sleep(2000);
			int searchedproducts_quant = searched_products.size();
			Thread.sleep(2000);
			for(int j=	1;j<=searchedproducts_quant;j++)
			{
				Thread.sleep(2000);
			String product = searched_products.get(j).getText();
			Thread.sleep(2000);
			
			//String price = searchedproducts_price.get(j).getText();
			System.out.println("Product name - "+product + " and price is ");			
			
		
			String no = Integer.toString(i+1);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//nav[@class='yFHi8N']/a["+no+"]")).click();		
			Thread.sleep(10000);
		}
	
	}
}
}
