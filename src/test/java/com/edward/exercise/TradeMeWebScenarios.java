package com.edward.exercise;


import com.edward.framework.BaseTestWeb;
import com.edward.framework.PageObject.TradeMeHomePage;
import org.junit.Assert;
import org.junit.Test;

public class TradeMeWebScenarios extends BaseTestWeb {

    // This scenario allows the user to verify successfully logging in of the Trade Me webpage.
    @Test
    public void checkTradeMeUserLogin() throws InterruptedException {
        TradeMeHomePage tradeMeHomePage = new TradeMeHomePage(getDriver());
        tradeMeHomePage.userLogin("edward@enhanceconsulting.co.nz", "Enhance123!");
        Thread.sleep(10000); //Added sleep to view screen only
        Assert.assertTrue("You have not successfully logged in TradeMe!", tradeMeHomePage.fetchUsernameSection().contains("Edward"));
        Thread.sleep(10000); //Added sleep to view screen only
    }
}
