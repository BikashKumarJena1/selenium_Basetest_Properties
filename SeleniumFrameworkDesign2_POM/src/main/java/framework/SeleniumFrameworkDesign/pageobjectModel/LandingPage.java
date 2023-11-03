package framework.SeleniumFrameworkDesign.pageobjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstarct_Component.Abstract_Component;

public class LandingPage extends Abstract_Component {
	
WebDriver driver;
public LandingPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);//To use @FindBy()
}


//
public void goTo()
{
	driver.get("https://rahulshettyacademy.com/client");
}
@FindBy(id="userEmail")
private WebElement UserEmail;
//Equivalent to -> WebElement emailTxt = driver.findElement(By.xpath("//input[@id='userEmail']"));


@FindBy(id="userPassword")
private WebElement userPassword;

@FindBy(id="login")
private WebElement login;

//Actions for Login
public void loginApp(String Email,String Pwd)
{
	UserEmail.sendKeys(Email);
	userPassword.sendKeys(Pwd);
	login.click();
	
}
}
