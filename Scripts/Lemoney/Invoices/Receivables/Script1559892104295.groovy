import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.interactions.Mouse as Mouse
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

	// Verification of By Default Invoice headers in Receivables tab
	List<WebElement> listInvoiceHeaders=WebUiCommonHelper.findWebElements( findTestObject('Object Repository/Lemoney/Invoices/Receivables/tableHeaders_Invoices'), 10)

	if(listInvoiceHeaders.get(0).getText().equalsIgnoreCase("Invoice Date"))
	{
		KeywordUtil.markPassed("Invoice Date Header is displayed.")
	}
	
	if(listInvoiceHeaders.get(1).getText().equalsIgnoreCase("Particulars"))
	{
		KeywordUtil.markPassed("Particulars Header is displayed.")
		
	}
	
	if(listInvoiceHeaders.get(2).getText().equalsIgnoreCase("Due Date"))
	{
		KeywordUtil.markPassed("Due Date Header is displayed.")
	}
	
	if(listInvoiceHeaders.get(3).getText().equalsIgnoreCase("Status"))
	{
		KeywordUtil.markPassed("Status Header is displayed.")
		
	}
	
	if(listInvoiceHeaders.get(4).getText().equalsIgnoreCase("Amount Due"))
	{
		KeywordUtil.markPassed("Amount Due Header is displayed.")
		
	}

	// Verification of 'Invoice Date' data rows: Can not be blank or null
	List<WebElement> listInvoiceDate = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Lemoney/Invoices/Receivables/tableRows_InvoiceDate'), 
    10)

	for (i = 0; i < listInvoiceDate.size(); i++) {
			
	    if (listInvoiceDate.get(i).getText().equalsIgnoreCase(' ') || listInvoiceDate.get(i).getText().equalsIgnoreCase(null)) 
			{
		        KeywordUtil.markError('\'Step failed with error: \'Invoice Date is either Blank or null at row no \'' + (i + 1))
		    }
		else
			{
				KeywordUtil.markPassed("Invoice Date "+listInvoiceDate.get(i).getText() +" is not Null or Blank. ")
			}
			
	}

	// Verification of 'Particulars Company Name' data rows: Can not be blank or null
	List<WebElement> listParticularsCompanyName = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Lemoney/Invoices/Receivables/tableRows_ParticularsCompanyName'), 
    10)

	if (listInvoiceDate.size() != listParticularsCompanyName.size()) 
		{
		    KeywordUtil.markError('\'Step failed with error: \'Missing Invoice date or Company Name')
		}

	for (i = 0; i < listParticularsCompanyName.size(); i++) {
	
	    if (listParticularsCompanyName.get(i).getText().equalsIgnoreCase(' ') || listParticularsCompanyName.get(i).getText().equalsIgnoreCase(
	        null)) 
			{
		        KeywordUtil.markError('\'Step failed with error: \'Company Name is either Blank or null at row no \'' + (i + 1))
		    }
		else
			{
				KeywordUtil.markPassed("Company Name "+listParticularsCompanyName.get(i).getText() +" is not Null or Blank. ")
			}
	}

	// Verification of 'Particulars Invoice Id' data rows: Can not be blank or null
	List<WebElement> listParticularsInvoiceID = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Lemoney/Invoices/Receivables/tableRows_ParticularInvoiceId'), 
    10)

	if (listInvoiceDate.size() != listParticularsInvoiceID.size())
		{
		    KeywordUtil.markError('Missing Invoice date or Invoice Id')
		}
	

	for (i = 0; i < listParticularsInvoiceID.size(); i++) {
	
		    if (listParticularsInvoiceID.get(i).getText().equalsIgnoreCase(' ') || listParticularsInvoiceID.get(i).getText().equalsIgnoreCase(
		        null)) 
				{
			        KeywordUtil.markError('\'Step failed with error: \'Invoice ID is either Blank or null at row no \'' + (i + 1))
			    }
			else
				{
					KeywordUtil.markPassed("Invoice id "+listParticularsInvoiceID.get(i).getText() +" is not Null or Blank. ")
				}
	    
	    listParticularsInvoiceID.get(i).getText().matches('INV_NBR_')
	}

	// Verification of 'Due Date' data rows: Can not be blank or null
	List<WebElement> listDueDate = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Lemoney/Invoices/Receivables/tableRows_DueDate'), 
	    10)

		if (listInvoiceDate.size() != listDueDate.size()) {
		    KeywordUtil.markError('\'Step failed with error: \'Missing Invoice date or Due Date')
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
		

		for (i = 0; i < listDueDate.size(); i++) {
		
		    if (listDueDate.get(i).getText().equalsIgnoreCase(' ') || listDueDate.get(i).getText().equalsIgnoreCase(null)) 
				{
			        KeywordUtil.markError("Step failed with error: 'Due Date is either Blank or null at row no " + (i + 1))
			    }
			else{
					KeywordUtil.markPassed("Due date "+listDueDate.get(i).getText() +" is not Null or Blank. ")				
				}
			
			
		    if (!(formatter.parse(listDueDate.get(i).getText()) >= formatter.parse(listInvoiceDate.get(i).getText()))) 
				{
			        KeywordUtil.markError("Step failed with error: 'Due Date "+listDueDate.get(i).getText()+" can not be before Invoice Date'"+ listInvoiceDate.get(i).getText())
			    }
		}
	// Verification of 'Status' data rows: Can not be blank or null
	List<WebElement> listStatus = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Lemoney/Invoices/Receivables/tableRows_Status'), 
	    10)
	
		if (listInvoiceDate.size() != listStatus.size()) 
			{
			    KeywordUtil.markError("Step failed with error: 'Missing Invoice date or Status no of rows in InvoiceDate are : '"+
					listInvoiceDate.size() + " no of rows in Status are : " + listStatus.size())
			}
	
		for (i = 0; i < listStatus.size(); i++) 
			{
			    println(listStatus.get(i).getText())
			
			    if (listStatus.get(i).getText().equalsIgnoreCase(' ') || listStatus.get(i).getText().equalsIgnoreCase(null)) 
					{
				        KeywordUtil.markError('\'Step failed with error: \'Status is either Blank or null at row no \'' + (i + 1))
				    }
				else
					{
						KeywordUtil.markPassed("Status "+listStatus.get(i).getText() +" is not Null or Blank. ")
					}
			}

	// Verification of 'Amount Due Currency Type' data rows: Can not be blank or null
	List<WebElement> listAmountDueCurrType = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Lemoney/Invoices/Receivables/tableRows_AmountDueCurrencyType'), 
	    10)
	
		for (i = 0; i < listAmountDueCurrType.size(); i++) 
			{
			    println(listAmountDueCurrType.get(i).getText())
			
			    if (listAmountDueCurrType.get(i).getText().equalsIgnoreCase(' ') || listAmountDueCurrType.get(i).getText().equalsIgnoreCase(
			        null))
				    {
				        KeywordUtil.markFailed('\'Step failed with error: \'Amount Due Currency Type is either Blank or null at row no \'' + 
				            (i + 1))
				    }
				else
					{
						KeywordUtil.markPassed("Amount Due Currency type "+listAmountDueCurrType.get(i).getText() +" is not Null or Blank. ")
					}
			}

	// Verification of 'Amount Due ' data rows: Can not be blank or null
	List<WebElement> listAmountDue = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Lemoney/Invoices/Receivables/tableRows_AmountDue'), 
	    10)
	
		for (i = 0; i < listAmountDue.size(); i++) {
		    println(listAmountDue.get(i).getText())
		
			    if (listAmountDue.get(i).getText().equalsIgnoreCase(' ') || listAmountDue.get(i).getText().equalsIgnoreCase(null)) 
					{
				        KeywordUtil.markError("Step failed with error: 'Amount Due is either Blank or null at row no '" + (i + 1))
						//KeywordUtil.markError("")
				    }
				else
					{
						KeywordUtil.markPassed("Amount Due "+listAmountDue.get(i).getText() +" is not Null or Blank. ")
					}
				
		}


