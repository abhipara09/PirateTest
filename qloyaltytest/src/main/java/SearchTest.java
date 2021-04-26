import datamodels.WaitHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType.*;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

//This is for the Pirate ship test automation

public class SearchTest {
	WaitHelper wh;
	public WebDriver driver;

	@BeforeTest
	public void test_launchurl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_csharp_search/862b0faa506b8487c25a3384cfde8af4/static/attachments/reference_page.html");
	}


	@Test
	public void test_existence() throws InterruptedException {
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
			Thread.sleep(15000);
			if (driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/input[1]")).size() !=0) {
				System.out.println("input text field exists on the main screen");
			} else
				System.out.println("input text field doesnt exists on the main screen");

			if (driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/button[1]")).size() != 0) {
				System.out.println("search button exists on the main screen");
			} else {
				System.out.println("search button doesnt exists on the main screen");
			}

		}
		@Test
	public void test_empty () throws InterruptedException {
		    Thread.sleep(5000);
			WebElement Searchbt1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/button[1]"));
			Searchbt1.click();
			WebElement errmsg = driver.findElement(By.id("error-empty-query"));
		String message = errmsg.getText();
			if (message.equalsIgnoreCase("Provide some query"))
				System.out.println("'Provide some Query' error message is displaying when we do empty search");
					else
					{
						System.out.println("value present in input field");
					}

				}
	@Test
	public void test_searchisland()
	{
		WebElement Searchtxt = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/input[1]"));
		Searchtxt.sendKeys("isla");
		WebElement Searchbt1= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/button[1]"));
		Searchbt1.click();
		List<WebElement> allText = driver.findElements(By.xpath("/body[1]/div[1]/div[2]/ul[1]/li[contains(text(),'Isla')]"));
		Iterator<WebElement> itr = allText.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().getText());

		}
		System.out.println("displaying search results");
		Searchtxt.clear();
		driver.close();
	}
	@Test
	public void test_noresult(){
		WebElement Searchtxt = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/input[1]"));
		Searchtxt.sendKeys("Castle");
		WebElement Searchbt1= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/button[1]"));
		Searchbt1.click();
		WebElement Searchnoreslt = driver.findElement(By.xpath("//ul[@id='search-results']"));
		String Noresults = Searchnoreslt.getText();
		if(Noresults.equalsIgnoreCase("No results")){
			System.out.println("No results found for the search string Castle");
		}
		Searchtxt.clear();
	}
	@Test
	public void test_matchresult() throws InterruptedException {
		WebElement Searchtxt = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/input[1]"));
		Searchtxt.sendKeys("port");
		WebElement Searchbt1= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/button[1]"));
		Searchbt1.click();
		Thread.sleep(5000);
		WebElement portroyl = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/ul[1]/li"));
		//wh.waitForElementVisible(portroyl,10);
		if(portroyl.isDisplayed()){
			System.out.println("When searched by port, result is displayed as Port Royal");
		}
		Searchtxt.clear();
	}

}



