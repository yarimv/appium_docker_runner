package AppiumSupport;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public abstract class AppiumBaseClass {

    public static AppiumDriver driver() {
        return AppiumController.instance.driver;
    }
    
   
}
