package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringParseRelatedUtil {
	public List<Integer> addListToInteger(String inputedNumber) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < inputedNumber.length(); i++) {
			list.add(inputedNumber.charAt(i) - '0');
		}

		return list;
	}
}
