package GetRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetOrder {
    @Test
    public void order(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        Response response = RestAssured.get("v2/store/order/2");

        response.then().assertThat().header("Content-Type", "application/json");
        response.getStatusCode();
        response.getTime();
        response.getBody().asString();

        Assert.assertEquals(response.getStatusCode(), 404);
    }
}
