package Introduction;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Exterdropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.getProperty("webdriver.chrome.driver", "C:\\Users\\sakabir\\Downloads\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Auto suggest dropdown
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Ne");
		Thread.sleep(3000);
		List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item']  a"));
		for(WebElement option:options) {
			if(option.getText().equalsIgnoreCase("Nepal")) {
				option.click();
				break;
			}
		}

		
		//Dynamic dropdown From and to
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='GOI']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CCU']")).click();
		
		//Checkbox
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//count the number of checkbox
		System.out.println("Number of chekbox in the page: "+ driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		//Passemger
		System.out.println("Enter the number of passenger: ");
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(3000);
		
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		
		for(int i=1;i<=size-1;i++) {
			driver.findElement(By.cssSelector("span[id='hrefIncAdt']")).click();	
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText(), size+" Adult");

		
		//Dropdown with Selct tag Static
		WebElement staticDropdown=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select dropdown=new Select(staticDropdown);
		dropdown.selectByVisibleText("AED");
		//System.out.println(dropdown.getFirstSelectedOption().getText());
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "AED");
		dropdown.selectByValue("INR");
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "INR");
		dropdown.selectByIndex(3);
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "USD");
		
		//RadioButton:
		driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_1']")).click();
		if(driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_1']")).getAttribute("class").contains("1")) {
			System.out.println("it's enabled");
		}
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker-title'] [class='ui-datepicker-month']")).getText().contains("August")) 
		{
		driver.findElement(By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']")).click();	
		}
		List<WebElement> dates=driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
		int count=driver.findElements(By.cssSelector("td[data-handler='selectDay']")).size();
		for(int i=0;i<count;i++) {
			String text=driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).getText();
			if(text.equalsIgnoreCase("16")) {
				driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).click();
				break;
			}
		}
		
		
	}

}
