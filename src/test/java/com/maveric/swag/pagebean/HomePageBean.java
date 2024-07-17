package com.maveric.swag.pagebean;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageBean {

	@FindBy(how=How.NAME,name="add-to-cart-sauce-labs-backpack")
	public WebElement product1;
	
	@FindBy(how=How.NAME,name="add-to-cart-sauce-labs-bike-light")
	private WebElement product2;
	
	@FindBy(how=How.NAME,name="add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement product3;
	
	@FindBy(how=How.XPATH,xpath="//span[@class='shopping_cart_badge']")
	private WebElement shoppingcart;
	
	@FindBy(how = How.ID,id="checkout")
    private WebElement checkout;
	
	@FindBy(how =How.ID,id="first-name")
	private WebElement firstname;
	
	@FindBy(how=How.NAME,name="lastName")
	private WebElement lastName;
	
	@FindBy(how=How.NAME,name="postalCode")
	private WebElement postalcode;
	
	@FindBy(how=How.NAME,name="continue")
	private WebElement Continue;
	
	@FindBy(how=How.XPATH,xpath="//button[text()='Finish']")
	private WebElement finish;
	
	public String getFinishmsg() {
		return finish.getText();
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname.sendKeys(firstname);
	}

	public WebElement getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName .sendKeys(lastName);
	}

	public WebElement getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode.sendKeys(postalcode);
	}

	public void ClickProduct1() {
		this.product1.click();
	}

	public WebElement getProduct2() {
		return product2;
	}

	public WebElement getProduct3() {
		return product3;
	}

	public WebElement getShoppingcart() {
		return shoppingcart;
	}

	public void CheckoutClick() {
		this.checkout.click();
	}

	public void ContinueClick() {
		this.Continue.click();
	}

	public void FinishClick() {
		this.finish.click();
	}
	
	
}
