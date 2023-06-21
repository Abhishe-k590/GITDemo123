import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShot {
    @Test
	public void lava() throws IOException {
		System.setProperty("webdriver.chrome.driver",".\\\\Driver\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
	//	TakesScreenshot ts= (TakesScreenshot)driver;
		WebElement section = driver.findElement(By.cssSelector(".header-lower"));
		File scr = section.getScreenshotAs(OutputType.FILE);
		
		File dsc= new File("./Screenshot.png");
		FileUtils.copyFile(scr, dsc);
		
driver.close();
	}

}
