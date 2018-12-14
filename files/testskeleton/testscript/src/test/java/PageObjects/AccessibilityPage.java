package PageObjects;

import java.util.List;

import io.appium.java_client.MobileElement;

public interface AccessibilityPage {
	public List getScreenElements();
	public MobileElement getNodeProvider();
	public MobileElement getNodeQuerying();
	public MobileElement getService();
	public MobileElement getView();
	public void click(MobileElement element);
	public boolean isAccessibilityScreen(List<MobileElement> elements);

}
