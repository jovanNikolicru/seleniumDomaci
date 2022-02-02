package d01_02_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class zadatak2 {

	public static void main(String[] args) {
	/*	2.Zadatak
		Napisti program koji:
		Ucitava stranicu https://videojs.com/city
		Pusta video klikom na play dugme
		Cekamo da se video ucita
		Tako sto proveravamo da li vise to play dugme nije vidljivo

		Za vezbanje
		Probajte da napisete dopunite koji ceka da se zavrsi video i ispisuje u konzoli. Video je gotov.
*/
		
		
		
		System.setProperty("webdriver.chrome.driver", 
				"driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.navigate().to("https://videojs.com/city");
		driver.manage().window().maximize();
		driver.findElement(By.className("vjs-big-play-button")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("vjs-icon-placeholder")));
		System.out.println("Dugme nije vidljivo");
		
		
		wait.until(ExpectedConditions.attributeToBe(By.className("vjs-play-progress"), "style", "width: 100%;"));
		System.out.println("Video je zavrsen");
		driver.close();
	}

}
