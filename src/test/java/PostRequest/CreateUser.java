package PostRequest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateUser {

    @Test
    public void create(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request =RestAssured.given();
        request.header("Content-Type","application/json");
        JSONObject json = new JSONObject();
        json.put("id","0");
        json.put("username","king");
        json.put( "firstName","string");
        json.put("lastName","string");
        json.put("email","string");
        json.put("password","king");
        json.put("phone","string");
        json.put("userStatus","0");

        request.body(json.toJSONString());
        Response response= request.request(Method.POST,"/v2/user");

        response.getStatusCode();
        Assert.assertEquals(response.getStatusCode(),200);
        String statusmessage = response.getStatusLine();
        System.out.println("status message is "+statusmessage);

         String body= response.getBody().asString();
         System.out.println("response body "+body);

        String  type = response.jsonPath().get("type");
        System.out.println("type is " +type);
        Assert.assertEquals(type,"unknown");

        //Assert.assertTrue(response.contains("dbid=\"6445\""));


    }
}
