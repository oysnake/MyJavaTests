package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.vlad.MyTest.utils.DriverUtils;

import static org.testng.Assert.assertEquals;


public class Login {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverUtils.get().getDriver();
        DriverUtils.get().getURL("https://work.ua/");
    }

    @AfterMethod
    public void tearDown(){
        DriverUtils.get().closePage();
    }

    @Test
    public void loginTest(){
        assertEquals("Work.ua — cайт поиска работы №1 в Украине", DriverUtils.get().getTitle());
        driver.findElement(By.cssSelector(".btn.btn-default")).click();
        WebDriverWait waitforForm = new WebDriverWait(driver, 20);
        waitforForm.until(ExpectedConditions.visibilityOfElementLocated(By.id("lForm")));

        driver.findElement(By.id("email")).sendKeys("oysnake@yandex.ru");
        driver.findElement(By.id("password")).sendKeys("Test123qwerty");

        Assert.assertTrue(driver.findElement(By.cssSelector(".btn.btn-default")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("remember")).isSelected());

        driver.findElement(By.cssSelector(".btn.btn-default")).click();

        String bodyText = driver.findElement(By.className("text-white")).getText();
        Assert.assertEquals("Добро пожаловать, Vlad!", bodyText);
    }
}
