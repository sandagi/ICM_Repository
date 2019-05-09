package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import functionalLibrary.Generic;
import functionalLibrary.GlobalVar;

public class ICMScreen extends GlobalVar {
WebDriver driver;
       
       public ICMScreen(WebDriver driver)
       {
             this.driver = driver;
             PageFactory.initElements(driver, this);
       }
       
       @FindBy (xpath = "//a[text()='Contacts']/span")
       public WebElement btnContactTab;
       
       @FindBy (xpath = "//input[@aria-label='Last Name']")
       public WebElement tfLastName;
       
       @FindBy (xpath = "//button[contains(@aria-label,'Create New Contact')]")
       public WebElement btnCreateNewContact;
       
       @FindBy (xpath = "//button[span[text()='Search ICM']]")
       public WebElement btnSearchICM;
       
       @FindBy (xpath = "//td[contains(@id,'SIN_Match') and @title='Checked']")
       public WebElement tblSIN_Match;
       
       @FindBy (xpath = "//a[@name='Last Name']")
       public WebElement lnkLastName;
       
       @FindBy (xpath = "//a[text()='Immigration']")
       public WebElement btnImmigrationTab;
       
       @FindBy (xpath = "//a[text()='Addresses']")
       public WebElement btnAddressesTab;
       
       @FindBy (xpath = "//span/button[text()='Add']")
       public WebElement btnAdd;
       
       @FindBy (xpath = "//button[contains(@aria-label,'Create New Contact') and @disabled='disabled']")
       public WebElement btnCreateNewContactDisabled;
       
       @FindBy (xpath = "//button[contains(@aria-label,'Search ICM') and @disabled='disabled']")
       public WebElement btnSearchICMDisabled;
       
//Xpath for all objects after Service Creation
       
       @FindBy (xpath = "//a[text()='Contacts Summary']")
       public WebElement btnContactsSummaryTab;
       

       @FindBy (xpath = "//button[contains(@aria-label,'Service Requests:New')]")
       public WebElement btnServiceRequestNew;
       
       @FindBy (xpath = "//input[@id='1_SR_Type_New_']")
       public WebElement SRType;
       

       @FindBy (xpath = "//input[@id='1_SR_Sub_Type']")
       public WebElement SRSubType;
       
       @FindBy (xpath = "//input[@name='Comm_Method']")//Comm_Method
       public WebElement SRContactMethod;
       
       @FindBy (xpath = "//a[@name='SR Number']")
       public WebElement lnkSRNumber;
       
       @FindBy (xpath = "//input[@id='1_SR_Sub_Sub_Type']")
       public WebElement SRSubsubType;
       
       @FindBy (xpath = "//input[@id='1_Priority']")
       public WebElement SRPriority;
       
       @FindBy (xpath = "//input[@id='1_Due_Date']")
       public WebElement SRDueDate;
       
       @FindBy (xpath = "//button[contains(@aria-label,'Activity Templates:New')]")
       public WebElement btnActivityTemplateNew;
       
       @FindBy (xpath = "//input[@id='1_Template']")//1_Type
       public WebElement ACPlan;
       
       
       //Xpath used for Case Creation
       
       @FindBy (xpath = "//a[text()='Related Cases']")
       public WebElement btnRelatedCases;
       
       @FindBy (xpath = "//button[contains(@aria-label,'Cases:New')]")
       public WebElement btnCasesNew;
       
       @FindBy (xpath = "//input[@id='1_Type']")//1_No_EFT_Reason
       public WebElement CaseType;
       
       @FindBy (xpath = "//a[@name='Subject Contact Last Name']")//Name
       public WebElement lnkConLastName;
       
       @FindBy (xpath = "//a[@name='Name']")//Name
       public WebElement lnkName;
       
       @FindBy (xpath = "//a[text()='Contact']")
       public WebElement btnContact;
       
       @FindBy (xpath = "//a[text()='Payment Profile']")
       public WebElement btnPaymentProfile;//Payment Profile
       
       @FindBy (xpath = "(//input[contains(@id,'No_EFT_Reason')])[1]")//s_4_1_73_0
       public WebElement NoEftReason;
       
       @FindBy (xpath = "//button[span[text()='Update MIS']]")
       public WebElement btnUpdateMIS;
                    
