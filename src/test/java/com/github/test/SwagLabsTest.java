package com.github.test;

import java.util.Base64;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.base.Common;
import com.github.pages.CartPage;
import com.github.pages.CheckoutCompletePage;
import com.github.pages.CheckoutInformationPage;
import com.github.pages.CheckoutOverviewPage;
import com.github.pages.LoginPage;
import com.github.pages.ProductsPage;

public class SwagLabsTest extends Common {

	LoginPage login;
	ProductsPage products;
	CartPage cart;
	CheckoutOverviewPage checkoutOverview;
	CheckoutInformationPage checkoutInformation;
	CheckoutCompletePage checkoutComplete;

	@BeforeClass
	void setUpObject() {
		login = new LoginPage(driver);
		products = new ProductsPage(driver);
		cart = new CartPage(driver);
		checkoutOverview = new CheckoutOverviewPage(driver);
		checkoutInformation = new CheckoutInformationPage(driver);
		checkoutComplete = new CheckoutCompletePage(driver);

	}

	@Test (priority = 1)
	void login() {
		
		login.login(properties.getProperty("username"), properties.getProperty("password"));
	
	}

	@Test (priority = 2)
	void productsList() {
		products.productsList();
	}

	@Test (priority = 3)
	void productsSorting() throws InterruptedException {
		products.productsSortingByName();
		products.productsSortingByprice();
	}

	@Test (priority = 4)
	void addingToCart() throws InterruptedException {
		products.addToCart();
		products.clickCartIcon();
	}

	@Test (priority = 5)
	void checkout() {
		cart.checkoutOrder();
		checkoutInformation.checkoutInformation(properties.getProperty("firstName"), properties.getProperty("lastName"), properties.getProperty("postalCode"));
		checkoutOverview.checkoutSubmit();
		checkoutComplete.checkoutComplete();
	}


}


