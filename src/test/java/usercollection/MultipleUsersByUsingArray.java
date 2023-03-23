package usercollection;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class MultipleUsersByUsingArray {
    @Test
    public void multipleusers(){
        RestAssured.baseURI="https://petstore.swagger.io";
        RequestSpecification httprequest =RestAssured.given();

        JSONObject json= new JSONObject();
        json.put("id","0");
        json.put("username","abc");
        json.put("firstName","string");
        json.put("lastName","string");
        json.put("email","abc@gmail.com");
        json.put("password","abc");
        json.put("phone","123456789");
        json.put("userStatus","0");

        JSONObject json1= new JSONObject();
        json1.put("id","0");
        json1.put("username","def");
        json1.put("firstName","string");
        json1.put("lastName","string");
        json1.put("email","def@gmail.com");
        json1.put("password","def");
        json1.put("phone","123456789");
        json1.put("userStatus","0");

        JSONObject array= new JSONObject();
        array.putAll(json1);
        array.putAll(json);

        System.out.println(array);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(array.toString())
                .log().all()
                .when().post(RestAssured.baseURI+"/v2/user/createWithArray")
                .then()
                .assertThat().statusCode(200)
                .body("message", equalTo("ok"))
                .log().all();

    }
}
