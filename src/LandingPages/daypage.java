package LandingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class daypage 
	{ 
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
		  	String email="zia@nadsoftdev.com";
		  	String Mobile="7020903936";
		  	String name="Amy Smith";
		  
		  	WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div[2]/nav/ul/li[1]/a[1]"));
		  	Actions action = new Actions(driver);
		  	action.moveToElement(element).build().perform();
		  	Thread.sleep(500);
		  	driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div[2]/nav/ul/li[1]/ul/li[2]/a")).click();
		  
		  	// On Clickfunnel
		  	Thread.sleep(1500);
		  	driver.findElement(By.linkText("Reserve Your Spot Now")).click();
		  	System.out.println("On registration page");
		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/div[3]/div[2]/div/div[5]/input")).sendKeys(name);
		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/div[3]/div[2]/div/div[6]/input")).sendKeys(Mobile);
		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/div[3]/div[2]/div/div[7]/input")).sendKeys(email);
		  	Thread.sleep(500);

		  	Select drpCountry = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/div[3]/div[2]/div/div[9]/label/select")));
		  	drpCountry.selectByVisibleText("Las vegas");
		  	driver.findElement(By.partialLinkText("REGISTER NOW")).click();
	  
		}
		public void checkout_page() throws InterruptedException
	  {
		  	System.out.println("On checkout page");
	  
		  	Thread.sleep(10000);
		  	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[22]/input")).sendKeys("Pune");
	  		driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[24]/input")).sendKeys("Pune");
	  		driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[26]/input")).sendKeys("MH");
	  		Select drp2Country = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[28]/select")));
	  		drp2Country.selectByVisibleText("India");
	  		driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[30]/input")).sendKeys("411001");
	  
	  		driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[39]/div[2]/div[1]/input")).sendKeys("4111111111111111");
	  		driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[39]/div[2]/div[2]/input")).sendKeys("1233");

			  /*Select drp2Country1 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[39]/div[2]/div[4]/select")));
			  drp2Country1.selectByVisibleText("2019");
			  
			  driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[44]/input")).click();
			  driver.findElement(By.linkText("Complete Order")).click();*/
	  }
	}
