package tests;

import java.io.IOException;
import java.util.Properties;
import org.checkerframework.common.reflection.qual.GetMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v126.page.model.Screenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.ResultPage;
import utilities.BasePage;
import utilities.ExcelReaderAndWriter;
import utilities.FileReaderAndWriter;
import utilities.ScreenshotPage;

public class SearchAndDebugResult extends BaseTest {
	
	private HomePage homepage;
    private ResultPage resultPage;
    private FileReaderAndWriter fileReaderAndWriter;
    private ExcelReaderAndWriter excelReaderAndWriter;
    private ScreenshotPage screenshotPage;
    
    @BeforeMethod
    public void setupPages() throws IOException {
    	homepage = new HomePage(getDriver());
        resultPage = new ResultPage(getDriver());
        fileReaderAndWriter = new FileReaderAndWriter("src\\test\\resources\\Amazon.txt");
        excelReaderAndWriter = new ExcelReaderAndWriter("src\\\\test\\\\resources\\\\TestDataExcel.xlsx");
        screenshotPage = new ScreenshotPage();
    }
	
	@Test
	public void testingUsingTxtFile() throws InterruptedException, IOException {
	String url = fileReaderAndWriter.getURL();
	String inputSearchTerm = fileReaderAndWriter.getInputSearchTerm();
	String indexString = fileReaderAndWriter.getIndex();
    int index = Integer.parseInt(indexString);
	getDriver().get(url);
	homepage.enterSearchInput(inputSearchTerm);
	homepage.clickSearchIcon();
	String price = resultPage.fetchResult(index);
//	screenshotPage.getScreenShot(getDriver(), "AmazonExcelData");
    fileReaderAndWriter.writeData("Price", price);
    System.out.println("Using Text"+" "+Thread.currentThread().getId());
	
	}
	@Test
	public void testingUsingExcel() throws InterruptedException, IOException {
	    String url = excelReaderAndWriter.getURL();
	    String inputSearchTerm = excelReaderAndWriter.getInputSearchTerm();
	    String indexString = excelReaderAndWriter.getIndex();

	    if (indexString != null && !indexString.isEmpty()) {
	        int index = Integer.parseInt(indexString);
	        getDriver().get(url);
	        homepage.enterSearchInput(inputSearchTerm);
	        homepage.clickSearchIcon();
	        String price = resultPage.fetchResult(index);
//	        screenshotPage.getScreenShot(getDriver(), "AmazonTextData");
	        excelReaderAndWriter.writeData("Price", price);
	    } else {
	        System.out.println("Index is null or empty");
	    }

	    excelReaderAndWriter.close();
	    System.out.println("Using Excel"+" "+Thread.currentThread().getId());
	}
}
