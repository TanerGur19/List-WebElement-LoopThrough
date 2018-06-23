package com.jobappliation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PersonalInfoTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {   // Run only once
		
		System.out.println("Setting Up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void navigateToHomePage() {
		System.out.println("Navigating to Homepage in @BeforeMethod");
		driver.get("https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ");
		
		
	}
	// New class version
	@Test
	public void fullNameEmptyTest() {
		
		// make sure you are on the same page
		
		assertEquals(driver.getTitle(), "SDET Job Application");
		driver.findElement(By.xpath("//input[@name='Name_First']")).clear();
		driver.findElement(By.xpath("//input[@name='Name_Last']")).clear();
      // OR
		//driver.findElement(By.xpath("//input[@elname='first']")).clear();
	//	driver.findElement(By.xpath("//input[@elname='last']")).clear();

		
		driver.findElement(By.xpath("//em[.=' Next ']")).click();  //  Specific text you can not use elname now.
		
		String nameError = driver.findElement(By.xpath("//p[@class='errorMessage']")).getText();
		// String nameError2 = driver.findElement(By.id("error-Name")).getText();
		
		assertEquals(nameError, "Enter a value for this field.");
		// assertEquals(nameError2, "Enter a value for this field.");
	}
	
	
	
	
	
	
	
	
	
	
}




















