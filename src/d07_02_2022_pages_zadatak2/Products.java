package d07_02_2022_pages_zadatak2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Products {
private WebDriver driver;
private List<WebElement> productList; 
private WebDriverWait wait;
	public Products(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getQuantity() {
		return driver.findElement(By.className("input-text"));
	}
	public WebElement getAddToCartBtn() {
		return driver.findElement(By.className("single_add_to_cart_button"));
	}
	public WebElement getProductPage(int index) {
		productList = driver.findElements(By.xpath("//*[contains(@class,'ellie-thumb-wrapper')]/a[1]"));
		return productList.get(index);
	}
	public void addProductToCart(String quantity) {
		getQuantity().clear();
		getQuantity().sendKeys(quantity);
		/*getAddToCartBtn().click();*/
	}
	public String messageAdd() {
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("woocommerce-message"))));
		return driver.findElement(By.className("woocommerce-message")).getText();
	}
	public WebElement getViewCartBtn() {
		return driver.findElement(By.xpath("//*[contains(@class, 'woocommerce-message')]//a"));
	}
	
}
