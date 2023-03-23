package datadriventesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Iterator;

public class DataDrivenTesting_AddNewEmployes {
    @Test(dataProvider = "empdataprovider")
    public void postemlopyees(String ename, String esal, String eage){
        RestAssured.baseURI ="https://dummy.restapiexample.com";
        RequestSpecification request = RestAssured.given();

        JSONObject json= new JSONObject();
        json.put("name",ename);
        json.put("salary",esal);
        json.put("age",eage);

        request.header("Content-Type","application/json");
        request.body(json.toJSONString());
        Response response=request.request(Method.POST,"/api/v1/create");


        String responseBody = response.getBody().asString();
        System.out.println("Response body is " +responseBody);

        Assert.assertEquals(responseBody.contains(ename),true);
        Assert.assertEquals(responseBody.contains(esal),true);
        Assert.assertEquals(responseBody.contains(eage),true);

        int code=response.getStatusCode();
        Assert.assertEquals(code,200);

    }
    @DataProvider(name = "empdataprovider")
    @Test(retryAnalyzer = RetryAnalizer.class)
    String[][] getEmpData() throws IOException
    {
        String path = "C:\\Users\\kaveri.appana\\IdeaProjects\\RestAssuredProject\\src\\test\\java\\datadriventesting\\Excelfilename.xlsx";
        int rownum = XLUtils.getRowCount(path,"Sheet1");
        int colcount = XLUtils.getCellCount(path, "Sheet1",1);
        String empdata[][] = new String[rownum][colcount];
        for(int i = 1; i <= rownum; i++)
        {
            for (int j =0 ; j < colcount; j++ )
            {
                empdata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
       // String empdata[][] = {{"ABCXYZ123","10000","25"},{"XYZ456","20000","30"},{"YZ789","30000","35"}};
        return(empdata);
    }
}
