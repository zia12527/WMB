package LandingPages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Beauty_buisines {
	public static WebDriver driver ; 

	@BeforeClass
	  public void beforeClass() throws InterruptedException 
	  {
			  System.setProperty("webdriver.chrome.driver", "/home/nadsoft34/Desktop/sel/chromedriver");
			  driver = new ChromeDriver();  
			  driver.manage().window().maximize();
			  driver.get("https://worldmicroblading.com/");
			  //Thread.sleep(8000);
	  }

	@BeforeMethod
	  public void beforeMethod() throws InterruptedException
	  {
			Thread.sleep(1000);
	  }

	  @AfterMethod
   	public void afterMethod() throws InterruptedException 
	  {
			Thread.sleep(1000);
	  }

	  @Test
	  public void actions() throws InterruptedException 
	  {
		  	reg_form();
		  	checkout_page();
	  }
	  public void reg_form() throws InterruptedException
	  {
		   	String email="salman@nadsoftdev.com";
		   	String Mobile="7020903936";
		   	String name="Amy Smith";
		  
		   	WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div[2]/nav/ul/li[1]/a[1]"));
		  	Actions action = new Actions(driver);
		  	action.moveToElement(element).build().perform();
		  	Thread.sleep(500);
		  	driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div[2]/nav/ul/li[1]/ul/li[4]/a")).click();
	      
		  	driver.findElement(By.linkText("Sign Up HERE")).click();
	      
	      // switch to pop
		  	String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		  	String subWindowHandler = null;

		  	Set<String> handles = driver.getWindowHandles(); // get all window handles
		  	Iterator<String> iterator = handles.iterator();
		  	while (iterator.hasNext())
		  	{
		  		subWindowHandler = iterator.next();
		  	}
		  	driver.switchTo().window(subWindowHandler); 
	      
		  	Thread.sleep(1000);
		  	driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div/div/div[4]/input")).sendKeys(name);
		  	driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div/div/div[5]/input")).sendKeys(Mobile);
		  	driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div/div/div[6]/input")).sendKeys(email);
		  	driver.findElement(By.linkText("Continue")).click();
		  
		  	Thread.sleep(1000);
		  	WebDriverWait wait = new WebDriverWait(driver, 30);
		  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign Up Now")));
		  	driver.findElement(By.linkText("Sign Up Now")).click();
		  
	  }
	  public void checkout_page() 
	  {
		  	System.out.println("On checkout page");
		
		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[20]/input")).sendKeys("Pune");
		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[22]/input")).sendKeys("Pune");
		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[24]/input")).sendKeys("MH");
		  	Select drp2Country = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[26]/select")));
		  	drp2Country.selectByVisibleText("India");
		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[28]/input")).sendKeys("411001");

		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[33]/div[2]/div[1]/input")).sendKeys("4111111111111111");
		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[33]/div[2]/div[2]/input")).sendKeys("1233");

		  	Select drp2Country1 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[33]/div[2]/div[4]/select")));
		  	drp2Country1.selectByVisibleText("2019");
		  
		  
		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[38]/input")).click();
		  	//For upsell 
		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[35]/input")).click();
//		 	 driver.findElement(By.linkText("Register Today")).click();
	 }
}
