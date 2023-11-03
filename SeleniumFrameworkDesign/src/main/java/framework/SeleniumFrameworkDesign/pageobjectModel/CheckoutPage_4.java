package framework.SeleniumFrameworkDesign.pageobjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Abstarct_Component.Abstract_Component;

public class CheckoutPage_4 extends Abstract_Component {
	
WebDriver driver;
public CheckoutPage_4(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);//To use @FindBy()
}


//
By cartfind=By.cssSelector(".ta-results");

@FindBy(xpath=" //input[@placeholder='Select Country']")
private WebElement inputCountry;

@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
private WebElement SelectCountry;

@FindBy(xpath="//a[text()='Place Order ']")
private WebElement placeOrderClick;


//Actions for Login

public void CheckoutpageDetailsfillup() throws InterruptedException

{
	
	Actions ac = new Actions(driver);
	ac.sendKeys(inputCountry, "India").build().perform();
	visibilityOfElementLocated(cartfind);
	SelectCountry.click();
	

	
}
public void placeOrderClick() throws InterruptedException
{
	placeOrderClick.click();

}
}
