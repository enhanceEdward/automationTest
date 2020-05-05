package com.edward.exercise;

import com.edward.framework.BaseTestAPI;
import org.junit.Test;
/*
·         Return how many named brands of used car are available in the TradeMe UsedCarscategory.
·         Check that the brand ‘Kia’ exists and return the current number of Kia cars listed.
·         Check that the brand ‘Hispano Suiza’ does not exist.
 */

public class TradeMeUsedCarsScenarios {

    // This scenario returns how many named brands of used cars are available in the TradeMe UsedCarscategory, this excludes "Others".
    @Test
    public void returnsCountOfNamedBrands() {
        BaseTestAPI baseTestAPI = new BaseTestAPI();
        baseTestAPI.requestCountOfNamedBrands();
    }

    // This scenario checks that the brand ‘Kia’ exists and return the current number of Kia cars listed.
    // The method checkCarBrandExists() has two variables;
    // carBrand = name of car brand to be verified
    // carExists = <true> if to check if it exists, <false> otherwise
    @Test
    public void checkCarExists() {
        BaseTestAPI baseTestAPI = new BaseTestAPI();
        baseTestAPI.checkCarBrandExists("Kia", true);
    }

    // This scenario checks that the brand ‘Hispano Suiza’ does not exist.
    // The method checkCarBrandExists() has two variables;
    // carBrand = name of car brand to be verified
    // carExists = <true> if to check if it exists, <false> otherwise
    @Test
    public void checkHispanoSuizaDoesntExist() {
        BaseTestAPI baseTestAPI = new BaseTestAPI();
        baseTestAPI.checkCarBrandExists("Hispano Suiza", false);
    }
}
