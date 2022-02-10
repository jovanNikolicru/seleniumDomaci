package d08_02_2022_test_zadatak1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import d08_02_2022_pages_zadatak1.FormPage;



public class FormTest {
	/*Zadatak
	Za potrebe zadatka kreirati FormPage koji ima sve potrebne metode.
		Zatim kreirati FormTest koji 
	Ucitava form.html stranicu (form.html je u folderu za domaci skinite je i otvorite u chrome i iskopirajte url)
	I popunjava formu koristeci FormData.xlsx fajl (u folderu je za domaci)
	Postavite odgovarajuce waitere tako da se saceka sledeci unos podataka u formu nakon submitovanja
*/
	
	private WebDriver driver;
	private FormPage fp;
	private JavascriptExecutor js;
	private WebDriverWait wait;
	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		fp = new FormPage(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		js=(JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
}
	@Test
	public void formTest() throws InterruptedException, IOException {
		driver.navigate().to("file:///C:/Users/jovan/Downloads/form.html");
		driver.manage().window().maximize();
		File file= new File("data/FormData.xlsx");
		System.out.println(file.getAbsolutePath());
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet =wb.getSheet("FormData");
		DataFormatter formatter = new DataFormatter();
	
		SoftAssert softAssert = new SoftAssert();
		for(int i =1;i<7;i++) {
			String ime= formatter.formatCellValue(sheet.getRow(i).getCell(0));
			String pol= sheet.getRow(i).getCell(1).getStringCellValue();
			
			String datum= formatter.formatCellValue(sheet.getRow(i).getCell(2));
			String email= formatter.formatCellValue(sheet.getRow(i).getCell(3));
			String role= formatter.formatCellValue(sheet.getRow(i).getCell(4));
			
			String wod= formatter.formatCellValue(sheet.getRow(i).getCell(5));
			
			String komentar= formatter.formatCellValue(sheet.getRow(i).getCell(6));
			
			fp.fillLogin(ime, pol, datum, email, role, wod, komentar);
			fp.getButton().click();
			
			/*fp.getFirstName().clear();
			fp.getDoB().clear();
			fp.getMail().clear();
			fp.getComment().clear();*/
			
			
			fp.cekajDO();
			fp.pocniPonovo();
			js.executeScript("arguments[0].scrollIntoView;", fp.getFirstName());
			driver.navigate().refresh(); // pretpostavljam da ne treba preko refresh ali nisam uspeo ni sa jednim waiterom 
										// da resim checkbox i radio dugme
			
		}
	
}

}