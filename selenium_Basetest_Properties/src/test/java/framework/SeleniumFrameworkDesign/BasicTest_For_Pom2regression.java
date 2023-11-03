package framework.SeleniumFrameworkDesign;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import all_Compnents_and_Properties.BaseTest;
import framework.SeleniumFrameworkDesign.pageobjectModel.CartPage_3;
import framework.SeleniumFrameworkDesign.pageobjectModel.CheckoutPage_4;
import framework.SeleniumFrameworkDesign.pageobjectModel.ConfirmationPage_5;
import framework.SeleniumFrameworkDesign.pageobjectModel.LandingPage;
import framework.SeleniumFrameworkDesign.pageobjectModel.Product_Catlouge_2;

public class BasicTest_For_Pom2regression  extends BaseTest{
	static WebDriver driver;
	static String Product_Name = "ZARA COAT 3";
	static String[] requireProducts = { "ZARA COAT 3"};
	static List<WebElement> productCount;
	
	static Product_Catlouge_2 p;
	static CartPage_3 c;
	static CheckoutPage_4 c1;
	static ConfirmationPage_5 c2;

	@Test
	public void Execute() throws InterruptedException, IOException
	{
		//using basetest class we are going to landing page
		
	
	//using beforemethod
	l.loginApp("Bikash1234@gmail.com", "Bikash@123");
	System.out.println(l.getErrorMessage());
	
		
       // p=new Product_Catlouge_2(driver);
      //  c=new CartPage_3(driver);
    //    c1=new CheckoutPage_4(driver);
    //    c2=new ConfirmationPage_5(driver);
	//	login();
		// particularProduct();
		//cartToCheckout();
		// placeTheOrder();

	}
	@Test
	public void execute2()
	{
		l.loginApp("Bikash1234@gmail.com", "Bikash@123");
		//System.out.println(l.getErrorMessage());
	}

	// For Login
/*	public static void login() throws IOException {
		// URL
		LandingPage l = launchApplication();
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

		

	}*/
}
