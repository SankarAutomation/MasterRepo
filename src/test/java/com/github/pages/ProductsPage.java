package com.github.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.base.SeleniumBase;

public class ProductsPage extends SeleniumBase {

	public ProductsPage(RemoteWebDriver driver) {
		this.driver = driver;

	}

	public void productsList() {
		List<WebElement> totalProducts = driver.findElements(By.xpath(properties.getProperty("ProductsPage.productsName.xpath")));
		System.out.println("Total Products available in Sawag Labs: "+totalProducts.size());
		System.out.println("Name of the products in the Swag Labs are: ");
		for (WebElement allProducts : totalProducts) {
			System.out.println(allProducts.getText());
		}
	}
	public void productsSortingByName() {
		WebElement options = driver.findElement(By.xpath(properties.getProperty("ProductsPage.productsSort.xpath")));
		Select dropdownOptions = new Select(options);
		dropdownOptions.selectByVisibleText("Name (A to Z)");
		List<WebElement> availableProducts = driver.findElements(By.xpath(properties.getProperty("ProductsPage.productsName.xpath")));
		System.out.println("Products order After selecting the Sort Name(A->Z) are: ");
		for (WebElement allProd : availableProducts) {
			System.out.println(allProd.getText());
		}
	}		
	public void productsSortingByprice() throws InterruptedException {
		List<WebElement> priceListBeforeSort = driver.findElements(By.xpath(properties.getProperty("ProductsPage.productsPrice.xpath")));
		System.out.println("Products order Before selecting the Sort Price (low to high) are: ");
		for (WebElement beforeSort : priceListBeforeSort) {
			System.out.println(beforeSort.getText());
		}
		WebElement options1 = driver.findElement(By.xpath(properties.getProperty("ProductsPage.productsSort.xpath")));
		Select dropdownValues = new Select(options1);
		dropdownValues.selectByVisibleText("Price (low to high)");
		List<WebElement> priceList = driver.findElements(By.xpath(properties.getProperty("ProductsPage.productsPrice.xpath")));
		System.out.println("Products order After selecting the Sort Price (low to high) are: ");
		for (WebElement allProducts : priceList) {
			System.out.println(allProducts.getText());
		}
		

	}
	
	public void addToCart() {
		
		for (int i = 1; i <= 3; i++)
		{
			driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])["+i+"]")).click();
		}
		
		System.out.println("Low Price 3 Products has been Selected & successfully added to cart");
	
	}
	
	public void clickCartIcon() {
		click(driver.findElement(By.className(properties.getProperty("ProductsPage.productAddToCartIcon.className"))));
	}

}



