// Test generated by RoostGPT for test ReatAssured-Test using AI Type Open AI and AI Model gpt-4


// Test generated for /store/order/{orderId}_delete for http method type DELETE in rest-assured framework


// RoostTestHash=6e4c4bbafe


package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class order_orderIdDeleteTest {
  
    @Test  
    public void order_orderId_delete_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "order_orderIdDeleteTest.csv"))) {  
            String headerLine = reader.readLine();  
            String[] headers = headerLine.split(",");  
  
            String line;  
            while ((line = reader.readLine()) != null) {  
                String[] data = line.split(",");  
  
                // Create a map of header to data  
                Map<String, String> map = new HashMap<>();  
                for (int i = 0; i < headers.length; i++) {  
                    map.put(headers[i], data[i]);  
                }  
                
  
                Response response = given()
				.pathParam("orderId", map.get("orderId") != null ? map.get("orderId") : "")
                .when()
                .delete("/store/order/{orderId}")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 400) {
					System.out.println("Description: Invalid ID supplied");
				}
if (response.statusCode() == 404) {
					System.out.println("Description: Order not found");
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}