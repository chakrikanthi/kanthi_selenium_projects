package DifferentWebsitesTesting;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Letskodeitpracticewebsite {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		String mainwindow= driver.getWindowHandle();
		System.out.println(mainwindow+driver.getTitle());
		driver.findElement(By.id("bmwradio")).click();
		driver.findElement(By.xpath("//label//input[@id='hondacheck']")).click();
		driver.findElement(By.xpath("//button[@id='openwindow']")).click();


		Set <String> allwindows= driver.getWindowHandles();
		for(String allwindow:allwindows) {
			
			if(!allwindow.equals(mainwindow))
			{
				driver.switchTo().window(allwindow);
				driver.manage().window().maximize();
				System.out.println(allwindow+driver.getTitle());
				driver.findElement(By.xpath("//a[normalize-space()='INTERVIEW']")).click();
				//Thread.sleep(3500);
				driver.close();
			}
			
								
		}
		driver.switchTo().window(mainwindow);
		driver.findElement(By.xpath("//a[@id='opentab']")).click();
		//driver.switchTo()
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		driver.findElement(By.xpath("//a[normalize-space()='SUPPORT']")).click();
		driver.findElement(By.id("name")).sendKeys("testing txt");
		driver.close();
		driver.switchTo().window(mainwindow);
		WebElement cars=driver.findElement(By.xpath("//select[@id='carselect']"));
		Select carmodels= new Select(cars);
		List<WebElement>carslist= carmodels.getOptions();
		System.out.println("Carlist Options are:");
		for(WebElement option:carslist) {
			System.out.println(option.getText());
		}
		driver.findElement(By.xpath("//option[text()='Honda']")).click();
		WebElement multi= driver.findElement(By.xpath("//select[@id='multiple-select-example']"));
        Select multichoice= new Select(multi);
        List <WebElement> multichoices= multichoice.getOptions();
        System.out.println("Multipule choice options are:");
        
        for(WebElement option:multichoices) {
			System.out.println(option.getText());
		}
        
        driver.findElement(By.xpath("//option[text()='Orange']")).click();
        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("this is a auto text");
        driver.findElement(By.xpath("//input[@id='enabled-button']")).click();
        driver.findElement(By.xpath("//input[@id='enabled-example-input']")).sendKeys("sample text for test");
        driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
        driver.findElement(By.xpath("//input[@id='show-textbox']")).click();
        
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('displayed-text').setAttribute('style', 'border:5px blue dotted;background:yellow')");
        
        driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("second text");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Satvik");
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        //Thread.sleep(3000);
        System.out.println("Alert message is:"+driver.switchTo().alert().getText());
       // Thread.sleep(3000);
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Vivek");
        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
        System.out.println("confirmation  message is:"+driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Actions act= new Actions(driver);
        WebElement mouseover=driver.findElement(By.xpath("//button[@id='mousehover']"));
        WebElement topmouseaction= driver.findElement(By.xpath("//a[text()='Top']"));
        
        act.moveToElement(mouseover).build().perform();
        act.moveToElement(topmouseaction).click().build().perform();
        //Thread.sleep(3000);
      List<WebElement> autorslist= driver.findElements(By.xpath("//td[@class='author-name']"));
      System.out.println("List of Authors are:");
          for(WebElement options:autorslist) {
			System.out.println(options.getText());
		} 
          
          List <WebElement>Coursenames=driver.findElements(By.xpath("//td[@class='course-name']"));
          System.out.println("List of courses are:");
          for(WebElement list:Coursenames) {
			System.out.println(list.getText());
		} 
         List<WebElement> Prices=driver.findElements(By.xpath("//td[@class='price']"));
         System.out.println("Price of the products are:");
        for(WebElement price:Prices) {
        	
        	System.out.println(price.getText());
        	
        }
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,400)");//This line will move down the scroll bar--as it contains positive value
		  driver.switchTo().frame("courses-iframe"); 
		  Thread.sleep(3000);
		  js.executeScript("window.scrollBy(0,-600)");// this line will scroll up the scrolling bar-- as it contains Negative value
		  Thread.sleep(3000);
		  WebElement courses=driver.findElement(By.xpath("//a[text()='ALL COURSES']"));
		  System.out.println(courses.getLocation()); 
		  courses.click();
		  driver.findElement(By.xpath("//input[@id='search']")).sendKeys("javascript");
		 Thread.sleep(4000);
		 driver.switchTo().defaultContent(); 
		 act.dragAndDropBy(courses,1200, 1000).perform();
		 js.executeScript("document.getElementById('autosuggest').setAttribute('style', 'border:5px blue dotted;background:yellow')" ); 
		 driver.findElement(By.xpath("//input[@id='autosuggest']")).clear();
		 WebElement text=driver.findElement(By.xpath("//input[@id='autosuggest']"));
		 text.sendKeys("Modified text");
		 //this below line is not printing
		 System.out.println(text.getText()); 
		 driver.quit();
		 	}

}
