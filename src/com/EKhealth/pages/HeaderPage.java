package com.EKhealth.pages;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import BillEntry.getData;
import BillEntry.loginUI;

public class HeaderPage {


	public static void waitTime(){

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
				//Declare Variables
	
	static String[][] data;
	static String[][] LineCMS;
	//static double ExpectedFeeSchedDis               //1037.90;
	//static double ExpectedAllowedamt                //=526.10;
	//int ActualFeeSchDis;
	//int ActualAllowed;;

	static String clientName;
	static String claimNum;
	static String St;
	static String BillingTaxID;
	static String BillingNPI;
	static String RenderingNPI;
	static String Zip;
	static String ProvFacNPI;
	static String DOSFrom;
	static String DOSt;
	static String PatientID;
	static String ProviderBillDate;
	static String ICDProcedureCode;
	static String ClientReceivedDate;
	static String BillReceivedDate;	
	static String TypeofBill;
	static String MedicareNumber;
	static String AdmitDate;
	static String DischargeDate;
	static String AdmissionHour;
	static String AdmissionType;
	static String AdmissionSource;
	static String DischargeHour;
	static String DischargeStatus;
	static String AdmittingDiagnosis;
	static String PrinProcCodes;
	static String PrinProcDate;
	static String OperationProvNPI;
	static String DRG;
	static String LOcID;
	static String StAddress;
	static String City;
	static String State;
	static String zip;
	static String Billid;

	//LINEITEM TAB
	static String DateofService;
	static String POSS;
	static String TOSS;
	static String BilledCode;
	static String BilledMod;
	static String ReviewedCode;
	static String ReviewedMod;
	static String DaysUnits;	//num
	static String Charges;		//num
	static String Diag;		//num
	static String TotCharges;	//num
	static String ExpFeeSchDis;
	static String ExpAllowed;
	
	
		
	
	public static void countOfData() throws IOException{      //Reader Header data Excel tab
		data = getData.readExcel("TestData3", "CMS");
	}

	public static void GetLineItemDataCMS() throws IOException{  //Read workbook and tab for LineItemCMS
		LineCMS = getData.readExcel("TestData3", "LineitemCMS");
	}
	
		
		public static void readLineItemCMSFrmExl(int rowNumber) throws IOException{   //get LineItem data for Excel
			
			int i=0;
			rowNumber=rowNumber+0;
			//DateofService=LineCMS[rowNumber][i];
			POSS=LineCMS[rowNumber][i+1];
			TOSS=LineCMS[rowNumber][i+2];
			BilledCode = LineCMS[rowNumber][i+3];
			BilledMod = LineCMS[rowNumber][i+4];
			ReviewedCode = LineCMS[rowNumber][i+5];
			ReviewedMod = LineCMS[rowNumber][i+6];
			DaysUnits = LineCMS[rowNumber][i+7];
			Charges = LineCMS[rowNumber][i+8];
			TotCharges=LineCMS[rowNumber][i+10];
			ExpFeeSchDis=LineCMS[rowNumber][i+11];
			ExpAllowed=LineCMS[rowNumber][i+15];
			//TypeofBill= data[rowNumber][i+17];	
			
		
		
	}
	
	public static void readDataFromExcel(int rowNumber) throws IOException{   //Get header data from Excel
		int i=0;
		rowNumber=rowNumber+0;
		clientName=data[rowNumber][i+1];
		claimNum=data[rowNumber][i+2];
		St=data[rowNumber][i+3];
		BillingTaxID = data[rowNumber][i+5];
		BillingNPI = data[rowNumber][i+6];
		RenderingNPI = data[rowNumber][i+7];
		Zip = data[rowNumber][i+8];
		ProvFacNPI = data[rowNumber][i+9];
		DOSFrom = data[rowNumber][i+10];
		DOSt = data[rowNumber][i+11];
		PatientID = data[rowNumber][i+12];
		ProviderBillDate = data[rowNumber][i+13];
		ICDProcedureCode = data[rowNumber][i+14];
		ClientReceivedDate = data[rowNumber][i+15];
		BillReceivedDate = data[rowNumber][i+16];
		TypeofBill= data[rowNumber][i+17];
		MedicareNumber = data[rowNumber][i+18];
		AdmitDate = data[rowNumber][i+19];
		DischargeDate = data[rowNumber][i+20];
		AdmissionHour = data[rowNumber][i+21];
		AdmissionType = data[rowNumber][i+22];
		AdmissionSource = data[rowNumber][i+23];
		DischargeHour = data[rowNumber][i+24];
		DischargeStatus = data[rowNumber][i+25];
		AdmittingDiagnosis = data[rowNumber][i+26];
		PrinProcCodes = data[rowNumber][i+27];
		PrinProcDate = data[rowNumber][i+28];
		OperationProvNPI = data[rowNumber][i+29];
		DRG = data[rowNumber][i+30];
		LOcID = data[rowNumber][i+31];
		StAddress = data[rowNumber][i+32];
		City = data[rowNumber][i+33];
		State = data[rowNumber][i+34];
		zip = data[rowNumber][i+35];
		Billid = data[rowNumber][i+36];



	}
	static WebDriver driver;

	public static void mainFlow() throws IOException{

		countOfData();

		System.setProperty("webdriver.gecko.driver", "C:/kul/geckodriver.exe");
		driver = new FirefoxDriver();

		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://52.37.60.147/decisions/Login.aspx");   //QA

		//driver.get("http://52.26.143.217/decisions/Login.aspx");	//Dev

		loginUI login=new loginUI(driver);
		login.inputUserName("amalik@ekhealth.com");
		login.inputPassword("Summer!2017");
		login.ClickOnLoginButton();
		login.ClickOnUserPortal();


		driver.get("http://52.37.60.147/decisions/Primary/H/?FolderId=56b91dee-8a71-11e6-ace6-00155d0fe70e&pageName=Billing%20Entry%20Main%20Page");

		//driver.get("http://52.26.143.217/decisions/Primary/H/?FolderId=56b91dee-8a71-11e6-ace6-00155d0fe70e&pageName=Billing%20Entry%20Main%20Page");

		driver.manage().window().maximize();	

		waitTime();

		for(int iter=1;iter<data.length;iter++){
			readDataFromExcel(iter);
			fillValuesInHTML();
			List<WebElement> abc = driver.findElements(By.xpath("//button[contains(@id,'SilverButton_') and text()='Next']"));
			//abc.get(abc.size()-1).click(); //Click Next button	
			WebElement Next=abc.get(0);
			Next.click(); 
			waitTime();
			GetLineItemDataCMS(); 
			readLineItemCMSFrmExl(iter);
			fillLineItemCMSValues();	
		}



		//		driver.quit();

	}

	
											//Fill LineItem CMS Data
	
	public static void fillLineItemCMSValues(){
		
		
		List<WebElement> silverBoxes = driver.findElements(By.xpath("//input[contains(@id,'SilverTextBox')]"));
		
		List<WebElement> numboxes = driver.findElements(By.xpath("//input[contains(@id,'numBox')]"));
				
		WebElement POS=silverBoxes.get(1);
		POS.sendKeys(POSS+Keys.TAB);
		
		WebElement TOS=silverBoxes.get(2);
		TOS.sendKeys(TOSS+Keys.TAB);
		
		WebElement BillCd=silverBoxes.get(9);
		BillCd.sendKeys(BilledCode+Keys.TAB);
		
		WebElement BillMd=silverBoxes.get(10);
		BillMd.sendKeys(BilledMod+Keys.TAB);
		
		WebElement RevCd=silverBoxes.get(11);
		RevCd.sendKeys(Keys.TAB);
		
		WebElement RevMd=silverBoxes.get(12);
		RevMd.sendKeys(BilledMod+Keys.TAB);
			
		WebElement Days=numboxes.get(5);
		Days.sendKeys(DaysUnits+Keys.TAB);
		
		WebElement Chrges=numboxes.get(6);
		Chrges.sendKeys(Charges+Keys.ENTER);
		waitTime();
		
		WebElement TotalChgs=numboxes.get(0);
		TotalChgs.sendKeys(TotCharges);	
		
		
		waitTime();
		WebElement checkSumButton = driver.findElement(By.xpath("//button[contains(@id,'SilverEventButton_') and text()='Checksum']"));
		//abc.get(abc.size()-1).click(); //Click Next button	
		checkSumButton.click(); 
		
		WebElement ActualFeeSchDis=numboxes.get(7);
		String ActFeeDisc = ActualFeeSchDis.getText();	
		
		if(ActFeeDisc.equals(ExpFeeSchDis)){
				System.out.println("Actual Fee Schedule is Correct: " +ExpFeeSchDis+" , "+ActFeeDisc);
		}
		else {
			System.out.println("Acutal Fee Schedule is Incorrect: " +ExpFeeSchDis+" , "+ActFeeDisc);
		}
		
		WebElement ActualAllowed=numboxes.get(11);
		String ActllowedVal =ActualAllowed.getText();	
		
		if(ActllowedVal.equals(ExpAllowed)){
				System.out.println("Actual Allowed Amount is Correct: " +ExpAllowed+" , "+ActllowedVal);
		}
		else {
			System.out.println("ActualAllowed is Incorrect: " +ExpAllowed+" , "+ActllowedVal);
		}
	}
	
	
	
	

	private static void If(boolean equals) {
		// TODO Auto-generated method stub
		
	}

	public static void fillValuesInHTML(){    //Fill Header Screen data
		//items in dropdown
		//waitTime();
		//WebElement dropIcon = driver.findElements(By.xpath("//div[contains(@id,'ItemSelectorArrowDiv_')]")).get(0);

		//dropIcon.click();
		//waitTime();


		//System.out.println(elements.size());
		//System.out.println(elements.get(0).getText());

		//list of input boxes -selector
		waitTime();
		List<WebElement> inputBoxes = driver.findElements(By.xpath("//input[contains(@id,'ItemSelectorText_')]"));

		WebElement clientInput=inputBoxes.get(0);

		clientInput.sendKeys(clientName);
		List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@id,'ItemSelectorItemListDiv_')]/ul/li"));  //dropdown list

