package Introduction;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EcommercePrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakabir\\Downloads\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//WebDriverWait wait=new WebDriverWait(driver,a);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		String[] itemNeeded= {"Brocolli","Cucumber","Beetroot"};
		addItems(driver,itemNeeded);
		checkoutPage(driver, wait);

	}
	public static void addItems(WebDriver driver, String[] itemNeeded) {
		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size()-1;i++) {
			String[] name=products.get(i).getText().split("-");
			String formattedName=name[0].trim();
			List<String> ItemNeededList=Arrays.asList(itemNeeded);
			if(ItemNeededList.contains(formattedName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				if(j==itemNeeded.length) {
					break;
					
				}
				
			}
			}
			}
	public static void checkoutPage(WebDriver driver, WebDriverWait wait) {
		String promoCode="rahulshettyacademy";
		String codeApl="Code applied ..!";
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='PROCEED TO CHECKOUT']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys(promoCode);
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		//explecit
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText(), codeApl);
		driver.findElement(By.xpath("//*[text()='Place Order']")).click();
		
		
	}

		}

