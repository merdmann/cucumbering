package net.michaelslab.demo.TestRunner.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.junit.runner.RunWith;

public class UserSteps {
    String url = "";
    WebDriver driver = null;
    Capabilities caps = null;
    String browserName = "";

    public void UserSteps() {
        System.out.println("UserSteps()");
        System.setProperty("webdriver.chrome.driver","C:\\windriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        this.driver = driver;
        this.caps = ((RemoteWebDriver) driver).getCapabilities();

        this.browserName = caps.getBrowserName();
    }

    @Given("browser {string} available")
    public void browser_available(String string) {
        // Write code here that turns the phrase above into concrete actions
        Capabilities caps = ((RemoteWebDriver) this.driver).getCapabilities();
        System.out.println( "BrowserName=" + caps.getBrowserName());
        // throw new io.cucumber.java.PendingException();
    }


    @When("open {string}")
    public void open_page_by_url(String url) throws Throwable {
        System.setProperty("webdriver.chrome.driver","C:\\windriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.url = url;
        this.driver.get( "http:" + this.url + "");
    }

    @Then("find {string}")
    public void search_for(String text) throws Throwable {
        WebElement input = this.driver.findElement( By.className("search-words") );
        input.sendKeys(text);
        this.driver.findElement( By.name("search") ).click();

    }



}
