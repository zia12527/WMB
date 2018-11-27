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

public class Vbright {
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
		  	driver.findElement(By.xpath("//*[@id=\"menu-item-14890\"]")).click();
	      
		  	Select drpCountry = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/div/div[2]/div/div[5]/label/select")));
		  	drpCountry.selectByVisibleText("Las vegas | Nov-10-2018 | 3 Days V-Bright Pro Training");
		  	driver.findElement(By.partialLinkText("Apply Now")).click();
		  
		  	//Scroll page automatic
		  	driver.findElement(By.xpath("/html/body/div[1]/div[10]/div/div[18]/div[2]/div/div[3]/input")).sendKeys(name);
		  	driver.findElement(By.xpath("/html/body/div[1]/div[10]/div/div[18]/div[2]/div/div[4]/input")).sendKeys(email);
		  	driver.findElement(By.xpath("/html/body/div[1]/div[10]/div/div[18]/div[2]/div/div[5]/input")).sendKeys(Mobile);
		  	driver.findElement(By.partialLinkText("YES! RESERVE MY SPOT NOW")).click();
		  
		  	System.out.println("Registration form submitted");
		  
	  }
	  public void checkout_page() 
	  {
	      	System.out.println("On checkout page");
		
	      	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[18]/input")).sendKeys("Pune");
	      	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[20]/input")).sendKeys("Pune");
	      	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[22]/input")).sendKeys("MH");
	      	Select drp2Country = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[24]/select")));
	      	drp2Country.selectByVisibleText("India");
	      	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[26]/input")).sendKeys("411001");

	      	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[34]/div[2]/div[1]/input")).sendKeys("4111111111111111");
	      	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[34]/div[2]/div[2]/input")).sendKeys("1233");

	      	Select drp2Country1 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[34]/div[2]/div[4]/select")));
	      	drp2Country1.selectByVisibleText("2019");
		  //upsell
	      	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[36]/input")).click();
	      	driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[39]/input")).click();
//		  driver.findElement(By.linkText("Register Today")).click();
	 }
}
