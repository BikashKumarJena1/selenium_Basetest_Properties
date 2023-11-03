package framework.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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

public class BasicTest {
	static WebDriver driver;
	static String Product_Name = "ZARA COAT 3";
	static String[] requireProducts = { "ZARA COAT 3"};
	static List<WebElement> productCount;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// registerUser();
		login();
		particularProduct();
		// addProductToCart();
		cartToCheckout();
		placeTheOrder();

	}
	// For Signup

	public static void registerUser() throws InterruptedException {
		driver.findElement(By.xpath("//a[.='Register']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Bikash");
		driver.findElement(By.id("lastName")).sendKeys("Jena");
		driver.findElement(By.id("userEmail")).sendKeys("Bikash1234@gmail.com");
		driver.findElement(By.id("userMobile")).sendKeys("7898766787");

		WebElement SelectDropdown = driver.findElement(By.xpath("//select[@formcontrolname='occupation']"));
		SelectDropdown.click();
		Select s = new Select(SelectDropdown);
		s.selectByVisibleText("Engineer");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.id("userPassword")).sendKeys("Bikash@123");
		driver.findElement(By.id("confirmPassword")).sendKeys("Bikash@123");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Register']")).click();
	}
	// For Login

	public static void login() {
		driver.findElement(By.id("userEmail")).sendKeys("Bikash1234@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Bikash@123");
		driver.findElement(By.xpath("//input[@id='login']")).click();
	}
	// Find out whole product and add to cart require product

	public static void particularProduct() {
		productCount = driver.findElements(By.cssSelector(".col-sm-10"));
		int NumberOfProduct = productCount.size();
		System.out.println(NumberOfProduct);
		int i;
		int j = 0;
		for (i = 0; i < NumberOfProduct; i++) {
			String name = productCount.get(i).getText();

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
			driver.findElements(By.cssSelector(".card-body button:last-of-type")).get(i).click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
				if (j == requireProducts.length) {
					break;
				}
			}
		}
	}

	public static void addProductToCart() {
		WebElement findPoduct = productCount.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(Product_Name)).findFirst()
				.orElse(null);
		findPoduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	}

	public static void cartToCheckout() throws InterruptedException {

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> cartItemList = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		boolean findMatch = cartItemList.stream()
				.anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(Product_Name));
		Assert.assertTrue(findMatch);
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
	}

	public static void placeTheOrder() throws InterruptedException {
		WebElement inputCountry = driver.findElement(By.xpath(" //input[@placeholder='Select Country']"));
		Actions ac = new Actions(driver);
		ac.sendKeys(inputCountry, "India").build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		Thread.sleep(3000);
		String actualText = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		Thread.sleep(2000);
		System.out.println(actualText);
		Assert.assertTrue(actualText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		System.out.println("Test run successful");
		Thread.sleep(2000);
		driver.close();

	}
}
