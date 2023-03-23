package usercollection;

import Testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUser extends TestBase {
    @Test
    public void deleteuser(){
        RequestSpecification request = RestAssured.given();
        response = request.delete("https://petstore.swagger.io/v2/user/jack");
        int code = response.getStatusCode();
        System.out.println("status code" +code);
        Assert.assertEquals(code,200);
    }
    @Test
    public void deletedeleteduser(){
        RequestSpecification request = RestAssured.given();
        response = request.delete("https://petstore.swagger.io/v2/user/jack");
        int code = response.getStatusCode();
        System.out.println("status code" +code);
        Assert.assertEquals(code,404);
    }
}
