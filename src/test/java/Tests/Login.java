package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static junit.framework.TestCase.assertEquals;

public class Login {
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.work.ua");
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void loginTest(){
        assertEquals("Work.ua — cайт поиска работы №1 в Украине", driver.getTitle());
        driver.findElement(By.cssSelector(".btn.btn-default")).click();
        WebDriverWait waitforForm = new WebDriverWait(driver, 20);
        waitforForm.until(ExpectedConditions.visibilityOfElementLocated(By.id("lForm")));

        driver.findElement(By.id("email")).sendKeys("oysnake@yandex.ru");
        driver.findElement(By.id("password")).sendKeys("Test123qwerty");

        Assert.assertTrue(driver.findElement(By.cssSelector(".btn.btn-default")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("remember")).isSelected());

        driver.findElement(By.cssSelector(".btn.btn-default")).click();

        String bodyText = driver.findElement(By.className("text-white")).getText();
        Assert.assertTrue("Добро пожаловать, Vlad!'", bodyText.contains(bodyText));
    }
}
