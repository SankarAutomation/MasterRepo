package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.base.SeleniumBase;

public class CartPage extends SeleniumBase {
	
	public CartPage(RemoteWebDriver driver) {
		this.driver = driver;
		
	}
	
	public void checkoutOrder() {
		click(driver.findElement(By.id(properties.getProperty("CartPage.checkout.id"))));
	}
}
