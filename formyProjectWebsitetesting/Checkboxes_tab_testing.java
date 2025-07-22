package formyProjectWebsitetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes_tab_testing {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();

		driver.get("https://formy-project.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('btn btn-lg')[2].style.border='5px red solid'");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div/div/li[3]/a")).click();
		System.out.println("Clicked on Check boxes tab successfully");
		driver.findElement(By.xpath("//input[@id='checkbox-1']")).click();
		System.out.println("Checked the check box 1");
		
		// 3 rd checkbox
		
		driver.findElement(By.xpath("//input[@id='checkbox-3']")).click();
		System.out.println("Checked the check box 3");
		
		driver.findElement(By.xpath("//input[@id='checkbox-2']")).click();
		System.out.println("Checked the check box 2");
		
		System.out.println("Now all the boxes got checked then will uncheck the chebox 1 now");
		
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@id='checkbox-1']")).click();
		System.out.println("UnChecked the check box 1");
		driver.quit();
		
		
		}

}
