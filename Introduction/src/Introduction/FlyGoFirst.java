package Introduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlyGoFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		https://www.flygofirst.com/
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\sakabir\\\\Downloads\\\\Driver\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flygofirst.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("cookie-btn")).click();
		driver.findElement(By.cssSelector("div[class='modal-content'] [class='fa fa-times-circle']")).click();

		Depart(driver);
		Return(driver);
	}
	public static void Depart(WebDriver driver) {
		driver.findElement(By.xpath("//div[@class='t-dates t-date-check-in']")).click();
		while(!driver.findElement(By.cssSelector("[class='t-datepicker-day t-datepicker-days'] [class='t-month']")).getText().contains("July"))
		{
			driver.findElement(By.cssSelector("[class='t-datepicker-day t-datepicker-days'] [class='t-arrow t-next']")).click();
		}
		List<WebElement> dates=driver.findElements(By.xpath("//td[@class='t-day']"));
		int count=driver.findElements(By.xpath("//td[@class='t-day']")).size();
		for(int i=0;i<count;i++) {
			String text=driver.findElements(By.xpath("//td[@class='t-day']")).get(i).getText();
			if(text.equalsIgnoreCase("21")) {
				driver.findElements(By.xpath("//td[@class='t-day']")).get(i).click();
				break;
			}
		}
	}
public static void Return(WebDriver driver) {
	while(!driver.findElement(By.cssSelector("[class='t-datepicker-day t-datepicker-days'] [class='t-month']")).getText().contains("August"))
	{
		driver.findElement(By.cssSelector("[class='t-datepicker-day t-datepicker-days'] [class='t-arrow t-next']")).click();
	}
	List<WebElement> dates=driver.findElements(By.xpath("//td[@class='t-day']"));
	int count=driver.findElements(By.xpath("//td[@class='t-day']")).size();
	for(int i=0;i<count;i++) {
		String text=driver.findElements(By.xpath("//td[@class='t-day']")).get(i).getText();
		if(text.equalsIgnoreCase("21")) {
			driver.findElements(By.xpath("//td[@class='t-day']")).get(i).click();
			break;
		}
	}

}

}
