package formyProjectWebsitetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Enable_n_DisabledElements {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();

		driver.get("https://formy-project.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('btn btn-lg')[6].style.border='5px red solid'");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/li[7]/a[1]")).click();
		WebElement disablebutton= driver.findElement(By.xpath("//input[@id='disabledInput']"));
		if(disablebutton.isEnabled()) {
			System.err.println("The first  button is enabled");
			
		}
		else {
			System.out.println("The first button is disabled");
		}

		WebElement enabledbtn= driver.findElement(By.xpath("//input[@id='input']"));
		if(enabledbtn.isEnabled()) {
			System.out.println("The second button is enabled so you can enter any text here:");
			enabledbtn.sendKeys("Hi this is a test message");
			System.out.println("Hi this is a test message.. this message go entered successfully");
		}
		
		else{
			System.err.println("Sorry this test got disables you cant enter any text herer");
		}
		driver.quit();
	}

}