				waitTime();
		for(WebElement item: elements){
			if(item.getText().equalsIgnoreCase(clientName)){
				item.click();
				break;

			}
		}


		//list of input boxes
		List<WebElement> silverBoxes = driver.findElements(By.xpath("//input[contains(@id,'SilverTextBox')]"));

		WebElement claim=silverBoxes.get(3);
		claim.sendKeys(claimNum);


		WebElement State=silverBoxes.get(4);
		State.sendKeys(St);

		//		waitTime();

		WebElement payCode=inputBoxes.get(2);
		payCode.sendKeys("Medical");

		        waitTime();
		for(WebElement item: elements){
			if(item.getText().equalsIgnoreCase("Medical")){
				item.click();

				break;

			}
		}

		//WebElement BillID=silverBoxes.get(7);
		//if(BillID.getAttribute("value").isEmpty()){
		//	BillID.sendKeys(Billid+Keys.TAB);
		//}



		WebElement billtaxid=silverBoxes.get(9);
		billtaxid.sendKeys(BillingTaxID+Keys.TAB);
		waitTime();
		System.out.println("Added Billing TAXID: "+BillingTaxID);



		try{
			if(driver.findElement(By.xpath("//img[@name='Image_Indicator_BillingTaxID_New' and @src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAUoSURBVEhLtVVbbBRlFP5mdmZn/713u2z30nbb3d7SQkoorWmgtGChJIJGrBKQQIgIFAM0SlTsAwoBggn4oomJT1zCiyZGI4H4YtRYItYEUYKUWwqlLAKWLnuZ3Zmd8czuBm1K+2I4m7Pnn3P5v3PmP+cfPG3iinJG2vbyLLs/Yv200i++AgHczZvqV9f+Gt909OjEw6LL/6ODu6tODA/16cqjQV0eP6MPn9ugHxoIf100z0imopyWPtgVbp8z2/dRW8cAl07egZIdh6ukHKmJP+uj1abBH87Grxddn0h8UU5HHGPakUWLX+PlZAy8KMIkMcipe2hta4PTzh8mnxmTnNG4f3d4bXtr087q+pVQMndhL/HBbBGRnrgGUWQw6X+XRSv1se8G478WQ6bQtBX09oIxQTvYtmAd5OQoROYCx41SV4zC4o5CVZOY09wIh92899XlHmcxbApNC9BcXfVW15JnK3WYAS0Oq92Sl9CSsLnc4HiVvDgsbC/3ResdA4WoqfREgP7XvYEyL//O7LkrkJVvw+zw0143AbOH2EseI7B5m5HLpRGtrUCFz7Kzv88XKURPpicCeFzW/d09vXY5fZ9yVMAcPG6NlmFH/3n09Z3DxYt+WJw5aLkbSDw4jQXPpCSXxD4shk+iKQDv9Qfm1VQ51wcr50FV7oG5Kkg7hlgsg1TiAYaGBnHq1DeAegbOsmbouQl4vOOoDUurdm+t6Cjs8i9NAbCJwuHu5etMcvI6TKIEM8sBOiBnHuLYsRME8DNsVpEiGZidwVIyG2pOo7NIcBYbf4S2mHQ7TALYszO0at7cui672wtNS1D2QTpU4za4BeQuQFHSeb+yACM9geTGURJ6DjynUhPE0dIozh/YWrE+71SkxwCNjTDbbPqhhYtfRCY5AkFyQzRTp+QuA9kLqImWFD2BSDWtdYFWIgRRByvtgKZraG2NG719YOlS2Aqe/wHo7Qlv71jQWcMLGQpOweoKAcp5yvQqPTMEKq1oafHluS7iJj0BcFSFJtNZLAPPcxAtMjrb9WBLdejt4raFSX5zc8AbmIUvVr602SKnb9BQ+SGxGGX/O1npdfA0C7RXZWUEtXUhtC+kts0lyEZ6MnAmHjrnhpIeRjCUw/BlNj8S5I4PXZTj+QpsFn5vz/LV7kz2GmWrgjntlL0x/TRcRpacgPh9N7bv+Anv7zmLOyN0jgYo6QtV6LB7usALDDqvoHuJZrM72AFjb37b+rKmaLl9U6RhDjTlISRHGLz2I5mkQrCRulnE6W/HcPXKJYyNjeDLU3QuQiH7POeB0mCe1dApwZqGBOqqxbVb1njaeJcN+5a9sFGUk7/R+AtgVuM6oG7hjWACMaQqorMjAoczBEFwoburiXwMAMNObEj6EjFHOxUWRE7TsKxH5a2CdIgP+aUV/vIGasskBFYKNX2W7vwsstkUcZKuihQUYp/7EiZiG5GN70IkfIXe9wTZiTNxZNU41MwjGszbMFmfp7HREAzLCPvFRdzHe8PKG++eFOJ3PyOnCwTwB5XLU29TUvTHkTTY6DeOBi4vSZGfJlIYa+OBM9ZGEGeiMDMkC4fD+8xZU1OtNVJqT82talgJXbtMk1sBs7Wcuqic1kG6/4lZAGaJ2ErfA8lPXeYl6aO2LCVbKc1LCfmRFF2QJCfNhoRfvjdhcEg5yW3ohMVb7//E7+HWOJ1epmtG1lQkdYbxo2opUXomNjI29AU7VfB4TdJ4pLXhm5AzSuyO9nlMjW0xCn2KBPwDyIG4Q+o2D+AAAAAASUVORK5CYII=']")).isDisplayed()){
				driver.findElement(By.xpath("//input[@value='Billing Tax ID:']")).click();
				waitTime();

				driver.findElement(By.xpath("//button[text()='Select Provider']")).click();
				//waitTime();

			}
			else if(driver.findElement(By.xpath("//img[@name='Image_Indicator_BillingTaxID_New' and @src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAB3RJTUUH2AQPDQ0laSi7LQAAAAlwSFlzAAALEgAACxIB0t1+/AAAAARnQU1BAACxjwv8YQUAAALdSURBVHjabVPvS1NRGH7OvfPeuU03M9TEAsmVKIz+gBA0w4SKzWmyRSkk7IPf9U8JKvowwiACi74GQj9QcPghlXKacxk2U8Fwbvfuxz09VzYx6LDDOTvnfZ73ed73XBWVcRMYagcWrgLbG8AK/jNCwEgHkOgCvn87GzMAjEacTuv91JR85PHIIWCMx+Is+D4QiWma9bqvT8Z0XY4CD+1z1c58zuV6NTk9LXx1degOBLC5tBTsKBZTTPHFDiJbxKfrM7f7+4ViWbjU1IRfmUyo3bKS4gZwODU56W3ioXl0BKtYRCmfx2w8joxhjGtA4bymzQz29sI0TRSOj1FiTDGbxezGRkm9AmxuLi8Pd/v9ArwoM8BRKqHr8mXsJJNBl8MRDvX0QJTLkLkcLJILxixubSEr5cSJzzAlNjJLNByGJgREoQAHAbYie69wze/vw+BaoIoESXaA2HPgmWoTfGVF/eVyMr22Fu5ua4OTPh1Uo+7uQqTTUCjXVqWSdJEqdqWMPSWYUEutVnnFJmFR0qlUuNPng0qJGjPW1tRAdzhgUcnHw0NsW1bscQVs45SzrbL/KMyUW12FztWj66h3OuHRNNTYfZUStYDJraxiThXYrWoQYmaArWz2euEmyM3sbpLoqgqN60XGZfL54DUg9bnS4hOCCH/1BPfV1qLR5YKTkll9HNG7Qt91bjcKVFTmWSvjf5pmMECSBZKoQeCeD3h5XdeFl1lqFOXEc57Feru3hxX69lMJeGaQrMj7ZnYqUygE+QTWxV16uqWqWgNl2l5t3wq9zhH427LGncBBqxDv7rS0oEiiYxbTnjnDwJtcrqR28iH9kTJ8wc7MWWQL51j9A4JZ7fg8s9BzYiufj7ZRhcl7gwSfqDALPFDXgGVKSR1IGWqitHkycz/OPser1WbB1gNSJn4YRrSFMR/4Eg+lHHsCvDht4TAQHeG7j5x8eP9+iZUhJoBBTpMzWj38C2dRTZc15mQUAAAAAElFTkSuQmCC']")).isDisplayed()){
				throw new NoSuchElementException("Cross mark is dispalyed for Billing txn ID");
			}
			else{
//				System.out.println("Valid Tax ID: "+Tax ID);
			}
		}
		catch(Exception e){
			System.out.println("warning icon is not visible for billing txn id");
		}



