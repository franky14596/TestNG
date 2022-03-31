package com.amazon.stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoeValidation {
	
	static WebDriver driver;
	
	@BeforeClass (groups ="default")
	public static void beforeclass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
	
	@AfterClass (groups ="default")
	public static void afterclass() {
		driver.quit();
	}
	
	@Test (priority = 1,groups ="sanity")
	public void footwear() {
		WebElement footwearbtn = driver.findElement(By.xpath("//span[text()='Footwear']"));
		footwearbtn.click();
	}
	
@Test (priority =2, groups ="sanity")
public void filter() {
	WebElement crocs = driver.findElement(By.xpath("//span[text()='crocs']"));
	crocs.click();
	WebElement asian = driver.findElement(By.xpath("//span[text()='ASIAN']"));
	asian.click();
}

@Test(priority =3)
public void selection() {
	WebElement product1 = driver.findElement(By.xpath("(//span[contains(text(),'Mesh')])[1]"));
	product1.click();
	WebElement product2 = driver.findElement(By.xpath("(//span[contains(text(),'Mesh')])[2]"));
    product2.click();
}

@Test(priority = 4) 
public void windowhandling() {
	String parent = driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	List<String> tablist = new ArrayList<String>();
	tablist.addAll(child);
	String finprod = tablist.get(1);
	driver.switchTo().window(finprod);
	}

@Test (priority = 5)
public void dropdown() throws Exception {
	
	WebElement dropdown = driver.findElement(By.name("dropdown_selected_size_name"));
	Select s = new Select(dropdown);
	s.selectByIndex(5);
	Thread.sleep(5000);
}

@Test (priority = 6,enabled = false)
public void buynow() {
	WebElement buynow = driver.findElement(By.xpath("//span[text()=' Buy Now ']"));
	buynow.click();
}
}
