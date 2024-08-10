package com.exe;

import org.testng.annotations.Test;

public class Output extends SecondPageExe {
	@Test
	public void url() {
		location();
		hotels();
		roomtype();
	}	
}
