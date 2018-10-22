package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import wdMethods.ProjectMethod;
import wdMethods.SeMethods;

public class LoginPage extends SeMethods{


	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID,using="username")
	private WebElement eleUserName;

	@Given("Enter the UserName as (.*)")
	public LoginPage typeUserName(String userName) {
		// eleUName = locateElement("username");
		type(eleUserName,userName);	
		return this;
	}

	@FindBy(how=How.ID,using="password")
	private WebElement elePassword;
	@And("Enter the Password as (.*)")
	public LoginPage typePassword(String password) {
		type(elePassword, password);
		return this;
	}


	@FindBy(how=How.CLASS_NAME,using = "decorativeSubmit")
	private WebElement eleLogin;
	@When("Click the Login Button")
	public MyHomePage clickLogin() {
		click(eleLogin);	
		return new MyHomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
	




}
