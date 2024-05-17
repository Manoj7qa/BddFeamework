package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		List<WebElement> ele = ldriver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));
		for (WebElement count : ele) {
			String st = count.getText();
			System.out.println("Price of product  " + st);
		}
	}

	public void close() {
		ldriver.close();
	}

}
