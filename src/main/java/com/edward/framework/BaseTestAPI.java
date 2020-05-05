package com.edward.framework;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.get;

public class BaseTestAPI {
    final String endpoint = "https://api.trademe.co.nz/v1/Categories/UsedCars.json";
    Response response;
    String responseBody;
    String buildRequestAdd;
    int carBrandCount;

    // This method will prettify the response and logs it in the console.
    private static String logRestAssured(String endpoint, String headers, String body, Response response) {
        String log = "Request:\n";
        log += "\nEndpoint: " + endpoint;
        log += "\nHeaders: " + headers;
        log += "\nBody: " + body;
        log += "\nResponse: \n";
        log += response.prettyPeek().asString();
        return log;
    }

    // This method counts number of car name brands.
    public void requestCountOfNamedBrands() {
        requestGETResponseForEndpoint("");
        parseJson(responseBody);
        if (buildRequestAdd.contains("Other")) {
            carBrandCount--;
        }
        System.out.println("The total number of car brands under used cars is: " + carBrandCount);
    }

    // This method checks if the car identified exists on the list.
    public void checkCarBrandExists(String carBrand, boolean carExists) {
        requestGETResponseForEndpoint("?with_counts=true");
        parseJson(responseBody);
        if ((buildRequestAdd.contains(carBrand)) && (carExists)) {
            System.out.println("The car brand " + carBrand + " exists! ");
            checkCountOfCarListed(carBrand);
        } else {
            System.out.println("The car brand " + carBrand + " does not exist! ");
        }
    }

    // This method will simply do a GET request from the endpoint.
    private void requestGETResponseForEndpoint(String queryParameters) {
        response = get(endpoint + queryParameters);
        responseBody = response.getBody().asString();
        Assert.assertEquals("Response code should be: ", 200, response.statusCode());
        logRestAssured(endpoint, "", "", response);
    }

    // This method is for parsing JSON.
    private void parseJson(String jsonBody) {
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonBody);
        JsonArray groupObject = jsonObject.getAsJsonArray("Subcategories");
        carBrandCount = groupObject.size();
        StringBuilder buildRequest = new StringBuilder();
        for (int count = 0; count < groupObject.size(); count++) {
            buildRequest.append(groupObject.get(count));
        }
        buildRequestAdd = buildRequest.toString();
    }

    // This method counts the number of cars listed based on the selected brand.
    private void checkCountOfCarListed(String carBrand) {
        Pattern pattern = Pattern.compile("(?<=" + carBrand + ")(.*?)(?=HasClassifieds)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(buildRequestAdd);
        if (matcher.find()) {
            String trimmedMatch = matcher.group();
            Pattern patternInsideText = Pattern.compile("(?<=Count\":)(.*?)(?=,\")", Pattern.DOTALL);
            Matcher matcherInsideText = patternInsideText.matcher(trimmedMatch);
            if (matcherInsideText.find()) {
                System.out.println("and there are (" + matcherInsideText.group() + ") number of stocks left for this brand.");
            } else {
                System.out.println("The number of stocks is not available!");
            }
        } else {
            System.out.println("Cannot find string match!");
        }
    }
}