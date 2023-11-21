package Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.MakeMyTripExcelFileRead;

public class MakeMyTripTestData {

	@DataProvider
	public Object[][] GetValidSearchTestData() throws IOException
	{
		return MakeMyTripExcelFileRead.ExcelRead("MakeMyTrip.xls","ValidSearch");
	}

	@DataProvider
	public Object[][] GetinValidSearchTestData() throws IOException
	{
		return MakeMyTripExcelFileRead.ExcelRead("MakeMyTrip.xls","invalidSearch");
	}
}
