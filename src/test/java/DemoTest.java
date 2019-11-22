import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DemoTest {

	private AndroidDriver driver;

	@AndroidFindBy(id ="com.alo7.android.student:id/go_login" )
	AndroidElement login;

	@Before
	public void setUp() throws MalformedURLException {
		System.setProperty("WebDriver.http.factory", "apache");
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//		desiredCapabilities.setCapability("platformName","android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"mumu");
		desiredCapabilities.setCapability("platformVersion","6.0.1");
		desiredCapabilities.setCapability("appPackage","com.alo7.android.student");
		desiredCapabilities.setCapability("appActivity",".activity.MainActivity");
		desiredCapabilities.setCapability("noReset",false);
		desiredCapabilities.setCapability("autoGrantPermissions",true);
//		desiredCapabilities.setCapability("deviceName","127.0.0.1:7555");

		URL remoteUrl =new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(remoteUrl,desiredCapabilities);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}



	@Test
	public void testLogin(){
		PageFactory.initElements(new AppiumFieldDecorator(this.driver),this) ;

		login.click();


	}


}
