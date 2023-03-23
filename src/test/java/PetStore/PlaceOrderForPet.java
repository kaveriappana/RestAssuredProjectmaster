package PetStore;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PlaceOrderForPet {
    @Parameters({"ID","petId","quantity","shipDate","status","complete"})
    @Test
    public void petorder(int ID,int petId,int quantity,String shipDate,String status,String complete){
        RestAssured.baseURI = "https://petstore.swagger.io";

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();


        requestParams.put("ID", ID);
        requestParams.put("petId", petId);
        requestParams.put("quantity", quantity);
        requestParams.put("shipDate", shipDate);
        requestParams.put("status", status);
        requestParams.put("complete", complete);

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST,"/v2/store/order");

        String responseBody = response.getBody().asString();
        System.out.println("Response body is " +responseBody);

        response.getTime();
        response.getStatusCode();

}
    @Test
    public void placleorderbychangingfields(){
        RestAssured.baseURI = "https://petstore.swagger.io";

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();


        requestParams.put("ID", "6");
        requestParams.put("petId", "8989");
        requestParams.put("quantity", "5");
        requestParams.put("shipDate", "2023-03-15T09:21:50.970Z");
        requestParams.put("status", "placed");
        requestParams.put("complete", "true");

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST,"/v2/store/order");

        String responseBody = response.getBody().asString();
        System.out.println("Response body is " +responseBody);

        System.out.println(response.getTime());
        response.getStatusCode();
    }

}
