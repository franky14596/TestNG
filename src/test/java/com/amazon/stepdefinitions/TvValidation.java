package com.amazon.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TvValidation {
	 static WebDriver driver;
	
@BeforeClass(groups ="default")
public static void beforeclass() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}

@AfterClass(groups="default")
public static void afterclass() {
	driver.quit();
}

@Test (priority = 1,groups ="sanity")
public void tvclick() {
	WebElement tvicon = driver.findElement(By.xpath("//img[@alt='Smart LED TVs']"));
	tvicon.click();
	
}

@Test (priority = 2,groups="sanity")
public void scroldown() {
	
	JavascriptExecutor j = (JavascriptExecutor)driver;
	WebElement down = driver.findElement(By.xpath("//span[text()='Amazon Basics Smart LED TVs']"));
	j.executeScript("arguments[0].scrollIntoView(true)", down);
	
}

@Test (priority = 3)
public void prodclick () {
	WebElement product = driver.findElement(By.xpath("(//span[contains(text(),'50')])[8]"));
	product.click();
}

}
