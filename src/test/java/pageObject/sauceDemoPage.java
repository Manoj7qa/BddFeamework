package pageObject;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class sauceDemoPage {
	public WebDriver ldriver;

	public sauceDemoPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id=\"user-name\"]")
	WebElement userNameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "login-button")
	WebElement loginButton;
	@FindBy(xpath = "//select[@class=\"product_sort_container\"]")
	WebElement filter;
	@FindBy(xpath = "//div[@class=\"inventory_item_price\"]")
	WebElement price;
	@FindBy(xpath = "//button[@id=\"react-burger-menu-btn\"]")
	WebElement menuButton;
	@FindBy(xpath = "//a[.='Logout']")
	WebElement logoutButton;

	public String getSauceDemoTitle() {
		return ldriver.getTitle();

	}

	public void enterUserName(String UN) {
		userNameField.sendKeys(UN);

	}

	public void enterPassword(String PWD) {
		passwordField.sendKeys(PWD);

	}

	public void loginButton() {
		loginButton.click();
	}

	public String homePageTitle() {
		return ldriver.getTitle();
	}

	public void applyFilter() {
		Select s = new Select(filter);
		s.selectByVisibleText("Price (low to high)");
	}

	public void getPriceWithFilter() {
		List<WebElement> productPrices = ldriver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));
		for (WebElement count : productPrices) {
			String st = count.getText();
			System.out.println("Price of product  " + st);
		}
	}

	Float[] array = new Float[6];

	public void getPriceWithoutFilter() {
		List<WebElement> productPrices = ldriver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));
		String[] textArray = new String[productPrices.size()];
		for (int i = 0; i < textArray.length; i++) {
			String price = productPrices.get(i).getText();
			String q = price.replaceAll("[^\\d.-]", "");
			Float a = Float.valueOf(q);
			array[i] = a;
		}

		for (int p = 0; p < productPrices.size() - 1; p++) {
			for (int q = 0; q < productPrices.size() - p - 1; q++) {
				if (array[q] > array[q + 1]) {
					Float temp = array[q];
					array[q] = array[q + 1];
					array[q + 1] = temp;
				}

			}
		}
		for (int w = 0; w < productPrices.size() - 1; w++) {
			System.out.println("Product " + (w + 1) + " price: " + array[w]);
		}
	}

	public void logout() {
		menuButton.click();
		Actions act = new Actions(ldriver);
		act.click(logoutButton);
	}

	public void close() {
		ldriver.close();
	}

}
