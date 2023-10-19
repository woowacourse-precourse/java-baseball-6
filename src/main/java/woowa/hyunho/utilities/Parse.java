package woowa.hyunho.utilities;

import java.util.ArrayList;
import java.util.List;

public class Parse {
	public static List<Integer> parseString(String userString) {
		List<Integer> user = new ArrayList<>();
		int i =0;
		while (i<userString.length()) {
			char c = userString.charAt(i);
			int numericVal = Character.getNumericValue(c);
			user.add(numericVal);
			i++;
		}
		return user;
	}
}