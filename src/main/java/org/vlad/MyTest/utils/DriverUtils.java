package org.vlad.MyTest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils {
    private WebDriver driver;
    private static DriverUtils instance = null;

    private DriverUtils(WebDriver driver){
        this.driver = driver;
        this.driver.manage().window().maximize();

    }

    public static DriverUtils get(){
        if (instance == null){
            System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
            instance = new DriverUtils(new ChromeDriver());

        }
        return instance;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void getURL(String url){
        driver.get(url);
    }

    public void closePage(){
        driver.close();
        instance = null;
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
