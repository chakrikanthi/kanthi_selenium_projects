package DifferentWebsitesTesting;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElements {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php");
	List <WebElement>spanelements= driver.findElements(By.xpath("//div//span"));
	System.out.println(spanelements.size());
	
	for(WebElement element:spanelements)
	{
		System.out.println(element.getText());
	}

	}

}
