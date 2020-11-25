package com.mayab.calidad.bdd;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeatures {
	
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	

	@And("Browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "D:\\Universidad\\Calidad y pruebas\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("user is in login page")
	public void user_is_in_login_page() {
	    driver.get("https://example.testproject.io/web");
	}

	@When("^users enters (.*) and (.*)$")
	public void users_enters_username_and_password(String username, String password) {
	    driver.findElement(By.id("name")).sendKeys(username);
	    driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
		driver.findElement(By.id("login")).click();
	}

	@Then("website shows main page")
	public void website_shows_main_page() {
		assertEquals("Logout",driver.findElement(By.id("logout")).getText());
		driver.close();
		driver.quit();
	}


}
