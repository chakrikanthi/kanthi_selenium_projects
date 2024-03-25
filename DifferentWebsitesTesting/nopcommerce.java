package DifferentWebsitesTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class nopcommerce {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li[6]//a[normalize-space()='Jewelry'][1][1]")).click();
		driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[2]/button[1]")).click();
		WebElement statusmsg=driver.findElement(By.xpath("//p[@class='content']"));
		System.out.println(statusmsg);
		Boolean status= statusmsg.isDisplayed();
		System.out.println(status);
		driver.findElement(By.xpath(" //span[@title='Close']")).click();
		Thread.sleep(2500);
		//driver.wait(3000);
		driver.findElement(By.xpath("//span[@class='cart-label']")).click();
		WebElement quantitybox=driver.findElement(By.xpath("//input[@name='itemquantity11842']"));

	}

}
