package testcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Payload;
import pojo.User;
import routes.Routes;
import utils.ConfigReader;
import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaTests extends BaseClass{

	
	@Test
	public void testProducrSchema() {
		int productId=configReader.getIntProperty("productId");
		
		given()
			.pathParam("id", productId)

		.when()
			.get(Routes.GET_PRODUCT_BY_ID)

		.then()
		 	.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("productSchema.json"));
		}
	
	@Test
	 public void testCartSchema() {
       int cartId=configReader.getIntProperty("cartId");
		 
		 given()
		 	 .pathParam("id", cartId)
		 .when()
		      .get(Routes.GET_CART_BY_ID)
		   .then()
		   .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("cartSchema.json"));
 
}
	
	
		@Test
		public void testUserSchema()
		{
			int userId=configReader.getIntProperty("userId");
			given()
				.pathParam("id",userId)
			.when()
				.get(Routes.GET_USER_BY_ID)
			.then()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("userSchema.json"));
			
		}


}