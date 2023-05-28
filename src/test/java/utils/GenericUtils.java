package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObjects.OfferPage;

public class GenericUtils {
	public WebDriver driver;
	public OfferPage offerpage;
	TestContextSetup testcontextsetup;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;		
	}

	public void SwitchWindowToChild() {
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentwindow = i1.next();
		String childwindow = i1.next();
		driver.switchTo().window(childwindow);
	}
	public String randomString(int length) {
		String alphabits="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb= new StringBuilder();
		Random random=new Random();	
		
		for(int i=0;i<=length; i++) {
			int index=random.nextInt(alphabits.length());
			char randomChar=alphabits.charAt(index);
			sb.append(randomChar);
		}
		String randomString=sb.toString();
		return randomString;
		
	}
	public String randomNumber(int length) {
		String alphabits="1234567890";
		StringBuilder sb= new StringBuilder();
		Random random=new Random();	
		
		for(int i=0;i<=length; i++) {
			int index=random.nextInt(alphabits.length());
			char randomChar=alphabits.charAt(index);
			sb.append(randomChar);
		}
		String randomString=sb.toString();
		return randomString;
			}
	public Actions actions(String path) {
		offerpage=new OfferPage(driver);
		Actions a=new Actions(driver);
		 return a.moveToElement(offerpage.hOver(path));
		
	}
	public String todayDate() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");  
		   LocalDateTime now = LocalDateTime.now();  
		   if(dtf.format(now).equalsIgnoreCase("31")) {
			   return "30";
		   }else {
			   return dtf.format(now);
		   }
		   
	}
	
}
