package framework.SeleniumFrameworkDesign;

import java.time.Duration;

import java.util.Arrays;
import java.util.List;

import org.bouncycastle.jcajce.provider.symmetric.AES.CCM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import framework.SeleniumFrameworkDesign.pageobjectModel.CartPage_3;
import framework.SeleniumFrameworkDesign.pageobjectModel.CheckoutPage_4;
import framework.SeleniumFrameworkDesign.pageobjectModel.ConfirmationPage_5;
import framework.SeleniumFrameworkDesign.pageobjectModel.LandingPage;
import framework.SeleniumFrameworkDesign.pageobjectModel.Product_Catlouge_2;

public class BasicTest_For_Pom {
	static WebDriver driver;
	static String Product_Name = "ZARA COAT 3";
	static String[] requireProducts = { "ZARA COAT 3"};
	static List<WebElement> productCount;
	static LandingPage l;
	static Product_Catlouge_2 p;
	static CartPage_3 c;
	static CheckoutPage_4 c1;
	static ConfirmationPage_5 c2;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		l = new LandingPage(driver);
        p=new Product_Catlouge_2(driver);
        c=new CartPage_3(driver);
        c1=new CheckoutPage_4(driver);
        c2=new ConfirmationPage_5(driver);
		login();
		 particularProduct();
		cartToCheckout();
		 placeTheOrder();

	}

	// For Login
	public static void login() {
		// URL
		l.goTo();
		// Instead of Type everything we are using POM Concept for login
		l.loginApp("Bikash1234@gmail.com", "Bikash@123");
		
	}
	// Find out whole product and add to cart require product

	public static void particularProduct() {
	List<WebElement> r = p.getProductList();
	
	p.getAllProductNames(requireProducts, r);
	//	productCount = driver.findElements(By.cssSelector(".col-sm-10"));
	
	}

	

	public static void cartToCheckout() throws InterruptedException {
		c.cartOptionClick();
	Thread.sleep(3000);
		c.Checkout();
		

		
		
	}

	public static void placeTheOrder() throws InterruptedException {
	c1.CheckoutpageDetailsfillup();
	c1.placeOrderClick();
	c2.ConPageData();
	c2.verifyConfirmMessage();

		

	}
}
