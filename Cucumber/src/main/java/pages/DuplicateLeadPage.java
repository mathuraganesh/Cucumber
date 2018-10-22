package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import wdMethods.SeMethods;

public class DuplicateLeadPage extends SeMethods {
	public DuplicateLeadPage() {
		PageFactory.initElements(driver, this);
		
	}
	
		
	@FindBy(how=How.CLASS_NAME,using="smallSubmit")
	private WebElement eleDuplicateButton;
	@When("Click the Duplicate Button")
	public ViewLeadPage clickDuplicateButton() throws InterruptedException {
		click(eleDuplicateButton);
		Thread.sleep(1000);
		return new ViewLeadPage();
	}
	
	@And("Verify the Title as (.*)")
	public boolean getTitle(String titleName) {
		return verifyTitle(titleName);
	}  
	
	
}
