package d10_02_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlayerPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	public PlayerPage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		this.js= (JavascriptExecutor)driver;
	}
	public WebElement getPriprema(String izbor) {
		//return driver.findElement(By.xpath("/html/body/div/header/p[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'faux-link')][@data-source='"+izbor+"']")));
		return driver.findElement(By.xpath("//*[contains(@class,'faux-link')][@data-source='"+izbor+"']"));
	}
	public void playVideo() {
		
		this.js.executeScript("player.play();");
	}
	public void pauseVideo() {
		
		this.js.executeScript("player.pause();");
	}
	public WebElement getCurrentTime() {
		return driver.findElement(By.xpath("//*[@aria-label='Current time']"));
	}
	public String currentTime() {
		return getCurrentTime().getText();
	}
	public WebElement getVolume() {
		return driver.findElement(By.xpath("//*[@aria-label='Volume']"));
	}
	public int volume() {
		int i=0;
		String volume = getVolume().getAttribute("aria-valuenow");
		
		     i = Integer.parseInt(volume);
		    return i;
			
	
	
	}
	public void volumeDown(int n) {
		String zvuk=""+n+"";
		js.executeScript("player.decreaseVolume(arguments[0]/100);", zvuk);
	}
	public void volumeUp(int n) {
		String zvuk=""+n;
		js.executeScript("player.decreaseVolume(arguments[0]/100);",zvuk);
	}
	
	
}
