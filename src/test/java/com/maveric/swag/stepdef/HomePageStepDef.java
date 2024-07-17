package com.maveric.swag.stepdef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.maveric.swag.databeans.AddCustDataBean;
import com.maveric.swag.databeans.AddProdDataBean;
import com.maveric.swag.pagebean.HomePageBean;
import com.maveric.swag.pagebean.LoginPageBean;
import com.maveric.swag.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageStepDef<CartBean> {

	LoginInStepDef loginDef= new LoginInStepDef();

	private LoginPageBean pageBean;

	public HomePageBean homeBean= new HomePageBean() ;

	/*@Before
	public void setUpEnv() {
		driver = DriverFactory.getDriver();
		pageBean = PageFactory.initElements(driver, LoginPageBean.class);
		homeBean = PageFactory.initElements(driver, HomePageBean.class);
	}
	*/
	
	//DriverFactory
	/*
	 * @Before public void setUpEnv() { driver = DriverFactory.getDriver(); }
	 * 
	 */
	  @Given("User is already login on Swag Labs loging page") 
	  public void user_is_already_login_on_swag_labs_loging_page() {
	 // driver.get("https://www.saucedemo.com/inventory.html"); 
		  }
	 
	@DataTableType
	public AddProdDataBean productBeanData(List<String> productBean) {
		AddProdDataBean bean = new AddProdDataBean();
		bean.setProduct(productBean.get(0));
		return bean;
	}

	@DataTableType
	public AddCustDataBean CustomerDetailsBeanData(Map<String, String> CustBean) {
		AddCustDataBean bean = new AddCustDataBean();
		bean.setFirstName(CustBean.get("FirstName"));
		bean.setLastname(CustBean.get("LastName"));
		bean.setPostalcode(CustBean.get("PostalCode"));
		return bean;
	}

	@Then("User add {string} in cart")
	public void user_add_in_cart(String string, List<String> productBean) throws InterruptedException {

		for (String bean : productBean) {
			System.out.println("Product: " +bean);
			if (bean.equals("Sauce Labs Backpack"))
				homeBean.ClickProduct1();
			    
			else if (bean.equals("Sauce Labs Bike Light"))
				homeBean.getProduct2();
			else if (bean.equals("Sauce Labs Bolt T-Shirt"))
				homeBean.getProduct3();
		}
		Thread.sleep(10000);
	}

	@Then("click on shopping cart container")
	public void click_on_shopping_cart_container() {

	}

	@Then("click on checkout")
	public void click_on_checkout() {
		homeBean.CheckoutClick();
		
	}

	@Then("user should enter checkout information")
	public void user_should_enter_checkout_information(AddCustDataBean CustBean) throws InterruptedException {
		homeBean.setFirstname(CustBean.getFirstName());
		Thread.sleep(3000);
		homeBean.setLastName(CustBean.getLastname());
		Thread.sleep(3000);
		homeBean.setPostalcode(CustBean.getPostalcode());
		Thread.sleep(3000);
	}

	@Then("click on continue")
	public void click_on_continue() {
		homeBean.ContinueClick();
	}

	@Then("User is able to see added products")
	public void user_is_able_to_see_added_products() {

	}

	@Then("click on finish")
	public void click_on_finish() {
		homeBean.FinishClick();
	}

	@Then("User is able to see Thank you for your order Meassage")
	public void user_is_able_to_see_thank_you_for_your_order_meassage() {

	}

	@Then("User logout from the screen")
	public void user_logout_from_the_screen() {
       
	}
	/*
	 * @After public void tearDown() { driver.quit(); }
	 */

}