		WebElement BillNPI=silverBoxes.get(12);
		BillNPI.sendKeys(BillingNPI+Keys.TAB);
		waitTime();
		
		WebElement RenderNPI=silverBoxes.get(13);
		RenderNPI.sendKeys(RenderingNPI+Keys.TAB);

		WebElement Loczip=silverBoxes.get(16);
		Loczip.sendKeys(Zip+Keys.TAB);

		WebElement FacitliyNPI=silverBoxes.get(18);
		FacitliyNPI.sendKeys(ProvFacNPI+Keys.TAB);

		waitTime();
		List<WebElement> dateBoxes = driver.findElements(By.xpath("//input[@placeholder='<M/d/yyyy>']"));

		WebElement DOS=dateBoxes.get(1);	
		DOS.click();
		DOS.sendKeys(DOSFrom+Keys.TAB);
		
			waitTime();
		//				DOS.sendKeys(Keys.TAB);

		//				WebElement DOSTo=dateBoxes.get(3);
		//				DOSTo.sendKeys(DOSt+Keys.TAB);

		WebElement Patient=silverBoxes.get(21);
		Patient.sendKeys(PatientID+Keys.TAB);

		WebElement BillDate=dateBoxes.get(3);
		BillDate.click();
		BillDate.sendKeys(ProviderBillDate+Keys.TAB);
		waitTime();
		//				BillDate.sendKeys(Keys.TAB);
		
