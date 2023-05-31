package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AngularPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\sakabir\\\\Downloads\\\\Driver\\\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/angularpractice/");
//WebElement editBox=driver.findElement(By.cssSelector("[name='name']"));

driver.switchTo().newWindow(WindowType.WINDOW);
Set<String> handles=driver.getWindowHandles();
Iterator<String> it=handles.iterator();
String parentId=it.next();
String childId=it.next();

driver.switchTo().window(childId);
driver.get("https://rahulshettyacademy.com/");

	}

}
