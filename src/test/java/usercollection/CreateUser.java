package usercollection;

import Testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUser extends TestBase {
    @Test
    public void createuser(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        httprequest = RestAssured.given();
        httprequest.header("Content-Type","application/json");
        JSONObject json = new JSONObject();

        json.put("id","0");
        json.put("username","jack");
        json.put( "firstName","jo");
        json.put("lastName","lee");
        json.put("email","jack@gmail.com");
        json.put("password","jack");
        json.put("phone","78987869");
        json.put("userStatus","0");

        httprequest.body(json.toJSONString());
        Response response= httprequest.request(Method.POST,"/v2/user");

        int statuscode = response.statusCode();
        System.out.println("Status code is "+statuscode);
        Assert.assertEquals(statuscode, 200);

        String responsebody = response.getBody().asString();
        System.out.println("Response body is "+responsebody);
        Assert.assertTrue(responsebody!=null);

        System.out.println(response.getTime());
        System.out.println(response.getStatusLine());

        JsonPath jsonpath = response.jsonPath();
        System.out.println((String) jsonpath.get("type"));
        Assert.assertEquals(jsonpath.get("type"),"unknown");
        System.out.println((String) jsonpath.get("message"));

    }
}
