package com.edward.framework.PageObject;

import com.edward.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TradeMeLoginPage extends BasePage {

    By emailTextField = By.id("page_email");
    By emailPasswordTextField = By.id("page_password");
    By loginButton = By.id("LoginPageButton");

    public TradeMeLoginPage(WebDriver driver) {
        super(driver);
        waitForElementToAppear(emailTextField);
    }

    // A method to login customer.
    public void userLoggingIn(String userEmail, String userPass) {
        driver.findElement(emailTextField).sendKeys(userEmail);
        driver.findElement(emailPasswordTextField).sendKeys(userPass);
        driver.findElement(loginButton).click();
    }

}
