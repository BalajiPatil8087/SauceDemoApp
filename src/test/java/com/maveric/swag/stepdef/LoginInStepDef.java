package com.maveric.swag.stepdef;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.maveric.swag.databeans.UserBean;
import com.maveric.swag.pagebean.LoginPageBean;
import com.maveric.swag.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginInStepDef {
	private LoginPageBean pageBean;

	public WebDriver driver;

	@BeforeAll
	public static void beforeAll() {
		System.out.println("  Before All ");
	}

	@Before
	public void setUpEnv() {
		System.out.println("Before  ");
		driver = DriverFactory.getDriver();
        pageBean = PageFactory.initElements(driver, LoginPageBean.class);
       
	}
	

	@BeforeStep
	public void beforeEachStep() {
		System.out.println(" ----> beforeEachStep ");
	}

	@Given("User is on Swag Labs loging page")
	public void user_is_on_swag_labs_loging_page() {
		driver.get("https://www.saucedemo.com/");
	}

//	@And("User logout from the screen")
//	public void User_logout_from_the_screen() {
//		driver.findElement(By.xpath("Logout")).click();
//		
//	}

	@DataTableType
	public UserBean userBeanData(Map<String, String> inputData) {
		UserBean bean = new UserBean();
        bean.setUserName(inputData.get("userName"));
		bean.setPasswsord(inputData.get("password"));
		return bean;
	}

	@When("User enter wrong credentials")
	public void user_enter_wrong_credentials(UserBean bean) {
		pageBean.setUsername(bean.getUserName());
		pageBean.setPassword(bean.getPasswsord());
	}

	@When("click on login")
	public void click_on_login() {
		pageBean.login();
		// Assert.fail();

	}

	@Then("{string} message should display")
	public void message_should_display(String string) {
		String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
		String actualErrorMsg = pageBean.getErrorMessage();
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}

	@When("User enter valid credentials")
	public void user_enter_valid_credentials(UserBean bean) {
		pageBean.setUsername(bean.getUserName());
		pageBean.setPassword(bean.getPasswsord());

	}

	@Then("user able to see home page of corresponding Swag Labs account")
	public void user_able_to_see_home_page_of_corresponding_swag_labs_account() {
		String txt = pageBean.getSwagLab();
		System.out.println(txt);
		String expectedErrorMsg = "Swag Labs";
		Assert.assertEquals(expectedErrorMsg, txt);
	}
	
//	//Home Page
//	HomePageBean HPBean = new HomePageBean();
//	@When("User should add {string}")
//	public void user_should_add(String prod) {
//		boolean flag = HPBean.getAddcartbackpack(prod,driver);
//		Assert.assertEquals(true, flag);
//		HPBean.getShoppingcart();
//		
//	}
//    
//	@After
//	public void tearDownEnv1(Scenario scenario) throws InterruptedException {
//		if (scenario.isFailed()) {
//			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//			byte[] screenShot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenShot, "image/png", "errorScreen");
//			driver.quit();
//		}
//		
//	}

	@After
	public void tearDownEnv(Scenario scenario) throws InterruptedException {
		if (scenario.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			byte[] screenShot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", "errorScreen");
		}
		Thread.sleep(1000);
		driver.quit();
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("  After All ");
	}
}
