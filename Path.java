package json;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class Path {
	public static void main(String[] args) {
		JsonPath path=new JsonPath(new File("jsonValue.json"));
		Object object = path.getList("store.book.price");
		System.out.println(object.toString());
	}
}
