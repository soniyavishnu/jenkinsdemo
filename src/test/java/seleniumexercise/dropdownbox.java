package seleniumexercise;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class dropdownbox {
	WebDriver driver;
  @Test
  public void SelectDropdownExample() throws InterruptedException
  {

  //To scroll the page
  JavascriptExecutor js = (JavascriptExecutor) driver; //Interface
  js.executeScript("window.scrollBy(0,300)");
  Reporter.log("Page is scrolled by pixel");

  //Define the Webelement first
  WebElement dropdownskills = driver.findElement(By.id("Skills"));

  //Inbuilt Select class
  Select dropdownvalue = new Select(dropdownskills);

  //SelectByVisibleText()
 
  dropdownvalue.selectByVisibleText("Adobe InDesign");
  Reporter.log("Selected using VisibleText : Adobe InDesign " );

  Thread.sleep(2000);

  //SelectByValue using Value Attribute

  dropdownvalue.selectByValue("Android"); //Android
  Reporter.log("Selected using value : Android ");
  Thread.sleep(2000);

  //SelectByIndex
  dropdownvalue.selectByIndex(3);
  Reporter.log("Selected using index : 3 ");
  Thread.sleep(2000);



  //Without using select By using getOptions
  selectoption(dropdownskills,"Art Design");
  Thread.sleep(5000);
  Reporter.log("Select drop down");


  //Define the Webelement first
  WebElement dropdownskills1 = driver.findElement(By.id("countries"));
  selectoption(dropdownskills1,"Algeria");
  Thread.sleep(2000);
  }
  
 
  public static void selectoption(WebElement ele, String value)
  {

  Select dropdownvalue = new Select(ele);

  // List<WebElement> optiontotlcount = dropdownvalue.getOptions();

  List<WebElement> optionscount = dropdownvalue.getOptions();

  //using for...each loop
  for(WebElement option:optionscount)
  {
  if(option.getText().equals(value)) //Condition
  {
  option.click();
  Reporter.log("Dynamically Without Select method by using get options count : " + value);
  break;
  }
  }
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
