package PostRequest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateMultipleUsers {
    @Test
    public void createmultipleusers(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        JSONObject json =new JSONObject();

        json.put("id","0");
        json.put("username","kaveri1");
        json.put( "firstName","durga");
        json.put("lastName","appana");
        json.put("email","string@gmail.com");
        json.put("password","kaveri");
        json.put("phone","123456");
        json.put("userStatus","0");



        request.body(json.toJSONString());
        Response response = request.request(Method.POST,"/v2/user/createWithArray");
        response.getBody().asString();
        int statuscode = response.getStatusCode();
        System.out.println("status code "+200);
        Assert.assertEquals(statuscode,200);

        String type = response.jsonPath().get("type");
        System.out.println("type is"+type);
        Assert.assertEquals("type",type);


    }
}
