package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class ApplicationManager {
	

	public static WebDriver driver;
	public static String baseUrl;
	public static boolean acceptNextAlert = true;
	
	public ApplicationManager() {
	    driver = new FirefoxDriver();
	    baseUrl = "http://addressbookv4.1.4/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	}

	public void stop() {
	    driver.quit();
	}
	
	public void returnToGroupsPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	public void submitGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}

	public void fillGroupForm(TestBase testBase, GroupData group) {
		driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void initGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	public void goToGroupsPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	public void openMainPage() {
		driver.get(baseUrl + "/");
	}

	public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