       @FindBy (xpath = "//input[@aria-label= 'Case Status']")
       public WebElement CaseStatus;
       
       @FindBy (xpath = "//button[@aria-label='Alerts:New']/span")
       public WebElement btnNewAlert;
       
       @FindBy (xpath = "(//button[@aria-label='Contacts:Query']/span)[2]")
       public WebElement btnQuery_Contacts;
       
       
       //Xpath for OPA related objects
       
       @FindBy (xpath = "//a[text()='Plans']")
          public WebElement btnPlansTab;
          
          @FindBy (xpath = "//a[text()='Save']")
          public WebElement btnSave;
          
          @FindBy (xpath = "//input[@value='End session']")
          public WebElement btnEndSession;
          
          @FindBy (xpath = "//button[@aria-label='Assisted Order Administration - Enter:New']")
          public WebElement btnNew_AssistedOrdAdmin_Enter;
          
          @FindBy (xpath = "//button[@aria-label='Assisted Order Administration - Confirm:Confirm']")
          public WebElement btnConfirm_AssistedOrderAdmin;
          
          //public WebElement tfTextField(String sFieldName){
            //    return driver.findElement(By.xpath("//input[@aria-label='"+sFieldName+"']"));
          //}
          
          public WebElement btnButton(String sBtnName){
             return driver.findElement(By.xpath("//button[@aria-label='"+sBtnName+"']/span"));
          }
          public WebElement txtText(String sText){
             return driver.findElement(By.xpath("//div[contains(text(),'"+sText+"')]"));
          }

       
       public WebElement tfTextField(String sFieldName){
             return driver.findElement(By.xpath("//input[@aria-label='"+sFieldName+"']"));
       }
       
       public WebElement CustomXpath(String sXpath){
             return driver.findElement(By.xpath(sXpath));
       }
       
