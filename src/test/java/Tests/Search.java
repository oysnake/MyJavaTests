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

public class Search {
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
    public void searchTest() {
        assertEquals("Work.ua — cайт поиска работы №1 в Украине", driver.getTitle());

        driver.findElement(By.id("search")).sendKeys("QA Automation");
        driver.findElement(By.className("js-main-region")).clear();
        driver.findElement(By.className("js-main-region")).sendKeys("Львов");
        driver.findElement(By.className("btn-search")).click();

        WebDriverWait waitforresults = new WebDriverWait(driver, 10);
        waitforresults.until(ExpectedConditions.presenceOfElementLocated(By.className("col-left")));

        driver.findElement(By.id("dropdownMenu1")).click();
        WebDriverWait waitforDropdown = new WebDriverWait(driver, 10);
        waitforDropdown.until(ExpectedConditions.visibilityOfElementLocated(By.className("dropdown-menu")));
        driver.findElement(By.cssSelector(".dropdown-menu > li:nth-child(3)")).click();
    }
}
