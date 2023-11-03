package all_Compnents_and_Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import framework.SeleniumFrameworkDesign.pageobjectModel.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	static WebDriver driver;
	public static LandingPage l;

	public static WebDriver iniializeDriver() throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\bkumarje\\eclipse-workspace\\selenium_Basetest_Properties\\src\\main\\java\\Global_Properties\\alldata.properties");
		p.load(fis);
	String browserName = p.getProperty("browser");
	if(browserName.equalsIgnoreCase("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("Edge"))
	{
		driver=new EdgeDriver();
	}
	else if(browserName.equalsIgnoreCase("Firefox"))
			{
		driver=(WebDriver) new GeckoDriverInfo();
			}
	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	//Before main method it will execute every time
	@BeforeMethod
	public static LandingPage launchApplication() throws IOException
	{
	driver=	iniializeDriver();
		
		 l=new LandingPage(driver);
		l.goTo();
		return l;
	}
	@AfterMethod
	public void CloseBrowser()
	{
		driver.close();
	}

}
