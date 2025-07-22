package formyProjectWebsitetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop_tabtesting {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();

		driver.get("https://formy-project.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('btn btn-lg')[4].style.border='5px red solid'");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div/div/li[5]/a")).click();
		Thread.sleep(2000);
		
		WebElement se= driver.findElement(By.xpath("//div[@id='image']//img"));
		WebElement box=driver.findElement(By.xpath("//div[@id='box']"));
		
		Actions act= new Actions(driver);
		act.dragAndDrop(se, box).perform();
		

	}

}
