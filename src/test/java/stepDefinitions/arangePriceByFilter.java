package stepDefinitions;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pageObject.sauceDemoPage;

public class arangePriceByFilter {
	WebDriver driver;
	public sauceDemoPage sd;

	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		sd = new sauceDemoPage(driver);
	}

	@When("User open URL {string}")
	public void User_open_url(String URL) {
		driver.get(URL);
	}

	@Then("Login Page title should be {string}")
	public void Login_page_title_should_be(String title) {
		assertEquals(sd.getSauceDemoTitle(), title);
	}

	@Then("Enter UN {string} and PWD {string}")
	public void Enter_un_and_pwd(String un, String pwd) {
		sd.enterUserName(un);
		sd.enterPassword(pwd);
	}

	@Then("Click on Login Button")
	public void Click_on_login_Button() {
		sd.loginButton();
	}

	@Then("Home Page title should be {string}")
	public void home_page_title_should_be(String title) {
		assertEquals(title, sd.homePageTitle());
	}

	@Then("Apply filter")
	public void apply_filter() {
		sd.applyFilter();
	}

	@Then("Get all product price")
	public void Get_all_product_price() {
		sd.getPriceWithFilter();
	}

	@Then("Close browse")
	public void Close_browse() {
		sd.close();
	}

}
