package scripts;

import org.testng.annotations.Test;

import functionalLibrary.Generic;
import functionalLibrary.SuperTestNG;
import pages.ICMScreen;

/**
* @author Mohamed Ashish
*/

public class EA_Flow extends SuperTestNG{
    @Test
    public void EA_With2Parents() throws Exception{
    	
    	ICMScreen icm = new ICMScreen(getDriver());
    	Generic generic = new Generic();
    	icm.bEA=true;
    	icm.sSheetName=icm.sSheetICMScreen;
    	generic.handleBrowserCompatibilityPopup();
    	icm.iColName=icm.C;
    	icm.ICM_CreateContact(icm);
    	icm.iColName=icm.D;
    	icm.ICM_CreateContact(icm);
    	icm.iColName=icm.B;
    	icm.ICM_CreateContact(icm);
//    	-generic.explicitWait(100);
//    	-icm.bOneParentFamily=true;
    	icm.bTwoParentFamily=true;
//    	-icm.bCouple=true;
    	icm.iColName=icm.D;
//    	-icm.iColNameFor1ParentFamily=icm.D;
    	icm.iColNameFor2ParentFamily=icm.D;
    	icm.icm(icm);
    	
    }
    
//    @Test
    public void EASingle() throws Exception{
    	ICMScreen icm = new ICMScreen(getDriver());
    	Generic generic = new Generic();
    	icm.bEA=true;
    	icm.sSheetName=icm.sSheetICMScreen;
    	generic.handleBrowserCompatibilityPopup();
    	icm.iColName=icm.B;
    	icm.ICM_CreateContact(icm);
    	icm.iColName=icm.B;
    	icm.icm(icm);
    }
    
   
}
