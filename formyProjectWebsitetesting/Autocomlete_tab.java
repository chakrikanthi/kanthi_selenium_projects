package formyProjectWebsitetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autocomlete_tab {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();

		driver.get("https://formy-project.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("document.getElementsByClassName('btn btn-lg')[0].style.border='5px red solid'");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div/div/li[1]/a[1]")).click();

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("hslhfUSOfHSJIGBHESUIfgh");
		driver.findElement(By.xpath("//input[@id='street_number']")).sendKeys("3456 tyth hthyth t");
		driver.findElement(By.xpath("//input[@id='route']")).sendKeys("Atlanta");
		driver.findElement(By.xpath("//input[@id='locality']")).sendKeys("Duluth");
		driver.findElement(By.xpath("//input[@id='administrative_area_level_1']")).sendKeys("Georgia");
		driver.findElement(By.xpath("//input[@id='postal_code']")).sendKeys("3456789");
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("USA");
		driver.quit();


	}

	

}
