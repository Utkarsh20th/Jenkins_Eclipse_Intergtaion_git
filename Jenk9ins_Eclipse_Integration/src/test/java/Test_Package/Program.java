package Test_Package;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Program {

	ChromeOptions chromeOptions = null;
	WebDriver driver = null;
	WebElement ele = null;

	@BeforeClass
	public void setup() {

		chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);

		/*
		//Setting the driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_JARs\\2_ChromeDriver\\Zipped_File\\chromedriver.exe");

		//Creating WebDriver instance
		driver = new ChromeDriver();
		*/

		driver.manage().window().maximize();

	}

	@Test
	public void website() throws InterruptedException, IOException {

		driver.get("https://www.penguinpickup.com/");
		Thread.sleep(4000);
		
		ele = driver.findElement(By.xpath("/html/body/header/div/nav/div/div[2]/ul/li[6]/a"));
		ele.click();
		Thread.sleep(4000);
		
		/*
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        //ImageIO.write(s.getImage(),"PNG",new File("C:\\Users\\Utkarshk\\Documents\\ExtentReports\\AShot_Full_Screenshots\\fullPageScreenshot.png"));
        ImageIO.write(s.getImage(), "jpg", new File("C:\\Users\\Utkarshk\\Documents\\ExtentReports\\AShot_Full_Screenshots\\fullPageScreenshot.jpg"));
        */
		
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C:\\Dummy\\Screenshots\\screenshot.jpg");
        FileUtils.copyFile(SrcFile, DestFile);
        
        Thread.sleep(4000);

	}
	
	@AfterClass
	public void ending() {
		
		driver.quit();
		
	}

}
