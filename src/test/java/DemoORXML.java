import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoORXML {
	public static void main(String[] args) throws DocumentException {
		WebDriver driver=null;
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		
		File lFile=new File(System.getProperty("user.dir")+"//Properties.xml");
		
		SAXReader lSax=new SAXReader();
		Document document=lSax.read(lFile);
		String mobileTesting=document.selectSingleNode("//menu/mobiletesting").getText();
		String emailtextBox=document.selectSingleNode("//menu/email").getText();
		String signUpButton=document.selectSingleNode("//menu/email").getText();
		
		//Navigating to Testing and back
		driver.findElement(By.xpath(mobileTesting)).click();
		driver.navigate().back();
		
		//Entering form data
		driver.findElement(By.id(emailtextBox)).sendKeys("testguru99@gmail.com");
		
		driver.findElement(By.id(signUpButton)).click();
	}
}
