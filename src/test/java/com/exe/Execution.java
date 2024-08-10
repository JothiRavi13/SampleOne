package com.exe;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.object.HotelSearchLocators;
import com.object.LoginPageLocators;

public class Execution extends HotelSearchLocators {
	@Test (priority =1)
	public static void username() {
		BaseClass.input( new LoginPageLocators().getUsername(),"yuvisekar3");
		//input (WebElement a,String b)
	}
	@Test (priority =2)
	public static void password() {
		BaseClass.input( new LoginPageLocators().getPassword(),"33CJOO");
	}
	@Test (priority =3)
	public static void login() {
		BaseClass.click(new LoginPageLocators().getLogin());
	}
	
}
