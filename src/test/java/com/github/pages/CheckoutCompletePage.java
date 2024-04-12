package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.base.SeleniumBase;

public class CheckoutCompletePage extends SeleniumBase {
	
	public CheckoutCompletePage(RemoteWebDriver driver) {
		this.driver = driver;
		
	}
	
	public void checkoutComplete() {
		String orderConfirmationHeaderMsg = driver.findElement(By.className(properties.getProperty("CheckoutCompletePage.orderConfirmationHeaderMsg.className"))).getText();
		String orderConfirmationMsg = driver.findElement(By.className(properties.getProperty("CheckoutCompletePage.orderConfirmationMsg.className"))).getText();
		System.out.println(orderConfirmationHeaderMsg + orderConfirmationMsg);
	}
	
	public void backHome() {
		click(driver.findElement(By.id(properties.getProperty("CheckoutCompletePage.backToHomeButton.id"))));
		
	}
}
