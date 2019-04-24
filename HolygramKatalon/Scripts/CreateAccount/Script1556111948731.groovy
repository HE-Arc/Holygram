import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:8080/')

WebUI.click(findTestObject('Page_Holygram/a_Account (12)'))

WebUI.click(findTestObject('Page_Holygram/a_Create (2)'))

WebUI.setText(findTestObject('Page_Holygram - Signin/input_Username_username (2)'), 'customer2')

WebUI.setText(findTestObject('Page_Holygram - Signin/input_Email_email (2)'), 'customer2@gmail.com')

WebUI.setEncryptedText(findTestObject('Page_Holygram - Signin/input_Password_password (2)'), 'r9inNhf6FTla56shneBo8g==')

WebUI.click(findTestObject('Page_Holygram - Signin/div_Password_col-sm-10'))

WebUI.setEncryptedText(findTestObject('Page_Holygram - Signin/input_Password_passwordConfirm (2)'), 'r9inNhf6FTla56shneBo8g==')

WebUI.click(findTestObject('Page_Holygram - Signin/button_Submit (2)'))

