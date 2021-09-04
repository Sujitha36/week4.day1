package assignmentweek4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ScreenShorts {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement clicks = driver.findElementByXPath("(//div[@id='wrapframe'])[1]/iframe");
		driver.switchTo().frame(clicks);
		WebElement element = driver.findElementById("Click");
		File src2 = element.getScreenshotAs(OutputType.FILE);
		File dst1 = new File("./snaps/seats.png");
		FileUtils.copyFile(src2, dst1);
		driver.switchTo().defaultContent();
		List<WebElement> frm = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames : "+frm.size());
	}

}