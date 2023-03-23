package GetRequest;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationBasicGet {
    @Test
    public void getauthorizeduser(){
        RestAssured.baseURI="https://postman-echo.com";
        //basic authontication
        PreemptiveBasicAuthScheme authscheme =new PreemptiveBasicAuthScheme();
        authscheme.setUserName("postman");
        authscheme.setPassword("password");
        RestAssured.authentication =authscheme;
        RequestSpecification httprequest =RestAssured.given();
        Response response= httprequest.request(Method.GET,"/basic-auth");

        String responsebody = response.getBody().asString();
        System.out.println("responsebody is "+responsebody);

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());

       // Assert.assertTrue(responsebody.contains("authenticated : true"));
        // String expectedResponse = {"authenticated":true};
         //Assert.assertTrue(responsebody.contentEquals(expectedResponse));
    }
}