   public void icm(ICMScreen icm){
     try{
       Generic generic = new Generic();
       System.out.println("Successfully clicked on Contact Summary");      
       generic.waitUntilElementIsVisible(driver, icm.btnServiceRequestNew, 20);
       generic.clickButton(icm.btnServiceRequestNew, 15);
       System.out.println("Clicking on Service New Request");
       sSRType=generic.getExcelStrVal(sXLFile, icm.sSheetName, 14, icm.iColName);
       generic.sendKeys(icm.SRType, sSRType);
       System.out.println("Entering the type as application");
       sSRSubType=generic.getExcelStrVal(sXLFile, icm.sSheetName, 15, icm.iColName);
       generic.sendKeys(icm.SRSubType, sSRSubType);
       System.out.println("Entering the sub type as Income Assistance");
       generic.robotTabKey();
       generic.robotTabKey();
       generic.robotTabKey(); 
       generic.clickButton(icm.SRContactMethod, 10);
       System.out.println("Clicking on the Contact Method tab");
       sSRContactMethod=generic.getExcelStrVal(sXLFile, icm.sSheetName, 16, icm.iColName);
       generic.sendKeys(icm.SRContactMethod, sSRContactMethod);
       System.out.println("Entering the Contact Method as Email");
       generic.waitUntilElementIsVisible(driver, icm.lnkSRNumber, 20);
       System.out.println("Checking if SR Number link is there");
       generic.clickButton(icm.lnkSRNumber, 15);  
       System.out.println("Clicking on the SR Link number");
       generic.waitUntilElementIsVisible(driver, icm.btnActivityTemplateNew, 20);
       System.out.println("Viewing on the New Applet");
       generic.clickButton(icm.btnActivityTemplateNew, 15);
       System.out.println("Clicking on the new applet number");
       sACPlan=generic.getExcelStrVal(sXLFile, icm.sSheetName, 17, icm.iColName);
       generic.sendKeys(icm.ACPlan, sACPlan);
       System.out.println("Entering the activity applet Plan");
       generic.robotSaveRecord(8);
       
       
       //Starting the Cases section.
       generic.clickButton(icm.btnRelatedCases, 15);
       System.out.println("CLicking on the Related Case button");
       generic.waitUntilElementIsVisible(driver, icm.btnCasesNew, 15);
       System.out.println("Viewing on the New under Cases");
       generic.clickButton(icm.btnCasesNew, 15);
       System.out.println("Clicking on the new button under cases");
       sCaseType=generic.getExcelStrVal(sXLFile, icm.sSheetName, 18, icm.iColName);
       generic.sendKeys(icm.CaseType, sCaseType);
       generic.robotSaveRecord(7);
       System.out.println("Entering the value for case type");
       generic.waitUntilElementIsVisible(driver, icm.lnkConLastName, 20);
       System.out.println("Checking if Contact last name link is there");
       generic.clickButton(icm.lnkConLastName, 15);  
       System.out.println("Clicking on the contact last name link");
       generic.waitUntilElementIsVisible(driver, icm.lnkName, 20);
       System.out.println("Checking if full name link is there");
       generic.clickButton(icm.lnkName, 15);  
       System.out.println("Clicking on the contact full name link");
       sWorkQueue=generic.getExcelStrVal(sXLFile, icm.sSheetName, 19, icm.iColName);
       generic.sendKeys(icm.tfTextField("Work Queue"), sWorkQueue);
       System.out.println("Entering the value for work queue");
       sCaseLoad=generic.getExcelStrVal(sXLFile, icm.sSheetName, 20, icm.iColName);
       generic.sendKeys(icm.tfTextField("Caseload"), sCaseLoad);
       System.out.println("Entering the value for case load");
       
       generic.clickButton(icm.CaseStatus, 10);
       System.out.println("Clicking on the case status button");
       
       Actions builder = new Actions(driver);
       builder.doubleClick(icm.CaseStatus).perform();
       System.out.println("Double Clicking on the case status button");
       icm.CaseStatus.sendKeys("Open");
       generic.robotTabKey();
       generic.explicitWait(40);
       
       System.out.println("Entering the value for case status");
       generic.waitUntilElementIsVisible(driver, icm.btnContact, 25);
       System.out.println("Waiting for the contact button to appear");
       generic.clickButton(icm.btnContact, 5);
       generic.clickButton(icm.btnContact, 20);
       System.out.println("Clicking on the contact button");
       generic.waitUntilElementIsVisible(driver, icm.btnPaymentProfile, 80);//btnPaymentProfile
       
       //Add Contact
       if(icm.bCouple){
    	   ICM_Couple(icm);
       }if(icm.bOneParentFamily){
    	   ICM_OneParentFamily(icm);
       }if(icm.bTwoParentFamily){
    	   ICM_TwoParentFamily(icm);
       }
       System.out.println("Waiting for the Payment Profile to appear");
       generic.clickButton(icm.btnPaymentProfile, 15);
       System.out.println("Clicking on the payment profile button");
       
       int tblNoEFTReason=driver.findElements(By.xpath("//td[contains(@id,'No_EFT_Reason')]")).size();
       for(int i=1;i<=tblNoEFTReason; i++)
         {
    	   generic.clickButton(icm.CustomXpath("(//td[contains(@id,'No_EFT_Reason')])["+i+"]"), 1/2);
    	   generic.clickButton(icm.CustomXpath("(//td[contains(@id,'No_EFT_Reason')])["+i+"]"), 2);
	       sNoEftReason=generic.getExcelStrVal(sXLFile, icm.sSheetName, 21, icm.iColName);
	       generic.sendKeys(icm.NoEftReason, sNoEftReason);
	       generic.explicitWait(2);
         }
//       --generic.clickButton(icm.CustomXpath("//td[contains(@id,'No_EFT_Reason')]"), 2);
//       --System.out.println("Clicking on the No eft Reason tab");
//       --sNoEftReason=generic.getExcelStrVal(sXLFile, icm.sICMScreen, 21, icm.iColName);
//      -- generic.sendKeys(icm.NoEftReason, sNoEftReason);
//      -- System.out.println("Entering the value for No eft Reason");
       
       generic.waitUntilElementIsVisible(driver, icm.btnUpdateMIS, 100);
       
       System.out.println("Waiting for Update MIS to appear");
       generic.clickButton(icm.btnUpdateMIS, 25);
       System.out.println("Clicking on the update MIS button");
       
       
     //OPA Assessment
       if(generic.isVisible(icm.btnPlansTab)){
             generic.clickButton(icm.btnPlansTab, 10);
       }else{
             Select tabselect = new Select(driver.findElement(By.id("j_s_vctrl_div_tabScreen")));
             tabselect.selectByVisibleText("Plans");
             generic.explicitWait(25);
       }
       generic.clickButton(icm.btnButton("Case:Assisted Elig."), 20);
       
       Set<String> handles = driver.getWindowHandles();
       String parentWindow = driver.getWindowHandle(); 
       handles.remove(parentWindow);
       String winHandle= (String) handles.iterator().next();
       if (winHandle!=parentWindow){
           String childWindow=winHandle;
           driver.switchTo().window(childWindow);
           generic.explicitWait(2);
       }
       driver.manage().window().maximize();
       generic.clickButton(icm.CustomXpath("//a[text()='Click here to determine eligibility for Employment and Assistance (EA or EAPWD)']"), 8);
//       sEAScreen_Date=generic.getExcelStrVal(sXLFile, icm.sICMScreen, 22, icm.iColName);
       sEAScreen_Date=generic.getCurrentSystemDate();
       generic.sendKeys(icm.CustomXpath("//input[contains(@id,'date')]"), sEAScreen_Date);
       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
       
       if(icm.bCouple){
    	   ICM_OPAQuestions(2, icm);
       }else if(icm.bOneParentFamily){
    	   ICM_OPAQuestions_WithParent(1, icm);
       }else if(icm.bTwoParentFamily){
    	   ICM_OPAQuestions_WithParent(2, icm);
       }else{
    	   ICM_OPAQuestions(1, icm);
       }
       generic.waitUntilElementIsVisible(driver, icm.btnSave, 10); 
       if(icm.bEA){
    	   EligibilitySummaryForEA(icm);
       }
       generic.clickButton(icm.btnSave, 10);
       generic.waitUntilElementIsVisible(driver, icm.btnEndSession, 10);
       generic.clickButton(icm.btnEndSession, 2);
       
       driver.switchTo().window(parentWindow);
       generic.clickButton(icm.btnPlansTab, 13);
       
       int tblPlans=driver.findElements(By.xpath("//td[contains(@id,'Program_Name')]")).size();
          for(int i=1;i<=tblPlans; i++)
            {
          generic.clickButton(icm.CustomXpath("(//td[contains(@id,'Program_Name')])["+i+"]"), 5);
                generic.clickButton(icm.btnButton("Plans:Confirm"), 6);
            }
          generic.explicitWait(2);
          //Create & Approve Orders
          generic.clickButton(icm.btnButton("Benefits:Create Order"), 8);
          generic.waitUntilElementIsVisible(driver, icm.btnNew_AssistedOrdAdmin_Enter, 8);
            generic.clickButton(icm.btnNew_AssistedOrdAdmin_Enter, 8);
       generic.clickButton(icm.CustomXpath("//input[@id='1_Hierarchy']"), 2);
       sHierarchy=generic.getExcelStrVal(sXLFile, icm.sSheetName, 23, icm.iColName);
       generic.sendKeys(icm.CustomXpath("//input[@id='1_Hierarchy']"), sHierarchy);
       sAllowance=generic.getExcelStrVal(sXLFile, icm.sSheetName, 24, icm.iColName);
       generic.sendKeys(icm.CustomXpath("//input[@id='1_Allowance']"), sAllowance);
       generic.explicitWait(2);
       sBaseAmount=generic.getExcelStrVal(sXLFile, icm.sSheetName, 25, icm.iColName);
       generic.sendKeys(icm.CustomXpath("//input[@id='1_Base_Amount']"), sBaseAmount);
       generic.robotTabKey();
       generic.robotTabKey();
       generic.robotTabKey();
       generic.robotTabKey();
//       generic.clickButton(icm.CustomXpath("(//td[contains(@id,'Is_Payee_Contact')])[1]"), 2);
       generic.clickButton(icm.CustomXpath("//input[@id='1_Is_Payee_Contact']"), 2);
       generic.explicitWait(20);
          generic.clickButton(icm.btnButton("Assisted Order Administration - Enter:Next"), 8);
          generic.waitUntilElementIsVisible(driver, icm.btnConfirm_AssistedOrderAdmin, 25);
          generic.clickButton(icm.btnConfirm_AssistedOrderAdmin, 25);
          
          int tblOrders=driver.findElements(By.xpath("//table[@summary='Case Orders']//td[@title='Pending']")).size();
          for(int i=1;i<=tblOrders; i++)
                {
                generic.clickButton(icm.CustomXpath("(//table[@summary='Case Orders']//td[@title='Pending'])[1]"), 5);
                      generic.clickButton(icm.btnButton("Orders:Submit Order"), 15);
                      generic.clickButton(icm.btnButton("Orders:Submit Order"), 15);
                }
             }
       catch(Exception e){
                    e.printStackTrace();
             }
       }
   
