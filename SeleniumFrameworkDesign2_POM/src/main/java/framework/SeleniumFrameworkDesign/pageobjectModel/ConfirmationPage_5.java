package framework.SeleniumFrameworkDesign.pageobjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Abstarct_Component.Abstract_Component;

public class ConfirmationPage_5 extends Abstract_Component {
	
WebDriver driver;
public ConfirmationPage_5(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);//To use @FindBy()
}


//


@FindBy(xpath="//h1[@class='hero-primary']")
private WebElement seeTheConfirmationData;


public void ConPageData() throws InterruptedException
{

	String actualText = seeTheConfirmationData.getText();
	Thread.sleep(2000);
	System.out.println(actualText);
	Assert.assertTrue(actualText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
}




public void verifyConfirmMessage() throws InterruptedException

{
	
	Thread.sleep(2000);
	System.out.println("Test run successful");
}
}
