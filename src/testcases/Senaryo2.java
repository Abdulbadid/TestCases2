package testcases;

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

public class Senaryo2 {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "https://www.enuygun.com/ucak-bileti/ ";
        String expectedTitle = "enuygun";
        String actualTitle = "";
        driver.get(baseUrl);
        //SENARYO 2
        
        String[] cities = new String[]{"İstanbul",
            "Adana",
            "İzmir",
            "Antalya",
            "Trabzon"
            };

        Random rand = new Random();

        String rando = cities[rand.nextInt(cities.length)];
        String rando2 = cities[rand.nextInt(cities.length)];
        if(rando == "İstanbul" || rando2 == "İstanbul")
        {
        Thread.sleep(1500);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("from-input")));
        driver.findElement(By.id("from-input")).sendKeys("İstanbul, Türkiye - Ata");
         Thread.sleep(500);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
        action.sendKeys(Keys.ENTER).perform();
        
         Thread.sleep(1500);
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("to-input")));
        driver.findElement(By.id("to-input")).sendKeys("İstanbul, Türkiye - Ata");
        Thread.sleep(500);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
        action.sendKeys(Keys.ENTER).perform();
        }
        if(rando == rando2 )
        {
        Thread.sleep(1500);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("from-input")));
        driver.findElement(By.id("from-input")).sendKeys(rando);

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
        action.sendKeys(Keys.ENTER).perform();
        
        Thread.sleep(1500);
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("to-input")));
        driver.findElement(By.id("to-input")).sendKeys(rando2);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
        action.sendKeys(Keys.ENTER).perform();
        }
        else{
        
        Thread.sleep(1500);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("from-input")));
        driver.findElement(By.id("from-input")).sendKeys(rando);

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
        action.sendKeys(Keys.ENTER).perform();

        Thread.sleep(1500);
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("to-input")));
        driver.findElement(By.id("to-input")).sendKeys(rando2);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
        action.sendKeys(Keys.ENTER).perform();
        }
        
        
        if (!driver.findElement(By.id("flight-direct")).isSelected()) {
            driver.findElement(By.id("flight-direct")).click();
           // driver.findElement(By.id("oneway-input")).click();
        }

        driver.findElements(By.id("select-passenger-btn")).get(0).click();
        Select selectBox = new Select(driver.findElement(By.id("flight-class-select")));
        selectBox.selectByValue("business");
        driver.findElements(By.className("passenger-selector-close")).get(0).click();
        driver.findElements(By.id("submit-icon")).get(0).click();
    }
}
