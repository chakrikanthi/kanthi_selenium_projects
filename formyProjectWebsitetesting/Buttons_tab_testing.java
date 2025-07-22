package formyProjectWebsitetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buttons_tab_testing {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();

		driver.get("https://formy-project.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("document.getElementsByClassName('btn btn-lg')[1].style.border='5px blue solid'");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/li[2]/a[1]")).click();
		Thread.sleep(1000);
		js.executeScript("document.getElementsByTagName('button')[4].style.border='5px red solid'");
		driver.findElement(By.xpath("//button[normalize-space()='Warning']")).click();
		System.out.println("Clicked on Warning button");
		
		js.executeScript("document.getElementsByClassName('btn btn-lg btn-primary')[2].style.border='5px yellow solid'");
		driver.findElement(By.xpath("//button[normalize-space()='Middle']")).click();
		System.out.println("Clicked on Middle button and the button got highlighted in yellow color");
		js.executeScript("document.getElementById('btnGroupDrop1').style.border='5px red solid'");
		driver.findElement(By.xpath("//button[@id='btnGroupDrop1']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[1]")).click();
		System.out.println("successfully clicked on dropdown link 1");
		driver.quit();
		
		
		
		
		


}
}