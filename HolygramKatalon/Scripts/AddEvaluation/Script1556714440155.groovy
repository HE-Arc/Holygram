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

WebUI.click(findTestObject('Object Repository/Page_Holygram/i_Evaluation_fas fa-thumbs-up'))

WebUI.setText(findTestObject('Object Repository/Page_Holygram/textarea_Comment_comment'), 'really nice !')

WebUI.click(findTestObject('Object Repository/Page_Holygram/input_Please write a comment_btn btn-primary'))

WebUI.click(findTestObject('Object Repository/Page_Holygram/i_Evaluation_fas fa-thumbs-down'))

WebUI.setText(findTestObject('Object Repository/Page_Holygram/textarea_Comment_comment'), 'pretty bad')

WebUI.click(findTestObject('Object Repository/Page_Holygram/input_Please write a comment_btn btn-primary'))

