// Test generated by RoostGPT for test ReatAssured-Test using AI Type Open AI and AI Model gpt-4


// Test generated for /store/order_post for http method type POST in rest-assured framework


// RoostTestHash=036bac41de


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

public class orderPostTest {
  
    @Test  
    public void order_post_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "orderPostTest.csv"))) {  
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
                .when()
                .post("/store/order")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");

                 System.out.println("Response body: " + response.getBody().asString());
    
                     if (response.path("xml.id") != null) {
                MatcherAssert.assertThat(response.path("xml.id"), instanceOf(String.class));  
          }

              if (response.path("xml.petId") != null) {
                MatcherAssert.assertThat(response.path("xml.petId"), instanceOf(String.class));  
          }

              if (response.path("xml.quantity") != null) {
                MatcherAssert.assertThat(response.path("xml.quantity"), instanceOf(String.class));  
          }

              if (response.path("xml.shipDate") != null) {
                MatcherAssert.assertThat(response.path("xml.shipDate"), instanceOf(String.class));  
          }

              if (response.path("xml.status") != null) {
                MatcherAssert.assertThat(response.path("xml.status"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.path("xml.status"), anyOf(equalTo("placed"), equalTo("approved"), equalTo("delivered")));

          }

              if (response.path("xml.complete") != null) {
                MatcherAssert.assertThat(response.path("xml.complete"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 400) {
					System.out.println("Description: Invalid Order");
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
