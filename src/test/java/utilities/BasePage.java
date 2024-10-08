package utilities;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
//edited in main branch
    // Now 13th line changes by Guest Branch
    // adding some text in 13th line
    //Now from guest branch add this line and practice the Pull request creation
    //adding one line from test branch and just committing

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void sendInput(WebElement element, String inputvalue) {
        element.sendKeys(inputvalue);
    }
    
    public static String getAttributeUsingInnerText(WebElement element) {
    	String innerText = "innerText";
		String attributeValue = element.getAttribute(innerText);
    	return attributeValue;
    }
    
    public static String getTextFromElement(WebElement element) {
    	String text = element.getText();
		return text; 	
    }
}