   public void ICM_CreateContact(ICMScreen icm){
	   try{
		   Generic generic = new Generic();
	       
	       generic.clickButton(icm.btnContactTab, 10);
	       generic.waitUntilElementIsVisible(driver, icm.tfLastName, 20);
	       System.out.println("Attribute value of CreateNewContact button:"+icm.btnCreateNewContact.getAttribute("disabled"));
	       System.out.println("Attribute value of SearchICM button:"+icm.btnSearchICM.getAttribute("disabled"));

//	       if(icm.btnCreateNewContactDisabled.isDisplayed()){
//	                  Reporter.log("Create New Contact button is disabled", true);
//	           }else{
//	                  Reporter.log("Create New Contact button is ENABLED", true);
//	                  Assert.assertEquals("Create New Contact button is ENABLED", "Create New Contact button should be disabled");
//	           }
	       
	       if (icm.btnCreateNewContact.getAttribute("disabled").equals("true")) {
	          Reporter.log("Create New Contact button is disabled", true);
	       }else{
	          Reporter.log("Create New Contact button is ENABLED", true);
//	                  Assert.assertEquals("Create New Contact button is ENABLED", "Create New Contact button should be disabled");
	       }
	       if (icm.btnSearchICM.getAttribute("disabled")==null) {
	          Reporter.log("Search ICM button is enabled", true);
	       }else{
	          Reporter.log("Search ICM button is DISABLED", true);
//	                  Assert.assertEquals("Search ICM button is DISABLED", "Create New Contact button should be enabled");
	       }
	       
	       sLastName1=generic.getExcelStrVal(sXLFile, icm.sSheetName, 1, icm.iColName);
	       generic.sendKeys(icm.tfLastName, icm.sLastName1);
	       sFirstName1=generic.getExcelStrVal(sXLFile, icm.sSheetName, 2, icm.iColName);
	       generic.sendKeys(icm.tfTextField("First Name"), icm.sFirstName1);
	       sGender=generic.getExcelStrVal(sXLFile, icm.sSheetName, 4, icm.iColName);
	       generic.sendKeys(icm.tfTextField("Gender"), icm.sGender);
	       sDOB1=generic.getExcelStrVal(sXLFile, icm.sSheetName, 5, icm.iColName);
	       generic.sendKeys(icm.CustomXpath("//input[contains(@aria-label,'Date of Birth')]"), icm.sDOB1);
	       if(icm.bHardship=true){
		       sSIN=generic.getExcelStrVal(sXLFile, icm.sSheetName, 3, icm.iColName);
		       generic.sendKeys(icm.tfTextField("SIN (Exact)"), icm.sSIN);
	       }
	       
	       generic.clickButton(icm.btnSearchICM, 8);
	       if (icm.btnCreateNewContact.getAttribute("disabled")==null) {
	          Reporter.log("Create New Contact button is enabled", true);
	       }else{
	          Reporter.log("Create New Contact button is DISABLED", true);
	                    Assert.assertEquals("Create New Contact button is DISABLED", "Create New Contact button should be enabled");
	       }
	       
	       generic.clickButton(icm.btnCreateNewContact, 12);
	       generic.robotEnterKey();
	       generic.waitUntilElementIsVisible(driver, icm.lnkLastName, 20);
	       generic.clickButton(icm.lnkLastName, 10);
	       
	       generic.waitUntilElementIsVisible(driver, icm.btnImmigrationTab, 25);
	       generic.clickButton(icm.btnImmigrationTab, 18);
	       sCanadianByBirth=generic.getExcelStrVal(sXLFile, icm.sSheetName, 8, icm.iColName);
	       generic.sendKeys(icm.tfTextField("Canadian By Birth?"), icm.sCanadianByBirth);
	       sCitizen=generic.getExcelStrVal(sXLFile, icm.sSheetName, 9, icm.iColName);
	       generic.sendKeys(icm.tfTextField("Citizen?"), icm.sCitizen);
	       
	       generic.clickButton(icm.btnAddressesTab, 15);
	       generic.waitUntilElementIsVisible(driver, icm.tfTextField("Override"), 10);
	       generic.clickButton(icm.tfTextField("Override"), 5);
	       generic.robotEnterKey();
//	       generic.getScreenShot(driver);
	       generic.explicitWait(6);
	       
	       Select select = new Select(driver.findElement(By.id("override-reason")));
	       select.selectByIndex(1);
	       generic.explicitWait(1);
	       sAddress1=generic.getExcelStrVal(sXLFile, icm.sSheetName, 10, icm.iColName);
	       generic.sendKeys(icm.tfTextField("Street Address 1:"), icm.sAddress1);
	       sCity=generic.getExcelStrVal(sXLFile, icm.sSheetName, 11, icm.iColName);
	       generic.sendKeys(icm.CustomXpath("//input[@id='city']"), icm.sCity);
	       sProvince=generic.getExcelStrVal(sXLFile, icm.sSheetName, 12, icm.iColName);
	       generic.sendKeys(icm.CustomXpath("//input[@id='province']"), icm.sProvince);
	       sPostalCode=generic.getExcelStrVal(sXLFile, icm.sSheetName, 13, icm.iColName);
	       generic.sendKeys(icm.CustomXpath("//input[@id='code']"), icm.sPostalCode);
	       generic.clickButton(icm.btnAdd, 18);
	       generic.robotEnterKey();
	       generic.explicitWait(4);
	       generic.robotEnterKey();
	       generic.explicitWait(2);
	       generic.waitUntilElementIsVisible(driver, icm.btnContactsSummaryTab, 20);
	       generic.clickButton(icm.btnContactsSummaryTab, 15);
	   }catch(Exception e){
           e.printStackTrace();
    }
   }
   
