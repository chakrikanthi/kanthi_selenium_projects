package DifferentWebsitesTesting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TheInternetherokuappwebsitetesting {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions act= new Actions(driver);
		
		
		 // Add/Remove Elements
		 
		  js.executeScript("document.getElementsByTagName('a')[2].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
			
		WebElement AddElement=driver.findElement(By.xpath("//button[text()='Add Element']"));
				
		for(int i=1; i<=5;i++) {
			AddElement.click();
		}
		System.out.println("5 ELEMENTS ADDED");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		System.out.println("1 Element deleted");
		// navigate back to original page
		driver.navigate().back();
		 js.executeScript("document.getElementsByTagName('a')[2].style.border='5px green solid'");
//		output:5 ELEMENTS ADDED
//		1 Element deleted
	   
		//Basic Auth
		//video link for this :How to Handle Authentication Popup in Selenium Web Driver:https://www.youtube.com/watch?v=cj8z9_c6ejo
	   
		js.executeScript("document.getElementsByTagName('a')[3].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		String text= driver.findElement(By.cssSelector("p")).getText();
		System.out.println(text);
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(2500);
		js.executeScript("document.getElementsByTagName('a')[3].style.border='5px green solid'");
		//output:Congratulations! You must have the proper credentials.
		
		//Broken images
		js.executeScript("document.getElementsByTagName('a')[4].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Broken Images']")).click();
		//Method1:
		WebElement image1=driver.findElement(By.xpath("//*[@id='content']//div//img[1]"));
		WebElement image2=driver.findElement(By.xpath("//*[@id='content']//div//img[2]"));
		WebElement image3=driver.findElement(By.xpath("//*[@id='content']//div//img[3]"));
		//first we will find the width of a image, if the image in not in good condition then width will be zero
		if(image1.getAttribute("naturalWidth").equals("0"))
		{
			System.out.println("image1 is broken");
		}
		if(image2.getAttribute("naturalWidth").equals("0"))
		{
			System.out.println("image2 is broken");
		}
		if(image3.getAttribute("naturalWidth").equals("0"))
		{
			System.out.println("image3 is broken");
		}else
		{
			System.out.println("image3 is not broken");
		}
		//Method2
		String[] imageXpath= {
				"//*[@id='content']//div//img[1]",
				"//*[@id='content']//div//img[2]",
				"//*[@id='content']//div//img[3]"
				
		};
		for (String imagepath : imageXpath) {
			WebElement image= driver.findElement(By.xpath(imagepath));
			
			if(image.getAttribute("naturalWidth").equals("0"))
			{
				System.out.println(imagepath+"is broken");
			}
			else 
				System.out.println(imagepath+"is not broken");
		}
		output://*[@id='content']//div//img[1]is broken
			//*[@id='content']//div//img[2]is broken
			//*[@id='content']//div//img[3]is not broken
			
			
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[4].style.border='5px green solid'");
//		output:image1 is broken
//		image2 is broken
//		image3 is not broken
		
		 
		//Challenging DOM(didn't know what to do)
		js.executeScript("document.getElementsByTagName('a')[5].style.border='5px red solid'");
	    driver.findElement(By.xpath("//a[text()='Challenging DOM']")).click();
	   //Challenging DOM--table 
	    List<WebElement> firstrow=driver.findElements(By.xpath("//DIV[@CLASS='large-10 columns']//th"));
	    System.out.println(firstrow.size());
	    
	    System.out.println(driver.findElement(By.xpath("//DIV[@CLASS='large-10 columns']//tr[4]")).getText());
	    Thread.sleep(4000);
	    //driver.findElement(By.xpath("//div[@class='large-2 columns']//a[@id='540d92a0-b982-013c-ea8a-4e0304c30c82'][@class='button'][text()='bar']")).click();
		//driver.findElement(By.xpath("//div[@class='large-2 columns']//a[@id='e7c7b2b0-b981-013c-e9fa-4e0304c30c82'][text()='foo']")).click();
		//driver.findElement(By.xpath("//a[@id='2364a1f0-b981-013c-e91f-4e0304c30c82'][text()='qux']")).click();
	    driver.navigate().back();
	    js.executeScript("document.getElementsByTagName('a')[5].style.border='5px green solid'");
	    
//	    output:
//	    	7
//	    	Iuvaret3 Apeirian3 Adipisci3 Definiebas3 Consequuntur3 Phaedrum3 edit delete
 
 
	    
	    //check boxes
	      js.executeScript("document.getElementsByTagName('a')[6].style.border='5px red solid'");
	     
	    driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();
	    WebElement checkbox1=driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]"));
	    checkbox1.click();
	    boolean chk1=checkbox1.isSelected();
	    if(chk1==true)
	    {
	    	System.out.println("checkbox1 is selected");
	    }
	    else 
	    	System.out.println("checkbox1 not  selected");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//form[@id='checkboxes']//input[2]")).click();
	    driver.navigate().back();
	    js.executeScript("document.getElementsByTagName('a')[6].style.border='5px green solid'");
	   // output: checkbox1 is selected
	    
	    //Context Menu
	    js.executeScript("document.getElementsByTagName('a')[7].style.border='5px red solid'");
	    driver.findElement(By.xpath("//a[text()='Context Menu']")).click();
	    WebElement  rightclickbox=driver.findElement(By.xpath("//div[@id='hot-spot'][1]"));
	   
	    act.contextClick(rightclickbox).perform();
	    System.out.println(driver.switchTo().alert().getText());
	    driver.switchTo().alert().accept();
	    driver.navigate().back();
	    js.executeScript("document.getElementsByTagName('a')[7].style.border='5px green solid'");
	   // output:You selected a context menu
	    
	    
	    
	    //Digest Authentication (user and pass: admin)
		js.executeScript("document.getElementsByTagName('a')[8].style.border='5px red solid'");
	    driver.findElement(By.xpath("//a[text()='Digest Authentication']")).click();
	    
	    //video link for this :How to Handle Authentication Popup in Selenium Web Driver:https://www.youtube.com/watch?v=cj8z9_c6ejo
	    driver.get("http://admin:admin@the-internet.herokuapp.com/digest_auth");
		String text1= driver.findElement(By.cssSelector("p")).getText();
		System.out.println(text1);
		driver.navigate().back();
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[8].style.border='5px green solid'");
		
		//output:Congratulations! You must have the proper credentials.
		 
		 
		
	    //Disappearing Elements
	      js.executeScript("document.getElementsByTagName('a')[9].style.border='5px red solid'");
	    driver.findElement(By.xpath("//a[text()='Disappearing Elements']")).click();
	    driver.findElement(By.xpath("//li//a[text()='About']")).click();
	    System.out.println(driver.getPageSource());
	    String message=driver.findElement(By.xpath("//h1[text()='Not Found']")).getText();
	    if(message.equals("Not Found")) {
	    	System.out.println("successfully clicked on About");
	    }
	    Thread.sleep(2000);
	    driver.navigate().back();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//li//a[text()='Contact Us']")).click();
	    
	    driver.navigate().back();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//li//a[text()='Portfolio']")).click();
	    driver.navigate().back();
	    Thread.sleep(2000);
	    //driver.findElement(By.xpath("//li//a[text()='Gallery']")).click();
	    //driver.navigate().back();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//li//a[text()='Home']")).click();
	    driver.navigate().back();
	    driver.navigate().back();
	    js.executeScript("document.getElementsByTagName('a')[9].style.border='5px green solid'");
//	    output:<html><head></head><body><h1>Not Found</h1></body></html>
//	    successfully clicked on About
	    
	    
	    //drag and drop
	    js.executeScript("document.getElementsByTagName('a')[10].style.border='5px red solid'");
	    driver.findElement(By.xpath("//a[text()='Drag and Drop']")).click();
	    WebElement firstbox=driver.findElement(By.xpath("//div[@id='column-a']"));
	    WebElement secondbox=driver.findElement(By.xpath("//div[@id='column-b']"));
	    act.dragAndDrop(firstbox, secondbox).perform();
	    System.out.println("Drag and drop done successfully");
	    driver.navigate().back();
	    js.executeScript("document.getElementsByTagName('a')[10].style.border='5px green solid'");
	    
	    //output:Drag and drop done successfully
	    
	    
	    //Dropdown
	     js.executeScript("document.getElementsByTagName('a')[11].style.border='5px red solid'");
	    driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
	    WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown']"));
	    Select options= new Select(dropdown);
	    List<WebElement> courselist= options.getOptions();
		// getting all the options in the drop down
		for(WebElement option:courselist) {
			System.out.println(option.getText());
		}
	    options.selectByVisibleText("Option 2");
	    
	    System.out.println("option 2 got selected");
	    Thread.sleep(2500);	  
	    driver.navigate().back();
	    js.executeScript("document.getElementsByTagName('a')[11].style.border='5px green solid'");
	    
//	    output:Please select an option
//	    Option 1
//	    Option 2
//	    option 2 got selected
	    
	    //dynamic content
	      js.executeScript("document.getElementsByTagName('a')[12].style.border='5px red solid'");
	    driver.findElement(By.xpath("//a[text()='Dynamic Content']")).click();
	    driver.findElement(By.xpath("//a[text()='click here']")).click();
	    boolean displaystatus=driver.findElement(By.xpath("//div[@class='large-2 columns']//img")).isDisplayed();
	    assertTrue(displaystatus);
	    System.out.println("image is displayed");
	    
	    Thread.sleep(2000);
	    driver.navigate().back();
	    driver.navigate().back();
	    Thread.sleep(2000);
	   js.executeScript("document.getElementsByTagName('a')[12].style.border='5px green solid'");
	   
	   //output:image is displayed
	    
	    
	   
	   //dynamic control
	   js.executeScript("document.getElementsByTagName('a')[13].style.border='5px red solid'");
	   driver.findElement(By.xpath("//a[text()='Dynamic Controls']")).click();
	   driver.findElement(By.xpath("//button[text()='Remove']")).click();
	   String actualmessage=driver.findElement(By.xpath("//p[@id='message']")).getText();
	   System.out.println(actualmessage);
	
	   if(actualmessage.equals("It's gone!"))
	   {
		   System.out.println("Remove button clicked ");
	   }
	  Thread.sleep(3000);
	  WebElement addbutton= driver.findElement(By.xpath("//button[text()='Add']"));
	boolean  addbuttonstatus=addbutton.isDisplayed();
	if (addbuttonstatus==true) {
		driver.findElement(By.xpath("//button[text()='Add']")).click();
	}
	 
	  driver.findElement(By.xpath("//button[text()='Enable']")).click();
	  Thread.sleep(3000);
	  
	WebElement  txtbox=driver.findElement(By.xpath("//input[@type='text']"));
	boolean txtboxstatus=txtbox.isEnabled();
	if(txtboxstatus==true) {
		System.out.println("text box status is enabled ");
		 txtbox.sendKeys("Kanthi");
	}
	  
	  driver.navigate().back();
	  js.executeScript("document.getElementsByTagName('a')[13].style.border='5px green solid'");
//	  output:It's gone!
//	  Remove button clicked 
//	  text box status is enabled 
	  
		
	  //Dynamic Loading
	    js.executeScript("document.getElementsByTagName('a')[14].style.border='5px red solid'");
	  driver.findElement(By.xpath("//a[text()='Dynamic Loading']")).click();
	  driver.findElement(By.xpath("//a[text()='Example 1: Element on page that is hidden']")).click() ;
	  driver.findElement(By.xpath("//button[text()='Start']")).click();
	  //WebElement hellomessage=driver.findElement(By.xpath("//div[@class='example']//div//h4[text()='Hello World!']"));
	  WebElement hellomessage= driver.findElement(By.xpath("//div[@class='example']//div[3]//h4[text()='Hello World!']"));
	  //assertTrue(hellomessage);
	  Thread.sleep(4000);
	  System.out.println(hellomessage.isDisplayed());
	  driver.navigate().back();
	  driver.findElement(By.xpath("//a[text()='Example 2: Element rendered after the fact']")).click();
	  driver.findElement(By.xpath("//div[@class='example']//div//button[text()='Start']")).click();
	  WebElement hellomessage2=driver.findElement(By.xpath("//div[@class='example']//div//h4[text()='Hello World!']"));
	  Thread.sleep(4000);
	  System.out.println(hellomessage2.isDisplayed());
	  driver.navigate().back();
	  driver.navigate().back();
	  js.executeScript("document.getElementsByTagName('a')[14].style.border='5px green solid'");
	  
//	  output:false(it was suppose to be true)
//             true
	  
		//File download
		js.executeScript("document.getElementsByTagName('a')[17].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='File Download']")).click();
		driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
		System.out.println("some-file.txt got dowloaded");
		
		driver.findElement(By.xpath("//a[text()='selenium-snapshot.png']")).click();
		System.out.println("selenium-snapshot.png got dowloaded");
		Thread.sleep(2000);
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[17].style.border='5px green solid'");
//		output:some-file.txt got dowloaded
//		selenium-snapshot.png got dowloaded
		
		
		//File Upload
		js.executeScript("document.getElementsByTagName('a')[18].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='File Upload']")).click();
		driver.findElement(By.xpath("//div[@id='drag-drop-upload']")).click();
		Robot rb= new Robot();
		rb.delay(2000);
		StringSelection SS= new StringSelection("C:\\Users\\chakr\\Desktop\\some-file.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(SS, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
				rb.delay(3000);
	     System.out.println("File got pasted");		
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();	
		System.out.println("File got uploaded");
		driver.navigate().back();
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[18].style.border='5px green solid'");
	    
//		output:File got pasted
//		File got uploaded
 
 
		
		//Floating menu
		js.executeScript("document.getElementsByTagName('a')[19].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Floating Menu']")).click();
		WebElement home=driver.findElement(By.xpath("//a[text()='Home']"));
	    boolean homedisplay=home.isDisplayed();
	    System.out.println(homedisplay);
	    assertTrue(homedisplay);
	    Thread.sleep(2500);
	    js.executeScript("window.scrollBy(0,2000)");
	    Thread.sleep(3500);
	    System.out.println(homedisplay);
	    Thread.sleep(3000);
	    js.executeScript("window.scrollBy(0,4000)");
	    assertTrue(homedisplay);
	    driver.navigate().back();
	    js.executeScript("document.getElementsByTagName('a')[19].style.border='5px green solid'");
	    
