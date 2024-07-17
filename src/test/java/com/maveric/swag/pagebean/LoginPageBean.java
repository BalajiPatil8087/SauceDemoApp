package com.maveric.swag.pagebean;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageBean {

	@FindBy(how = How.ID, id = "user-name")
	private WebElement username;

	@FindBy(how = How.ID, id = "password")
	private WebElement password;

	@FindBy(how = How.NAME, name = "login-button")
	private WebElement login;

	@FindBy(how = How.XPATH, xpath = "//div[@class='error-message-container error']/h3")
	private WebElement errorMessage;

	@FindBy(how = How.XPATH, xpath = "//div[text()='Swag Labs']")
	private WebElement SwagLab;

	public String getSwagLab() {
		return SwagLab.getText();
	}

	public String getUsername() {
		return username.getText();
	}

	public void setUsername(String username) {
		this.username.sendKeys(username);
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

	public String getPassword() {
		return password.getText();
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void login() {
		login.submit();
	}
}
