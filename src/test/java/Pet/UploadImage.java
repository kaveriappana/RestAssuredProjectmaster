package Pet;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadImage {
    @Test
    public void uploadimage(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification httprequest =RestAssured.given();
        Response response =httprequest.request(Method.POST,"/v2/pet/12/uploadImage");

        String responsebody=response.getBody().asString();
        System.out.println("response body is"+responsebody);
//        Assert.assertEquals(response.getStatusCode(),400);
    }
    @Test
    public void updatespetinstore(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification httprequest =RestAssured.given();
        Response response =httprequest.request(Method.POST,"/v2/pet/12");
        Assert.assertEquals(response.getStatusCode(),200);

        String type = response.jsonPath().get("type");
        System.out.println("status is " +type);
        Assert.assertEquals(type,"unknown");
    }
}