   public void ICM_Couple(ICMScreen icm){
	   try{
		   Generic generic = new Generic();
		   generic.clickButton(icm.btnButton("Contacts:Add"), 20);
		   generic.waitUntilElementIsVisible(driver, icm.btnQuery_Contacts, 15);
		   generic.explicitWait(5);
		   generic.clickButton(icm.btnQuery_Contacts, 5);
		   String sLN=generic.getExcelStrVal(sXLFile, icm.sSheetName, 1, icm.iColNameForCouple);
		   generic.sendKeys(icm.CustomXpath("//input[@id='1_Last_Name']"), sLN);
		   String sFN=generic.getExcelStrVal(sXLFile, icm.sSheetName, 2, icm.iColNameForCouple);
		   generic.sendKeys(icm.CustomXpath("//input[@id='1_First_Name']"), sFN);
		   generic.clickButton(icm.CustomXpath("(//button[@aria-label='Contacts:Go']//label)[1]"), 5);
		   generic.clickButton(icm.CustomXpath("//button[@aria-label='Contacts:Ok']//label"), 6);
		   generic.clickButton(icm.CustomXpath("//td[text()='Unknown']"), 2);
		   generic.robotDeleteKey();
		   generic.explicitWait(2);
		   generic.sendKeys(icm.CustomXpath("(//input[contains(@id,'Relationship')])[1]"), "Spouse");
		   generic.robotTabKey();
		   generic.clickButton(icm.CustomXpath("(//input[contains(@id,'Subject')])[1]"), 4);
	   }catch(Exception e){
           e.printStackTrace();
    }
   }
   
