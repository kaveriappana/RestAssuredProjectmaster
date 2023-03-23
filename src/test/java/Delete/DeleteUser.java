package Delete;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUser {
    @Test
    public void delete(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request =RestAssured.given();
        Response response =request.request(Method.DELETE,"v2/user/king");

        int code= response.statusCode();
        System.out.println("Status code "+code);
        Assert.assertEquals(code,200);

    }
    @Test
    public void deleteordernyorderid(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request =RestAssured.given();
        Response response =request.request(Method.DELETE,"/v2/store/order/6");

        int code= response.statusCode();
        System.out.println("Status code "+code);
        Assert.assertEquals(code,200);

    }
}
