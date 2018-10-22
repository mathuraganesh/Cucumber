package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import wdMethods.SeMethods;

public class EditLeadPage extends SeMethods {
	public EditLeadPage() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.ID,using="updateLeadForm_companyName")
	private WebElement eleClearField;
	@And("Clear the Company Field")
	public EditLeadPage clearCompanyName() {
		clear(eleClearField);
		return this;
	}
	
	@FindBy(how=How.ID,using="updateLeadForm_companyName")
	private WebElement eleEditField;
	@And("Enter the Company Name to be Edit as (.*)")
	public EditLeadPage typeCompanyName(String Cname) {
		type(eleEditField, Cname);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//input[@class='smallSubmit']")
	private WebElement eleSubmitButton;
	@When("Click the Edit Submit Button")
	public ViewLeadPage clickEditButton() throws InterruptedException {
		click(eleSubmitButton);
		Thread.sleep(1000);
		return new ViewLeadPage();
	}
	
}
