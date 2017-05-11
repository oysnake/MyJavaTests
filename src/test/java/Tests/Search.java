package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import org.vlad.MyTest.po.MainPagePO;
import org.vlad.MyTest.po.SearchPagePO;
import org.vlad.MyTest.utils.DriverUtils;

public class Search {
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
    public void searchTest() {
        assertEquals("Work.ua — cайт поиска работы №1 в Украине", DriverUtils.get().getTitle());
        new SearchPagePO()
                .typeJobName("QA Automation")
                .typeCity("Львов")
                .clickSearchButton()
                .clickRecentDropdown()
                .clickDropdownItem(2)
                .printResults();

    }
}
