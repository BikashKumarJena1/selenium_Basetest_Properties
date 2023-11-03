package framework.SeleniumFrameworkDesign.pageobjectModel;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstarct_Component.Abstract_Component;

public class Product_Catlouge_2 extends Abstract_Component  {
	
WebDriver driver;
public Product_Catlouge_2(WebDriver driver)

{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);//To use @FindBy()
}

By findBy=By.xpath("//div[@id='toast-container']");


@FindBy(css=".ng-animating")
private WebElement element;

@FindBy(css=".col-sm-10")
private List<WebElement> ProductCount;
//Equivalent to -> productCount = driver.findElements(By.cssSelector(".col-sm-10"));
@FindBy(css=".card-body button:last-of-type")
private List<WebElement> AddtoCart;


public List<WebElement> getProductList()

{
	waitForElementToAppear(findBy);
	return ProductCount;
}
public void getAllProductNames(String[] requireProducts,List<WebElement> ProductCount)
{
	int i;
	int j = 0;
	for (i = 0; i < ProductCount.size(); i++) {
		String name = ProductCount.get(i).getText();

		// to get 1st word
		int indexOfLineBreak = name.indexOf('\n');
		String textBeforeLineBreak = " ";
		if (indexOfLineBreak != -1) {
			// Check if a line break is found
			textBeforeLineBreak = name.substring(0, indexOfLineBreak);
			// Extract text before the line break
		}

		System.out.println(textBeforeLineBreak);
		// System.out.println(name);
		List<String> cart = Arrays.asList(requireProducts);
		if (cart.contains(textBeforeLineBreak)) {
			j++;
			AddtoCart.get(i).click();
			waitForElementToAppear(findBy);
			waitForElementToDisappear(element);
			if (j == requireProducts.length) {
				break;
			}

		}
	}
}




}

