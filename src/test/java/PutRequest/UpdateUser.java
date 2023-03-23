package PutRequest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUser {
    @Test
    public void updateuser(){

        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        JSONObject json = new JSONObject();
        json.put("id","0");
        json.put("username","king");
        json.put( "firstName","string");
        json.put("lastName","string");
        json.put("email","kgf@gmail");
        json.put("password","king");
        json.put("phone","string");
        json.put("userStatus","0");

        request.body(json.toJSONString());
        Response response = request.request(Method.PUT,"/v2/user/abc");

        response.getStatusCode();
        response.getTime();
        response.getBody().asString();

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
