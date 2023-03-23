package usercollection;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutUpdateUser {
    @Test
    public void updateuser(){
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
        Response response =request.put("https://petstore.swagger.io/v2/user/abc");

        int code = response.getStatusCode();
        System.out.println("status code:" +code);

        String data = response.asString();
        System.out.println("Data is" +data);


    }
}
