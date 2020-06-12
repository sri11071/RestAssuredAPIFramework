package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import com.wavelabs.pojo.AddPlaceAPI;
import com.wavelabs.pojo.Location;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefinations {

	ResponseSpecification resspec;

	Response response;

	RequestSpecification addPlaceRequest1;

	@Given("Add place payload")
	public void add_place_payload() {
		// Write code here that turns the phrase above into concrete actions
		AddPlaceAPI p = new AddPlaceAPI();
		p.setAccuracy(90);
		p.setAddress("Sriqqn1ivas");
		p.setLanguage("Enqgl1ish -EN");

		List<String> mytype = new ArrayList<String>();
		mytype.add("sh1qoee");
		mytype.add("ww1qiqwo");
		p.setTypes(mytype);
		Location l = new Location();
		l.setLat(-232.2922);
		l.setLng(312.9001);
		p.setLocation(l);
		p.setPhone_number("+929221012121");
		p.setWebsite("www.ashah1@ssdwsad.as");
		p.setName("Frontline house");

		RequestSpecification reqbuild = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();

		addPlaceRequest1 = given().spec(reqbuild).body(p);

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}

	@When("User calls add with Post http request")
	public void user_calls_add_with_Post_http_request() {
		// Write code here that turns the phrase above into concrete actions
		response = addPlaceRequest1.when().post("/maps/api/place/add/json").then().spec(resspec).extract().response();

	}

	@Then("The API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		String responseString = response.asString();
		System.out.println(response.getStatusCode());

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		String responseString1 = response.asString();
		JsonPath js = new JsonPath(responseString1);
		String placeid = js.getString("place_id");
		System.out.println(placeid);
		assertEquals(js.get(string).toString(), string2);

	}

}