//	    output:true
//	    true
	    
	    //Forgot Password
		js.executeScript("document.getElementsByTagName('a')[20].style.border='5px red solid'");
	    
	    driver.findElement(By.xpath("//a[text()='Forgot Password']")).click();
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sri@gmail.com");
	 
	    driver.findElement(By.xpath("//i[text()='Retrieve password']")).click();
	    
	    System.out.println("forgot password link sent to the above email id");
	    driver.navigate().back();
	    driver.navigate().back();
	    js.executeScript("document.getElementsByTagName('a')[20].style.border='5px green solid'");
	    //output:forgot password link sent to the above email id
	     
	     
	    
	    //Form Authentication
	    js.executeScript("document.getElementsByTagName('a')[21].style.border='5px red solid'");

		driver.findElement(By.xpath("//a[text()='Form Authentication']")).click();
	    WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
	    username.sendKeys("tomsmith");
	    		    
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
	    driver.findElement(By.xpath("//button[@class='radius']//i")).click();
	    String messagetxt=driver.findElement(By.xpath("//div[@id='flash-messages']")).getText();
		System.out.println(messagetxt);
				
	    driver.findElement(By.xpath("//a[@class='button secondary radius']//i[text()=' Logout']")).click();
		for(int i=1;i<=3;i++)
		{
			driver.navigate().back();
		}
	    js.executeScript("document.getElementsByTagName('a')[21].style.border='5px green solid'");

		//output:You logged into a secure area!    X
		
		
		//Nested Frames
	    js.executeScript("document.getElementsByTagName('a')[22].style.border='5px red solid'");

		driver.findElement(By.xpath("//a[text()='Frames']")).click();
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		Thread.sleep(3000);
		String mainframe=driver.getWindowHandle();
		
		System.out.println(mainframe);
		
		int framecount=driver.findElements(By.tagName("frame")).size();
		System.out.println(framecount);//3 frames are in one set and another frame is another set, so it's displaying 2 here
		driver.switchTo().frame(1);
		System.out.println(driver.getWindowHandle());
		String bottomframe= driver.findElement(By.tagName("body")).getText();	
		System.out.println(bottomframe);
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame-top");
				
		driver.switchTo().frame("frame-left");
		
		String leftframe= driver.findElement(By.tagName("body")).getText();
		System.out.println(leftframe);
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame-middle");
		String middleframe= driver.findElement(By.tagName("body")).getText();
		System.out.println(middleframe);
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame-right");
		String rightframe= driver.findElement(By.tagName("body")).getText();
		System.out.println(rightframe);
		
		driver.switchTo().defaultContent();
	   
