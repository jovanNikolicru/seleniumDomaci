package d08_02_2022_pages_zadatak1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FormPage {

		private WebDriver driver;
		private WebDriverWait wait;
		private JavascriptExecutor js;
		public  FormPage(WebDriver driver) {
			this.driver=driver;
		}
		public WebElement getFirstName() {
			return driver.findElement(By.id("first-name"));
		}
		public WebElement getGender(String radioValue) {
			return driver.findElement(By.xpath("//*[@name='gender'][@value='"+ radioValue +"']"));
		}
		public WebElement getCheckBox(String checkboxValue) {
			return driver.findElement(By.xpath("//*[@type='checkbox'][@value='"+ checkboxValue +"']"));
		}
		public WebElement getDoB() {
			return driver.findElement(By.name("dob"));
		}
		public WebElement getMail() {
			return driver.findElement(By.name("email"));
		}
		public WebElement getRole(String role) {
			Select drop= new Select(driver.findElement(By.name("role")));
			
			drop.selectByVisibleText(role);;
			return driver.findElement(By.name("role"));
		}
		public WebElement getComment() {
			return driver.findElement(By.name("comment"));
		}
		
		
		
		
		public WebElement getButton() {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
			return driver.findElement(By.id("submit"));
		}
		
		public void fillLogin(String ime, String pol, String datum, String email,
				String role, String wod, String komentar) throws InterruptedException {
			
			js=(JavascriptExecutor)driver;
			getFirstName().sendKeys(ime);
			getGender(pol).click();
			getDoB().sendKeys(datum);
			getMail().sendKeys(email);
			
			getRole(role).click();
			js.executeScript("arguments[0].scrollIntoView;", getComment());
			getCheckBox(wod).click();
			getComment().sendKeys(komentar);
			
		}
		public void cekajDO() {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("message-element"))));
			
		}
		public void pocniPonovo() {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("message-element"))));
		}
		
}
