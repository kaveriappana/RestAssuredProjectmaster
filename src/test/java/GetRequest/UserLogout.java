package GetRequest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLogout {
    @Test
    public void logout(){
        RestAssured.baseURI = "https://petstore.swagger.io";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();


        //Response object
        Response response = httpRequest.request(Method.GET,"/v2/store/order/11");

        response.getTime();
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