//		 output for nested frames:
//		 * 4532263EBBA5BD64165A1170028819BE
//           2
//           4532263EBBA5BD64165A1170028819BE
//           BOTTOM
//           LEFT
//           MIDDLE
//           RIGHT
		 
		
		driver.navigate().back();
		
		//iframes
		driver.findElement(By.xpath("//a[text()='iFrame']")).click();
		WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(iframe);
		WebElement iframetextbox=driver.findElement(By.id("tinymce"));
		Thread.sleep(3000);
		
		iframetextbox.clear();
		Thread.sleep(3000);
		iframetextbox.sendKeys("This is a sample text for testing the iframes");
		Thread.sleep(3000);
		System.out.println(iframetextbox.getText());
		driver.switchTo().defaultContent();
		driver.navigate().back();
		driver.navigate().back();
		 js.executeScript("document.getElementsByTagName('a')[22].style.border='5px green solid'");

		//output:This is a sample text for testing the iframes
		//geolocation(didn't do it)
		
		//Horizontal Slider
		js.executeScript("document.getElementsByTagName('a')[24].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Horizontal Slider']")).click();
		WebElement slider=driver.findElement(By.xpath("//input[@value='0']"));
		
		act.dragAndDropBy(slider, 100, 250).perform();
		System.out.println("slider got moved to location 5 successfully");
		Thread.sleep(2000);
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[24].style.border='5px green solid'");
		//output:slider got moved to location 250 successfully
		
		//Hovers
	    js.executeScript("document.getElementsByTagName('a')[25].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Hovers']")).click();
		WebElement user1img=driver.findElement(By.xpath("//div[@class='figure'][1]//img"));
		WebElement profile1=driver.findElement(By.xpath("//div[@class='figure'][1]//div[1]//a[1]"));
		act.moveToElement(user1img).perform();
		act.moveToElement(profile1).click().perform();
		Thread.sleep(2500);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		
		
		WebElement user2img=driver.findElement(By.xpath("//div[@class='figure'][2]//img"));
		WebElement profile2=driver.findElement(By.xpath("//div[@class='figure'][2]//div[1]//a[1]"));
		act.moveToElement(user2img).perform();
		act.moveToElement(profile2).click().perform();
		Thread.sleep(2500);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		
		
		WebElement user3img=driver.findElement(By.xpath("//div[@class='figure'][3]//img"));
		WebElement profile3=driver.findElement(By.xpath("//div[@class='figure'][3]//div[1]//a[1]"));
		act.moveToElement(user3img).perform();
		act.moveToElement(profile3).click().perform();
		Thread.sleep(2500);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[25].style.border='5px green solid'");
		
