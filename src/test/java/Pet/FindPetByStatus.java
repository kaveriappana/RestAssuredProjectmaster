package Pet;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindPetByStatus {
    @Test
    public void findpetbystatus(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        Response response= request.request(Method.GET,"/v2/pet/findByStatus?status=sold");
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());


        int code =response.statusCode();
        System.out.println("Status code is "+code);
        Assert.assertEquals(code,200);
    }
    @Test
    public void findpetbyid(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        Response response= request.request(Method.GET,"/v2/pet/12");
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());


        int code =response.statusCode();
        System.out.println("Status code is "+code);
        Assert.assertEquals(code,200);
    }
}
