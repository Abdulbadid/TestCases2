/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcases;

import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author sakar
 */
public class Senaryo5 {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "https://www.enuygun.com/ucak-bileti/sikca-sorulan-sorular/ ";
        String expectedTitle = "enuygun";
        String actualTitle = "";
        driver.get(baseUrl);

        //hotel-form-tab
        driver.findElement(By.xpath("//a[@href ='https://www.enuygun.com/otel/']")).click();
        Thread.sleep(1500);

        driver.findElement(By.id("otel-region")).clear();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("otel-region")));
        driver.findElement(By.id("otel-region")).sendKeys("Ankara, Türkiye");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.ENTER).perform();

        //data pickerden tarih seçimini yapamadım
        driver.findElement(By.xpath("//input[@id='checkin-checkout-date']")).click();
        Thread.sleep(500);
        driver.findElements(By.id("room-guest")).get(0).click();
        Thread.sleep(500);

        driver.findElements(By.cssSelector("i.fa.fa-plus-circle")).get(0).click();
        driver.findElements(By.xpath("//div[@id='guest-room-selector']/div[2]/button")).get(0).click();

        driver.findElements(By.xpath("(//button[@type='button'])[3]")).get(0).click();
        Thread.sleep(1500);

        // DROPDOWN ÇALIŞTIRAMADIM
        //WebElement selectElem = driver.findElement(By.xpath("//div[@id='result-sort-box']"));
        //Select dropdown = new Select(selectElem);
        //dropdown.selectByVisibleText("Fiyata göre artan");
        Thread.sleep(1500);
        //GÖSTER BUTON

        WebElement ulOtel = driver.findElement(By.className("otel-list"));
        List<WebElement> liAll = ulOtel.findElements(By.tagName("li"));
        System.out.println(liAll.size());

        liAll.get(0).findElement(By.tagName("a")).click();

    }

}
