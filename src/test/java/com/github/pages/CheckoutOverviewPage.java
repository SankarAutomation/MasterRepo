package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.base.SeleniumBase;

public class CheckoutOverviewPage extends SeleniumBase {
	
	public CheckoutOverviewPage(RemoteWebDriver driver) {
		this.driver = driver;
		
	}
	
	public void checkoutSubmit() {
		click(driver.findElement(By.id(properties.getProperty("CheckoutOverviewPage.finish.id"))));
	}
}
