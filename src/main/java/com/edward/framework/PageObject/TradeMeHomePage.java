package com.edward.framework.PageObject;

import com.edward.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TradeMeHomePage extends BasePage {

    By loginButton = By.id("LoginLink");
    By usernameBlockText = By.xpath("//*[@id=\"container\"]/div[1]/div[1]/div[3]/div/form/p");

    public TradeMeHomePage(WebDriver driver) {
        super(driver);
        waitForElementToAppear(loginButton);
    }

    // A method to login customer.
    public void userLogin(String userEmail, String userPass) {
        try{
            driver.findElement(loginButton).click();
            TradeMeLoginPage tradeMeLoginPage = new TradeMeLoginPage(getDriver());
            tradeMeLoginPage.userLoggingIn(userEmail, userPass);
        }
        catch (Exception e){
            System.out.println("The user has failed to login!");
        }
    }

    // A method to return the text fetched from the web element where the user's name is displayed.
    public String fetchUsernameSection() throws StackOverflowError {
        return driver.findElement(usernameBlockText).getText();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
