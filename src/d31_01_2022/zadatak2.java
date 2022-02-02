package d31_01_2022;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class zadatak2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().to("https://geodata.solutions/");
		driver.manage().window().maximize();
		
		Select drop= new Select(driver.findElement(By.className("countries")));
		drop.selectByIndex(6);
		
		Select drop1= new Select(driver.findElement(By.className("states")));
		drop1.selectByIndex(2);
		
		Select drop2= new Select(driver.findElement(By.className("cities")));
		drop2.selectByIndex(1);
		
	
	}

}
