package org.vlad.MyTest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils {
    // (1) 
    // driver - WebDriver instanse (belongs to DriverUtils class)
    private WebDriver driver;

    // instance - an instance of DriverUtils (saves it if it was initialized)
    private static DriverUtils instance = null;

    // CONSTRUCTOR (methot that creates DriverUtills object)
    private DriverUtils(WebDriver driver){
    //                    ^ WebDriver object than becomes from get() method

    //  here we save createn WebDriver in get() method to DriverUtils object
        this.driver = driver;
    //      ^ (1)        ^(2)
    //      |            | it came from get() method
    //      |
    //      | it save WebDriver instanse to DriverUtils class

    // maximize window
        this.driver.manage().window().maximize();

    }

    // static factory pattern
    // initialize DriverUtils
    public static DriverUtils get(){
    // if DriverUtils instance is null (it means that it wasn't create before)
    // so we create new instance of DriverUtils and send new instanse of WebDriver to DriverUtils constructor
        if (instance == null){
            System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
            WebDriver chrome = new ChromeDriver();
            instance = new DriverUtils(chrome);
    //                                  ^ (2) goes to constructor

        }
    // return DriverUtils instanse
        return instance;
    }

    // TODO remove it temporarry method
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
