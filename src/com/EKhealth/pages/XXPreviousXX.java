package com.EKhealth.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import BillEntry.getData;

public class XXPreviousXX {
				
	
	public static void waitTime(){															
		try {														
			Thread.sleep(5000);													
		} catch (InterruptedException e) {														
			// TODO Auto-generated catch block													
			e.printStackTrace();													
		}														
	}															
																
	public static void main (String[] args) throws IOException{															
																
		String[][] data = getData.readExcel("TestData", "CMS");														
																
																
		String clientName=data[1][0];														
																
		System.setProperty("webdriver.gecko.driver", "C:/kul/geckodriver.exe");														
		WebDriver driver = new FirefoxDriver();														
																
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);														
																
		driver.get("http://52.37.60.147/decisions/Login.aspx");														
																
		driver.findElement(By.id("txt_login_username")).sendKeys("amalik@ekhealth.com");														
																
		driver.findElement(By.id("txt_login_password")).sendKeys("Summer!2017");														
																
		driver.findElement(By.id("btn_login_submit")).click();														
																
		driver.findElement(By.id("btn_user_portal")).click();														
																
		driver.get("http://52.37.60.147/decisions/Primary/H/?FolderId=56b91dee-8a71-11e6-ace6-00155d0fe70e&pageName=Billing%20Entry%20Main%20Page");														
																
		waitTime();														
																
		//WebElement dropIcon = driver.findElements(By.xpath("//div[contains(@id,'ItemSelectorArrowDiv_')]/span")).get(0);														
																
		//dropIcon.click();														
		waitTime();														
																
		//items in dropdown														
		List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@id,'ItemSelectorItemListDiv_')]/ul/li"));														
																
		System.out.println(elements.size());														
		System.out.println(elements.get(0).getText());														
																
		//list of input boxes -selector														
		List<WebElement> inputBoxes = driver.findElements(By.xpath("//input[contains(@id,'ItemSelectorText_')]"));														
																
		WebElement clientInput=inputBoxes.get(0);														
		clientInput.sendKeys(clientName);														
		//waitTime();														
		for(WebElement item: elements){														
		if(item.getText().equalsIgnoreCase(clientName)){														
				item.click();												
			break;													
																
			}													
		}														
																
																
		//list of input boxes														
		List<WebElement> silverBoxes = driver.findElements(By.xpath("//input[contains(@id,'SilverTextBox')]"));														
																
		WebElement claim=silverBoxes.get(3);														
		claim.sendKeys("W123456789");														
																
		WebElement State=silverBoxes.get(4);														
		State.sendKeys("CA");														
																
		WebElement payCode=inputBoxes.get(2);														
		payCode.sendKeys("Medical");														
		waitTime();														
		for(WebElement item: elements){														
		if(item.getText().equalsIgnoreCase("Medical")){														
				item.click();												
			break;													
																
			}													
		}														
																
//		for (int i = 1; i < data.length; i++) {														
//			String claimNum = data[i][0];													
//			String	State = data[i][1];												
//			String	BillingTaxID = data[i][2];												
//			String	BillingNPI = data[i][3];												
//			String	RenderingNPI = data[i][4];												
//			String	Zip = data[i][5];												
//			String	DOSFrom = data[i][6];												
//			String	DOSTo = data[i][7];												
//			String	PatientID = data[i][8];												
//			String	ProviderBillDate = data[i][9];												
//			String	ICDProcedureCode = data[i][10];												
//			String	ClientReceivedDate = data[i][11];												
//			String	BillReceivedDate = data[i][12];												
//																
//		//List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@id,'ItemSelectorItemListDiv_')]/ul/li"));														
//																
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_dee25e08-cdda-4953-a0f3-2b903a8fe823']")).sendKeys(claimNum);														
//		//claimNumber.sendKeys(Keys.TAB);														
//		//validation?														
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_f294878b-f954-4356-a888-61344b74b31a']")).sendKeys(State);														
//																
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_f35dfc14-ae99-41de-843a-faebd866c3d0']")).sendKeys(BillingTaxID);														
//																
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_f294878b-f954-4356-a888-61344b74b31a']")).sendKeys(BillingNPI);														
//																
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_de133dcf-eb66-4e81-b638-c123f8e7c1b4']")).sendKeys(RenderingNPI);														
//																
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_e1695347-5f88-4998-b220-ba5293968064']")).sendKeys(Zip);														
//																
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_f294878b-f954-4356-a888-61344b74b31a']")).sendKeys(DOSFrom);														
//																
//																
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_f294878b-f954-4356-a888-61344b74b31a']")).sendKeys(DOSTo);														
//																
//																
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_f294878b-f954-4356-a888-61344b74b31a']")).sendKeys(PatientID);														
//																
//																
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_f294878b-f954-4356-a888-61344b74b31a']")).sendKeys(ProviderBillDate);														
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_f294878b-f954-4356-a888-61344b74b31a']")).sendKeys(ICDProcedureCode);														
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_f294878b-f954-4356-a888-61344b74b31a']")).sendKeys(ClientReceivedDate);														
//		driver.findElement(By.xpath("//*[@id='SilverTextBox_f294878b-f954-4356-a888-61344b74b31a']")).sendKeys(BillReceivedDate);														
//																
//		driver.findElement(By.xpath("//*[@id='SilverButton_3b34d1f129cf40de8e93b6819974b018__9de6134fe48a48148e325e70a137935c']")).click();														
	}
}