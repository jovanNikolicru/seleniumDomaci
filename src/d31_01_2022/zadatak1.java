package d31_01_2022;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		driver.navigate().to("https://s.bootsnipp.com/iframe/Dq2X");
		driver.manage().window().maximize();
		List<WebElement>links=driver.findElements(By.xpath("//*[@type='button']"));
		List<WebElement>baneri=driver.findElements(By.xpath("//*[contains(@class,'alert-')]"));
		boolean daLiSeUgasilo;
		int brojac=0;
	
		
		for (int i=links.size()-1;i>=0;i--) {
	
		driver.findElements(By.xpath("(//*[@type='button'])[last()]"));
			links.get(i).click();
		try {
			WebElement e= links.get(i).findElement(By.xpath("//*[@aria-hidden='true']"));
			daLiSeUgasilo=false;
		} catch (Exception e) {
			daLiSeUgasilo=true;
		}
		if(daLiSeUgasilo) {
			System.out.println("Ugasio se");
		}else {
			System.out.println("nije se ugasio");
		}
			
		}
	} 
}

