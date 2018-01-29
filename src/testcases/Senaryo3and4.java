package testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Senaryo3and4 {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "https://www.enuygun.com/otel/ ";
        String expectedTitle = "enuygun";
        String actualTitle = "";
        driver.get(baseUrl);

        //SENARYO 3
        WebElement ulPopular = driver.findElement(By.className("item-list-inline"));
        List<WebElement> liAll = ulPopular.findElements(By.tagName("li"));
        System.out.println(liAll.size());
       
        Collections.shuffle(liAll);
        liAll.get(0).findElement(By.tagName("a")).click();

        
        
        //SENARYO 4
        
        Thread.sleep(1500);
        WebElement olOtel = driver.findElement(By.className("otel-list"));
        List<WebElement> liOtelAll = olOtel.findElements(By.className("otel"));
        System.out.println(liOtelAll.size());

        Collections.shuffle(liOtelAll);
        liOtelAll.get(0).findElement(By.tagName("a")).click();
        
        

    }
}
