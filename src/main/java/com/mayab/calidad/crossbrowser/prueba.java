package com.mayab.calidad.crossbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.regex.Pattern;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class prueba {
	public static final String URL= "https://adineri:28c2372a-8b03-4d5c-a204-5fc6241dbcfb@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	public static void main(String args[]) throws Exception {
		DesiredCapabilities caps = DesiredCapabilities.firefox();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("platform", "Linux");
	    caps.setCapability("platform", "macOS 10.13");
	    caps.setCapability("version", "latest");
	    caps.setCapability("name", "Firefox");
	    caps.setCapability("extendedDebugging", "true");
	    caps.setCapability("buildNumber", "3.0");
    
	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);

		driver.get("https://mern-crud.herokuapp.com/");
		driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
		driver.findElement(By.name("name")).click();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("Andres Abimeri");
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("andres@gmail.com");
		driver.findElement(By.name("age")).click();
		driver.findElement(By.name("age")).clear();
		driver.findElement(By.name("age")).sendKeys("22");
		driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
		driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
		driver.findElement(By.xpath("//form/button")).click();
		
		driver.quit();
	}	
}