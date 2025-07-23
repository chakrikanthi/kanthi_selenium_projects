package globalSQAwebsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class XyzBanking {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Customer login
		driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).click();
		WebElement Yourname=driver.findElement(By.id("userSelect"));
		Select yournamelist= new Select(Yourname);
		yournamelist.selectByValue("2");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		//withdrawl when there is no amount in the account--verifying the error message is displaying or not
		driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
		driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("100");
		driver.findElement(By.xpath("//button[normalize-space()='Withdraw']")).click();
		WebElement Errormsg=driver.findElement(By.xpath("//span[@ng-show='message']"));
		boolean errormsgstatus=Errormsg.isDisplayed();
		if(errormsgstatus==true) {
			System.out.println("Error message is displayed:Transaction Failed. You can not withdraw amount more than the balance");
		}
		
		//Despositing money into account
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Logout']"));
		
		driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).click();
		
		yournamelist.selectByValue("3");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//div[@ng-hide='noAccount']//button[contains(text(),'Deposit')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1000");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String Actualmessage=driver.findElement(By.xpath("//span[@ng-show='message']")).getText();
		String Expectedmessage="Deposit Successful";
		Assert.assertEquals(Actualmessage, Expectedmessage);
		
		//Withdraw from account and update the balance
		
		
		
		
		
		
	}

}
