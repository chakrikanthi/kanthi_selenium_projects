package DifferentWebsitesTesting;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Testautomationpracticewebsite {

	public static void main(String[] args) throws InterruptedException {
/* Enter name: kanthi
 * Email:
 * Phone:
 * Address:
 *  In Gender: select Female
 *  In Days: select Monday, Tuesday
 *  Country: India
 *  Colors:Blue & White
 *  Date: select November 30, 2023
 *  Pagination Table: select Product 1 & Product 2
 *  
 */
      WebDriver driver= new ChromeDriver();
      driver.get("https://testautomationpractice.blogspot.com/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      String firstwindow= driver.getWindowHandle();
		
      driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Kanthi");
      driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Kanthi@gmail.com");
      driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("404-000-6666");
      driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("Pleasant hill rd, Atlanta, GA");
      driver.findElement(By.xpath("//input[@id='female']")).click();
      
      driver.findElement(By.xpath("//input[@id='monday']")).click();
      driver.findElement(By.xpath("//input[@id='tuesday']")).click();
      driver.findElement(By.xpath("//input[@id='wednesday']")).click();
      //WebElement  drpcountryEle=driver.findElement(By.xpath("//select[@id='country']"));
      //;Select drpcountry= new Select(drpcountryEle);  instead of writing the line 39 & 40 we can write single line 41
      Select drpcountry= new Select(driver.findElement(By.xpath("//select[@id='country']")));
      List<WebElement> countrylist= drpcountry.getOptions();
     System.out.println( drpcountry.isMultiple());
      
      //SLECT OPTION FROM DROPDOWN MENU FROM COUNTRY
      
      drpcountry.selectByVisibleText("India");
      
      Select color= new Select(driver.findElement(By.xpath("//select[@id='colors']")));
      List<WebElement> colcorslist=color.getOptions();
	
	   color.selectByVisibleText("Red");
	   
	  List<WebElement> BookName=driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
	 System.out.println(BookName.size());
	
	 
	 WebElement firstrow=driver.findElement(By.xpath("//table[@name='BookTable']//tr[2]"));
	 System.out.println(firstrow.getText());
	 
	 WebElement lastrow=driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]"));
	 System.out.println(lastrow.getText());
	 Actions act= new Actions(driver);
	 //act.dragAndDropBy(lastrow,600, 600).perform();
	 driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[1]//td[4]//input[@type='checkbox']")).click();
	 driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[5]//td[4]//input[@type='checkbox']")).click();
	 System.out.println(driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[2]")).getText());
	 driver.findElement(By.xpath("//ul//a[text()='2']")).click();
	 driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[2]//td[4]//input[@type='checkbox']")).click();
	 Thread.sleep(4000);
	 
	 driver.findElement(By.xpath("//button[text()='New Browser Window']")).click();
	 
	 driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
	 assertTrue(driver.findElement(By.xpath("//img[@title='Your Store']")).isDisplayed());
	 driver.switchTo().window(firstwindow);
	 Thread.sleep(4000);
	 driver.findElement(By.xpath("//button[text()='Alert']")).click();
	 driver.switchTo().alert().getText();
	 driver.switchTo().alert().accept();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
	 System.out.println(driver.switchTo().alert().getText());
	 driver.switchTo().alert().accept();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[text()='Prompt']")).click();
	 Thread.sleep(4000);
	 driver.switchTo().alert().sendKeys("kanthi");
	 //Thread.sleep(3000);
	//System.out.println(driver.findElement(By.xpath("//div//p[@id='demo']")).getText()); 
	 System.out.println(driver.switchTo().alert().getText());
	 driver.switchTo().alert().accept();
	 Thread.sleep(2000);
	 WebElement copytext=driver.findElement(By.xpath("//button[text()='Copy Text']"));
	 act.doubleClick(copytext).perform();
	 Thread.sleep(2000);
	
	 WebElement firstbox= driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
	 System.out.println(firstbox.getText());
	 WebElement SecondBox=driver.findElement(By.xpath("//p[text()='Drop here']"));
	 System.out.println(SecondBox.getText());
	 act.dragAndDrop(firstbox, SecondBox).perform();
	 
	 WebElement slidder=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
	 act.dragAndDropBy(slidder, 100, 50).perform();
	 System.out.println("slider location:"+slidder.getLocation());
	 WebElement iframe= driver.findElement(By.xpath("//IFRAME[@ID='frame-one796456169']"));
	 driver.switchTo().frame(iframe);
	 driver.findElement(By.xpath("//input[@id='RESULT_TextField-0']")).sendKeys("kanthi");
	 driver.findElement(By.xpath("//table[@class='inline_grid choices']//tr[2]//td//label[text()='Female']")).click();
	 //driver.findElement(By.xpath("//p[@class='description']//span")).click();
	 driver.findElement(By.xpath("//input[@name='RESULT_TextField-2']")).sendKeys("03/01/2024");
	 //driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tr[5]//a[text()=25]")).click();
	Select jobs=new Select(driver.findElement(By.id("RESULT_RadioButton-3")));
	jobs.selectByVisibleText("Manager");
	driver.findElement(By.xpath("//input[@name='Submit']")).click();
	driver.switchTo().defaultContent();
	System.out.println(driver.getTitle());
    driver.findElement(By.xpath("//a[text()='orange HRM']")).click();
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	System.out.println(driver.getTitle());
	driver.quit();
	}

}
