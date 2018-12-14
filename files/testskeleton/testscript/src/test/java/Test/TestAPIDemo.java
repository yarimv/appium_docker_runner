package Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.logging.LogEntry;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;
import java.util.logging.Level;

public class TestAPIDemo extends BaseTestClass {

	 @Test
	 public void test_01() {

		 //Main page 의 화면 구성요소들을 얻는다. 
	     List<MobileElement> list = mainPage.getScreenElements();
	     
	     //얻어온 화면 구성요소가 Main page의 구성요소가 맞는지 확인한다. 
	     Assert.assertTrue(mainPage.isMainScreen(list));
	     
	 }
	 
	 @Test
	 public void test_02() {

		 //Accessibility 구성요소를 얻는다. 
		 MobileElement accessibility = mainPage.getAccessibility();
		 
		 //Null 이 아닌지 확인한다.
		 Assert.assertNotNull(accessibility);
		 
		 //Accessibility 구성요소를 클릭한다.
		 mainPage.click(accessibility);
		 
		 // 화면 전환하는 속도를 고려해 딜레이를 준다. 
		 waitfor(NEEDS_SWITCH_SCREEN_DELAY);
		 
		 //Accessibility 화면 구성요소를 얻는다.
		 List<MobileElement> list = accessibilityPage.getScreenElements();
		 
		 //얻어온 화면 구성요소가 Accessibility page의 구성요소가 맞는지 확인한다. 
	     Assert.assertTrue(accessibilityPage.isAccessibilityScreen(list));
	     
	 }
	 
	 @Test
	 public void test_03() { //scroll

		 //이전 페이지로 돌아간다.(Main)
		 driver().navigate().back();
		 
		 //Main Page에서 Graphics에 대한 레퍼런스를 얻어온다.  
		 MobileElement graphics = mainPage.getGraphics();
		 
		 //Null 이 아닌지 확인한다.
		 Assert.assertNotNull(graphics);
		 
		 //Graphics 구성요소를 클릭한다.
		 mainPage.click(graphics);
		 
		 // 화면 전환하는 속도를 고려해 딜레이를 준다. 
		 waitfor(NEEDS_SWITCH_SCREEN_DELAY);
	     
	     //scroll up
	     for(int i = 0; i < 5 ; ++ i){
	    	 //화면 사이즈를 얻어온다. 
	         Dimension size = this.driver().manage().window().getSize();
	         	
	         //가로 화면 중앙 좌표 
	         int startX = size.width/2; // 예 100 인 경우 50
	        	
	         //세로 화면 상단 80% 지점 좌표 
	         int startY = (int) (size.height *0.80); // 예 100인 경우 80 
	        	
	         //세로 화면 상단 20% 지점 좌표 
	         int endY = (int) (size.height *0.20); // 예 100인 경우 20 
	        	
	         //스크롤 
	         //this.driver().swipe(startX,startY,startX,endY,2000); //(50,80) 지점에서 (50, 20)지점으로 스크롤 
	         new TouchAction(driver()).press(startX, startY).waitAction()
	 		.moveTo(startX, endY).release().perform();	
	         //화면 전환하는 속도를 고려해 딜레이를 준다
	         waitfor(NEEDS_SWITCH_SCREEN_DELAY);
	     }
	     
	     // scroll down
	     for(int i = 0; i < 5 ; ++ i){
	    	//화면 사이즈를 얻어온다.
	    	Dimension size = this.driver().manage().window().getSize();
	    	
	    	//가로 화면 중앙 좌표 
	        int startX = size.width/2;// 예 100 인 경우 50
	        
	        //세로 화면 하단 25% 지점 좌표 
	        int startY = (int) (size.height *0.25); // 예 100 인 경우 25
	        
	        //세로 화면 상단 90% 지점 좌표 
	        int endY = (int) (size.height *0.90);// 예 100 인 경우 90
	        
	        //스크롤 
	        //this.driver().swipe(startX,startY,startX,endY,1000); //(50,25) 지점에서 (50, 90)지점으로 스크롤
	        new TouchAction(driver()).press(startX, startY).waitAction()
	 		.moveTo(startX, endY).release().perform();
	        
	        waitfor(NEEDS_SWITCH_SCREEN_DELAY);
	     }
	     
	     //왼쪽에서 오른쪽으로, 오른쪽에서 왼쪽으로도 스크롤 가능 
	     
	
	 }
	 
