package d01_02_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class zadatak1 {

	public static void main(String[] args) {
		/*Zadatak
		Napisati program koji :
		Ucitava stranicu https://www.udemy.com/courses/search/?src=ukw&q=slksd
		Klikce na dugme za jezik i proverava da li se prikazuje dijalog za promenu jezika
		Stampa u konzoli tekst “Dijalog se prikazao”
		udlite-modal-close modal--close-button--wK-5V
*/
		
		System.setProperty("webdriver.chrome.driver", 
				"driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("https://www.udemy.com/courses/search/?src=ukw&q=slksd");
		driver.manage().window().maximize();
		driver.findElement(By.className("language-selector-button--button--1wgoL")).click();
		wait.until(ExpectedConditions.elementToBeClickable
				(By.className("modal--close-button--wK-5V")));
		
		System.out.println("Dijalog se prikazao");
		driver.findElement(By.className("modal--close-button--wK-5V")).click();
		driver.close();
	}

}
