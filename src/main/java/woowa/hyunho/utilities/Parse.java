package woowa.hyunho.utilities;

import java.util.ArrayList;
import java.util.List;

public class Parse {
	public static List<Integer> parseStringToIntList(String str) {
		List<Integer> intList = new ArrayList<>();
		int i =0;
		while (i < str.length()) {
			char c = str.charAt(i);
			int numericVal = parseCharToInt(c);
			intList.add(numericVal);
			i++;
		}
		return intList;
	}
	
	public static int parseStringToInt(String str) {
		return Integer.parseInt(str);
	}
	
	public static int parseCharToInt(char c) {
		return Character.getNumericValue(c);
	}
}