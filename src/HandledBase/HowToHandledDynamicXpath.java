package HandledBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.utility.RandomString;

import org.openqa.selenium.JavascriptExecutor;

public class HowToHandledDynamicXpath {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement carname = driver.findElement(By.name("q"));
		carname.sendKeys("lambo");

		List<WebElement> suggetions = driver
				.findElements(By.xpath("(//ul[@jsname='bw4e9b'])[1]/li/descendant::div[@class='eIPGRd']"));

		for (WebElement ListOfSuggetions : suggetions) {

			System.out.println(ListOfSuggetions.getText());

			String suggetionforclick = "lamborghini aventador";
			if (ListOfSuggetions.getText().equals(suggetionforclick)) {
				ListOfSuggetions.click();
				break;

			}
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement ClickOnWikipedia = driver.findElement(By.xpath("(//cite[@role='text'])[15]"));
		ClickOnWikipedia.click();

		String actualTitle = driver.getTitle();
		String aspectedTitle = "Lamborghini Aventador - Wikipedia";

		System.out.println("Visibility Of Page Title===> " + driver.getTitle());

		if (actualTitle.equals(aspectedTitle)) {
			System.out.println("[TestCase Pass]");
		} else {
			System.out.println("[TestCase Fail]");
		}

		driver.quit();

	}

}
