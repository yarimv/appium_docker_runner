package Test;

import AppiumSupport.AppiumBaseClass;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import AppiumSupport.AppiumController;
import PageObjects.AccessibilityPage;
import PageObjects.AccessibilityPageAndroid;
import PageObjects.MainPage;
import PageObjects.MainPageAndroid;


public class BaseTestClass extends AppiumBaseClass{
//    protected static FoodTrackerMainPage mainPage;
//    protected static FoodTrackerRegisterFoodPage registerMenuPage;
//    protected static PhotoPage photoPage;
	protected static MainPage mainPage;
	protected static AccessibilityPage accessibilityPage;
	
    
    public static final int NEEDS_NETWORK_DELAY = 1;
    public static final int NEEDS_SWITCH_SCREEN_DELAY = 2000;
    public static final int NEEDS_CAPTURE_SCREEN_DELAY = 2000;

    @BeforeClass
    public static void setUp() throws Exception {
    	AppiumController.executionOS = AppiumController.OS.ANDROID;
        AppiumController.instance.start();
        
        switch (AppiumController.executionOS) {
            case ANDROID:
            	mainPage = new MainPageAndroid(driver());
            	accessibilityPage = new AccessibilityPageAndroid(driver());
                break;
            case IOS:
//                mainPage = new FoodTrackerMainPageIOS(driver());
//                registerMenuPage = new FoodTrackerRegisterFoodPageIOS(driver());
//                photoPage = new PhotoPageIOS(driver());
                break;
        }
    }

    @AfterClass
    public static void tearDown() {
        AppiumController.instance.stop();
    }
    
    public void waitfor(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
