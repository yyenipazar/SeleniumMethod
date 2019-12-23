package SeleniumMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree");
		
		driver.findElement(By.id("justAnInputBox")).click();
		selectMultipleDropDown(driver,"choice 2","choice 4","choice 6");
	}
	public static void selectMultipleDropDown(WebDriver driver,String... value){
		List<WebElement> dropList=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		System.out.println(dropList.size());
		
		if(!value[0].equalsIgnoreCase("ALL")){
			
		
		for(int i=0;i<dropList.size();i++){
			String text=dropList.get(i).getText();
			System.out.println(text);
			
		//Array	
		for(int j=0;j<value.length;j++){
			try {
				if(!text.isEmpty()){
					if(text.equals(value[j])){
						dropList.get(i).click();
						break;
					}
				
				} 
			}
			catch (Exception e) {
				
				}
			
			}
		}
	}else{try {
		for(int full=0;full<dropList.size();full++){
			dropList.get(full).click();
			
		}
	} catch (Exception e) {
		// TODO: handle exception
			}
		}
	}
}	

		



