package assignmentweek4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		Thread.sleep(20000);
		driver.get("https://dev113545.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("w6hnF2FRhwLC");
		driver.findElementById("sysverb_login").click();
		driver.switchTo().defaultContent();
		driver.findElementById("filter").sendKeys("incident");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@class='sn-widget-list_v2 sn-widget-list_dense collapse in'])[3]/li[6]/div/div/a")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElementById("sysverb_new").click();
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l=new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(l.get(0));
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Test");
String val=driver.findElement(By.id("incident.number")).getAttribute("value");
System.out.println(val);
driver.findElement(By.id("sysverb_insert_bottom")).click();
driver.switchTo().window(l.get(0));
WebElement frm= driver.findElementByXPath("//div[@class='navpage-main-left ng-isolate-scope']/iframe"); 
driver.switchTo().frame(frm);
WebElement A = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
A.sendKeys(val);
A.sendKeys(Keys.ENTER);
WebElement id = driver.findElement(By.xpath("(//a[@class='linked formlink'])"));
String ver=id.getText();
if (val.equals(ver)) {
	System.out.println("Incident created successfully");
}
else {
	System.out.println("Incident not created");
}

File src1 = driver.getScreenshotAs(OutputType.FILE);
File dst = new File("./snaps/snow.png");
FileUtils.copyFile(src1, dst);


	}

}