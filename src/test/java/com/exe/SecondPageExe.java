package com.exe;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.object.HotelSearchLocators;

public class SecondPageExe extends Execution {
	@Test
	public static void location() {
		BaseClass.byVisibleText(new HotelSearchLocators().getLocation(),"Sydney");
	}
	@Test
	public static void hotels() {
		BaseClass.byVisibleText( new HotelSearchLocators().getHotels(),"Hotel Creek");
	}
	@Test
	public static void roomtype() {
		BaseClass.byVisibleText( new HotelSearchLocators().getRoomType(),"Standard");
	}
	
	public static void roomNos() {
		BaseClass.byVisibleText( new HotelSearchLocators().getRoomnos(),"2 - Two");
	}
	public static void dateIn() {
		BaseClass.clear(new HotelSearchLocators().getDatepick_in());
		BaseClass.input( new HotelSearchLocators().getDatepick_in(),excelRead(4,0));
	}
	public static void dateOut() {
		BaseClass.clear(new HotelSearchLocators().getDatepick_out());
		BaseClass.input( new HotelSearchLocators().getDatepick_out(),excelRead(5,0));
	}
	public static void adultRoom() {
		BaseClass.byVisibleText( new HotelSearchLocators().getAdult_room(),excelRead(3,0));
	}
	public static void ChildRoom() {
		BaseClass.byVisibleText( new HotelSearchLocators().getChild_room(),excelRead(3,0));
	}
	public static void sub() {
		BaseClass.click( new HotelSearchLocators().getSubmit());
	}
	
	

}