   public void ICM_OneParentFamily(ICMScreen icm){
	   try{
		   Generic generic = new Generic();
		   generic.clickButton(icm.btnButton("Contacts:Add"), 15);
		   generic.waitUntilElementIsVisible(driver, icm.btnQuery_Contacts, 20);
		   generic.clickButton(icm.btnQuery_Contacts, 5);
		   String sLN=generic.getExcelStrVal(sXLFile, icm.sSheetName, 1, icm.iColNameFor1ParentFamily);
		   generic.sendKeys(icm.CustomXpath("//input[@id='1_Last_Name']"), sLN);
		   String sFN=generic.getExcelStrVal(sXLFile, icm.sSheetName, 2, icm.iColNameFor1ParentFamily);
		   generic.sendKeys(icm.CustomXpath("//input[@id='1_First_Name']"), sFN);
		   generic.clickButton(icm.CustomXpath("(//button[@aria-label='Contacts:Go']//label)[1]"), 5);
		   generic.clickButton(icm.CustomXpath("//button[@aria-label='Contacts:Ok']//label"), 6);
		   generic.clickButton(icm.CustomXpath("//td[text()='Unknown']"), 2);
		   generic.robotDeleteKey();
		   generic.explicitWait(2);
		   generic.sendKeys(icm.CustomXpath("(//input[contains(@id,'Relationship')])[1]"), "Son");
		   generic.robotTabKey();
//		   generic.clickButton(icm.CustomXpath("(//td[@title='Unchecked' and contains(@id,'Subject')]/span/img)[1]"), 2);
//		   generic.robotTabKey();
//		   generic.explicitWait(1);
		   generic.clickButton(icm.CustomXpath("(//input[contains(@id,'Subject')])[1]"), 4);
	   }catch(Exception e){
           e.printStackTrace();
    }
   }
   
