package testcases;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest 
{
	public static WebDriver driver;
	
	@BeforeSuite
    public void setUp()
    {
		System.setProperty("webdriver.gecko.driver", "C:\\Executables\\geckodriver-v0.26.0-win64\\geckodriver.exe");
    	driver = new FirefoxDriver();
    }
    
    @Test
    public void doLogin()
    {
    	driver.get("http://gmail.com");
		// For fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).withMessage("user defined time out after 10 secs.")
				.ignoring(NoSuchElementException.class);
		
    	driver.findElement(By.id("identifierId")).sendKeys("shilpa.reshmi84@gmail.com");
    	driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("aarush18nov1!");
    	System.out.println("lets try to commit and push to Git after adding this line");
    }
    
    @AfterSuite
    public void tearDown()
    {
    	driver.quit();
    }
}
