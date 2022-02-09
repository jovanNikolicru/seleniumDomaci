package d07_02_2022_pages_zadatak2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationPages {
	private WebDriver driver;
	
	public NavigationPages(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getShopLink() {
		return driver.findElement(By.xpath("//li[contains(@class,'page-item-7')]//a"));
	}
	public WebElement getCartLink() {
		return driver.findElement(By.xpath("//li[contains(@class,'page-item-8')]//a"));
	}
	
}
