package org.vlad.MyTest.po;

import org.openqa.selenium.By;

public class LoginPagePO extends AbstractPO {
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By loginButton = By.cssSelector(".btn.btn-default");
    private By rememberMeCheckbox = By.id("remember");

    public LoginPagePO typeEmail(String email){
        sendKeys(emailInput, email);
        return this;
    }

    public LoginPagePO typePassword(String password){
        sendKeys(passwordInput, password);
        return this;
    }

    public boolean isRememberMeChecboxSelected(){

        return isSelected(rememberMeCheckbox);
    }

    public void clickLoginButton(){
        click(loginButton);
    }
}
