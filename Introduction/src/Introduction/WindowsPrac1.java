package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsPrac1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\sakabir\\Downloads\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.navigate().to("https://university.hyland.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.findElement(By.xpath("//a[@id='signinstatus']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("saiful.kabir@hyland.com");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("label[for='input47']")).click();
		driver.findElement(By.xpath("//input[@id='idp-discovery-submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Jaadu@123456789");
		driver.findElement(By.xpath("//input[@class='button button-primary']")).click();

	}

}
