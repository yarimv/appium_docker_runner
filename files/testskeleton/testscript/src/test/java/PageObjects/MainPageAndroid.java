package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainPageAndroid implements MainPage {
	
	@FindBy(xpath="//android.widget.TextView[@text='Accessibility']") 
	private MobileElement accessibility;
	
	@FindBy(xpath="//android.widget.TextView[@text='Animation']") 
	private MobileElement animation;
	
	@FindBy(xpath="//android.widget.TextView[@text='App']") 
	private MobileElement app;
	
	@FindBy(xpath="//android.widget.TextView[@text='Content']") 
	private MobileElement content;
	
	@FindBy(xpath="//android.widget.TextView[@text='Graphics']") 
	private MobileElement graphics;
	
	@FindBy(xpath="//android.widget.TextView[@text='Media']") 
	private MobileElement media;
	
	@FindBy(xpath="//android.widget.TextView[@text='NFC']") 
	private MobileElement nfc;
	
	@FindBy(xpath="//android.widget.TextView[@text='OS']") 
	private MobileElement os;
	
	@FindBy(xpath="//android.widget.TextView[@text='Preference']") 
	private MobileElement preference;
	
	@FindBy(xpath="//android.widget.TextView[@text='Text']") 
	private MobileElement text;
	
	@FindBy(xpath="//android.widget.TextView[@text='Views']") 
	private MobileElement views;
	
	@FindBy(id = "android:id/list")
	private MobileElement textViews;
	
	
	public MainPageAndroid(AppiumDriver driver) {//
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//        By xpath = By.xpath("//android.widget.TextView[@text='Accessibility']");
//        accessibility = (MobileElement) driver.findElement(xpath);
//
//        xpath = By.xpath("//android.widget.TextView[@text='Animation']");
//        animation = (MobileElement) driver.findElement(xpath);
//
//        xpath = By.xpath("//android.widget.TextView[@text='App']");
//        app = (MobileElement) driver.findElement(xpath);
//
//        xpath = By.xpath("//android.widget.TextView[@text='Content']");
//        content = (MobileElement) driver.findElement(xpath);
//
//        xpath = By.xpath("//android.widget.TextView[@text='Graphics']");
//        graphics = (MobileElement) driver.findElement(xpath);
//
//        xpath = By.xpath("//android.widget.TextView[@text='Media']");
//        media = (MobileElement) driver.findElement(xpath);
//
//        xpath = By.xpath("//android.widget.TextView[@text='NFC']");
//        nfc = (MobileElement) driver.findElement(xpath);
//        
//        xpath = By.xpath("//android.widget.TextView[@text='OS']");
//        os = (MobileElement) driver.findElement(xpath);
//
//        xpath = By.xpath("//android.widget.TextView[@text='Preference']");
//        preference = (MobileElement) driver.findElement(xpath);
//
//        xpath = By.xpath("//android.widget.TextView[@text='Text']");
//        text = (MobileElement) driver.findElement(xpath);
//
//        xpath = By.xpath("//android.widget.TextView[@text='Views']");
//        views = (MobileElement) driver.findElement(xpath);        

    }

	public List getScreenElements() {
		// TODO Auto-generated method stub
		List<MobileElement> elements = new ArrayList();
    	elements.add(accessibility);
    	elements.add(animation);
    	elements.add(app);
    	elements.add(content);
    	elements.add(graphics);
    	elements.add(media);
    	elements.add(nfc);
    	elements.add(os);
    	elements.add(preference);
    	elements.add(text);
    	elements.add(views); 

		return elements;
	}
	
	public MobileElement getAccessibility() {
		return accessibility;
	}
	
	public MobileElement getAnimation() {
		return animation;
	}
	
	public MobileElement getApp() {
		return app;
	}
	
	public MobileElement getContent() {
		return content;
	}
	
	public MobileElement getGraphics() {
		return graphics;
	}
	
	public MobileElement getMedia() {
		return media;
	}
	
	public MobileElement getNfc() {
		return nfc;
	}
	
	public MobileElement getOs() {
		return os;
	}
	
	public MobileElement getPreference() {
		return preference;
	}
	
	public MobileElement getText() {
		return text;
	}
	
	public MobileElement getViews() {
		return views;
	}

	public void click(MobileElement element) {
		// TODO Auto-generated method stub
		element.click();
	}
	
	public boolean isMainScreen(List<MobileElement> elements){
		
		List<MobileElement> thisElements = getScreenElements();

		if(elements.size() != thisElements.size())
			return false;
		
		List<String> texts = Arrays.asList("Accessibility", "Animation", "App", "Custom View", "Content", "Graphics", "Media", "NFC", "OS", "Preference", "Text" ,"Views");
		
		for(int i = 0; i < elements.size() ; ++ i) {
			MobileElement el = elements.get(i);
			String text = el.getText();// rect, location....
			if(!texts.contains(text)) return false;
		}
		
		return true;
		
	}

}
