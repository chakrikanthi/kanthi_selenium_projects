package omayowebsite;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class omayowebsitetesting {


	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String mainwindow=driver.getWindowHandle();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10)); 
		
		//This blog is created for http://www.Selenium143.blogspot.com
		WebElement Bloglink=driver.findElement(By.xpath("//a[@id='selenium143']"));
		Bloglink.click();
		Thread.sleep(2000);
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		driver.close();
		driver.switchTo().window(mainwindow);

		//Multi Selection box
		WebElement multiselectionbox=driver.findElement(By.xpath("//select[@id='multiselect1']"));
		Select select= new Select(multiselectionbox);
		select.selectByValue("swiftx");
		select.selectByValue("Hyundaix");

		WebElement combobox=driver.findElement(By.xpath("//select[@id='drop1']"));
		Select select1= new Select(combobox);
		select1.selectByValue("ghi");

		//Selenium143 link 1
		WebElement link1=driver.findElement(By.xpath("//a[@id='link1']"));
		link1.click();
		Thread.sleep(1200);
		driver.navigate().back();
		//Selenium143 link2
		WebElement link2=driver.findElement(By.xpath("//a[@id='link2']"));
		link2.click();
		Thread.sleep(1200);
		driver.navigate().back();

		//text box with preloaded text
		WebElement preloadedtxtbox=driver.findElement(By.xpath("//input[@id='textbox1']"));
		String prefilledtxt=preloadedtxtbox.getText();
		System.out.println(prefilledtxt);
		preloadedtxtbox.clear();
		preloadedtxtbox.sendKeys("New text is entered and previous text got deleted");


		//Opens In New Window Link
		System.out.println("output of Opens In New Window Link:");
		System.out.println(driver.getTitle());
		WebElement seleniumtutorialink=driver.findElement(By.xpath("//a[@id='link2'][text()='SeleniumTutorial']"));
		seleniumtutorialink.click();
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		System.out.println(driver.getTitle());
		WebElement seleniumtxt=driver.findElement(By.xpath("//a[text()='What is Selenium?']"));
		seleniumtxt.click();
		Thread.sleep(1500);
		driver.close();
		driver.switchTo().window(mainwindow);

		//Enabled Button
		System.err.println("output of Enabled Button:");
		WebElement EnabledButton=driver.findElement(By.xpath("//button[@id='but2']"));
		EnabledButton.click();
		System.out.println(EnabledButton.isEnabled()+":true means button is in enabled status");

		//Disabled Button
		System.err.println("output of disabled Button:");
		JavascriptExecutor jsexe= (JavascriptExecutor)driver;
		jsexe.executeScript("document.getElementById('but1').style.border='5px red solid'");
		WebElement DisabledButton=driver.findElement(By.id("but1"));
		System.out.println(DisabledButton.isEnabled()+":false means button is in disabled status");

		//Disabled Text Box
		System.err.println("output of disabled Button:");
		jsexe.executeScript("document.getElementById('tb2').style.border='5px yellow solid'");
		WebElement Disabledtextbox=driver.findElement(By.id("tb2"));
		System.out.println(Disabledtextbox.isEnabled()+":false means text box  is in disabled status");


		//Buttons with same name attribute values
		System.err.println("Buttons with same name attribute values output is:");
		jsexe.executeScript("document.getElementsByName('samename')[0].style.border='5px red solid'");
		WebElement Submitbtn=driver.findElement(By.xpath("//button[text()='Submit']"));
		System.out.println(Submitbtn.getText());
		String Submitbtnatr=Submitbtn.getAttribute("name");
		System.out.println("Submit button name arrtibute value is:"+Submitbtn.getAttribute("name"));
		jsexe.executeScript("document.getElementsByName('samename')[1].style.border='5px green solid'");
		WebElement Loginbtn=driver.findElement(By.xpath("//button[text()='Login']"));
		System.out.println(Loginbtn.getText());
		String Loginbtnatr=Submitbtn.getAttribute("name");
		System.out.println("Login button name arrtibute value is:"+Loginbtn.getAttribute("name"));
		jsexe.executeScript("document.getElementsByName('samename')[2].style.border='5px blue solid'");
		WebElement Registerbtn=driver.findElement(By.xpath("//button[text()='Register']"));
		System.out.println(Registerbtn.getText());
		String registerbtnatr=Submitbtn.getAttribute("name");
		System.out.println("Register button name arrtibute value is:"+Registerbtn.getAttribute("name"));
		if(Submitbtnatr.equals(registerbtnatr)) {

				System.err.println("All the  3 buttons have same attribute");
			}


		//Ordered List
		System.err.println("Ordered List output is:");
        List<WebElement> orderlist = driver.findElements(By.xpath("//div[@id='HTML25']//div[1]//li"));
        System.out.println("Number of items in order list are:"+orderlist.size());
        for (WebElement webElement : orderlist) {
        	System.out.println(webElement.getText());
		}	
		//UnOrdered list
        System.err.println("UnOrdered list output is:");
        List<WebElement> Unorderlist = driver.findElements(By.xpath("//div[@id='HTML26']//div//li"));
        System.out.println("Number of items in order list are:"+Unorderlist.size());
        for (WebElement webElement : Unorderlist) {
        	System.out.println(webElement.getText());
		}	
		//DisplayForTimeAndDissapear
        System.err.println("Display For Time And Dissapear:");
        WebElement clickaftertxtdispbtn=driver.findElement(By.xpath("//input[@id='alert2']"));
        clickaftertxtdispbtn.click();
        System.out.println("Alert text is:"+driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //TextWillBeDisplayedWithDelay
        System.err.println("Text Will Be Displayed With Delay:");

        WebDriverWait mywait1=new WebDriverWait(driver,Duration.ofSeconds(10)); 
        WebElement delayedtxt=mywait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='delayedText']")));
        System.out.println(delayedtxt.getText());

        //DisplayForTimeAndDissapear

        System.err.println("Display For Time And Dissapear:");

        WebElement disappeartxt=mywait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='deletesuccess']")));
        System.out.println(disappeartxt.getText());
        WebElement clickaftertxtdispbtn2=driver.findElement(By.xpath("//input[@id='alert2']"));
        System.out.println(clickaftertxtdispbtn2.getText());
        clickaftertxtdispbtn2.click();
        driver.switchTo().alert().accept();


        //Upload File
        System.err.println("Upload File:");

        WebElement UploadFile=driver.findElement(By.xpath("//input[@id='uploadfile']"));
        Thread.sleep(1200);
        UploadFile.sendKeys("C:\\Users\\chakr\\Desktop\\Project .jpg");
        System.out.println("File got uploaded successfully");
		
		
        //Timer Enable Button(didn't work)
        System.err.println("Timer Enable Button output:");
        WebElement TimerEnableButton=driver.findElement(By.xpath("//input[@id='timerButton']"));
        Thread.sleep(2000);

        mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='timerButton']")));
       driver.findElement(By.xpath("//input[@id='timerButton']")).click();
        	System.out.println(driver.switchTo().alert().getText());
             driver.switchTo().alert().accept();
        

      //Double click here
		 System.err.println("Double click here:");
		WebElement doubleclickbtn= driver.findElement(By.xpath(" //button[text()=' Double click Here   ']"));
		Actions act= new Actions(driver);
		act.doubleClick(doubleclickbtn).build().perform();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

      //Mr option--element to be enabled and clickable
		 System.err.println("Mr option--element to be enabled and clickable:");
		 driver.findElement(By.xpath("//button[text()='Check this']")).click();
		 mywait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dte']"))).click();
		 System.out.println("Mr Option got enabled");
		 System.out.println("Mr Option got selected");

		 //Text area field 1
		   System.err.println("Text area 1 output:");
		 WebElement textfield1=driver.findElement(By.xpath("//textarea[@id='ta1']"));
		 System.out.println(textfield1.getText());
		 textfield1.clear();
		 System.out.println("text got cleared");
		 textfield1.sendKeys("This is the first test area field to test in this webpage");

		 //Text area 2
		 System.err.println("Text area 2 output:");
		 WebElement textfield2=driver.findElement(By.xpath("//textarea[normalize-space()='The cat was playing in the garden.']"));
		 System.out.println("First text in the box was:"+textfield2.getText());
		 textfield2.clear();
		 System.out.println("text got cleared");
		 textfield2.sendKeys("This is the second test area field to test in this webpage");

		 //hidden btn
		 WebElement Hiddenbtn= driver.findElement(By.xpath("//input[@id='hbutton']"));
		 System.out.println(Hiddenbtn.getDomAttribute("value"));
		 mywait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='hbutton']"))).getDomAttribute("value");

		 //Table
		 WebElement table1= driver.findElement(By.xpath("//table[@id='table1']"));
		 List <WebElement> tablerows= driver.findElements(By.xpath("//table[@id='table1']//tr"));
		 System.out.println("Row values of the Table :");
		 for (WebElement webElement : tablerows) {
			 System.out.println(webElement.getText());

		}

		 List <WebElement> firstcolumn= driver.findElements(By.xpath("//table[@id='table1']//td[1]"));
		 System.err.println("First columm values:");
		 for (WebElement webElement : firstcolumn) {
			 System.out.println(webElement.getText());

		}

		 List <WebElement> secondcolumn= driver.findElements(By.xpath("//table[@id='table1']//td[2]"));
		 System.err.println("Second columm values:");
		 for (WebElement webElement : secondcolumn) {
			 System.out.println(webElement.getText());

		}

		 List <WebElement> Thirdcolumn= driver.findElements(By.xpath("//table[@id='table1']//td[3]"));
		 System.err.println("Third columm values:");
		 for (WebElement webElement : Thirdcolumn) {
			 System.out.println(webElement.getText());

		}

		 WebElement iframe1= driver.findElement(By.xpath("//iframe[@id='iframe1']"));

		 driver.switchTo().frame(iframe1);
		 System.out.println(driver.getClass());


		 driver.switchTo().defaultContent();

		 WebElement iframe2= driver.findElement(By.xpath("//iframe[@id='iframe2']"));
		 driver.switchTo().frame(iframe2);

		System.out.println(driver.getClass());
		driver.switchTo().defaultContent();

		//Radio options
		driver.findElement(By.xpath("//input[@id='radio2']")).click();
		System.out.println("Female option got selected");

		//Alert Demo
		WebElement Alertbtn =driver.findElement(By.xpath("//input[@id='alert1']"));
		System.out.println(Alertbtn.getAttribute("Value"));
		Alertbtn.click();
		System.out.println("Alert text is:"+driver.switchTo().alert().getText());
		Thread.sleep(1200);
		driver.switchTo().alert().accept();
		//By Default Selected Check Box option
		WebElement Bluechkbx =driver.findElement(By.xpath("//input[@id='checkbox2']")); 
		Bluechkbx.click();
		System.out.println("Blue check box got selected");
		WebElement Orangechkbx =driver.findElement(By.xpath("//input[@id='checkbox1']")); 
		Orangechkbx.click();
		System.err.println("Red check box got unselected");

		//Readonly TextBox
		WebElement readonlytxt =driver.findElement(By.xpath("//input[@id='rotb']"));
		System.out.println("Text in Readonly TextBox is:"+readonlytxt.getAttribute("Value"));
		
		//Get Prompt
		WebElement promptbx =driver.findElement(By.xpath("//input[@id='prompt']"));
		promptbx.click();
		//This alert interface supports only firefox browser...that means if u write: WebDriver driver= new FirefoxDriver() and write below lines then it will work
		//Alert alert=driver.switchTo().alert();
		//alert.sendKeys("Kanthi");

		driver.switchTo().alert().accept();

		//Confirmation Dialog
		WebElement confirmbx =driver.findElement(By.xpath("//input[@id='confirm']"));
		confirmbx.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
    
		
		//Locate using name attribute
		WebElement nameatrbx =driver.findElement(By.xpath("//input[@name='textboxn']"));
		nameatrbx.sendKeys("Selenium webDriver");

  //Testing Other Sites to Practice Automation links
		
		WebElement compendiumdevlink =driver.findElement(By.xpath("//a[normalize-space()='compendiumdev']"));
		System.out.println("First link that got clicked was:"+compendiumdevlink.getText());
		compendiumdevlink.click();
		Thread.sleep(1000);
		driver.navigate().back();
		
		WebElement onlytestingbloglink =driver.findElement(By.xpath("//a[normalize-space()='onlytestingblog']"));
		System.out.println("Second link that got clicked was:"+onlytestingbloglink.getText());
		onlytestingbloglink.click();
		Thread.sleep(1000);
		driver.navigate().back();
		
		
		WebElement testwiselylink =driver.findElement(By.xpath("//a[normalize-space()='testwisely']"));
		System.out.println("Third link that got clicked was:"+testwiselylink.getText());
		testwiselylink.click();
		Thread.sleep(1000);
		driver.navigate().back();
		
		WebElement jqueryuilink =driver.findElement(By.xpath("//a[normalize-space()='jqueryui']"));
		System.out.println("Fourth link that got clicked was:"+jqueryuilink.getText());
		jqueryuilink.click();
		Thread.sleep(1000);
		driver.navigate().back();
		
		WebElement theautomatedtesterlink =driver.findElement(By.xpath("//a[normalize-space()='theautomatedtester']"));
		System.out.println("Fifth link that got clicked was:"+theautomatedtesterlink.getText());
		theautomatedtesterlink.click();
		Thread.sleep(1000);
		driver.navigate().back();
		
		
		
		//Having same id and name attribute values
		WebElement sameidnName =driver.findElement(By.xpath("//input[@id='sa']"));
		System.out.println("value for this WebElement is:"+sameidnName.getAttribute("Value"));
		
		//Locate using class
		WebElement Locateusingclass =driver.findElement(By.xpath("//div[@id='HTML24']//input"));
		System.out.println("Class of Locate using class WebElement is:"+Locateusingclass.getAttribute("class"));
		Locateusingclass.sendKeys("Testing the elemnt located using class");
		
		
		//element having same class name of above field
		
		WebElement Elmtwithsamenamenclass =driver.findElement(By.xpath("//div[@id='HTML28']//input"));
		System.out.println("Class value of element having same class name of above field is:"+Elmtwithsamenamenclass.getAttribute("class"));
		Elmtwithsamenamenclass.sendKeys("Testing element having same class name of above field");
		
		
		//Select a vehicle
		WebElement Bikebtn =driver.findElement(By.xpath("//input[@value='Bike']"));
		Bikebtn.click();
		System.out.println("Select a vehicle output is:Bicycle got selected");
		
		//Select multiple options
		System.out.println("Select multiple options output is:");
		WebElement Booknchkbx =driver.findElement(By.xpath("//input[@value='Book']"));
		Booknchkbx.click();
		System.out.println("Book got unselected");
		
		WebElement penchkbx =driver.findElement(By.xpath("//div[@class='widget-content']//input[@value='Pen'][@name='accessories']"));
		penchkbx.click();
		System.out.println("Pen got selected");
		
		WebElement Laptopchkbx =driver.findElement(By.xpath("//input[@value='Laptop']"));
		Laptopchkbx.click();
		System.out.println("Laptop got selected");
		
		WebElement Bagchkbx =driver.findElement(By.xpath("//input[@value='Bag']"));
		Bagchkbx.click();
		System.out.println("Bag got selected");
		
		//Test Double Click
		WebElement doubleclickbtn1=driver.findElement(By.xpath("//p[@id='testdoubleclick']"));
		Actions act1= new Actions(driver);
		act1.doubleClick(doubleclickbtn1).perform();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Flipkart']")));
		driver.findElement(By.xpath("//a[text()='Flipkart']")).click();
		System.out.println("Clicked on Flipkart");
		Thread.sleep(1200);
		driver.navigate().back();
		act1.doubleClick(doubleclickbtn1).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Facebook']")));
		driver.findElement(By.xpath("//a[text()='Facebook']")).click();
		System.out.println("Clicked on Facebook");
		Thread.sleep(1200);
		driver.navigate().back();
		
		//Blogger
		WebElement Bloggerlink=driver.findElement(By.xpath("//a[text()='Blogger']"));
		Bloggerlink.click();
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		driver.close();
		Thread.sleep(2500);
		driver.switchTo().window(mainwindow);
		
		//Blogs
		System.err.println("Testing blogs tab..switching from onew window to another");
		Actions act11= new Actions(driver);
		WebElement Blogsmenu=driver.findElement(By.xpath("//span[@id='blogsmenu']"));
		WebElement Selenium143=driver.findElement(By.xpath("//span[text()='Selenium143']"));
		WebElement SeleniumbyArun=driver.findElement(By.xpath("//span[text()='SeleniumByArun']"));
		WebElement SeleniumOneByArun=driver.findElement(By.xpath("//span[text()='SeleniumOneByArun']"));
		WebElement SeleniumTwoByArun=driver.findElement(By.xpath("//span[text()='SeleniumTwoByArun']"));
		act11.moveToElement(Blogsmenu).click(Selenium143).perform();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		act11.moveToElement(Blogsmenu).click(SeleniumbyArun).perform();
		driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/QAFox/playlists']//img")).click();
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(mainwindow);
		driver.navigate().back();
		act11.moveToElement(Blogsmenu).click(SeleniumOneByArun).perform();
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div[@id='post-body-3439009644269995214']//div[1]//a[1]//img[1]")).click();
		driver.findElement(By.xpath("//div[@class='CSS_LIGHTBOX_FILMSTRIP_CONTROLS_RIGHT']")).click();
		driver.findElement(By.xpath("//div[@class='CSS_LIGHTBOX_BTN_CLOSE CSS_LIGHTBOX_BTN_CLOSE_POS']")).click();
		driver.navigate().back();
		act11.moveToElement(Blogsmenu).click(SeleniumTwoByArun).perform();
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		System.out.println(driver.getTitle());
		WebElement languageselect=driver.findElement(By.xpath("//select[@class='goog-te-combo']"));
		Select languageselectdrpdwn=new Select(languageselect);
		languageselectdrpdwn.selectByValue("te");
		driver.navigate().back();
		driver.quit();
		
	}

}
