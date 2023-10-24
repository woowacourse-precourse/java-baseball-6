package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class TargetNumber extends Number {
	private TargetNumber(String number) {
		super(number);
	}

	public static TargetNumber create(int size) {
		String randomNumbers = parseNumberListToString(NumberFactory.createRandomNumbers());
		return new TargetNumber(randomNumbers);
	}

	public static String parseNumberListToString(List<Integer> fromList) {
		return fromList.stream()
			.map(String::valueOf)
			.collect(Collectors.joining());
	}

}
