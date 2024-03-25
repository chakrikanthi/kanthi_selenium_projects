package DifferentWebsitesTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class yourstorereviewtabtest {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("samsung galaxy");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Samsung Galaxy Tab 10.1']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='0 reviews']")).click();
		driver.findElement(By.xpath("//input[@id='input-name']")).sendKeys("kanthi");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//textarea[@id='input-review']")).sendKeys("This is a test review for testing this product");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@value='5']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[@id='button-review']")).click();
		driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed();
		
		driver.quit();//this will close all the broswers which are opened through this program
		
		
		
	}
}
