package tests;

import java.io.IOException;

import objects.RomaBookingPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.DriverSetup;


public class Roma_Test extends DriverSetup{

	WebDriver driver;
	RomaBookingPage bookingPage;
	String from = "Kyiv";
	String till = "Odesa";
	String date = "06.12.2015";
	
	
	@BeforeClass
	public void startUp() throws IOException {

	    driver = setUp();
		bookingPage= new RomaBookingPage(driver);

	}

	@Test
	public void RomanTestTableIsPresent() throws InterruptedException {
		
		bookingPage.enterStationFrom(from);
		bookingPage.enterStationTill(till);
		bookingPage.enterDate(date);
		bookingPage.submitbuttonSearch();
		bookingPage.trainsTablePresent();
		
		Assert.assertEquals(true, bookingPage.isTableEnabled());
		
							
	}

	@Test
	public void RomanTestTrainIsPresent() throws InterruptedException {
		
		bookingPage.cleanUpAll();
		bookingPage.enterStationFrom(from);
		bookingPage.enterStationTill(till);
		bookingPage.enterDate("06.12.2015");
		bookingPage.submitbuttonSearch();
		bookingPage.trainsTablePresent();
	
		Assert.assertEquals(bookingPage.findTrain(), "148 Ê");
		//Assert.assertEquals(bookingPage.findTrain(), "763 Ê");
		
	}	
	
	@AfterClass
	public void shutDown() {
		driver.quit();
	}

}