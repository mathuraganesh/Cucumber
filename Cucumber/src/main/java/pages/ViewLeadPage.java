package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import wdMethods.SeMethods;

public class ViewLeadPage extends SeMethods {
	public ViewLeadPage() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.ID,using="viewLead_firstName_sp")
	private WebElement eleVerifyFname;
	@Then("Verify the First Name as (.*)")
	public ViewLeadPage verifyFirstName(String fName) throws IOException {
		verifyExactText(eleVerifyFname,fName);
		//System.out.println("First Name"+expectedText);
		takeSnap("CreateLead"+fName);
		reportStep("Create Lead "+fName+" Created Sucessfully", "Pass","CreateLead"+fName);
		return this;
	}
	
	@Then("Verify the DuplicateLead First Name as (.*)")
	public ViewLeadPage verifyDuplicateFirstName(String fName) throws IOException {
		verifyExactText(eleVerifyFname,fName);
		//System.out.println("First Name"+expectedText);
		takeSnap("DuplicateLead"+fName);
		reportStep("Duplicate Lead "+fName+" Duplicated Sucessfully", "Pass","Duplicate"+fName);
		return this;
	}
	
	@FindBy(how=How.LINK_TEXT,using="Edit")
	private WebElement eleEditButton;
	@And("Click the Edit Button")
	public EditLeadPage clickEditButton() {
		click(eleEditButton);
		return new EditLeadPage();
	}
	
	@FindBy(how=How.XPATH,using="//a[text()='Duplicate Lead']")
	private WebElement eleDuplicateButton;
	@And("Click the Duplicate Link")
	public DuplicateLeadPage clickDuplicateLink() {
		click(eleDuplicateButton);
		return new DuplicateLeadPage();
	}
	
	@FindBy(how=How.ID,using="viewLead_companyName_sp")
	private WebElement eleverifycompanyname;
	@Then("Verify the Company Name as (.*)")
	public EditLeadPage verifyCompanyName(String cName) throws IOException {
		verifyPartialText(eleverifycompanyname,cName);
		takeSnap("EditLead"+cName);
		reportStep("Company Name "+cName+" Edited Sucessfully","Pass","EditLead"+cName);
		
		return new EditLeadPage();
	}
		
	@FindBy(how=How.XPATH,using="//a[@class='subMenuButtonDangerous']")
	private WebElement eleDeleteButton;
	@And("Click the Delete Button")
	public MyLeadsPage clickDeleteButton() throws InterruptedException {
		click(eleDeleteButton);
		Thread.sleep(1000);
		return new MyLeadsPage();
	}
	
}
