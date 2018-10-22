package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import wdMethods.SeMethods;

public class FindLeadPage extends SeMethods {
	public static String sFirstLeadId;
	public FindLeadPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(how=How.XPATH,using="(//input[@name='firstName'])[3]")
	WebElement eleEditFirstName;
	@And("Enter the First Name to be Edit as (.*)")
	public FindLeadPage typeEditFname(String EditfName)
	{
		type(eleEditFirstName, EditfName);
		return this;
	}
	
	
	@FindBy(how=How.XPATH,using="//button[text()='Find Leads']")
	private WebElement eleFindLead;
	@And("Click the Find Leads")
	public FindLeadPage clickFindLeads() throws InterruptedException
	{
		click(eleFindLead);
		Thread.sleep(1000);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="(//a[@class='linktext'])[4]")
	private WebElement eleLeadID;
	@And("Click the LeadId")
	public ViewLeadPage clickLeadId() throws InterruptedException {
		click(eleLeadID);
		Thread.sleep(1000);
		return new ViewLeadPage();
	}
	
	@FindBy(how=How.XPATH,using="//span[text()='Phone']")
	private WebElement eleDeletePhoneTab;
	@And("Click the Delete Phone Tab")
	public FindLeadPage clickDeletePhoneTab() throws InterruptedException {
		click(eleDeletePhoneTab);
		Thread.sleep(1000);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='phoneNumber']")
	private WebElement eleDeletePhoneNumber;
	@And("Enter the Phone Number to be Delete as (.*)")
	public FindLeadPage typeDeletePhoneNumber(String phoneNumber) {
		type(eleDeletePhoneNumber, phoneNumber);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="(//a[@class='linktext'])[4]")
	private WebElement eleGetFirstLeadId;
	@And("Get the LeadId")
	public FindLeadPage getLeadID() {
		sFirstLeadId=getText(eleGetFirstLeadId);
		//System.out.println("First LeadID"+sFirstLeadId);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="(//input[@name='id'])[1]")
	private WebElement eleTypeLeadId;
	@And("Enter the LeadId")
	public FindLeadPage typeLeadId() {
		//System.out.println("First LeadID"+sFirstLeadId);
		type(eleTypeLeadId,sFirstLeadId);
		return this;
	}
	public FindLeadPage typeFirstLeadId(String sLeadId) {
		//System.out.println("First LeadID"+sFirstLeadId);
		type(eleTypeLeadId,sLeadId);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//div[@class='x-paging-info']")
	private WebElement eleVerifyrecord;
	@Then("Verify No Record To Display")
	public FindLeadPage verifyNoRecordDisplay() {
		verifyExactText(eleVerifyrecord,"No records to display");
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//span[text()='Email']")
	private WebElement eleEmailTab;
	@And("Click the Email Tab")
	public FindLeadPage clickEmailTab() throws InterruptedException {
		click(eleEmailTab);
		Thread.sleep(1000);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='emailAddress']")
	private WebElement eleEmailId;
	@And("Enter the EmailId to DuplicateLead (.*)")
	public FindLeadPage typeEmailId(String emailId) {
		type(eleEmailId, emailId);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="(//a[@class='linktext'])[6]")
	private WebElement eleGetFirstName;
	@And("Get the FirstName")
	public String getFirstName() {
		return getText(eleGetFirstName);
				
	}
	
	/*public FindLeadPage getFirstName() {
		sGetFirstName=getText(eleGetFirstName);
		System.out.println("First Name"+sGetFirstName);
		return this;
	}  */

}
