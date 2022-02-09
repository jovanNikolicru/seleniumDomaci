package d07_02_2022_test_zadatak1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d07_02_2022_pages_zadatak1.FormPage;



public class FormTest {

	private WebDriver driver;
	private FormPage fp;
	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		fp = new FormPage(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
}
	@Test
	public void formTest() throws InterruptedException {
		driver.navigate().to("file:///C:/Users/jovan/Downloads/form.html");
		driver.manage().window().maximize();
		fp.getFirstName().sendKeys("bla bla");
		fp.getGender("male").click();;
		fp.getMail().sendKeys("fdasasd@fds.com");
		fp.getDoB().sendKeys("02.05.2020");
		fp.getCheckBox("read_books").click();;
		fp.getComment().sendKeys("bla bla");
		fp.getRole("QA").click();
		fp.getButton().click();
		Thread.sleep(4000);
		Assert.assertTrue(fp.isFilledCorrectly(),"Forma nije dobro popunjena");
		
	}
	@AfterMethod
	public void after() {
		//driver.quit();
	}
}