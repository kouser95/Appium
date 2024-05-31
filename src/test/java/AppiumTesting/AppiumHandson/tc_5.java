package AppiumTesting.AppiumHandson;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;


public class tc_5 extends Base {

	@Test
	public void SwipeDemoTest() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextFields\"));"))
				.click();
		driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Nida");
		Thread.sleep(3000);
	}
}
