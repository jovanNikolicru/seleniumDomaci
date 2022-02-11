package d10_02_2022_test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import d10_02_2022_pages.PlayerPage;

public class PlayerTest {
	private WebDriver driver;
	private WebDriverWait wait;
	private PlayerPage pp;
	private JavascriptExecutor js;
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(115, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
		
		js=(JavascriptExecutor)driver;
		pp= new PlayerPage(driver, js);
}
	/*private void takeSnapShot(WebDriver driver, String path) throws IOException {
		 path="D:\\projekti\\seleniumDomaci\\test-screenshots\\snapGoogle.png";
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(path);
		FileUtils.copyFile(SrcFile, DestFile);
		
	}*/
	@Test
/*	1.Zadatak(Za vezbanje)
	Napisati test koji otvara Google stranicu i pravi screenshot stranice. Screenshot-ove cuvati u test-screenshots folderu u okviru projekta.
*/
/*	public void googleTestScreenshot() throws IOException {
		driver.navigate().to("https://www.google.rs/");
		driver.manage().window().maximize();
		
		this.takeSnapShot(driver, "c://test.png") ;
	}*/
	
	public void playerTesting() throws IOException, InterruptedException {
		
		SoftAssert sa = new SoftAssert();
		driver.navigate().to("https://plyr.io/");
		driver.manage().window().maximize();
		pp.getPriprema("video").click();
		String pocetno =pp.currentTime();
		Thread.sleep(2000);
		pp.playVideo();
		Thread.sleep(2000);
		pp.pauseVideo();
		String novo=pp.currentTime();
		
		sa.assertTrue(!pocetno.equals(novo),"Player didn't started");
	}
	
	@Test
	public void volumeTesting() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		driver.navigate().to("https://plyr.io/");
		driver.manage().window().maximize();
		pp.getPriprema("video").click();
		pp.playVideo();
		Thread.sleep(4000);
		
		
		pp.pauseVideo();
		int voltrenutno=pp.volume();
		
		pp.volumeDown(10);
		pp.volumeDown(10);
		pp.volumeUp(5);
		int volposle=pp.volume();
		sa.assertEquals(volposle, 75,"Volume doesn't work");
		
		sa.assertAll();
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}