	 @Test
	 public void test_04() { // resource 사용량 얻기 
		 // driver 얻어오기 
		 AndroidDriver driver = (AndroidDriver) driver();
		 
		 List performanceDataTypes = driver.getSupportedPerformanceDataTypes();//사용 가능한 resource 종류 얻기	 
		 for(int i = 0 ; i < performanceDataTypes.size() ; ++i ){

		 	//사용 가능한 resource list중 하나 얻어오기 
			String performanceDataType = (String)performanceDataTypes.get(i);
		    System.out.println("performanceDataType = " + performanceDataType);	        		
	        List<List<Object>> res = null;
			
			try {
				// 사용 가능한 resource의 데이타 얻어오기 
				res = driver.getPerformanceData("demo.fun.com.apis", (String)performanceDataTypes.get(i), 5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			if(res != null) {
				// resource 종류 얻기
		        List resourceNames = res.get(0);
		        // 타이틀을 갖는 resource의 값 얻기
		        List resourceValues = res.get(1);
		        for(int j= 0 ; j < resourceNames.size() ; ++ j){
		        	String resourceName = (String)resourceNames.get(j);
			        String resourceValue = (String)resourceValues.get(j);
			        
			        System.out.println("resourceName = " + resourceName + ", resourceValue = " + resourceValue);
		            		
		        }
			}
	            	
	     }
		 
	 }
	 
	 @Test
	 public void test_05() { //device log
	     AndroidDriver driver = (AndroidDriver) driver();
		 List logEntries = null;
		 try{

		 	//logcat entry 얻기 
			logEntries = driver.manage().logs().get("logcat").filter(Level.ALL);
		    StringBuilder sb = new StringBuilder();
		 	for( int i = 0 ; i < logEntries.size() ; ++i ){
		 		//logcat entry의 값 얻기
		 		LogEntry temp = (LogEntry)logEntries.get(i);
		        sb.append(temp + "\n");
		    }
		 	System.out.println("sb = " + sb.toString());
				
		}catch(Exception e){
			e.printStackTrace();
		}
		 
	 }
	 
	 @Test
	 public void test_06() { //스크린 캡쳐 
	     try {
	       AndroidDriver driver = (AndroidDriver) driver();
	       
	       //driver에서 디바이스의 스크린 캡쳐 파일에 대한 파일 객체 얻어오기  
	       File scrFile = driver.getScreenshotAs(OutputType.FILE); 
 		
	       //스크린 캡쳐 파일 저장할 디렉토리 생성하기 
 		   File resultDirectory = new File("result");
 		   if(!resultDirectory.exists()){
 		       resultDirectory.mkdirs();
 		   }
 	
 		   //스크린 캡쳐 파일 이름 
 		   String destFile = "screenshot.png";
 	
 		   //스크린 캡쳐 파일 로컬에 저장할 패스 정의하기 
 		   String destImagePath = resultDirectory + File.separator + destFile;

 		   //디바이스 스크린 캡쳐 파일 로컬에 저장하기 
 		   File imageFile = new File(destImagePath);
 		   FileUtils.copyFile(scrFile, imageFile); 
 		   
 		   //스크린 캡쳐 후 딜레이 주기 
 		   waitfor(NEEDS_CAPTURE_SCREEN_DELAY);
				
		}catch(Exception e){
			e.printStackTrace();
		}
		 
	 }
}
