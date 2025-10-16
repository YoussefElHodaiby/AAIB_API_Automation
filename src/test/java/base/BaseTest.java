package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/api";
        
    
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("x-api-key", "reqres-free-v1");  
        builder.addHeader("Content-Type", "application/json");  
        builder.addHeader("Accept", "application/json");  
        
        RequestSpecification requestSpec = builder.build();
        RestAssured.requestSpecification = requestSpec;
        
        System.out.println("Base URI: " + RestAssured.baseURI);
        System.out.println("Headers: x-api-key, Content-Type, Accept");
    }
}
