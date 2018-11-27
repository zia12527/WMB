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

public class online_class {
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

	  private void reg_form() throws InterruptedException 
	  {
			  String email="zia@nadsoftdev.com";
			  String Mobile="7020903936";
			  String name="Amy Smith";
			  
			  WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div[2]/nav/ul/li[5]/a[1]"));
			  Actions action = new Actions(driver);
		      action.moveToElement(element).build().perform();
		      Thread.sleep(500);
		      driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div[2]/nav/ul/li[5]/ul/li/a")).click();
		      
		      WebDriverWait wait = new WebDriverWait(driver, 60);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[8]/div/div[2]/div[1]/div/div[4]/a/span[1]")));
		      driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/div[2]/div[1]/div/div[4]/a/span[1]")).click();
		      
		      // registration form
		      driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/div[2]/div/div/div[4]/input")).sendKeys(name);
			  driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/div[2]/div/div/div[5]/input")).sendKeys(Mobile);
			  driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/div[2]/div/div/div[6]/input")).sendKeys(email);
		      
			  driver.findElement(By.partialLinkText("Start Your Free Training Today")).click();
			  WebDriverWait wait1 = new WebDriverWait(driver, 30);
			  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[8]/div/div[3]/div[2]/div/div[4]/a")));
		  
			  driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/div[3]/div[2]/div/div[4]/a")).click();
			  
	  }
	  public void checkout_page() 
	  {
	      	  System.out.println("On checkout page");
		
	      	  driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[22]/input")).sendKeys("Pune");
		      driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[24]/input")).sendKeys("Pune");
		      driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[26]/input")).sendKeys("MH");
		  
		      Select drp2Country = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[28]/select")));
		      drp2Country.selectByVisibleText("India");
		  
		      driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[30]/input")).sendKeys("411001");
//
		      driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[49]/div[2]/div[1]/input")).sendKeys("4111111111111111");
		      driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[49]/div[2]/div[2]/input")).sendKeys("1233");

		      Select drp2Country1 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[49]/div[2]/div[4]/select")));
		      drp2Country1.selectByVisibleText("2019");
		  
		      driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[55]/input")).click();
			  //For upsell 
			  driver.findElement(By.xpath("/html/body/div[1]/div[8]/div/form/div/div[1]/div/div[52]/input")).click();
//			  driver.findElement(By.partialLinkText("Complete Order")).click();
			  //
	 }
}
