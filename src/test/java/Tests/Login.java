package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.vlad.MyTest.po.LoginPagePO;
import org.vlad.MyTest.po.MainPagePO;
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
        LoginPagePO loginPage = new MainPagePO()
                .clickLoginButton()
                .typeEmail("oysnake@yandex.ru")
                .typePassword("Test123qwerty");

        Assert.assertTrue(loginPage.isRememberMeChecboxSelected());

        loginPage.clickLoginButton();

        String bodyText = driver.findElement(By.className("text-white")).getText();
        Assert.assertEquals("Добро пожаловать, Vlad!", bodyText);
    }
}
