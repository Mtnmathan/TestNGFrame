package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotPage {
	
	public static void getScreenShot(WebDriver driver, String name) {
		String dest = System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		try {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(dest));
		}
		catch(IOException e) {
			System.out.println("Exception occured"+" "+e.getMessage());
		}
	}
}
