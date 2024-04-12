package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.base.SeleniumBase;

public class CheckoutInformationPage extends SeleniumBase {
	
	public CheckoutInformationPage(RemoteWebDriver driver) {
		this.driver = driver;
		
	}
	
	public void checkoutInformation(String firstName, String lastName, String postalCode) {
		type(driver.findElement(By.id(properties.getProperty("CheckoutInformationPage.firstName.id"))), firstName);
		type(driver.findElement(By.id(properties.getProperty("CheckoutInformationPage.lastName.id"))), lastName);
		type(driver.findElement(By.id(properties.getProperty("CheckoutInformationPage.postalCode.id"))), postalCode);
		click(driver.findElement(By.id(properties.getProperty("CheckoutInformationPage.continueButton.id"))));
		System.out.println("Customer Information has been added successfully to Checkout");
	}
}