//			output:https://the-internet.herokuapp.com/users/1
//			https://the-internet.herokuapp.com/users/2
//			https://the-internet.herokuapp.com/users/3
//			https://the-internet.herokuapp.com/hovers
	
		//Infinite Scroll
		 
		js.executeScript("document.getElementsByTagName('a')[26].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Infinite Scroll']")).click();
		js.executeScript("window.scrollBy(500,300)");
		Thread.sleep(3500);
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(3500);
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(3500);
		System.out.println("sucessfully scrolled down");
		driver.navigate().back();
		 js.executeScript("document.getElementsByTagName('a')[26].style.border='5px green solid'");
		//output:sucessfully scrolled down
		 
		 
		//inputs
		js.executeScript("document.getElementsByTagName('a')[27].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Inputs']")).click();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("10");
		Thread.sleep(2500);
		System.out.println("entered number 10");
		driver.findElement(By.xpath("//input[@type='number']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("200");
		System.out.println("entered number 200");
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[27].style.border='5px green solid'");
//		output:entered number 10
//		entered number 200
		
		
		//JQuery UI Menus
		js.executeScript("document.getElementsByTagName('a')[28].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='JQuery UI Menus']")).click();
		WebElement Enabled=driver.findElement(By.xpath("//a[normalize-space()='Enabled']"));
		WebElement downloads=driver.findElement(By.id("ui-id-4"));
		WebElement pdf=driver.findElement(By.id("ui-id-5"));
		WebElement csv=driver.findElement(By.id("ui-id-6"));
		WebElement excel=driver.findElement(By.id("ui-id-7"));
		WebElement BacktoJqueryUI=driver.findElement(By.id("ui-id-8"));
		
		act.moveToElement(Enabled).pause(Duration.ofSeconds(2)).moveToElement(downloads).pause(Duration.ofSeconds(2)).moveToElement(pdf).pause(Duration.ofSeconds(2)).click().build().perform();//as it is chain of action first we need to build it//if it is a single action then we can directly go to perform
		System.out.println("PDF downloaded successfully");
		act.moveToElement(Enabled).pause(Duration.ofSeconds(2)).moveToElement(downloads).pause(Duration.ofSeconds(2)).moveToElement(excel).pause(Duration.ofSeconds(2)).click().build().perform();
		System.out.println("Excel downloaded successfully");
		act.moveToElement(Enabled).pause(Duration.ofSeconds(2)).moveToElement(downloads).pause(Duration.ofSeconds(2)).moveToElement(csv).pause(Duration.ofSeconds(2)).click().build().perform();
		System.out.println("CSV downloaded successfully");
		act.moveToElement(BacktoJqueryUI).click().perform();
		Thread.sleep(3000);
		System.out.println("successfully clicked on Jquery UI");
		driver.navigate().back();
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[28].style.border='5px green solid'");
		//OUTPUT:PDF downloaded successfully
//		Excel downloaded successfully
//		CSV downloaded successfully
//		successfully clicked on Jquery UI
		
		
		
		//JavaScript Alerts
		js.executeScript("document.getElementsByTagName('a')[29].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[normalize-space()='JavaScript Alerts']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	
		System.out.println("You successfully clicked an alert");
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		System.out.println("You clicked: Ok");
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		System.out.println("You clicked: cancel");
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		driver.switchTo().alert().sendKeys("This is a testing text message ");
		driver.switchTo().alert().accept();
		System.out.println("You entered: This is a testing text message");
		
		//output:You successfully clicked an alert
//		You clicked: Ok
//		You clicked: cancel
//		You entered: This is a testing text message
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[29].style.border='5px green solid'");

		
		//Key presses
		
		js.executeScript("document.getElementsByTagName('a')[31].style .border='5px red solid'");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Key Presses']")).click();
		//Option 1
//		driver.findElement(By.id("target")).sendKeys(Keys.SPACE);
//		System.out.println(driver.findElement(By.id("result")).getText());
//		driver.findElement(By.id("target")).sendKeys(Keys.ALT);
//		System.out.println(driver.findElement(By.id("result")).getText());
		
		//option 2
		
		act.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("result")).getText());
		driver.findElement(By.id("target")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("result")).getText());
		driver.navigate().back();
