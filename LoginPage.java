package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import functionalLibrary.Generic;

public class LoginPage {
	WebDriver driver;
	Generic generic;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (id = "user")
	public WebElement tfUserName;
	
	@FindBy (id = "password")
	public WebElement tfPassword;
	
	@FindBy (name = "btnSubmit")
	public WebElement btnLogin;
	
	@FindBy (xpath = "//span[text()='Log in with IDIR']")
	public WebElement btnOtherLogin;
	
		public void login(){
//			driver.get("https://sitps.icm.ext.gov.bc.ca/epublicsector_enu/");
//			driver.get("https://sit.icm.gov.bc.ca/epublicsector_enu/");
			driver.get(new Generic().getDataFromPropertiesFile("URL"));
			new Generic().explicitWait(1);
			
			if(tfUserName.isDisplayed()){
				new Generic().clickButton(btnOtherLogin, 6);
//				tfUserName.sendKeys("HGWRK06");
//				tfPassword.sendKeys("Cuddy!18");
				tfUserName.sendKeys(new Generic().getDataFromPropertiesFile("username"));
				tfPassword.sendKeys(new Generic().getDataFromPropertiesFile("password"));
				new Generic().clickButton(btnLogin, 1);
				//For Reference - Print in console
				System.out.println("URL from prop ::" +new Generic().getDataFromPropertiesFile("URL"));
				System.out.println("User name from prop::" +new Generic().getDataFromPropertiesFile("username"));
			    System.out.println("Password from prop::" +new Generic().getDataFromPropertiesFile("password"));
			}
			
			
		}
}
