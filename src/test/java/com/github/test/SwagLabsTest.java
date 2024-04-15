package com.github.test;

import java.util.Base64;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
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

	@BeforeSuite
	public void startReport() {
		initializeReport();
	}

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
		
		String methodName = new Exception().getStackTrace()[0].getMethodName();
		test = extent.createTest(methodName, "TC001- Login");
		test.assignCategory("Sanity Testing");
		test.assignAuthor("Sankar");
		byte[] decryptUsername = Base64.getDecoder().decode(properties.getProperty("encryptedUsername"));
		String decryptedUsername = new String (decryptUsername);
		byte[] decryptPwd = Base64.getDecoder().decode(properties.getProperty("encryptedPassword"));
		String decryptedPassword = new String (decryptPwd);
		login.login(decryptedUsername, decryptedPassword);

	}

	@Test (priority = 2)
	void productsList() {
		String methodName = new Exception().getStackTrace()[0].getMethodName();
		test = extent.createTest(methodName, "TC002- Product Listing: Verify the products");
		test.assignCategory("Sanity Testing");
		test.assignAuthor("Sankar");
		products.productsList();
	}

	@Test (priority = 3)
	void productsSorting() throws InterruptedException {
		String methodName = new Exception().getStackTrace()[0].getMethodName();
		test = extent.createTest(methodName, "TC003- Sorting : Sort By Name and Price");
		test.assignCategory("Sanity Testing");
		test.assignAuthor("Sankar");
		products.productsSortingByName();
		products.productsSortingByprice();
	}

	@Test (priority = 4)
	void addingToCart() {
		String methodName = new Exception().getStackTrace()[0].getMethodName();
		test = extent.createTest(methodName, "TC004 / TC006- Adding to Cart: After sorting, adding first 3 low price to cart and check out");
		test.assignCategory("Sanity Testing");
		test.assignAuthor("Sankar");
		products.addToCart();
		products.clickCartIcon();
	}

	@Test (priority = 5)
	void checkout() {
		String methodName = new Exception().getStackTrace()[0].getMethodName();
		test = extent.createTest(methodName, "TC005 Checkout: verify that the user can proceed to checkout");
		test.assignCategory("Sanity Testing");
		test.assignAuthor("Sankar");
		cart.checkoutOrder();
		checkoutInformation.checkoutInformation(properties.getProperty("firstName"), properties.getProperty("lastName"), properties.getProperty("postalCode"));
		checkoutOverview.checkoutSubmit();
		checkoutComplete.checkoutComplete();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}


