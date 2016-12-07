package MimiTechnopolisTests.startingpoint;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassOne {
	WebDriver driver;
	
	@Before
	public void setUpEnvironment(){
		//System.setProperty("webdriver.chrome.driver", "D://libr//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C://Users//matanasova//Milena additional//programs//chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	}
	
	@Test
	public void loadPage(){
		driver.get("http://www.technopolis.bg/");
	}

}
