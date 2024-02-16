package parsing;

import java.util.HashMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

public class Serialization {

	@Test
	private void serialize() throws Exception{
		
		HashMap<String, Object> m=new HashMap<>();
		m.put("hours","10");
		m.put("minutes",11);
		m.put("seconds","12");
		
		HashMap<String, Object> map=new HashMap<>();
		map.put("year","2022");
		map.put("month","october");
		map.put("date","3");
		map.put("hours","12");
		map.put("minutes",1);
		map.put("seconds","50");
		map.put("Secondary Time",m);
		
		ObjectMapper mapper = new ObjectMapper();
//		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./jsonValue.json"), map);
		String writeValueAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		System.out.println(writeValueAsString);
	}
	
}
