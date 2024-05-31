package AppiumTesting.AppiumHandson;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;


public class tc_4 extends Base {

	@Test
	public void WifiSettingsName() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']")).click();

	}
}
