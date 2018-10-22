package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;

public class SeMethods extends ProjectMethod implements WdMethods {
	public static RemoteWebDriver driver;
	public static String sFirstLeadId;
	int i = 1;
	public void startApp(String browser, String url) throws IOException {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:/Ganesh/TestLeaf/Driver/chromedriver.exe");
				 driver = new ChromeDriver();			
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:/Ganesh/TestLeaf/Driver/geckoriver.exe");
				 driver = new FirefoxDriver();		
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//System.out.println("The Browser "+browser+" is Launched Successfully");
			takeSnap("Browser"+i);
			reportStep("The Browser "+browser+" is Launched Successfully", "pass","Browser"+i);
			i++;
			
			
		} catch (Exception e) {
			takeSnap("Browser");
			reportStep("The Browser "+browser+" is Launched UnSuccessfully", "Fail","Browser");
		}
		
	}

	public WebElement locateElement(String locator, String locValue) {
		switch (locator) {
		case "id": 	  return driver.findElementById(locValue);
		case "class": return driver.findElementByClassName(locValue);
		case "xpath": return driver.findElementByXPath(locValue);	
		case "linktext": return driver.findElementByLinkText(locValue);
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}

	public void type(WebElement ele, String data) {
		ele.sendKeys(data);
		System.out.println("The Data "+data+" is Entered Successfully");
		//takeSnap();
	}

	public void click(WebElement ele) {
	ele.click();
	System.out.println("The Element "+ele+" is clicked Successfully");
	//takeSnap();		
	}
	
	public void clear(WebElement ele) {
		ele.clear();
		System.out.println("The Element "+ele+" is clicked Successfully");
		//takeSnap();		
		}
	
	public String getAttribute(WebElement ele,String value) {
		String sGetvalue=ele.getAttribute(value);
		return sGetvalue;
		
	}
	public String getText(WebElement ele) {
		String sGetvalue=ele.getText();
		return sGetvalue;
		
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		WebElement dd=ele;
		Select sList=new Select(dd);
		sList.selectByVisibleText(value);
		System.out.println("The Value "+value+" is selected Using Visible text Successfully");
		//takeSnap();
		
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		WebElement dd=ele;
		Select sList=new Select(dd);
		sList.selectByIndex(index);
		System.out.println("The Value is selected By Index Value Successfully");
		//takeSnap();
		
	}

	public boolean verifyTitle(String expectedTitle) {
		boolean bTitle=false;
		if(driver.getTitle().contains(expectedTitle)) {
			System.out.println("The Title "+expectedTitle+" is Matched");
			//System.out.println(driver.getTitle());
			return bTitle=true;
		}
		else {
			System.out.println("The Title "+expectedTitle+" is not Matched");
			//System.out.println(driver.getTitle());
			return bTitle=false;
		}
		
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		if(ele.getText().equals(expectedText)) {
			System.out.println("The ExactText "+expectedText+" is Matched");
			//takeSnap();
			//test.pass("Lead Created Sucessfully");
			
		}
		else {
			System.out.println("The ExactText "+expectedText+" is not Matched");
			//takeSnap();
			
		}
		
		
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		if(ele.getText().contains(expectedText)) {
			System.out.println("The PartialText "+expectedText+" is Matched");
			//takeSnap();
			
		}
		else {
			System.out.println("The PartialText "+expectedText+" is not Matched");
			//takeSnap();
			
		}
		
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		if(ele.getAttribute(attribute).equals(value)) {
			System.out.println("The ExactAttribute "+value+" is Matched");
			//takeSnap();
			
		}
		else {
			System.out.println("The ExactAttribute "+value+" is not Matched");
			//takeSnap();
			
		}
		
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		if(ele.getAttribute(attribute).contains(value)) {
			System.out.println("The PartialAttribute "+value+" is Matched");
			//takeSnap();
			
		}
		else {
			System.out.println("The PartialAttribute "+value+" is not Matched");
			//takeSnap();
			
		}
		
	}

	public void verifySelected(WebElement ele) {
		ele.isSelected();
		
	}

	public void verifyDisplayed(WebElement ele) {
		ele.isDisplayed();
		
	}

	public void switchToWindow(int index) {
		Set<String> sGetWindow=driver.getWindowHandles();
		List<String> sGetWindowList=new ArrayList(sGetWindow);
		sGetWindowList.addAll(sGetWindowList);
		driver.switchTo().window(sGetWindowList.get(index));
					
	}
	
	public String getParentWindow() {
		String iParent=driver.getWindowHandle();
		return iParent;
			
	}
	
	public void switchToWindow(String value) {
		driver.switchTo().window(value);
					
	}
	
	
	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);
		
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
		
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		
	}

	public String getAlertText(String sText) {
		sText=driver.switchTo().alert().getText();
		return sText;
	}

	public void takeSnap(String imgName) {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/"+imgName+".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void closeBrowser() {
		driver.close();
		
	}

	public void closeAllBrowsers() {
		driver.quit();
		
	}
	
	public void moveToElement(WebElement ele1,WebElement ele2) {
		Actions moveToEle=new Actions(driver);
		moveToEle.moveToElement(ele1).pause(300).click(ele2).perform();
	}
	
	public void selectRadioButton(List<WebElement> ele, int Index) {
		List<WebElement> sr=ele;
		sr.get(Index).click();
		System.out.println("The Index "+Index+" is selected for RadioButton Successfully");
		//takeSnap();
		
	}

	
		

}
