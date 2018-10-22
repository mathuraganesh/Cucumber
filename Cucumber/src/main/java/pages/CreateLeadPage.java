package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import wdMethods.SeMethods;

public class CreateLeadPage extends SeMethods {
	public CreateLeadPage() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.ID,using="createLeadForm_companyName")
	private WebElement eleCompanyName;
	@And("Enter the Company Name as (.*)")
	public CreateLeadPage typeCompanyName(String cName) {
		type(eleCompanyName, cName);
		return this;
	}
	
	@FindBy(how=How.ID,using="createLeadForm_firstName")
	private WebElement eleFisrtName;
	@And("Enter the First Name as (.*)")
	public CreateLeadPage typeFirstName(String fName) {
		type(eleFisrtName, fName);
		return this;
	}
	
	@FindBy(how=How.ID,using="createLeadForm_lastName")
	private WebElement eleLastName;
	@And("Enter the Last Name as (.*)")
	public CreateLeadPage typeLastName(String cName) {
		type(eleLastName, cName);
		return this;
	}
	
	@FindBy(how=How.ID,using="createLeadForm_primaryEmail")
	private WebElement eleEmailId;
	@And("Enter the EmailId as (.*)")
	public CreateLeadPage typeEmailid(String emailId) {
		type(eleEmailId, emailId);
		return this;
	}
	
	@FindBy(how=How.ID,using="createLeadForm_primaryPhoneNumber")
	private WebElement elePhoneNumber;
	@And("Enter the PhoneNo as (.*)")
	public CreateLeadPage typephoneNumber(String phoneNumber) {
		type(elePhoneNumber, phoneNumber);
		return this;
	}
	
	@FindBy(how=How.CLASS_NAME,using="smallSubmit")
	private WebElement eleSubmitButton;
	@When("Click the Create Lead Submit Button")
	public ViewLeadPage clickCreateLead() {
		click(eleSubmitButton);
		return new ViewLeadPage();
	}
	
	@FindBy(how=How.CLASS_NAME,using="errorList")
	private WebElement eleErrorMessage;
	public CreateLeadPage clickSubmitForFailure() {
		click(eleSubmitButton);
		return this;
	}
		
	public CreateLeadPage veifyErrMsg(String expectedText) {
		verifyPartialText(eleErrorMessage, expectedText);
		return this;
	}
	
}
