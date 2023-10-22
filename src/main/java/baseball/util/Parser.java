package baseball.util;

import java.util.List;
import java.util.stream.Collectors;

public class Parser {
	public static String parseNumberListToString(List<Integer> fromList) {
		return fromList.stream()
			.map(String::valueOf)
			.collect(Collectors.joining());
	}
}
