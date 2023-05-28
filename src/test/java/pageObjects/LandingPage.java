package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement textBox(String locator) {
		//return driver.findElement(By.xpath("//input[@name='"+inputText+"'] or (//*[text()='"+inputText+"']//following::div/input)[1]"));
		return driver.findElement(By.xpath("//label[text()='"+locator+"']/preceding-sibling::input[@type='text']"));
	}

	public WebElement button(String locator) {
		return driver.findElement(By.xpath("//*[contains(@title,'"+locator+"')]"));
		
	}

	public WebElement clickable(String locator) {
		
		return driver.findElement(By.xpath("//*[@id='"+locator+"' or text()='"+locator+"' or contains(@name,'"+locator+"')]"));
		//return driver.findElement(By.xpath("(//*[text()='" + object + "' or contains(text(),'" + object + "')])[1]"));
	}
	public WebElement clickWithSection(String submenu,String menu) {
		return driver.findElement(By.xpath("//*[@class='title']//*[text()='"+menu+"']//following::a[text()='"+submenu+"']"));
	}
public WebElement Colorclick(String color) {
		
		return driver.findElement(By.xpath("//*[contains(@aria-label,'"+color+"')]"));
		//return driver.findElement(By.xpath("(//*[text()='" + object + "' or contains(text(),'" + object + "')])[1]"));
	}

}