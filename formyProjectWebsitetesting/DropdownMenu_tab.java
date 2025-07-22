package formyProjectWebsitetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownMenu_tab {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();

		driver.get("https://formy-project.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(1000);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('btn btn-lg')[5].style.border='5px red solid'");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/li[6]/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-labelledby='dropdownMenuButton']//a[normalize-space()='Complete Web Form']")).click();


		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Kanthi");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("SRI");
		driver.findElement(By.xpath("//input[@id='job-title']")).sendKeys("QA Lead");
		driver.findElement(By.xpath("//input[@id='radio-button-2']")).click();
		driver.findElement(By.xpath("//input[@id='checkbox-2']")).click();
		
	    WebElement dropdown= driver.findElement(By.id("select-menu"));
	    Select experience= new Select(dropdown);
	    experience.selectByValue("3");
	    driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	    driver.findElement(By.xpath("//td[normalize-space()='19']")).click();
	    driver.findElement(By.xpath("//a[normalize-space()='Submit']")).click();
	    
	   String status=driver.findElement(By.xpath("//div[@role='alert']")).getText();
	   System.out.println(status);
	   Boolean successmsg=driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed();
	   if (successmsg.TRUE) {
		   System.out.println("Application submitted successfuly");
	   }     
	   driver.quit();
	}
}



/* output:The form was successfully submitted!
Application submitted successfuly*/