   //This method may not be required as we can cover 2 parent in couple and 1 parent
   public void ICM_TwoParentFamily(ICMScreen icm){
	   //Add spouse contact
	   ICM_Couple(icm);
	   try{
		   Generic generic = new Generic();
		   generic.clickButton(icm.btnButton("Contacts:Add"), 20);

		   generic.clickButton(icm.btnQuery_Contacts, 5);
		   String sLN=generic.getExcelStrVal(sXLFile, icm.sSheetName, 1, icm.iColNameFor2ParentFamily);
		   generic.sendKeys(icm.CustomXpath("//input[@id='1_Last_Name']"), sLN);
		   String sFN=generic.getExcelStrVal(sXLFile, icm.sSheetName, 2, icm.iColNameFor2ParentFamily);
		   generic.sendKeys(icm.CustomXpath("//input[@id='1_First_Name']"), sFN);
		   generic.clickButton(icm.CustomXpath("(//button[@aria-label='Contacts:Go']//label)[1]"), 5);
		   generic.clickButton(icm.CustomXpath("//button[@aria-label='Contacts:Ok']//label"), 6);
		   generic.clickButton(icm.CustomXpath("//td[text()='Unknown']"), 2);
		   
		   generic.robotDeleteKey();
		   generic.sendKeys(icm.CustomXpath("//input[@id='1_Relationship']"), "Son");
		   generic.robotTabKey();
		   generic.clickButton(icm.CustomXpath("//input[@id='1_Subject']"), 4);
//		   icm.bCouple=true;
//		   icm.bOneParentFamily=true;
	   }catch(Exception e){
           e.printStackTrace();
    }
   }
   
