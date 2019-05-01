import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/AuthentificationRegistration')

suiteProperties.put('name', 'AuthentificationRegistration')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\dev\\he-arc\\3257.2-Java_Enterprise_Edition_JEE\\Holygram\\HolygramKatalon\\Reports\\AuthentificationRegistration\\20190501_150316\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/AuthentificationRegistration', suiteProperties, [new TestCaseBinding('Test Cases/RegistrationExorcist', 'Test Cases/RegistrationExorcist',  null), new TestCaseBinding('Test Cases/RegistrationCustomer', 'Test Cases/RegistrationCustomer',  null), new TestCaseBinding('Test Cases/LoginCustomer', 'Test Cases/LoginCustomer',  null), new TestCaseBinding('Test Cases/LogoffCustomer', 'Test Cases/LogoffCustomer',  null), new TestCaseBinding('Test Cases/LoginExorcist', 'Test Cases/LoginExorcist',  null), new TestCaseBinding('Test Cases/LogoffExorcist', 'Test Cases/LogoffExorcist',  null)])
