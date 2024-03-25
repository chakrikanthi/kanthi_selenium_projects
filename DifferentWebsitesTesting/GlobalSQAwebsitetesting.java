package DifferentWebsitesTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GlobalSQAwebsitetesting {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/");
        driver.findElement(By.xpath("//a[text()='Tabs']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[text()='Slider']")).click();
        
        Actions act=new Actions(driver);
        WebElement redslider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
       
       act.clickAndHold(redslider);
      
      
      
	}

}
