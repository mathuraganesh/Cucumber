package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.SeMethods;

public class MergeLeadPage extends SeMethods {
	public MergeLeadPage() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="(//form[@name='MergePartyForm'])//a")
	WebElement eleFirstLeadIdGrid;
		
	@FindBy(xpath="//a[@class='linktext']")
	WebElement eleLeadLink;
	
	@FindBy(xpath="//table[@id='widget_ComboBox_partyIdTo']//following::a")
	WebElement eleSecondLeadIdGrid;
	
	@FindBy(linkText="Merge")
	WebElement eleMergeButton;
	
	public String ParentWindow() {
		return getParentWindow();
	}
		
	/*public MergePage switchwindow(int index) {
		switchToWindow(index);
		return new MergePage();
	}  */
	
	public MergePage FirstLeadIDGrid() {
		click(eleFirstLeadIdGrid);
		switchToWindow(1);
		return new MergePage();
	}
	
	public MergePage SecondLeadIDGrid() {
		click(eleSecondLeadIdGrid);
		switchToWindow(1);
		return new MergePage();
	}
	
	public MergeLeadPage MergeButton() throws InterruptedException {
		click(eleMergeButton);
		Thread.sleep(1000);
		return this;
	}
	
	public FindLeadPage AcceptAlert() throws InterruptedException {
		acceptAlert();
		Thread.sleep(1000);
		return new FindLeadPage();
	}
	
}

