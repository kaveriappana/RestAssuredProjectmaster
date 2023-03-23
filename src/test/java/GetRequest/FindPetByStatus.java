package GetRequest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindPetByStatus {
    @Test
    public void getpetbystatus(){
        RestAssured.baseURI= "https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        Response response =RestAssured.request(Method.GET,"/v2/pet/findByStatus?status=sold");
        System.out.println(response.getStatusLine());
        String ContentType =response.getHeader("Content-Type");
        System.out.println("content type is "+ContentType);
        response.then().statusCode(200);


    }
}
