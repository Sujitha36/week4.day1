package assignmentweek4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//ul[@class='shortcuts']/li[4]/a")).click();
		driver.findElementByXPath("//input[@id='partyIdFrom']/following::a/img").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l= new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		driver.switchTo().window(l.get(0));
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following::a[1]/img")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> L=new ArrayList<String>(windowHandles2);
		
		  driver.switchTo().window(L.get(1)); driver.
		  findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a").click();
		  driver.switchTo().window(L.get(0));
		  driver.findElementByXPath("//input[@id='partyIdTo']/following::a[1]/following::tr[2]/td[2]/a").click();
		  driver.switchTo().alert().accept();
		  System.out.println("Title of the page is : "+driver.getTitle());
		 
	}

}