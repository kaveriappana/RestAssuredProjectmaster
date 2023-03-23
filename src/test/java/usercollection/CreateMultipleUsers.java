package usercollection;

import datadriventesting.RetryAnalizer;
import datadriventesting.XLUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateMultipleUsers {
    @Test(dataProvider = "empdataprovider")
    public void createusers(String username,String firstname,String lastname,String email,String pass,String phone)
    {


            RestAssured.baseURI ="https://petstore.swagger.io";
            RequestSpecification request = RestAssured.given();

            JSONObject json= new JSONObject();
            json.put("id","0");
            json.put("username",username);
            json.put("firstName",firstname);
            json.put("lastName",lastname);
            json.put("email",email);
            json.put("password",pass);
            json.put("phone",phone);
            json.put("userStatus","0");


            request.header("Content-Type","application/json");
            request.body(json.toJSONString());
            Response response=request.request(Method.POST,"/v2/user");


            String responseBody = response.getBody().asString();
            System.out.println("Response body is " +responseBody);
            Assert.assertTrue(responseBody!=null);

            Assert.assertEquals(responseBody.contains(username),true);
            Assert.assertEquals(responseBody.contains(pass),true);
            Assert.assertEquals(responseBody.contains(email),true);

            int code=response.getStatusCode();
            Assert.assertEquals(code,200);

        }
        @DataProvider(name = "empdataprovider")
        @Test(retryAnalyzer = RetryAnalizer.class)
        String[][] getEmpData() throws IOException
        {
            String path = "C:\\Users\\kaveri.appana\\IdeaProjects\\RestAssuredProject\\src\\test\\java\\usercollection\\API_Training_Kaveri (3).xlsx";
            int rownum = XLUtils.getRowCount(path,"Sheet2");
            int colcount = XLUtils.getCellCount(path, "Sheet2",1);
            String empdata[][] = new String[rownum][colcount];
            for(int i = 1; i <= rownum; i++)
            {
                for (int j =0 ; j < colcount; j++ )
                {
                    empdata[i-1][j] = XLUtils.getCellData(path, "Sheet2", i, j);
                }
            }
            // String empdata[][] = {{"ABCXYZ123","10000","25"},{"XYZ456","20000","30"},{"YZ789","30000","35"}};
            return(empdata);
        }
    }



