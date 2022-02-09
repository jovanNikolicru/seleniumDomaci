package d07_02_2022_pages_zadatak1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sun.security.x509.IssuingDistributionPointExtension;

public class FormPage {
	private WebDriver driver;
	
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
		return driver.findElement(By.xpath(" //*[@type='checkbox'][@value='"+ checkboxValue +"']"));
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		return driver.findElement(By.id("submit"));
	}
	public boolean isFilledCorrectly() {

		if(driver.getPageSource().contains("visibility: visible")){
return true;
		}return false;
	}
	
	}

