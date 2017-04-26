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
import static org.testng.Assert.assertTrue;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class CitySearch {
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
    public void citySearch() {
        assertEquals("Work.ua — cайт поиска работы №1 в Украине", DriverUtils.get().getTitle());
        Assert.assertTrue(driver.findElement(By.className("i-by-region")).isDisplayed());
        driver.findElement(By.className("i-by-region")).click();
        WebDriverWait waitForCitiesList = (new WebDriverWait(driver, 10));
        waitForCitiesList.until(ExpectedConditions.visibilityOfElementLocated(By.className("emblems-search-by-cities")));

        Assert.assertTrue(driver.findElement(By.className("image-emblems-lviv")).isDisplayed());
        driver.findElement(By.className("image-emblems-lviv")).click();
        WebDriverWait waitForLviv = (new WebDriverWait(driver, 10));
        waitForLviv.until(ExpectedConditions.visibilityOfElementLocated(By.id("cityPage")));

        String messageLviv = driver.findElement(By.id("cityPage")).getText();
        Assert.assertEquals("Работа во Львове", messageLviv);

        String lvivInput = driver.findElement(By.className("js-main-region")).getAttribute("value");
        Assert.assertEquals("Львов", lvivInput);
    }
}
