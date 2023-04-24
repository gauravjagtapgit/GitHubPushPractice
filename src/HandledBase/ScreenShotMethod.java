package HandledBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.utility.RandomString;

public class ScreenShotMethod {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		String url = "https://www.amazon.in/";
		driver.get(url);

		WebElement searchFilde = driver.findElement(By.id("twotabsearchtextbox"));
		searchFilde.sendKeys("portrait");

//	List<WebElement>list=driver.findElements(By.xpath("s-suggestion-container"));
//	for(WebElement listOfAllSuggetions:list) {
//	  String expectedsuggetion="portrait painting";
//	  if(listOfAllSuggetions.getText().equals(expectedsuggetion));
//	  listOfAllSuggetions.click();
//		
//	}

		By element = By.xpath(
				"//div[@class='left-pane-results-container']/div/descendant::div[@aria-label='portrait painting']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		ele.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ViewelementOfScrolling = driver.findElement(By.cssSelector(
				"img[alt=\"Pitaara Box Close Up Leopard Portrait Unframed Canvas Painting 24.6 X 24.6Inch\"]"));
		js.executeScript("arguments[0].scrollIntoView();", ViewelementOfScrolling);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement TillScrollingElementClick = driver.findElement(By.cssSelector(
				"img[alt=\"Pitaara Box Close Up Leopard Portrait Unframed Canvas Painting 24.6 X 24.6Inch\"]"));
		TillScrollingElementClick.click();

//		WebElement ClickByImageForScreenShot = driver.findElement(By.xpath(
//				"//span[@class=\"mirai-scene-image-block-tag-container\"]//img[@class=\"a-dynamic-image a-stretch-vertical\"]"));
//		ClickByImageForScreenShot.click();
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String random = RandomString.make(1);
		File dest=new File("E:\\TecksScreenshot fro wabpage using selenium"+random+"png");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
		
		
		
		
		
		
		
		
		
	}

}
