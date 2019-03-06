import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import javax.xml.ws.wsaddressing.W3CEndpointReference.Address as Address
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.junit.After as After
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.interactions.Mouse as Mouse
import org.openqa.selenium.remote.server.DefaultDriverFactory
import org.stringtemplate.v4.compiler.STParser.element_return
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.util.List as List
import java.util.ArrayList as ArrayList

WebUI.openBrowser('')

	WebUI.navigateToUrl('https://www.bigbasket.com/')
	
	WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/a_Login'))
	
	WebUI.setText(findTestObject('Object Repository/Page_Online Grocery Shopping and On/input_OR_email'), 'nivedita.hbti@gmail.com')
	
	WebUI.setEncryptedText(findTestObject('Object Repository/Page_Online Grocery Shopping and On/input_Please enter valid email'), 
	    'LqVTzjb8H0GS29zWb5N07g==')
	
	WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/button_LOGIN'))
	
	//Go To My Orders Page
	WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount'), 
	    15)
	
	Thread.sleep(2000)
	
	WebUI.click(findTestObject('Object Repository/Page_Online Grocery Shopping and On/span_UserAccount'))
	
	WebUI.click(findTestObject('Object Repository/BigBasket/SpendTrend/Nivedita_MyAccount'))
	
	WebUI.waitForElementPresent( findTestObject('Object Repository/BigBasket/SpendTrend/LeftMenu_SpendTrends'), 0)
	
	WebUI.click(findTestObject('Object Repository/BigBasket/SpendTrend/LeftMenu_SpendTrends') )
	
	Thread.sleep(2000)

	// Read From Bar Chart How much did I spend on orders?
	List<WebElement> ExpenditureOnOrdersMonthName=WebUiCommonHelper.findWebElements( findTestObject('BigBasket/SpendTrend/Order_ExpenditureChart_Month'), 15)
	List<WebElement> ExpenditureOnOrdersAmountPerMonth=WebUiCommonHelper.findWebElements(findTestObject('BigBasket/SpendTrend/Order_ExpenditureChart_Amount') , 15)
	
	noOfMonths=ExpenditureOnOrdersMonthName.size()
	
	println("    noOfMonths : " + noOfMonths)

	for(i=0;i<noOfMonths;i++){
		println("Expenditure on orders Per month is, \n" +"                                    " +ExpenditureOnOrdersMonthName.get(i).getAttribute("innerHTML") + ": "+ ExpenditureOnOrdersAmountPerMonth.get(i).getAttribute("innerHTML"))
	}
	
	// How much did I spend on orders?
	List<WebElement> SavingOnOrdersMonthName=WebUiCommonHelper.findWebElements( findTestObject('Object Repository/BigBasket/SpendTrend/Order_SavingChart_month'), 15)
	List<WebElement> SavingOnOrdersAmountPerMonth=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/BigBasket/SpendTrend/Order_SavingChart_Amount') , 15)
	
	noOfMonths_Saving=SavingOnOrdersMonthName.size()
	
	println("    noOfMonths_Saving : " + noOfMonths_Saving)

	for(i=0;i<noOfMonths_Saving;i++){
		println("Savings on orders Per month is, \n" +"                                    " +SavingOnOrdersMonthName.get(i).getAttribute("innerHTML") + ": "+ SavingOnOrdersAmountPerMonth.get(i).getAttribute("innerHTML"))
	}
	
	// What categories did I spend money on?
	List<WebElement> Expenditure_CategoryName=WebUiCommonHelper.findWebElements( findTestObject('Object Repository/BigBasket/SpendTrend/Order_CategoryExpenditure_CategoryName'), 15)
	List<WebElement> Expenditure_Amount=WebUiCommonHelper.findWebElements( findTestObject('Object Repository/BigBasket/SpendTrend/Order_CategoryExpenditure_Amount'), 15)
	
	noOfCategory=Expenditure_CategoryName.size()
	
	println("    no Of Categories : " + noOfCategory)

	for(i=0;i<noOfCategory;i++){
		println("Expenditure on Categories Per month is, \n" +"                                    " +Expenditure_CategoryName.get(i).getAttribute("innerHTML") + ": "+ Expenditure_Amount.get(i).getAttribute("innerHTML"))
	}
	
	WebUI.closeBrowser()
	
	//////
	//       //*[local-name() = 'text'][@text-anchor='start']
