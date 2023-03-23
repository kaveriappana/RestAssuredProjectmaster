package GetRequest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLogin {
    @Test
    public void login(){
        RestAssured.baseURI="https://petstore.swagger.io";
       Response response= RestAssured.get("v2/user/login?username=king&password=king");
       int statuscode = response.getStatusCode();
       System.out.println("status code is " +statuscode);
       Assert.assertEquals(statuscode, 200);

       String responsebody = response.getBody().asString();
       System.out.println("response body is "+responsebody);
       Assert.assertEquals(responsebody.contains("message"),true);

       Assert.assertEquals(response.contentType(), "application/json");

       //getting all the headers from response body
       Headers allheaders =response.headers();

       for( Header header:allheaders){
           System.out.println(header.getName()+"   "+header.getValue());
       }
        Assert.assertTrue(responsebody.contains("type"));
        Assert.assertTrue(responsebody.contains("unknown"));



      //String expectedResponse = "{"code":200,"type":"unknown","message":"logged in user session:1679378689702"}";
       //Assert.assertEquals(responsebody.contentEquals(expectedResponse),true);


    }
}
