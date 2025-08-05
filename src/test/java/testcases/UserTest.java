package testcases;

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

public class UserTest extends BaseClass {
	
	@Test
	public void testGetAllUser() {
		
		given()
		 
		.when()
			.get(Routes.GET_ALL_USERS)
		   
		.then()
			.statusCode(200)
//			.log().body()
			.contentType(ContentType.JSON)
			.body("size()",greaterThan(0));
		
	}
	
	@Test
	public void testGetUserById()
	{
		int userId=configReader.getIntProperty("userId");
		
		given()
			.pathParam("id",userId)
		    .when()	
		    	.get(Routes.GET_USER_BY_ID)
		    .then()
		    	.statusCode(200);
//		    	.log().body();
	}
	
	//3) Test to fetch a limited number of users
		@Test
		public void testGetUsersWithLimit()
		{
			int limit=configReader.getIntProperty("limit");
			
			given()
				.pathParam("limit",limit)
			.when()
				.get(Routes.GET_USERS_WITH_LIMIT)
			.then()
				.statusCode(200)
//				.log().body()
				.body("size()",equalTo(limit));		
			
		}
		
		
		//4) Test to fetch users sorted in descending order
		@Test
		void testGetUsersSorted() {
			
			Response response=given()
				.pathParam("order", "desc")
			.when()
					.get(Routes.GET_USERS_SORTED)
			.then()
					.statusCode(200)
					.extract().response();
			
					
		List<Integer> userids=response.jsonPath().getList("id", Integer.class);
		
		assertThat(isSortedDesceding(userids), is(true));
		
		}

		//5) Test to fetch users sorted in ascending order
		@Test
		void testGetUsersSortedAsc() {
			Response response=given()
					.pathParam("order", "asc")
				.when()
						.get(Routes.GET_USERS_SORTED)
				.then()
						.statusCode(200)
						.extract().response();
				
						
			List<Integer> userids=response.jsonPath().getList("id", Integer.class);
			
			assertThat(isSortedAsceding(userids), is(true));
		}




//6) Test to create a new user

	@Test
	public void testCreateUser() {
		
		 User newuser=Payload.userPayload();
		 
		int id= given()
		 	.contentType(ContentType.JSON)
		 	.body(newuser)
		 .when()
		     .post(Routes.CREATE_USER)
		 .then()
		 	 .statusCode(201)
//		 	  .log().body()
		 	 .body("id", notNullValue())

		 	 .extract().jsonPath().getInt("id");
		
		System.out.println("Generated UserID=====:"+ id);

		 	 
}
	
	//7) Test to update user
	
		@Test
		public void testUpdateUser() {
			
			int userId=configReader.getIntProperty("userId");
			User updateUser=Payload.userPayload();
			
			given()
				.contentType(ContentType.JSON)
				.pathParam("id", userId)
				.body(updateUser)
			.when()	
				.put(Routes.UPDATE_USER)
			.then()
				.statusCode(200)
//				.log().body()
				.body("username",equalTo(updateUser.getUsername()));

					
		}

		//8) delete user
		
		@Test
		void testDeleteUser() {
			int userId=configReader.getIntProperty("userId");
			
			given()
				.pathParam("id", userId)
			.when()
				.delete(Routes.DELETE_USER)
			.then()
				.statusCode(200);

		}

}