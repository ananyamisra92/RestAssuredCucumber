package com.APITest.cucumber;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.HashMap;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Steps {
	
	Response response;
	HashMap<String, String> postContent;


	@Given("URL and ID are given {string} {string}")
	public void user_details_are_added_in_endpoint_with_data(String url , String ID) {
		
		RestAssured.baseURI = url;
		RestAssured.basePath = ID; 
		
	}
	
	@Then("GET API is Triggered")
	public void trigger_get_api() {
		given().accept(ContentType.JSON);
		response = given().when().get();
	}

	@And("Response is validated for success StatusCode")
	public void response_is_validated() {
		 
		response.then().assertThat().statusCode(200);
	}

	@And("Firstname {string} and ID {string} is validated")
	public void Response_is_validated_for_firstname(String Fname, String ID) {

		response
		.then().body("data.first_name", equalTo(Fname))
		.and().body("data.id", equalTo(Integer.parseInt(ID)));
		
	}
	
	
	@Given("URL, NAME and JOB is given {string} {string} {string}")
	public void url_name_and_job_is_given(String uri, String name, String job) {
	   
		RestAssured.baseURI = uri;
		postContent = new HashMap<>();
		postContent.put("name", name);
		postContent.put("job", job);
		
	}

	@Then("POST Endpoint is triggered")
	public void post_endpoint_is_triggered() {
		
		response = given().contentType(ContentType.JSON).
				with().body(postContent).
				when().post();
	   
	}

	@And("responseCode is validated for created statusCode")
	public void response_code_is_validated_for_created_status_code() {
	   response.then().assertThat().statusCode(201);
	}

	@And("Response Body is validated for Name {string} and job {string}")
	public void response_body_is_validated(String name, String job) {
	  response.then()
	  	.assertThat().body("name", equalTo(name))
	  	.and().body("job", equalTo(job));
	}
	
	
	@Given("URL, ID, NAME and JOB is given {string} {string} {string} {string}")
	public void url_id_name_and_job_is_given(String uri, String ID, String name, String job) {
		RestAssured.baseURI = uri;
		RestAssured.basePath = ID;
		postContent = new HashMap<>();
		postContent.put("name", name);
		postContent.put("job", job);
		
	}

	@Then("PUT Endpoint is triggered")
	public void put_endpoint_is_triggered() {
		response = given().contentType(ContentType.JSON).
				with().body(postContent).
				when().put();
	   
	}

	@Then("responseCode is validated for success statusCode")
	public void response_code_is_validated_for_success_status_code() {
		 response.then().assertThat().statusCode(200);
	}

	@Then("Response Body is validated for UpdatedAt is not null")
	public void response_body_is_validated_for_updated_at_is_not_null() {
		 response.then()
		  	.assertThat().body("updatedAt", notNullValue());
	}

	
	@Then("DELETE Endpoint is triggered")
	public void delete_endpoint_is_triggered() {
		response = given().accept(ContentType.ANY).delete();
	}

	@And("responseCode is validated for noContent statusCode")
	public void response_code_is_validated_for_no_content_status_code() {
		 response.then().assertThat().statusCode(204);
	}



}
