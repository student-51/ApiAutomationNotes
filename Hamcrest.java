package validate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.startsWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Hamcrest {

	@Test
	private void get() {
//		assertThat(200,equalTo(200));
//		assertThat(10,Matchers.greaterThan(5));
//		assertThat(10,instanceOf(Integer.class));
//		assertThat("abc",isOneOf("abc","def","ghi"));
//		assertThat("abc",isIn(new String[] {"a","b","c"}));
		MatcherAssert.assertThat("abc", Matchers.equalToIgnoringWhiteSpace("abc"));
	}

	@Test
	private void assertString() {
		String str1 = "calligraphy";
		String start = "call";
		String end = "phy";
		assertThat(str1,allOf( startsWith(start),containsString("all"),endsWith(end)));
		assertThat(str1,anyOf( startsWith(start),containsString("all"),endsWith(end)));
		assertThat(str1, startsWith(start));
		assertThat(str1, containsString("all"));
		assertThat(str1, endsWith(end));
		assertThat(start, Matchers.hasLength(4));
	}

	@Test
	private void assertCollection() {
		List<String> emptyList = new ArrayList<>();
		assertThat(emptyList, empty());

		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat(hamcrestMatchers, arrayWithSize(4));
		
		 List<String> ham = Arrays.asList("collections", "beans", "text", "number");
			    assertThat(ham, hasSize(4));
	}
	@Test
	private void numberMatcher() {
		 assertThat(1, greaterThan(0));
		 assertThat(5, greaterThanOrEqualTo(5));
		 assertThat(-1, lessThan(0));
		 assertThat(-1, lessThanOrEqualTo(5));
		 assertThat(1.2, Matchers.closeTo(1, 0.5));
	}
	
}
