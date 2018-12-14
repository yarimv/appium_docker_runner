package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccessibilityPageAndroid implements AccessibilityPage {
	
	@FindBy(xpath = "//android.widget.TextView[@text='Accessibility Node Provider']")
	private MobileElement nodeProvider;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Accessibility Node Querying']")
	private MobileElement nodeQuerying;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Accessibility Service']")
	private MobileElement service;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Custom View']")
	private MobileElement view;	
	
	
	public AccessibilityPageAndroid(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	
	public List getScreenElements() {
		// TODO Auto-generated method stub
		List<MobileElement> elements = new ArrayList();
    	elements.add(nodeProvider);
    	elements.add(nodeQuerying);
    	elements.add(service);
    	elements.add(view);
    		    	
		return elements;
	}
	
	public MobileElement getNodeProvider() {
		return nodeProvider;
	}

	public MobileElement getNodeQuerying() {
		return nodeQuerying;
	}
	
	public MobileElement getService() {
		return service;
	}
	
	public MobileElement getView() {
		return view;
	}

	public void click(MobileElement element) {
		// TODO Auto-generated method stub
		element.click();
	}
	
	public boolean isAccessibilityScreen(List<MobileElement> elements){
		
		List<MobileElement> thisElements = getScreenElements();
		
		if(elements.size() != thisElements.size())
			return false;
		
		List<String> texts = Arrays.asList("Accessibility Node Provider", "Accessibility Node Querying", "Accessibility Service", "Custom View");
		
		for(int i = 0; i < elements.size() ; ++ i) {
			MobileElement el = elements.get(i);
			String text = el.getText();
			if(!texts.contains(text)) return false;
		}		
		return true;
		
	}

}
