package tests;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
//Adding just line to check the changes
	    private WebDriver driver;

		@BeforeClass
	    public void setUp() {
	    	WebDriverManager.chromedriver().setup();
	        setDriver(new ChromeDriver());
	        getDriver().manage().window().maximize();
	        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    }

	    @AfterClass
	    public void tearDown() {
//	        if (driver != null) {
	            getDriver().quit();
//	        }
	    }

		public WebDriver getDriver() {
			return driver;
		}

		public void setDriver(WebDriver driver) {
			this.driver = driver;
		}
	}
	

