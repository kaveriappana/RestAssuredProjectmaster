package Pet;

import datadriventesting.RetryAnalizer;
import datadriventesting.XLUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class AddPet {
    @Test(dataProvider = "empdataprovider")
    public void addpet(int id,String name,String photoUrls,String status,String requestbody) {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RequestSpecification httprequest = RestAssured.given();
//        JSONObject json = new JSONObject();
//        json.put("id",id);
//        json.put("id",id);
//        json.put("name",name);
//        json.put("name",id);
//        json.put("photoUrls",photoUrls);
//        json.put("id",id);
//        json.put("name",name);
//        json.put("status",status);

        Response response = httprequest.when().body(requestbody).post(RestAssured.baseURI+"/v2/pet");
//        httprequest.header("Content-Type","application/json");
//        httprequest.body(json.toJSONString());
//        Response response=httprequest.request(Method.POST,"/v2/user");


        String responseBody = response.getBody().asString();
        System.out.println("Response body is " +responseBody);

        String responsebody =response.getBody().asString();
        System.out.println("Response body is "+responsebody);

    }
    @DataProvider(name = "empdataprovider")
    @Test(retryAnalyzer = RetryAnalizer.class)
    String[][] getEmpData() throws IOException
    {
        String path = "C:\\Users\\kaveri.appana\\IdeaProjects\\RestAssuredProject\\src\\test\\java\\Pet\\requestbody.xlsx";
        int rownum = XLUtils.getRowCount(path,"Sheet5");
        int colcount = XLUtils.getCellCount(path, "Sheet5",1);
        String empdata[][] = new String[rownum][colcount];
        for(int i = 1; i <= rownum; i++)
        {
            for (int j =0 ; j < colcount; j++ )
            {
                empdata[i-1][j] = XLUtils.getCellData(path, "Sheet5", i, j);
            }
        }

        return(empdata);
    }
}


