package d07_02_2022_pages_zadatak2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Cart(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isThere2Products(String quantity) {
		WebElement element = driver.findElement(By.className("input-text"));
		String elementval = element.getAttribute("value");
		return	elementval.equals(quantity);
	}
	public void removeProduct() {
		 driver.findElement(By.xpath("//td[contains(@class,'product-remove')]/a")).click();;
	}
	public String messageEmptyCart() {
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.className("cart-empty"), 1));
		return driver.findElement(By.className("cart-empty")).getText();
	}
	
	
}
