package TestNG;

//import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;

public class TestmeApp 
{
	static WebDriver driver;
	//static ExtentTest test;

	@BeforeTest
	public static void beforelogin()
	{
		//Setting the System Property
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_d2.03.07\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//Navigate to the URL
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		//test.log(Status.INFO,"Opening Url");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Implement Implicit wait
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
								
	}
	@Test(priority=0,enabled=false)
	public static void SignUp() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();	
		//test.log(Status.INFO,"Clicking on signup button");
		driver.findElement(By.id("userName")).sendKeys("johndoe");
		//test.log(Status.INFO,"Entering Username");
		driver.findElement(By.id("firstName")).sendKeys("vikas");
		//test.log(Status.INFO,"Entering first name");
		driver.findElement(By.id("lastName")).sendKeys("pandey");
		//test.log(Status.INFO,"Entering last name");
		driver.findElement(By.id("password")).sendKeys("12345678");
		//test.log(Status.INFO,"Entering password");
		driver.findElement(By.name("confirmPassword")).sendKeys("12345678");
		//test.log(Status.INFO,"confirming password");
		driver.findElement(By.xpath("//*[@value=\"Male\"]")).click();
		//test.log(Status.INFO,"selecting gender");
		driver.findElement(By.id("emailAddress")).sendKeys("abc@t.com");
		//test.log(Status.INFO,"entering email");
		driver.findElement(By.id("mobileNumber")).sendKeys("1234567891");
		//test.log(Status.INFO,"Entering Mobile Number");
		driver.findElement(By.name("dob")).sendKeys("27/09/1997");
		//test.log(Status.INFO,"Entering DateOf Birth");
		driver.findElement(By.id("address")).sendKeys("Gurgaon DDC2");
		//test.log(Status.INFO,"Entering Address");
		driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]/option[1]")).click();
		//test.log(Status.INFO,"Choosing the security question");
		driver.findElement(By.id("answer")).sendKeys("kanpur");
		//test.log(Status.INFO,"Entering answer of security question");
		Thread.sleep(5000);
		driver.findElement(By.name("Submit")).click();
		//test.log(Status.INFO,"Clicking on submit button");
		String s=driver.findElement(By.xpath("(//*[@id='errormsg'])[4]")).getText();
		//System.out.println(s);
		Assert.assertTrue(s.equals("User Registered Succesfully!!! Please login"));
		//test.log(Status.INFO,"Checking sign up is successfully done or not");
		}
	@Test(priority=1)
	public static void LogIn() 
	{
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();	
		//test.log(Status.INFO,"Clicking on Signin button");
		driver.findElement(By.id("userName")).sendKeys("Admin");
		//test.log(Status.INFO,"Entering username");
		driver.findElement(By.id("password")).sendKeys("Password456");
		//test.log(Status.INFO,"Entering password");
		driver.findElement(By.name("Login")).click();
		//test.log(Status.INFO,"Clicking on Login button");
		String s=driver.findElement(By.xpath(".//*[@test='true']")).getText();
	    System.out.println(s);
	    Assert.assertTrue(s.contains("Hi, Admin"));
		//test.log(Status.INFO,"Checking sign is successfully done or not");
		
	}
	@Test(priority=2,enabled=true)
	public static void AddCategory() throws InterruptedException
	{
		driver.findElement(By.xpath(".//button[@class='btn btn-nav active']")).click();
		//test.log(Status.INFO,"Clicking on AddCategory");
		driver.findElement(By.id("catgName")).sendKeys("Electronics");
		//test.log(Status.INFO,"Entering category name");
		driver.findElement(By.id("catgDesc")).sendKeys("Vikas");
		//test.log(Status.INFO,"Entering category description");
		driver.findElement(By.xpath(".//*[@type='submit']")).click();
		//test.log(Status.INFO,"clicking on submit button");
		String s=driver.findElement(By.xpath("/html/body/main/div/div/div/form/b/i")).getText();
		System.out.println(s);
		Assert.assertTrue(s.contains("Product Category : Electronics is added Succesfully !!!"));
		//test.log(Status.INFO,"Checking whether category is added or not");
		driver.navigate().back();
		driver.navigate().back();
	}
	@Test(priority=3,enabled=true)
	public static void AddSubCategory()
	{
		driver.findElement(By.xpath(".//button[contains(@onclick,'AddProductSubCategory')]")).click();
		//test.log(Status.INFO,"Clicking on AddSubCategory");
		driver.findElement(By.xpath("//*[@id=\"subCatgId\"]/option[1]"));
		//test.log(Status.INFO,"Selecting category name");
		driver.findElement(By.name("subCatgName")).sendKeys("VikasPandey");
		//test.log(Status.INFO,"Entering Sub Category name");
		driver.findElement(By.name("subCatgDesc")).sendKeys("Employee id is 11825521");
		//test.log(Status.INFO,"Entering sub category description");
		driver.findElement(By.xpath(".//*[@type='submit']")).click();
		//test.log(Status.INFO,"Clicking on submit button");
		String s=driver.findElement(By.xpath("/html/body/main/div/div/div/form/b/i")).getText();
		System.out.println(s);
		Assert.assertTrue(s.contains("Product Sub Category : VikasPandey is added Succesfully !!!"));
		//test.log(Status.INFO,"Checking whether subcategory is added or not");
		driver.navigate().back();
		driver.navigate().back();
	}
	@Test(priority=4)
	public static void AddProduct() throws Exception
	{
		driver.findElement(By.xpath(".//button[contains(@onclick,'routeaddprod')]")).click();
		//test.log(Status.INFO,"Clicking on Add Product");
		driver.findElement(By.xpath("//*[@id=\"categorydropid\"]/option[2]")).click();
		//test.log(Status.INFO,"Selecting Category name");
		driver.findElement(By.xpath("//*[@id=\"subcategorydropid\"]/option[4]")).click();
		//test.log(Status.INFO,"Selecting subcategory name");
		driver.findElement(By.id("prodid")).sendKeys("VikasPandey1861");
		//test.log(Status.INFO,"Entering product name");
		driver.findElement(By.name("pricename")).sendKeys("375000");
		//test.log(Status.INFO,"Entering price");
		driver.findElement(By.name("Quantity")).sendKeys("1");
		//test.log(Status.INFO,"Entering quantity");
		driver.findElement(By.name("Brand")).sendKeys("Accenture");
		//test.log(Status.INFO,"Entering brand");
		driver.findElement(By.name("description")).sendKeys("Application Development Associate");
		//test.log(Status.INFO,"Entering Description");
		
		 driver.findElement(By.xpath(".//div[contains(@class,'image-preview-input')]")).click();
	//		test.log(Status.INFO,"Clicking on browse button");
		   Thread.sleep(10000);
		   //Set the Path to the Clipboard Memory
		   StringSelection stringSelection = new StringSelection("C:\\Users\\training_d2.03.07\\Pictures\\Screenshots\\a.png");
		//	test.log(Status.INFO,"Entering the path of the image");
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		   //robot class to upload file
		   Robot robot = new Robot();
		   robot.keyPress(KeyEvent.VK_CONTROL);
			//test.log(Status.INFO,"pressing ctrl button");
		   robot.keyPress(KeyEvent.VK_V);
			//test.log(Status.INFO,"pressing v button");
		   robot.keyRelease(KeyEvent.VK_V);
			//test.log(Status.INFO,"Releasing the v button");
		   robot.keyRelease(KeyEvent.VK_CONTROL);
			//test.log(Status.INFO,"Releasing the ctrl button");
		   Thread.sleep(2000);
		   robot.keyPress(KeyEvent.VK_ENTER);
			//test.log(Status.INFO,"Pressing enter button");
		   robot.keyRelease(KeyEvent.VK_ENTER);
			//test.log(Status.INFO,"Releasing the enter button");
		   Thread.sleep(3000);
		   driver.findElement(By.name("Add Product")).click();
		   //test.log(Status.INFO,"Clicking on add product button");
		   Thread.sleep(3000);
		
		
		String s=driver.findElement(By.xpath("/html/body/main/div/div/div/form/b/i")).getText();
		System.out.println(s);		
		Assert.assertTrue(s.contains("Product : VikasPandey1861 is added Succesfully !!!"));
	//	test.log(Status.INFO,"checking product is added or not");
		  
		
		
	}

	

}
