package d07_02_2022_test_zadatak2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d07_02_2022_pages_zadatak2.Cart;
import d07_02_2022_pages_zadatak2.NavigationPages;
import d07_02_2022_pages_zadatak2.Products;



public class zadatak2Test {
	/*2.Zadatak
	Napisati test koji:
	Ucitava stranicu http://cms.demo.katalon.com/
	Vrsi klik na Shop link iz navigacije
	Otvara stranicu prvog proizvoda klikom na karticu prvog proizvoda
	Dodaje proizvod u korpu sa kolicinom 2
	Verifikuje poruku nakon dodavanja “has been added to your cart.”
	Odlazi u korpu klikom na dugme VIew Cart
	Verifikuje stanje u korpi, tj. da postoji proizvod sa kolicinom 2.
	Brise stavku iz korpe klikom na dugme x.
	Verifikuje poruku za praznu korpu.
	Osmislite pageve za ovaj zadatak!
*/
	
	private WebDriver driver;
	private NavigationPages np;
	private Cart cart;
	private Products products;
	private JavascriptExecutor js;
	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		np = new NavigationPages(driver);
		cart = new Cart(driver);
		products= new Products(driver);
		js= (JavascriptExecutor) driver;
	}

	@Test
	public void addingAndRemovingFromCart() throws InterruptedException {
		driver.navigate().to("https://cms.demo.katalon.com/");
		driver.manage().window().maximize();
		np.getShopLink().click();
		products.getProductPage(1).click();
		js.executeScript("arguments[0].scrollIntoView();", products.getQuantity());
		products.addProductToCart("2");
		products.getQuantity().sendKeys(Keys.ENTER); //morao sam ovako a ne preko metode odnosi mi neki element klik
		js.executeScript("arguments[0].scrollIntoView();", products.getAddToCartBtn());
		
		System.out.println(products.messageAdd());
		Assert.assertTrue(products.messageAdd().contains("have been added"),"Message didn't appeared");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.className("page-header-block")));
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(products.getViewCartBtn()));
		products.getViewCartBtn().click();
		
		WebElement element = driver.findElement(By.className("input-text"));
		String elementval = element.getAttribute("value");
		System.out.println(elementval);
		Assert.assertTrue(cart.isThere2Products("2"),"There is not 2 products in cart");
		cart.removeProduct();
		System.out.println(cart.messageEmptyCart());
		Assert.assertTrue(cart.messageEmptyCart().contains("cart is currently empty"), "Message didn't appeared");
}
	@AfterMethod
	public void after() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}