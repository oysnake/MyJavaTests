package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.vlad.MyTest.utils.DriverUtils;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class extendSearch {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverUtils.get().getDriver();
        DriverUtils.get().getURL("https://work.ua/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void extendSearch(){
        assertEquals("Work.ua — cайт поиска работы №1 в Украине", DriverUtils.get().getTitle());
        Assert.assertTrue(driver.findElement(By.className("hovered")).isDisplayed());
        driver.findElement(By.className("hovered")).click();

        WebDriverWait waitForAdvSearch = (new WebDriverWait(driver, 10));
        waitForAdvSearch.until(ExpectedConditions.visibilityOfElementLocated(By.className("advansed-search-box")));

        driver.findElement(By.id("adv-search")).click();

        Boolean search = (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.className("advansed-search-box")));
        Assert.assertTrue(search);

    }
}
