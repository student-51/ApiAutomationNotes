package json;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.module.jsv.JsonSchemaValidatorSettings;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings("unused")
public class JsonSch {
	public static void main(String[] args) {
		validates_schema_in_classpath();
//		createUserUsingMap();
	}

	private static void createUserUsingMap() {
		Map<Object,Object> requestBody = new HashMap<>();
		requestBody.put("name", "Neo");
		requestBody.put("job", "Engineer");

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.body(requestBody).contentType(ContentType.JSON);

		Response response = requestSpecification.post("https://reqres.in/api/users");
		response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("JsonSchema/jschema.json")).using(JsonSchemaValidatorSettings.settings().with().checkedValidation(false)));
		System.out.println("===================================");
	}

	public static void validates_schema_in_classpath() {
        String json = "{\"name\":\"Neo\",\"job\":\"Engineer\",\"id\":\"599\",\"createdAt\":\"2024-02-16T11:39:37.409Z\"}";
 
        assertThat(json, JsonSchemaValidator.matchesJsonSchema(new File("JsonSchema/jschema.json")));
    }
}
