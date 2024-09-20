package pageobjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePage;

public class ResultPage extends BasePage {

    public ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String fetchResult(int index) {
    	String dynamicXPath = "(//span[contains(text(),'HP')])["+index+"]//ancestor::div[@data-cy='title-recipe']//following-sibling::div/descendant::span[@class='a-price']";
    	 WebElement searchRes = driver.findElement(By.xpath(dynamicXPath));
//		String price = getAttributeUsingInnerText(searchRes);
		String price = getTextFromElement(searchRes);
         return price;
    }
}
