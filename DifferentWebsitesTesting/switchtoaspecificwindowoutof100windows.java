package DifferentWebsitesTesting;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchtoaspecificwindowoutof100windows {
static WebDriver driver;
	public static void main(String[] args) {
  // video link for this test: https://www.youtube.com/watch?v=7xh371gk2ho
           WebDriver driver= new ChromeDriver();
           driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
           String parentwindowid=driver.getWindowHandle();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']//*[name()='svg']")).click();
           driver.findElement(By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']//*[name()='svg']")).click();
           System.out.println(driver.getCurrentUrl()+":"+driver.getTitle());
           driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']//*[name()='svg']")).click();
           driver.findElement(By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']//*[name()='svg']")).click();
	     
           Set<String> handles= driver.getWindowHandles();
	      List<String> hlist= new ArrayList<String>(handles);//here we are converting about strings(set of strings) into arrayslist	
	
	      if (SwitchtoRightWindow("facebook.com/OrangeHRM/",hlist))
	{
		System.out.println(driver.getCurrentUrl()+":"+driver.getTitle());
	}
	      closeallwindows(hlist,parentwindowid);
	      switchToParentwindow(parentwindowid);
	      System.out.println(driver.getCurrentUrl()+":"+driver.getTitle());
	}
	public static void closeallwindows(List<String> hlist,String parentwindowid)
	{
		for(String e:hlist)
		{
			if(!e.equals(parentwindowid))
			{
				driver.switchTo().window(e).close();
			}
		}
	}
	public static void switchToParentwindow(String parentwindowid)
	{
		driver.switchTo().window(parentwindowid);
	}
	
	//switch to right window
	public static boolean SwitchtoRightWindow(String windowTitle,List<String> hlist) {
		for(String e:hlist)
		{
			String Title= driver.switchTo().window(e).getTitle();
			if(Title.contains(windowTitle)) {
				System.out.println("Found the right window:");
				return true;
				
			}
		}
		return false;
		
	}

}