//		output:You entered: DOWN
//		You entered: HOME
		js.executeScript("document.getElementsByTagName('a')[31].style .border='5px green solid'");    
//		output:You entered: DOWN
//		You entered: HOME
		//Large & Deep DOM(didn't do this)	
		
		//Multiple Windows
		js.executeScript("document.getElementsByTagName('a')[33].style .border='5px red solid'");

		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		String window1=driver.getWindowHandle();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Thread.sleep(2500);
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(window1);
		driver.navigate().back();
	    js.executeScript("document.getElementsByTagName('a')[33].style .border='5px green solid'");

//	    output:https://the-internet.herokuapp.com/windows
//	    	https://the-internet.herokuapp.com/windows/new
		
		//Nested Frames
		js.executeScript("document.getElementsByTagName('a')[34].style .border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		driver.switchTo().frame(1);
		System.out.println(driver.getWindowHandle());
		String bottomframe1= driver.findElement(By.tagName("body")).getText();	
		System.out.println(bottomframe1);
        driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame-top");
				
		driver.switchTo().frame("frame-left");
		String leftframe1=driver.findElement(By.tagName("body")).getText();
		System.out.println(leftframe1);
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame-middle");
		String Middleframe= driver.findElement(By.tagName("body")).getText();
		System.out.println(Middleframe);
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame-right");
		String Rightframe= driver.findElement(By.tagName("body")).getText();
		System.out.println(Rightframe);
		driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();
		driver.navigate().back();
	  	js.executeScript("document.getElementsByTagName('a')[34].style .border='5px green solid'");
//       output:BE4A2DD8D4E7CA18517ADA3186A13BF9
//       BOTTOM
//       LEFT
//       MIDDLE
//       RIGHT
	  	
	  	
		
		//Notification Messages
		
		js.executeScript("document.getElementsByTagName('a')[35].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Notification Messages']")).click();
		driver.findElement(By.xpath("//a[text()='Click here']")).click();
		String textmsg=driver.findElement(By.id("flash")).getText();
		System.out.println(textmsg);
		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[35].style.border='5px green solid'");
		Thread.sleep(3000);
		//output:Action unsuccesful, please try again X
		
	     
		
		//Redirect Link
		
		js.executeScript("document.getElementsByTagName('a')[36].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Redirect Link']")).click();
		driver.findElement(By.id("redirect")).click();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		Thread.sleep(2500);
	    WebElement	value101=driver.findElement(By.xpath("//table[@id='table-http-status-codes-1']//tr[2]"));
	   System.out.println( value101.getText());
	    driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='200']")).click();
		String message200=driver.findElement(By.tagName("p")).getText();
		System.out.println(message200);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[36].style.border='5px green solid'");
		
