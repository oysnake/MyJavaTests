package org.vlad.MyTest.po;


import org.openqa.selenium.By;

public class MainPagePO extends AbstractPO {
    //extends - наследование от basepage
    private By loginButton = By.cssSelector(".btn.btn-default");
  //access/ type / name

    public LoginPagePO clickLoginButton(){
        click(loginButton);
        return new LoginPagePO();
    }
}
