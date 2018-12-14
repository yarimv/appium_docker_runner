package PageObjects;

import java.util.List;

import io.appium.java_client.MobileElement;

public interface MainPage {
	public List getScreenElements();
	public MobileElement getAccessibility();
	public MobileElement getAnimation();
	public MobileElement getApp();
	public MobileElement getContent();
	public MobileElement getGraphics();
	public MobileElement getMedia();
	public MobileElement getNfc();
	public MobileElement getOs();
	public MobileElement getPreference();
	public MobileElement getText();
	public MobileElement getViews();
	public void click(MobileElement element);
	public boolean isMainScreen(List<MobileElement> elements);
}
