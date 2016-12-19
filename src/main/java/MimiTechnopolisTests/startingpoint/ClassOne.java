package MimiTechnopolisTests.startingpoint;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClassOne {
	WebDriver driver;
	
	@Before
	public void setUpEnvironment(){
		System.setProperty("webdriver.chrome.driver", "D://libr//chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C://Users//matanasova//Milena additional//programs//chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://www.technopolis.bg/");
		 
	}
	
	@Test
	public void verifyValidationIsRaisedForMissingPass(){

		WebElement vhodButton = driver.findElement(By.xpath("//a[@href='/bg/login']"));
		vhodButton.click();
		
		WebElement usernameField = driver.findElement(By.id("j_username"));
		usernameField.click();
		usernameField.sendKeys("mimi");
		
		WebElement sbmtButton = driver.findElement(By.xpath("//form[@id='loginForm']//button[@type='submit']"));
		sbmtButton.click();
		
		WebElement errorMsg = driver.findElement(By.xpath("//div[@class='message error']"));

		Assert.assertNotNull(errorMsg);
		driver.quit();
	}
	
	@Test
	public void verifyProductIsInBasket(){
		WebElement searchBox = driver.findElement(By.id("search"));
		searchBox.sendKeys("лаптоп");
		WebElement findButton = driver.findElement(By.xpath("//button[text()='Tърсене']"));
		findButton.click();
		
		WebElement firstProductInList = driver.findElement(By.xpath("//form[@id='addToCartForm512850']//button[@id='addToCartButton']"));
		firstProductInList.click();
		String expectedResult = driver.findElement(By.xpath("//div[@class='product-box']//h2//a[contains(@href, '512850')]")).getText();
		String actualResult = driver.findElement(By.xpath("//div[@id='cboxLoadedContent']//figcaption")).getText();
		Assert.assertEquals(expectedResult, actualResult);
		driver.quit();
	}
	
	@Test
	public void verifyPlaceholdervalueInSearchBox(){
		WebElement categoryButton = driver.findElement(By.xpath("//form[@name='site_search']//li[@class='category']"));
		Actions action = new Actions(driver);
		action.moveToElement(categoryButton).build().perform();
		
		WebElement chosenCategory = driver.findElement(By.xpath("//form[@name='site_search']//li[@class='category']//li//a[@class='category-pc']"));
		chosenCategory.click();
		//TODO verify the placeholder text is corrct basing on the chosen category. Try data driven in order to select all categories
	}
	

}
