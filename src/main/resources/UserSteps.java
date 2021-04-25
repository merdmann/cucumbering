package net.michaelslab.demo.UserSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UserSteps {
    int my_cukes = 0;
    String url = "";
    WebDriver driver = null;

    public void UserSteps() {
        System.setProperty("webdriver.chrome.driver","C:\\windriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();

        String browserName = caps.getBrowserName();
        System.out.println("browsername:" + browserName);
        this.driver = driver;
    }

    @When("open \"([^\"]*)\"$")
    public void open_page_by_url(String url) throws Throwable {
        System.setProperty("webdriver.chrome.driver","C:\\windriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        //this.driver.getCapabilities();
        this.url = url;
        this.driver.get( "http:" + this.url + "");
    }

    @When("find \"([^\"]*)\"$")
    public void search_for(String text) throws Throwable {
        WebElement input = this.driver.findElement( By.className("search-words") );
        input.sendKeys(text);
    }

    @Given("I have {int} cukes in my belly")
    public void i_have_n_cukes_in_my_belly(int cukes) {
        this.my_cukes = cukes;
        System.out.format( "%n\n", cukes);
    }

    @Then("the answer is {int}")
    public void the_answer_is(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        if( this.my_cukes != int1 )
            throw new io.cucumber.java.PendingException();
    }

}