    public void ICM_OPAQuestions(int Couple, ICMScreen icm){
	   try{
		   Generic generic = new Generic();
		   for(int i=1; i<=Couple; i++){
			   //Screen1
		       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2); //Yes
		       generic.clickButton(icm.CustomXpath("//input[@id='n30']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@id='n50']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
		   }
		   for(int i=1; i<=Couple; i++){
		       //Screen2
		       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@id='n30']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
		   }
		   for(int i=1; i<=Couple; i++){
		       //Effect of Circumstance 
		       generic.clickButton(icm.CustomXpath("//input[@id='n20']"), 1/2); //No
		       generic.clickButton(icm.CustomXpath("//input[@id='n40']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n60']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
		   }
		   for(int i=1; i<=Couple; i++){
		       //Effect of Being in Prison or Other Lawful Place of Confinement 
		       generic.clickButton(icm.CustomXpath("//input[@id='n20']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n40']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 10);
		   }
		   for(int i=1; i<=Couple; i++){
		       //Requirement for Two Year Employment 
		       generic.clickButton(icm.CustomXpath("//input[@id='n20']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n40']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 10);
		   }
		   for(int i=1; i<=Couple; i++){
		       //Exemption for Two Year Employment 
		       generic.clickButton(icm.CustomXpath("//input[@id='n20']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n40']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n60']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n80']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n100']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n120']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n140']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n160']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n180']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n200']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n220']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n240']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n260']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n280']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 10);
		   }
		   for(int i=1; i<=Couple; i++){
		       //Minister's Opinion Regarding the Applicant and Two-Year Employment 
		       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@id='n30']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 9);
		   }
		   for(int i=1; i<=Couple; i++){
		       //Employment Plan 
		       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 9);
		   }
		   for(int i=1; i<=Couple; i++){
		       //Immediate EPBC Referral 
		       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
		   }
		   if(bHardship){
			   for(int i=1; i<=Couple; i++){
			       //Undue Hardship 
			       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
			       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
			   }
			   for(int i=1; i<=Couple; i++){
			       //Applicants Who Do Not Meet Requirement for Social Insurance Number or Proof of Identity
			       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
			       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
			   }
			   for(int i=1; i<=Couple; i++){
			       //Hardship Duration Limits
			       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
			       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
			   }
			   for(int i=1; i<=Couple; i++){
			       //Hardship Duration Limits Under EA Regulation
			       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
			       generic.clickButton(icm.CustomXpath("//input[@id='n30']"), 1/2);//Yes
			       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
			   }
			   //District Supervisor Approval for Hardship Beyond Duration Limits
			   for(int i=1; i<=Couple; i++){
			       //Hardship Duration Limits
			       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
			       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
			   }
			   //Hardship Amounts Based on Financial Need
			   generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
		   }
	   }catch(Exception e){
           e.printStackTrace();
    }
   }

    
    public void ICM_OPAQuestions_WithParent(int Couple, ICMScreen icm){
 	   try{
 		   Generic generic = new Generic();
 		   for(int i=1; i<=Couple; i++){
 			   //Screen1
 		       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2); //Yes
 		       generic.clickButton(icm.CustomXpath("//input[@id='n30']"), 1/2);//Yes
 		       generic.clickButton(icm.CustomXpath("//input[@id='n50']"), 1/2);//Yes
 		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
 		   }
 		   if(bOneParentFamily || bTwoParentFamily){
 			   generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2); //Yes
 		       generic.clickButton(icm.CustomXpath("//input[@id='n30']"), 1/2);//Yes
 		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 9);
 		   }
 		  for(int i=1; i<=Couple; i++){
		       //Screen2
		       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@id='n30']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 9);
		   }
		   for(int i=1; i<=Couple; i++){
		       //Effect of Circumstance 
		       generic.clickButton(icm.CustomXpath("//input[@id='n20']"), 1/2); //No
		       generic.clickButton(icm.CustomXpath("//input[@id='n40']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@id='n60']"), 1/2);//No
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 9);
		   }
		   for(int i=1; i<=Couple; i++){
		       //Employment Plan 
		       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 9);
		   }
		   for(int i=1; i<=Couple; i++){
		       //Immediate EPBC Referral 
		       generic.clickButton(icm.CustomXpath("//input[@id='n10']"), 1/2);//Yes
		       generic.clickButton(icm.CustomXpath("//input[@value='Continue']"), 8);
		   }
 	  }catch(Exception e){
          e.printStackTrace();
   }
  }
    
    public void EligibilitySummaryForEA(ICMScreen icm){
    	Generic generic = new Generic();
    	generic.verifyText(icm.txtText("Eligibility Summary"), "Eligibility Summary");
        generic.verifyText(icm.txtText("The family unit is eligible for income assistance."), "The family unit is eligible for income assistance.");
        generic.verifyText(icm.txtText("Employment Plan Outcomes"), "Employment Plan Outcomes");
        //After first name, page source has double space
//        generic.verifyText(icm.txtText(sLastName1+" requires an EPBC employment plan."), sLastName1+" requires an EPBC employment plan.");
//        if((bOneParentFamily=false) || (bTwoParentFamily=false)){
//     	   generic.verifyText(icm.txtText(sLastName1+" is designated as SDEO."), sLastName1+" is designated as SDEO.");
//        }
        generic.verifyText(icm.txtText("The prorated support amount is"), "The prorated support amount is");
        generic.verifyText(icm.CustomXpath("(//div[contains(text(),'The amount of monthly support is')])[1]"), "The amount of monthly support is");
        generic.verifyText(icm.CustomXpath("(//div[contains(text(),'The amount of monthly support is')])[2]"), "The amount of monthly support is");
        
    }
}


