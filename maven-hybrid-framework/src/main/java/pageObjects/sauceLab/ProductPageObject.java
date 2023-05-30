package pageObjects.sauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.sauceLab.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);

	}

	public boolean isProductNameSortByAscending() {
		// Khai báo ra 1 ArrayList để chứa các product name trên UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			System.out.println("Product Name ở trên UI: " + productName.getText());
		}

		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay không
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// sort cái productSortList
		Collections.sort(productSortList);

		for (String productName : productSortList) {
			System.out.println("Product Name sau khi sort: " + productName);
		}

		// so sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		// Khai báo ra 1 ArrayList để chứa các product name trên UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			System.out.println("Product Name ở trên UI: " + productName.getText());
		}

		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay không
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// sort cái productSortList
		Collections.sort(productSortList);

		for (String productName : productSortList) {
			System.out.println("Product Name sau khi sort ASC: " + productName);
		}

		// reverse cái productSortList
		Collections.reverse(productSortList);

		for (String productName : productSortList) {
			System.out.println("Product Name sau khi sort DSC: " + productName);
		}

		// so sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending() {
		// Khai báo ra 1 ArrayList để chứa các product name trên UI
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productPrice : productPriceText) {
//			String priceText = productPrice.getText();
//			
//			// xóa ký tư $
//			priceText.replace("$", "");
//			
//			// convert qua kiểu Float
//			Float priceTextFloat = Float.parseFloat(priceText);

			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
			System.out.println("Product Name ở trên UI: " + productPrice.getText());
		}

		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay không
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float productPrice : productUIList) {
			productSortList.add(productPrice);
		}

		// sort cái productSortList
		Collections.sort(productSortList);

		for (Float productPrice : productSortList) {
			System.out.println("Product Name sau khi sort: " + productPrice);
		}

		// so sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
		// Khai báo ra 1 ArrayList để chứa các product name trên UI
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productPrice : productPriceText) {
//					String priceText = productPrice.getText();
//					
//					// xóa ký tư $
//					priceText.replace("$", "");
//					
//					// convert qua kiểu Float
//					Float priceTextFloat = Float.parseFloat(priceText);

			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
			System.out.println("Product Name ở trên UI: " + productPrice.getText());
		}

		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay không
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}

		// sort cái productSortList
		Collections.sort(productSortList);

		for (Float productPrice : productSortList) {
			System.out.println("Product Name sau khi sort ASC: " + productPrice);
		}

		// reverse cái productSortList
		Collections.reverse(productSortList);

		for (Float productPrice : productSortList) {
			System.out.println("Product Name sau khi sort DSC: " + productPrice);
		}

		// so sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);
	}

}
