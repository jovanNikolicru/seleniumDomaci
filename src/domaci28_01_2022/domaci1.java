package domaci28_01_2022;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class domaci1 {

	public static void main(String[] args) throws InterruptedException {
		/*		Zadatak 
		Maksimizirati prozor
		Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr
		Od korisnika ucitati broj na koju zvezdicu je potrebno kliknuti (u rasponu od 1 do 5)
		I izvrsite akciju klik na odgovarajuci element
		Na kraju programa ugasite pretrazivac.
		
		NISAM SIGURAN DA LI OVAKO SALJEM NA GIT
*/
		System.setProperty("webdriver.chrome.driver", 
				"driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
		driver.navigate().to("https://s.bootsnipp.com/iframe/WaXlr");
		driver.manage().window().maximize();
		
		List<WebElement>links=driver.findElements(By.xpath("//*[@type='button']"));
		Scanner s= new Scanner(System.in);
		System.out.println("Unesite broj zvezdica");
		int i = s.nextInt() -1;
		
			links.get(i).click();
		Thread.sleep(5000);
		driver.close();
		
	}

}
