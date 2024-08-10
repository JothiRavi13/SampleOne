package com.object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPageLocators extends BaseClass{

	public LoginPageLocators() {
		PageFactory.initElements(dr,this);
	}
	@FindBy(id = "username")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}
	@FindBy(id = "password")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(id = "login")
	private WebElement login;
	public WebElement getLogin() {
		return login;
	}
}

