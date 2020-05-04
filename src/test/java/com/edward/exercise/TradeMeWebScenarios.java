package com.edward.exercise;


import com.edward.framework.BaseTest;
import com.edward.framework.PageObject.TradeMeHomePage;
import org.junit.Assert;
import org.junit.Test;

public class TradeMeWebScenarios extends BaseTest {

    @Test
    public void checkTradeMeLogin() throws InterruptedException {
        TradeMeHomePage tradeMeHomePage = new TradeMeHomePage(getDriver());
        tradeMeHomePage.userLogin("edward@enhanceconsulting.co.nz", "Enhance123!");
        Thread.sleep(10000);
        Assert.assertTrue("You have not successfully logged in TradeMe!", tradeMeHomePage.fetchUsernameSection().contains("Edward"));
        Thread.sleep(10000);
    }
}
