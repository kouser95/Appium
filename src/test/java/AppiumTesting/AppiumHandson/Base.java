package AppiumTesting.AppiumHandson;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C://Users//nkouser//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("NK Phone");
		//Pixel 6 Pro API 33
		options.setApp("C://Users//nkouser//eclipse-workspace//AppiumTraining//src//test//java//resources//General-Store.apk");
		//options.setApp("C://Users//nkouser//eclipse-workspace//AppiumTraining//src//test//java//resources//ApiDemos-debug.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void longPressAction(WebElement ele)

	{
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void scrollToEndAction(){
		
		boolean canScrollMore;
		do
		{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
	}while(canScrollMore);
	}
	
	public Double getFormattedAmount(String amount )
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}


