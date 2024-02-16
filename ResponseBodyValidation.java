package json;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ResponseBodyValidation {
	public static void main(String[] args) {
		val();
	}
	
	static void val() {
		Map<Object,Object> requestBody=new HashMap<>();
		requestBody.put("name","Neo");
		requestBody.put("job", "Engineer");
		
		RequestSpecification  requestSpecification= RestAssured.given();
		requestSpecification.body(requestBody).contentType(ContentType.JSON);
		Response response = requestSpecification.post("https://reqres.in/api/users");
		
		ResponseBody responseBody = response.body();
		JsonPath jsonPath = responseBody.jsonPath();
//		String prettyPrint = jsonPath.prettyPrint();
//		System.out.println(prettyPrint);
	}
}
