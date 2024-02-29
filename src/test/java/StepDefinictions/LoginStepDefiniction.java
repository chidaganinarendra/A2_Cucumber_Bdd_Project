package StepDefinictions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefiniction {
	
	
	WebDriver driver;

	@Given("User is on Login page")
	public void user_is_on_login_page() {
		// Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.saucedemo.com/v1/");
	}

	@When("User enter the Vaild Username and Password")

	public void user_enter_the_vaild_username_and_password() throws Exception {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
	}

	@And("Click on Login button")
	public void click_on_login_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("login-button")).click();

		Thread.sleep(5000);
	}

	@Then("User is navigated to Home page")
	public void user_is_navigated_to_home_page() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"header_container\"]/div[1]/div")).size() > 0,
				"User is navigated to Home page");
	}

	@Then("Close The Browser")
	public void close_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		driver.close();
	}


}
