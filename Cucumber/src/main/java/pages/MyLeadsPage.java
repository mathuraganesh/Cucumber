package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import wdMethods.SeMethods;

public class MyLeadsPage extends SeMethods {
	public MyLeadsPage() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.LINK_TEXT,using="Create Lead")
	private WebElement eleCreateLead;
	@Given("Click the Create Lead Button")
	public CreateLeadPage clickCreateLead() {
		click(eleCreateLead);
		return new CreateLeadPage();
	}
	
	@FindBy(how=How.LINK_TEXT,using="Find Leads")
	private WebElement eleFindLeads;
	@And("Click the Find Leads Link")
	public FindLeadPage clickFindLeadLink() {
		click(eleFindLeads);
		return new FindLeadPage();
	}
	
	@FindBy(how=How.LINK_TEXT,using="Merge Leads")
	private WebElement eleMergeLeads;
	public MergeLeadPage clickMergeLeadLink() throws InterruptedException {
		click(eleMergeLeads);
		Thread.sleep(1000);
		return new MergeLeadPage();
	}

}
