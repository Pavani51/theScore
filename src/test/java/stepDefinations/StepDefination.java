package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.Utils;
import static org.junit.Assert.*;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;

	// TestDataBuild data =new TestDataBuild();
	@Given("Get details using the GET API call")
	public void pass_cityName_and_APP_ID_to_the_call() throws IOException {
		res = given().spec(requestSpecification());
	}

	@When("user pass league {string} and season {string}  with {string} http request")
	public void user_calls_with_http_request(String resource, String requestType) throws IOException {
		APIResources resourceAPI = APIResources.valueOf(resource);

		System.out.println(resourceAPI.getResource());
		if (requestType.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource());
		else if (requestType.equalsIgnoreCase("GET"))
			response = res.queryParam("", getGlobalValue("")).queryParam("", getGlobalValue(""))
					.when().get(resourceAPI.getResource());
		System.out.println(response.asString());
	}

	@Then("the API call is success with status code {int}")
	public void the_API_call_is_success_with_status_code(int statusCode) {
		assertEquals(response.getStatusCode(), statusCode);
	}

}