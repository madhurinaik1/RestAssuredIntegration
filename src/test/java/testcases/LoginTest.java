package testcases;

import org.testng.annotations.Test;

import payloads.Payload;
import pojo.Login;

import org.testng.annotations.Test;

import routes.Routes;

import pojo.Product;
import routes.Routes;
import utils.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Payload;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;

public class LoginTest extends BaseClass{

	
	@Test
	public void testInvalidUserLogin() {
    Login newLogin=Payload.loginPayload();
    
    given()
           .contentType(ContentType.JSON)
    		.body(newLogin)
    .when()
    	 .post(Routes.AUTH_LOGIN)
    	 
    .then()
//    	  .statusCode(200)
          .statusCode(401) // Expecting 401 for unauthorized access
	      .body(equalTo("username or password is incorrect"));   //validate the message in the response body
  
	}
	
	@Test
	public void testValidUserLogin() {
		//Getting valid credentials from config.prperties file
    	String username = configReader.getProperty("username");
      	String password = configReader.getProperty("password");
		
      	Login newLogin=new Login(username,password);
		
		given()
			.contentType(ContentType.JSON)
			.body(newLogin)
		.when()
			.post(Routes.AUTH_LOGIN)
		.then() 
//			.log().body()
			.statusCode(201) // Expecting 401 for unauthorized access
			.body("token", notNullValue()); // Validate the response token should be null
		
	}

}

