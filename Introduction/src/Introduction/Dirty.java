package Introduction;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Dirty{
    public static void main(String[] args){
    	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\sakabir\\\\Downloads\\\\Driver\\\\chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
    	//StreamFilter();
    	table(driver);
    }
    public static void StreamFilter(){
        ArrayList<String> ar=new ArrayList<String>();
        ar.add("Abhi");
        ar.add("zozo");
        ar.add("Aana");
        ar.add("poba");
Long pr=ar.stream().filter(s->s.startsWith("A")).count();
System.out.println(pr);
Stream.of("Tiki","Aiki","Ciki","Aaiki","BBiki").filter(s->s.endsWith("i")).sorted().forEach(s->System.out.print(s+" "));
Stream.of("Tiki","Aiki","Ciki","Aaiki","BBiki").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s+" "));
    }
    
    public static void table(WebDriver driver) {
    	WebElement names=driver.findElements(By.xpath("//table//tbody//tr")).get(0);
    	System.out.println(names);
    }
}