//		output:101 Switching Protocols [RFC9110, Section 15.2.2]
//				This page returned a 200 status code.
//
//				For a definition and common list of HTTP status codes, go here
		
		
		//secure file download
		
		driver.findElement(By.xpath("//a[text()='Digest Authentication']")).click();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.navigate().back();
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[37].style.border='5px red solid'");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Secure File Download']")).click();
		//driver.get("http://admin:admin@https://the-internet.herokuapp.com/download_secure");
		driver.findElement(By.xpath("//a[text()='random_data.txt']")).click();
		System.out.println("random_data.txt  got downloaded");
		driver.findElement(By.xpath("//a[text()='Superman.png']")).click();
		System.out.println("Superman.png got downloaded");
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[37].style.border='5px green solid'");
		
//		output:Project .png got downloaded
//		puppy.png got downloaded
		
		
		
		//Shadow DOM element
		 js.executeScript("document.getElementsByTagName('a')[38].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Shadow DOM']")).click();
		//This Element is inside single shadow DOM.
		String cssSelectorForHost1 = "body > div:nth-child(2) > div:nth-child(2) > my-paragraph:nth-child(4)";
		Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > my-paragraph:nth-child(4)")).getShadowRoot();
		Thread.sleep(1000);
		System.out.println(shadow.findElement(By.cssSelector("p")).getText());
		//This Element is inside single shadow DOM.
		String cssSelectorForHost2 = "body > div:nth-child(2) > div:nth-child(2) > my-paragraph:nth-child(5)";
		Thread.sleep(1000);
		SearchContext shadow2 = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > my-paragraph:nth-child(5)")).getShadowRoot();
		Thread.sleep(1000);
		System.out.println(shadow.findElement(By.cssSelector("p")).getText());
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[38].style.border='5px green solid'");
		//output:
