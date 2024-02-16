package json;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import io.restassured.path.json.JsonPath;

public class Gpath {
	public static void main(String[] args) {
		extractSingleValueWithFind_findAPlayerWithACertainJerseyNumber();
//		JsonPath path=new JsonPath(new File("JsonSchema/Gpath.json"));
//		System.out.println(path.get("teams.name[0]").toString());	// find the first “name”
//		System.out.println(path.get("teams.name[-1]").toString());	// find the last “name”
//		ArrayList<String> allTeamNames = path.get("teams.name");	// ALL The team names into a list
//		System.out.println(allTeamNames);							
//		ArrayList<Map<String,?>> allTeamData = path.get("teams");	// ALL The team names into a Map
	}
	public static void extractSingleValueWithFind_findAPlayerWithACertainJerseyNumber() {
			JsonPath path=new JsonPath(new File("JsonSchema/Gpath.json"));
		    String string = path.get("players.find { it.jerseyNumber == 20 }.name");
		    System.out.println(string);
		}
	
}

//	https://www.james-willett.com/rest-assured-gpath-json/