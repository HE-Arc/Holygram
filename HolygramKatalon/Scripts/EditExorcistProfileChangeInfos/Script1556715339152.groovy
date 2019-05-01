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
import org.openqa.selenium.Keys as Keys

WebUI.selectOptionByValue(findTestObject('Object Repository/selectCanton'), '13', true)

WebUI.click(findTestObject('Object Repository/div_Information                                                                                                                                Email'))

WebUI.setText(findTestObject('Object Repository/input_Phone number_phonenumber_input'), '+41 32 123 45 67')

WebUI.click(findTestObject('Object Repository/div_Information                                                                                                                                Email'))

WebUI.setText(findTestObject('Object Repository/textarea_Bonjour voici ma nouvelle description faite avec le test Katalon'), 
    'Bonjour voici ma nouvelle description faite avec le test Katalon')

