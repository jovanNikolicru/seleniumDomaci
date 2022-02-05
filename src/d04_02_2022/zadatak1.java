package d04_02_2022;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class zadatak1 {
	/*1.Zadatak
	Napisti TestNg test koji:
	Ucitava stranicu https://www.udemy.com/
	U delu za pretragu ukucajte tekst “Selenium” i lupite enter
	Sortirajte rezultate pretrage prema rejtingu (Highest Rated)
	Dohvatite rejting prvog rezultata pretrage
	Dohvatite rejting zadnjeg rezultata pretrage (HELP: trebace vam getText metoda)
		[HELP] Dohvatite rejting kao listu  pa iz liste izvucite prvi i zadnji element.
		//*[@data-purpose=\"rating-number\"]
	Proverite da li je reting prvog veci od rejtinga zadnjeg rezultata
	pretvaranje stringa u double link ce vam trebati za ovaj zadatak
	
	Imao sam problem i sa kupujemprodajem pa sam uzeo eBay
	*/
	
	WebDriver driver;
	Select drop ;
	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", 
				"driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		/* DesiredCapabilities capabilities = new DesiredCapabilities();
		 
		 capabilities.setCapability("build", "CaptchaInSelenium");
	        capabilities.setCapability("name", "TCaptchaInSeleniumSample");*/
	}
	@Test
	public void sortingPrices() throws InterruptedException, ParseException {
		driver.navigate().to("https://www.ebay.com/");
		driver.findElement(By.id("gh-ac")).sendKeys("iPhone",Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
		driver.findElement(By.id("s0-14-11-5-3[0]-38")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Price + Shipping: lowest first"))));
		driver.findElement(By.linkText("Price + Shipping: lowest first")).click();
		List<WebElement> results= driver.findElements(By.className("s-item__price"));
		
		String prvi =results.get(1).getText();
		String drugi=results.get(results.size()-1).getText();
		/*for(int i =0; i <results.size();i++) {
			 drugi=results.get(i).getText();
		}*/
		
		
		//Ovi Stringovi hvataju dobre vrednosti ali ne mogu da skinem znak $ kada hocu da ih prebacim u double
		
		prvi=prvi.replaceFirst("$", "");
		drugi=drugi.replaceFirst("$", "");
		/*double d1 = new Double(prvi).doubleValue(); 
		double d2 = new Double(drugi).doubleValue(); */
		
		/*Double d1 = Double.valueOf(prvi);
		Double d2 = Double.valueOf(drugi);*/
		System.out.println(prvi+"     " +drugi);
		double d1 = Double.parseDouble(prvi);
		double d2 = Double.parseDouble(drugi);
		
		
		/*NumberFormat num = DecimalFormat.getNumberInstance();
        Number pointsNum = num.parse(prvi);     
        double d1 = pointsNum.doubleValue();
        NumberFormat num1 = DecimalFormat.getNumberInstance();
        Number pointsNum1 = num1.parse(drugi);     
        double d2 = pointsNum1.doubleValue();*/
		
		System.out.println(d1);
		System.out.println(d2);
		Assert.assertFalse(d1>d2,"Products not sorted correctly");
		//Da mi rade ovo pretvaranje iz Stringa u double ovaj assert bih upotrebio
		
}
}