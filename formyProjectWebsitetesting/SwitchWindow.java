package formyProjectWebsitetesting;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();

		driver.get("https://formy-project.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('btn btn-lg')[12].style.border='5px red solid'");
		Thread.sleep(1000);
		String mainwindow= driver.getWindowHandle();
		System.out.println(mainwindow+driver.getTitle());
		driver.findElement(By.xpath("//li[13]//a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='new-tab-button']")).click();
		Thread.sleep(1000);
		Set <String> allwindows= driver.getWindowHandles();
		for(String allwindow:allwindows) {
			
			if(!allwindow.equals(mainwindow))
			{
				driver.switchTo().window(allwindow);
				System.out.println(driver.getTitle());
				driver.close();
			}
	}
		driver.switchTo().window(mainwindow);
		driver.findElement(By.xpath("//button[@id='alert-button']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		driver.quit();
	}
	
}
