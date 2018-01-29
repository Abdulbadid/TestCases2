/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class senaryo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "https://www.enuygun.com/ucak-bileti/sikca-sorulan-sorular/ ";
        String expectedTitle = "enuygun";
        String actualTitle = "";
        driver.get(baseUrl);
        
        //SENARYO 1
        
        WebElement we = driver.findElement(By.xpath("//a[@href='#topic1']"));
    
	we.click();
	
	we = driver.findElement(By.xpath("//div[@id='topic1']"));
	
	Thread.sleep(1500);
	
	List<WebElement> linkList = we.findElements(By.xpath("//a[@class='nav-link']"));
	
	System.out.println("Link Length : "+linkList.size());
	
	for (WebElement webLink : linkList)
	{
		String adr = webLink.getAttribute("href");
		System.out.println(adr);
		if (adr.contains("ucak-bileti/sikca-sorulan-sorular") && !adr.contains("#") && webLink.isDisplayed())
		{
			System.out.println(adr);
			webLink.click();
			new Thread()
			{
				public void run() 
				{
					try { Thread.sleep(5000); }  catch (Exception e) { }
					driver.navigate().back();
				}
			}.start();
			
		}
		
	}
        
       
    }

}
