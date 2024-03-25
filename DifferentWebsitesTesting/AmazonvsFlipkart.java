package DifferentWebsitesTesting;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonvsFlipkart {

	public static void main(String[] args) throws AWTException, InterruptedException {
		  WebDriver driver= new ChromeDriver();
	      driver.get("https://www.amazon.com/");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphonexr 64gb yellow");
	      driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	      driver.findElement(By.xpath("//span[normalize-space()='Apple iPhone XR, US Version, 64GB, Yellow - Unlocked (Renewed)']")).click();
	      String price= driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[10]/div[5]/div[4]/div[15]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/span[2]")).getText();
	      System.out.println(price);
	      driver.navigate().to("https://www.flipkart.com/");
	      driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("iphonexr 64gb yellow");
	      Thread.sleep(3000);
	        Robot rb= new Robot();
			rb.delay(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[normalize-space()='Apple iPhone XR (Yellow, 64 GB) (Includes EarPods, Power Adapter)']")).click();//sendKeys(Keys.RETURN);;
			Thread.sleep(4000);
			
			Set<String> newwindow=driver.getWindowHandles();
			System.out.println(newwindow);
			Thread.sleep(3000);
			Iterator<String> iterator= newwindow.iterator();
			String Parentwindow= iterator.next();
			String flipnewwindow= iterator.next();
			driver.switchTo().window(flipnewwindow);
			
			String price1=driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
	        System.out.println(price1);
	       driver.quit();
	}
	
	

}
