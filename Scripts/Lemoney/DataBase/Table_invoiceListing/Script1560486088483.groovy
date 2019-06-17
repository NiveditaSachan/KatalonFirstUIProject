import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.By.ByXPath as ByXPath

	Invoice_nbr = 'INV_NBR_2'
	
	queryString = "select invoice_nbr,id,bill_to,invoice_sent_at,payment_due_date,total_cost from invoice where invoice_nbr='$Invoice_nbr'"

	// Execute query
	result = CustomKeywords.'com.database.DemoSQLPro.executeQuery'(queryString)
	
	//Run the loop until there is next row in result set-  result.next() 
	while (result.next()) {
		
	    println('invoice nbr : ' + result.getString(1))
	
	    println('id : ' + result.getString(2))
	
	    println('billTo : ' + result.getString(3))
	
	    println('InvoiceDate : ' + result.getString(4))
	
	    println('Due date : ' + result.getString(5))
	
	    println('Amount : ' + result.getString(6))
	}
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	// Any Data in Table preceding the Invoice Number Xpath
	List<WebElement> RowDataPrecedingInvoice_nbr =driver.findElements(By.xpath("//span[(text() = '${Invoice_nbr}' or . = '${Invoice_nbr}')]/preceding::td[count(. | //td) = count(//td)]"))
	println(RowDataPrecedingInvoice_nbr.get(0).getText())
	
	// Any Data in Table following the Invoice Number Xpath
	List<WebElement> RowDatafollowingInvoice_nbr =driver.findElements(By.xpath("//span[(text() = '${Invoice_nbr}' or . = '${Invoice_nbr}')]/following::td[count(. | //td) = count(//td)]"))
		println("Size is : " + RowDatafollowingInvoice_nbr.size() )
		println(" Due Date is : " +RowDatafollowingInvoice_nbr.get(0).getText())
		println(" Status is : " +RowDatafollowingInvoice_nbr.get(1).getText())
		println(" Amount Due is : " +RowDatafollowingInvoice_nbr.get(2).getText())
		println(" Button is : " +RowDatafollowingInvoice_nbr.get(3).getText())
		
	List<WebElement> RowsinTable = WebUiCommonHelper.findWebElements( findTestObject('Object Repository/Lemoney/Invoices/Receivables/tableRows_InvoiceDate'),10)
	RowsinTable.size()
	
	j=0
	for (i=0;i<RowsinTable.size();i++)
		{
			println(" Due Date is : " +RowDatafollowingInvoice_nbr.get(j).getText())
			println(" Status is : " +RowDatafollowingInvoice_nbr.get(j+1).getText())
			println(" Amount Due is : " +RowDatafollowingInvoice_nbr.get(j+2).getText())
			println(" Button is : " +RowDatafollowingInvoice_nbr.get(j+3).getText())
			j=j+5
		}
	
