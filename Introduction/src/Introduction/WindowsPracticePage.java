package Introduction;

import java.lang.StackWalker.Option;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WindowsPracticePage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakabir\\Downloads\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// Radio button
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		driver.findElement(By.xpath("//input[@value='radio3']")).click();
		if (driver.findElement(By.xpath("//input[@value='radio3']")).getAttribute("value").contains("radio3")) {
			System.out.println("It's enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// Suggestion
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='ui-menu-item']")));
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}

		}

		// Dropdown
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropDown = new Select(staticDropdown);
		dropDown.selectByVisibleText("Option2");
		Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Option2");

		// Checkbox example
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).isSelected());
		System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).getSize());

		// Alert ExAMPLES:
		String name = "Saiful Kabir";
		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

		driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='name']")));
		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();

		PageLinks(driver);
		FooterLinks(driver);
		TableLinksCount(driver);
		//ValidateTableLinks(driver);
		WebTable(driver);
//		EcommercePrac ep=new EcommercePrac();
//		ep.main(args);

	}

	public static void PageLinks(WebDriver driver) {
		driver.findElements(By.tagName("a")).size();
		System.out.println(driver.findElements(By.tagName("a")).size());
	}

	public static void FooterLinks(WebDriver driver) {
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

	}

	public static void TableLinksCount(WebDriver driver) {
		WebElement columnLinks = driver.findElement(By.xpath("//table//tbody//tr//td[1]//ul"));
		for (int i = 0; i < columnLinks.findElements(By.tagName("a")).size(); i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnLinks.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
		}
	}

//	public static void ValidateTableLinks(WebDriver driver) {
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> it = windows.iterator();
//		while (it.hasNext()) {
//			driver.switchTo().window(it.next());
//			System.out.println(driver.getTitle());
//
//		}
//	}
	public static void WebTable(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<values.size();i++) {
			sum=sum+Integer.parseInt(values.get(i).getText());
		}
		
	}
}
