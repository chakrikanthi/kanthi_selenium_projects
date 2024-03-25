package DifferentWebsitesTesting;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SwagLabswebsitetesting {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for(int i=1; i<=3;i++)
		{
		WebElement Username=driver.findElement(By.xpath("//input[@id='user-name']"));
		WebElement Password=driver.findElement(By.xpath("//input[@id='password']"));
		WebElement loginbutton=driver.findElement(By.xpath("//input[@id='login-button']"));
		Username.sendKeys("standard_user");
		Password.sendKeys("secret_sauce");
		loginbutton.click();
		WebElement Backpack=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		WebElement boltTshirt=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
		WebElement onesie=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"));
		WebElement Bikelight=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
		WebElement fleecejacket=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
		WebElement allthethings=driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"));
		Backpack.click();
		WebElement removebutton=driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
		boolean removestatu=removebutton.isDisplayed();
		Assert.assertTrue(removestatu);
		System.out.println("Backpack got selected");
//		if(removestatu==true)
//		{
//			System.out.println("Backpack got selected");
//		}
		System.out.println("order:");
		boltTshirt.click();
		System.out.println("boltTshirt got selected");
		onesie.click();
		System.out.println("onesie got selected");
		Bikelight.click();
		System.out.println("Bikelight got selected");
		fleecejacket.click();
		System.out.println("fleecejacket got selected");
		allthethings.click();
		System.out.println("allthethings got selected");
		
		WebElement shoppingcart=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		shoppingcart.click();
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
		System.out.println("backpack got removed");
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		WebElement Firstname=driver.findElement(By.xpath("//input[@id='first-name']"));
		WebElement Lastname=driver.findElement(By.xpath("//input[@id='last-name']"));
		WebElement Zipcode=driver.findElement(By.xpath("//input[@id='postal-code']"));
		String str=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(5);
		Firstname.sendKeys(str);
		Lastname.sendKeys(str);
		Zipcode.sendKeys(num);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		WebElement successmsg=driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
		if(successmsg.isDisplayed()){
			System.out.println("Order been placed successfully");
		}
		else
		{
			System.out.println("Order didn't placed");
		}
		WebElement backhomebtn=driver.findElement(By.xpath("//button[text()='Back Home']"));
		Assert.assertEquals(backhomebtn.isDisplayed(), true);
		backhomebtn.click();
		WebElement menubar=driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
		menubar.click();
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
			
		}
		
	}
	}


