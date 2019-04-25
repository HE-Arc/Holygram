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

WebUI.click(findTestObject('Object Repository/Page_Holygram/a_Account (16)'))

WebUI.click(findTestObject('Object Repository/Page_Holygram/a_Log in (13)'))

WebUI.setText(findTestObject('Page_Please sign in/input_Username_username (5)'), 'exorcist')

WebUI.setEncryptedText(findTestObject('Page_Please sign in/input_Password_password (5)'), 'RigbBhfdqOBGNlJIWM1ClA==')

WebUI.click(findTestObject('Page_Please sign in/button_Sign in (2)'))

WebUI.click(findTestObject('Object Repository/Page_Holygram/span_exorcist (8)'))

WebUI.click(findTestObject('Object Repository/Page_Holygram/a_Profile (8)'))

WebUI.click(findTestObject('Object Repository/Page_Holygram/button_exorcist_btn btn-secondary (6)'))

WebUI.click(findTestObject('Object Repository/Page_Holygram/i_exorcist_fas fa-save'))

WebUI.closeBrowser()

