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

WebUI.click(findTestObject('Object Repository/Page_Holygram/a_Account'))

WebUI.click(findTestObject('Object Repository/Page_Holygram/a_Create'))

WebUI.click(findTestObject('Object Repository/Page_Holygram - Signin/label_Exorcist'))

WebUI.setText(findTestObject('Object Repository/Page_Holygram - Signin/input_Username_username'), 'qwertz')

WebUI.setText(findTestObject('Object Repository/Page_Holygram - Signin/input_Email_email'), 'qwertz@mail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Holygram - Signin/input_Password_password'), 'RigbBhfdqOBGNlJIWM1ClA==')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Holygram - Signin/password2'), 'RigbBhfdqOBGNlJIWM1ClA==')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Holygram - Signin/selectCanton'), 'NE', true)

WebUI.setText(findTestObject('Object Repository/Page_Holygram - Signin/input_Phone_phoneNumber'), '023 465 78 90')

WebUI.setText(findTestObject('Object Repository/Page_Holygram - Signin/textarea_Description_description'), '12345678')

WebUI.click(findTestObject('Object Repository/Page_Holygram - Signin/button_Submit'))

WebUI.click(findTestObject('Object Repository/Page_Holygram/a_qwertz'))

WebUI.click(findTestObject('Object Repository/Page_Holygram/a_Disconnect'))

WebUI.click(findTestObject('Page_Confirm Log Out/button_Log Out'))

WebUI.closeBrowser()

