package AppiumSupport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumController {

    public static OS executionOS = OS.IOS;

    public enum OS {
        ANDROID,
        IOS
    }
    public static AppiumController instance = new AppiumController();
    public static AndroidDriver driver;

    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        switch(executionOS){
        	
            case ANDROID:
            	    File appDir = new File("apps" + File.separator + "Android"); // 테스트하고자 하는 애플리케이션 full path
                File app = new File(appDir, "ApiDemo.apk"); // 애플리케이션 이름 
                
                DesiredCapabilities capabilities = new DesiredCapabilities(); //애피움 서버와의 세션 생성을 위한 설정 값 
                //capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "");//System.getProperty("platformVersion")
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
                //capabilities.setCapability("automationName", "Selendroid"); //app이 기반 테스트 프레임워크가 셀렌드로이드 기반일때만 설정(API Level 9이상 17이하일때)
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//System.getProperty("platformName")
                //capabilities.setCapability("udid","adb devices를 통해 얻은 device ID"); //여러 디바이스가 설치된 경우, 테스트하고자 하는 디바이스를 선택 

                capabilities.setCapability("app", app.getAbsolutePath());
                driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case IOS:
//                File classpathRoot = new File(System.getProperty("user.dir"));
//                File appDir = new File("/", "/Users/hwangheeseon/Library/Developer/Xcode/DerivedData/FoodTracker-eesrwojtljoixdbhqrhzrprvqmbo/Build/Products/Debug-iphonesimulator");
//                File app = new File(appDir, "FoodTracker.app");
//                DesiredCapabilities capabilities = new DesiredCapabilities();
//                capabilities = new DesiredCapabilities();
//                capabilities.setCapability("automationName", "XCUITest");
//                capabilities.setCapability("platformName", "ios");
//                capabilities.setCapability("deviceName", "iPhone 6");
//                capabilities.setCapability("app", app.getAbsolutePath());
//                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
}
