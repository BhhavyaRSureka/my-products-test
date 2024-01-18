// Test generated by RoostGPT for test ReatAssured-Test using AI Type Open AI and AI Model gpt-4


// Test generated for /pet/findByTags_get for http method type GET in rest-assured framework


// RoostTestHash=c43742dac4


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

public class findByTagsGetTest {
  
    @Test  
    public void findByTags_get_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "findByTagsGetTest.csv"))) {  
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
                .get("/pet/findByTags")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");
    
              if (response.jsonPath().get("id") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(Integer.class));  
          }
    
              if (response.jsonPath().get("category") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("category"), nullValue());  
          }
    
              if (response.jsonPath().get("name") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("name"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("photoUrls") != null) {    
                for (int i = 0; i < response.jsonPath().getList("photoUrls").size(); i++) {    
                  }  
                MatcherAssert.assertThat(response.jsonPath().getList("photoUrls"), instanceOf(List.class));
  
          }
    
              if (response.jsonPath().get("tags") != null) {    
                for (int i = 0; i < response.jsonPath().getList("tags").size(); i++) {    
              if (response.jsonPath().get("tags["+ i +"].id") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("tags["+ i +"].id"), instanceOf(Integer.class));  
          }
    
              if (response.jsonPath().get("tags["+ i +"].name") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("tags["+ i +"].name"), instanceOf(String.class));  
          }
    
                  }  
                MatcherAssert.assertThat(response.jsonPath().getList("tags"), instanceOf(List.class));
  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("status"), anyOf(equalTo("available"), equalTo("pending"), equalTo("sold")));
  
          }
				}
if (response.statusCode() == 400) {
					System.out.println("Description: Invalid tag value");
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
