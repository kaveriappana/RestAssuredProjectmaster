package users;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostDeletePutExample {
    @Test
    public void test1(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        JSONObject json = new JSONObject();
        json.put("id","0");
        json.put("username","kaveri");
        json.put( "firstName","kav");
        json.put("lastName","appana");
        json.put("email","kav@gmail.com");
        json.put("password","kaveri");
        json.put("phone","12346");
        json.put("userStatus","0");

        request.body(json.toJSONString());

        Response response =request.post("https://petstore.swagger.io/v2/user");

        int code = response.getStatusCode();

        String data = response.asString();
        System.out.println("Data is" +data);

        Assert.assertEquals(code,200);


    }
    @Test
    public void delete(){
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("https://petstore.swagger.io/v2/user/kaveri");
        int code = response.getStatusCode();

    }
    @Test
    public void put(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        JSONObject json = new JSONObject();
        json.put("id","0");
        json.put("username","durga");
        json.put( "firstName","kav");
        json.put("lastName","appana");
        json.put("email","kav@gmail.com");
        json.put("password","kaveri");
        json.put("phone","12346");
        json.put("userStatus","0");

        request.body(json.toJSONString());

        Response response =request.put("https://petstore.swagger.io/v2/user/kaveri");

        int code = response.getStatusCode();

        String data = response.asString();
        System.out.println("Data is" +data);


    }
}