		WebElement ProcedureCode=silverBoxes.get(22);
		ProcedureCode.sendKeys(ICDProcedureCode);
		ProcedureCode.click();
		ProcedureCode.sendKeys(Keys.TAB);

		waitTime();
		
		WebElement ReceivedDate=dateBoxes.get(4);
		ReceivedDate.click();
		ReceivedDate.sendKeys(ClientReceivedDate+Keys.TAB);
		waitTime();
		//				ReceivedDate.sendKeys(Keys.TAB);

		WebElement BillReceived=dateBoxes.get(5);
		BillReceived.click();
		BillReceived.sendKeys(BillReceivedDate+Keys.TAB);
		//waitTime();
		//				BillReceived.sendKeys(Keys.TAB);



		//   UB-04 fields

		String billTypeTxt=inputBoxes.get(3).getAttribute("value");

		if(billTypeTxt.equalsIgnoreCase("UB-04")){


			WebElement TypeOfBillElement=silverBoxes.get(25);
			TypeOfBillElement.sendKeys(TypeofBill+Keys.TAB);

			WebElement MedicareNo=silverBoxes.get(26);
			MedicareNo.sendKeys(MedicareNumber+Keys.TAB);

			WebElement AdmtDt=dateBoxes.get(7);	
			AdmtDt.click();
			AdmtDt.sendKeys(AdmitDate+Keys.TAB);

			WebElement DschgDt=dateBoxes.get(8);	
			DschgDt.click();
			DschgDt.sendKeys(DischargeDate+Keys.TAB);

			WebElement AdmissonHr=silverBoxes.get(27);
			AdmissonHr.sendKeys(AdmissionHour+Keys.TAB);	

			List<WebElement> arrowListElement = driver.findElements(By.xpath("//div[contains(@id,'ItemSelectorArrowDiv_')]")); 
			WebElement lastArrow = arrowListElement.get(arrowListElement.size()-1);

			//			WebElement dropIcon = driver.findElements(By.xpath("//div[contains(@id,'ItemSelectorArrowDiv_')]")).get( driver.findElements(By.xpath("//div[contains(@id,'ItemSelectorArrowDiv_')]")).size()-1);

			lastArrow.click();
			waitTime();

			List<WebElement> dropdownListElement = driver.findElements(By.xpath("//div[contains(@id,'ItemSelectorItemListDiv_')]"));  
			WebElement admissionTypeDropdown = dropdownListElement.get(dropdownListElement.size()-1);

			List<WebElement> listUnderAdmissionType = admissionTypeDropdown.findElements(By.tagName("li"));  //dropdown list

			for(WebElement item: listUnderAdmissionType){
				System.out.println(item.getText().trim());
				if(item.getText().contains("Emergency")){
					item.click();
					break;

				}
			}


			WebElement AdmissonSrc=silverBoxes.get(28);
			AdmissonSrc.clear();
			AdmissonSrc.sendKeys(AdmissionSource+Keys.TAB);

			WebElement DischargeHr=silverBoxes.get(29);
			DischargeHr.sendKeys(DischargeHour+Keys.TAB);

			WebElement DischargeSt=silverBoxes.get(30);
			DischargeSt.sendKeys(DischargeStatus+Keys.TAB);

			WebElement AdmittingDiag=silverBoxes.get(31);
			AdmittingDiag.sendKeys(AdmittingDiagnosis+Keys.TAB);

			WebElement PrinProcCDs=silverBoxes.get(32);
			PrinProcCDs.sendKeys(PrinProcCodes+Keys.TAB);
			waitTime();
			
			WebElement PrinProcDt=dateBoxes.get(9);	
			PrinProcDt.click();
			PrinProcDt.sendKeys(PrinProcDate+Keys.TAB);

			WebElement OpProvNPI=silverBoxes.get(34);
			OpProvNPI.sendKeys(OperationProvNPI+Keys.TAB);

			WebElement Drgcd=silverBoxes.get(35);
			Drgcd.sendKeys(DRG+Keys.TAB);

		}


		//LOcID = data[rowNumber][30];
		//StAddress = data[rowNumber][31];
		//City = data[rowNumber][32];
		//State = data[rowNumber][33];
		//zip = data[rowNumber][34];



	}


	public static void main (String[] args) throws IOException{
		mainFlow();


	}

}