//		Let's have some different text!
//		Let's have some different text!

		
		//Shifting Content
		js.executeScript("document.getElementsByTagName('a')[39].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Shifting Content']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Example 1: Menu Element']")).click();
		
		//WebElement Gallerybtn=driver.findElement(By.xpath("//a[text()='Gallery']"));
		WebElement Gallerybtn=driver.findElement(By.xpath("//a[@class='shift']"));
		Point pointloc=Gallerybtn.getLocation();
		System.out.println(pointloc);
		Rectangle galleryrect=Gallerybtn.getRect();
		System.out.println(galleryrect.getHeight());
		System.out.println(galleryrect.getWidth());
		System.out.println(galleryrect.getX());
		System.out.println(galleryrect.getY());
		System.out.println(galleryrect.getDimension());
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='click here']")).click();
		Thread.sleep(3000);
		System.out.println(pointloc);
		driver.findElement(By.xpath("//p[contains(text(),'To specify a differant numbor of pixels to shift t')]//a[contains(text(),'click here')]")).click();
		driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/p[4]/a[1]")).click();
		
		System.out.println(galleryrect.getHeight());
		System.out.println(galleryrect.getWidth());
		System.out.println(galleryrect.getX());
		System.out.println(galleryrect.getY());
		System.out.println(galleryrect.getDimension());
		System.out.println(pointloc);
		for(int i=1; i<=5;i++)
		{
			driver.navigate().back();
		}
		js.executeScript("document.getElementsByTagName('a')[39].style.border='5px green solid'");
//		output:(893, 292)
//		52
//		105
//		893
//		292
//		(105, 52)
//		(893, 292)

//		52
//		105
//		893
//		292
//		(105, 52)
//		(893, 292)
			
		
		
		
		
		//Slow resourses
		js.executeScript("document.getElementsByTagName('a')[40].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Slow Resources']")).click();
		System.out.println(System.currentTimeMillis());
		Thread.sleep(3000);
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[40].style.border='5px green solid'");
		//output:1709955869583
	
		//Sortable Data Tables
		js.executeScript("document.getElementsByTagName('a')[41].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Sortable Data Tables']")).click();
		WebElement table1secondrow=driver.findElement(By.xpath("//table[@id='table1']//tr[2]"));
		String table1secondrowtxt=table1secondrow.getText();
		
		WebElement table2secondrow=driver.findElement(By.xpath("//table[@id='table2']//tr[2]"));
		String table2secondrowtxt= table2secondrow.getText();
		Thread.sleep(2500);
		if (table1secondrowtxt.equals(table2secondrowtxt)) {
			System.out.println("two tables have same data set of data");
		}
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[41].style.border='5px green solid'");
		//output:two tables have same data set of data
		
		//status codes
		 js.executeScript("document.getElementsByTagName('a')[42].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
		driver.findElement(By.xpath("//a[text()='200']")).click();
		Thread.sleep(3000);
		String txt200=driver.findElement(By.xpath("//p[contains(text(),'This page returned a 200 status code.')]")).getText();
		System.out.println("200 Staus messgae:"+txt200);
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='301']")).click();
		String txt301=driver.findElement(By.xpath("//p[contains(text(),'This page returned a 301 status code.')]")).getText();
		System.out.println("301 Staus messgae:"+txt301);
		Thread.sleep(3000);
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='404']")).click();
		String txt404=driver.findElement(By.xpath("//p[contains(text(),'This page returned a 404 status code.')]")).getText();
		System.out.println("404 Staus messgae:"+txt404);
		Thread.sleep(3000);
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='500']")).click();
		String txt500=driver.findElement(By.xpath("//p[contains(text(),'This page returned a 500 status code.')]")).getText();
		System.out.println("500 Staus messgae:"+txt500);
		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().back();
		
		js.executeScript("document.getElementsByTagName('a')[42].style.border='5px green solid'");
		//output:200 Staus messgae:This page returned a 200 status code.
       
