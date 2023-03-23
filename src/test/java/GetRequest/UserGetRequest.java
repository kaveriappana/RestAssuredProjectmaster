package GetRequest;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserGetRequest {
    @Test
    public void test(){
        baseURI="https://petstore.swagger.io";
        Response rest =get("v2/user/kaveri");
        System.out.println(rest.getStatusCode());
        System.out.println(rest.getTime());
        System.out.println(rest.getBody().asString());
        System.out.println(rest.getContentType());
        System.out.println(rest.getStatusLine());

        Assert.assertEquals(rest.getStatusCode(), 200);
        String contenttype= rest.header("Content-Type");
        Assert.assertEquals(contenttype, "application/json");
    }
}
