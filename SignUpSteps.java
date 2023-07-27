package StepDefinitions;

import java.awt.Button;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSteps {
	WebDriver driver =null;
			
	@Given("user is on sign up page")
	public void user_is_on_sign_up_page() {
	String projectPath = System.getProperty("user.dir");
	System.out.println("Project path is :"+projectPath);
	System.out.println("Inside step : User in on the signup page");
	System.setProperty("webdriver.msedge.driver",projectPath+"/src/test/resources/drivers/msedgedriver.exe");
	driver = new EdgeDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.navigate().to("https://trello.com/");
	}

	@When("user enters the email address on the sign up page")
	public void user_enters_the_email_address_on_the_sign_up_page() {
	System.out.println("Inside step : User enters th email address on the signup page");
	driver.findElement(By.name("email")).sendKeys("testingtrello@gmail.com");

	}

	@And("clicks on the signup button")
	public void clicks_on_the_signup_button() {
	System.out.println("Inside step : User clicks on the sign up button");
	driver.findElement(By.name("email")).sendKeys(Keys.ENTER);

	}

	@Then("user is navigated to the sign up to continue page")
	public void user_is_navigated_to_the_sign_up_to_continue_page() {
	System.out.println("Inside step : User is navigated to the signup to continue page");
	driver.getPageSource().contains("Sign up to continue");

	}
	
	@And("clicks on the sign up button")
	public void clicks_on_the_sign_up_button() {
	System.out.println("Inside step : User clicks on the sign up button");
	//driver.findElement(By.id("signup-submit")).click();
	driver.findElement(By.xpath("//span[contains(.,'Sign up')]")).click();

	}

	@Then("user is navigated to the Trello Home page")
	public void user_is_navigated_to_the_trello_home_page() {
		System.out.println("Inside step : User is navigated to the Trello HomePage");

	}


}