//For a definition and common list of HTTP status codes, go here
//301 Staus messgae:This page returned a 301 status code.
//
//For a definition and common list of HTTP status codes, go here
//404 Staus messgae:This page returned a 404 status code.
//
//For a definition and common list of HTTP status codes, go here
//500 Staus messgae:This page returned a 500 status code.
//
//For a definition and common list of HTTP status codes, go here
     
		
		
		//typos
		 js.executeScript("document.getElementsByTagName('a')[43].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='Typos']")).click();
		String typomessage11=driver.findElement(By.xpath("//p[contains(text(),'This example demonstrates a typo being introduced.')]")).getText();
		Thread.sleep(2500);
		System.out.println(typomessage11);
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[43].style.border='5px green solid'");
		//output:This example demonstrates a typo being introduced. It does it randomly on each page load.
		
		//WYSIWYG Editor
		  js.executeScript("document.getElementsByTagName('a')[44].style.border='5px red solid'");
		driver.findElement(By.xpath("//a[text()='WYSIWYG Editor']")).click();
		WebElement iframebox1=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(iframebox1);
		WebElement iframetextbox11=driver.findElement(By.id("tinymce"));
		Thread.sleep(3000);
		iframetextbox11.clear();
		Thread.sleep(3000);
		iframetextbox11.sendKeys("HI...the internethorokku app testing is finished");
		Thread.sleep(3000);
		System.out.println(iframetextbox11.getText());
		driver.navigate().back();
		js.executeScript("document.getElementsByTagName('a')[44].style.border='5px green solid'");
		//output:HI...the internethorokku app testing is finished
		 
		 /*
		 //entry Ad(it's not working)
	  js.executeScript("document.getElementsByTagName('a')[15].style.border='5px red solid'");
	  driver.findElement(By.xpath("//a[text()='Entry Ad']")).click();
	  String mainwindow= driver.getWindowHandle();
	  String mainwindowtitle= driver.getTitle();
	  System.out.println(mainwindowtitle);
	  driver.findElement(By.xpath("//p//a[@id='restart-ad']")).click();
	  
	  WebElement child=driver.findElement(By.xpath("//div//h3[text()='This is a modal window']"));
	  String childwindow=driver.getWindowHandle();
	  String childwindowtitle=driver.getTitle();
	  System.out.println(childwindowtitle);
	  driver.switchTo().window(childwindow);
	  
	  Set<String> windowids=driver.getWindowHandles();
	  System.out.println(driver.getTitle());
	  
	  //driver.findElement(By.xpath("//div[@class='modal']//div[3]//p[text()='Close']")).click();
	  
	  
	  for(String windowid:windowids) {
		  driver.switchTo().window(windowid);
		  String actualtitle=driver.getTitle();
		  System.out.println(actualtitle);
		  if(actualtitle.equals("THIS IS A MODAL WINDOW"))
		  {
			  System.out.println( driver.getTitle());
			  driver.findElement(By.xpath("//div[@class='modal']//div[3]//p[text()='Close']")).click();
		  }
	  }
	  
	  
	  
	  driver.findElement(By.xpath("//div[@class='modal']//div[1]//h3[normalize-space()='This is a modal window']"));
	  ////h3[normalize-space()='This is a modal window']
		Set <String> allwindows=driver.getWindowHandles();
	  System.out.println(allwindows);
	  for(String allwindow:allwindows) {
			
			if(!allwindow.equals(mainwindow))
			{
				driver.switchTo().window(allwindow);
				
				System.out.println(allwindow+driver.getTitle());
	      	  driver.findElement(By.xpath("//div[@class='modal']//div[3]//p[text()='Close']")).click();
			}
	  }
		 */
	}

}
