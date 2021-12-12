package seleniumexercise;
import org.testng.annotations.Test;
import java.util.List;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class checkbox {
	WebDriver driver;
	
	@Test
 
  public void checkboxvalidation() throws InterruptedException {

	//To select the specific checkbox


	//IsDisplayed
	Reporter.log("Checkbox : " + driver.findElement(By.id("checkbox1")).isDisplayed());

	//isEnabled
	Reporter.log("Checkbox : " + driver.findElement(By.id("checkbox1")).isEnabled());


	//isSelected
	Reporter.log("Before Checkbox Status : " + driver.findElement(By.id("checkbox1")).isSelected());

	//To select the particular Checkbox
	driver.findElement(By.id("checkbox1")).click();

	//isSelected
	Reporter.log("After Checkbox Status : " + driver.findElement(By.id("checkbox1")).isSelected());

	// driver.findElement(By.xpath("//input[@id='checkbox2']")).click();

	Reporter.log("Checkbox is selected successfully");
	Thread.sleep(5000);
	}
  
  @Test
//To select all the Checkbox using Dynamically
public void selectallcheckbox() throws InterruptedException
{
//Java Collections - List
//Java for...each loop

//Select all the checkbox
List<WebElement> checkboxcount = driver.findElements(By.xpath("//input[@type='checkbox']"));

checkboxcount.size();

Reporter.log("Dynamically Number of Checkbox is : " + checkboxcount.size()); //Count of checkbox

//using for...each loop
for(WebElement chkboxvalue : checkboxcount) //directly assigning it to the webelement reads the checkboxes one after the other
{
chkboxvalue.click(); //Select the checkbox

Reporter.log("Selected Checkbox ID : " + chkboxvalue.getAttribute("id"));

Reporter.log("Selected Checkbox Value : " + chkboxvalue.getAttribute("value"));
}

Thread.sleep(5000);
}
  
  @Test
//To select specific checkbox
public void SelectSpecificCheckbox() throws InterruptedException
{
List<WebElement> checkboxcount = driver.findElements(By.xpath("//input[@type='checkbox']"));
Reporter.log("Number of Checkbox is : " + checkboxcount.size());

//using for...each loop
for(WebElement chkboxvalue : checkboxcount) //directly assigning it to the webelement reads the checkboxes one after the other
{

String chkboxname = chkboxvalue.getAttribute("id");
if(chkboxname.equals("checkbox2") || chkboxname.equals("checkbox3"))
{
chkboxvalue.click();
}
}
Thread.sleep(5000);
}

@BeforeTest
  public void beforeTest() {
	  

	  System.setProperty("webdriver.chrome.driver","C:\\Soniya\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://demo.automationtesting.in/Register.html");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  driver.quit();
  }

}
