package d03_02_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zadatak2 {

	public static void main(String[] args) {
	/*	.Zadatak
		Napisati program koji:
		Ucitava stanicu https://www.wikipedia.org/
		Sa stranice sakuplja sve linkove (jezike) i svaki link otvara u novom prozoru pretrazivaca
		Svaki link potrebno je otvoriti u novom tabu.
		Skripta: window.open(arguments[0]);*/
		
		//*[contains (@class, 'central-featured-lang')]/a
		
		System.setProperty("webdriver.chrome.driver", 
				"driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.wikipedia.org/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		List<WebElement>jezici= driver.findElements(By.xpath("//*[contains (@class, 'central-featured-lang')]/a"));
		
		for (int i =0;i<jezici.size();i++) {
			js.executeScript("window.open(arguments[0]);", jezici.get(i));
		}
	}

}
