package GetRequest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData {
    @Test
    public void testResponseCode(){

        int code=get("https://petstore.swagger.io/v2/user/king").statusCode();
       System.out.println("Status code is "+code);
        Assert.assertEquals(code ,200);

    }
    @Test
    public void testBody(){
        Response rest = get("https://petstore.swagger.io/v2/user/king");
        String data = rest.asString();
        System.out.println("Data is" +data);
        System.out.println("Response time" +rest.getTime());
    }

}
