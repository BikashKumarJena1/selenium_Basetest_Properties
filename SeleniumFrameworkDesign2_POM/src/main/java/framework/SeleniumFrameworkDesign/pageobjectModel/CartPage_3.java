package framework.SeleniumFrameworkDesign.pageobjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstarct_Component.Abstract_Component;

public class CartPage_3 extends Abstract_Component {
	
WebDriver driver;
public CartPage_3(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);//To use @FindBy()
}


//


@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
private WebElement cart;

//driver.findElement(By.xpath("//button[text()='Checkout']")).click();
@FindBy(xpath="//button[text()='Checkout']")
private WebElement checkout;
//Actions for Login
public void cartOptionClick()
{

	cart.click();

}
public void Checkout() throws InterruptedException
{
	pageScroll();

	checkout.click();
	
}
}
