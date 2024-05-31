package AppiumTesting.AppiumHandson;

import java.net.MalformedURLException;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class tc_2 extends Base {

	@Test
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		scrollToEndAction();
		driver.findElement(AppiumBy.accessibilityId("TextClock")).click();
		Thread.sleep(3000);
	}
}
