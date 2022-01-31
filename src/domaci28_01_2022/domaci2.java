package domaci28_01_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class domaci2 {



		public static void main(String[] args) throws InterruptedException {
		/*	Zadatak
			Napisati program koji vrsi dodavanje 5 reda u tabelu. 
			Maksimizirati prozor
			Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
			Dodati red podataka - jedan red u jednoj iteraciji 
			Kliknite na dugme Add New
			Unesite name,departmant i phone (mogu da budu uvek iste vrednost)
			Kliknite na zeleno Add dugme
			Na kraju programa ugasite pretrazivac.
			
			NISAM SIGURAN DA LI OVAKO SALJEM NA GIT
*/
			
			
			System.setProperty("webdriver.chrome.driver", 
					"driver-lib/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		
			
			driver.navigate().to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
			driver.manage().window().maximize();
			
			for(int i =0;i<5;i++) {
			driver.findElement(By.xpath("//*[contains(@class,'add-new')]")).click();
			List<WebElement>links=driver.findElements(By.xpath("//*[@type='text']"));
			
				links.get(0).sendKeys("Miki Mikic");
				links.get(1).sendKeys("QA");
				links.get(2).sendKeys("5465465546");
				driver.findElement(By.xpath("//*[@style='display: inline;']")).click();
				
				Thread.sleep(4000);
				
			
			
			}
			driver.close();
		}

	}
