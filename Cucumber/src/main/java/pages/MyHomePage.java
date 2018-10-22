package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wdMethods.SeMethods;

public class MyHomePage extends SeMethods {
	public MyHomePage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.LINK_TEXT,using = "CRM/SFA")
	private WebElement eleCRMClick;
	@When("Click the CRMSFA Link")
	public MyHomePage clickLogin() {
		click(eleCRMClick);	
		return this;
	}
	
	@Then("Verify the Home Page")
	public MyHomePage verifyLogin() {
		System.out.println("Login page Verified sucessfully");	
		return this;
	}
	
	@FindBy(how=How.LINK_TEXT,using="Leads")
	private WebElement eleLeads;
	@Given("Click the Leads Link")
	public MyLeadsPage clickLeads() throws InterruptedException {
		click(eleLeads);
		Thread.sleep(1000);
		return new MyLeadsPage();
	}

	
}
