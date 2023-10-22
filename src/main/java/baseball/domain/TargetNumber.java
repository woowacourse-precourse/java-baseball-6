package baseball.domain;

import baseball.util.Parser;

public class TargetNumber extends Number {
	private TargetNumber(String number, int size) {
		super(number, size);
	}

	public static TargetNumber create(int size) {
		String randomNumbers = Parser.parseNumberListToString(NumberFactory.createRandomNumbers(size));
		return new TargetNumber(randomNumbers, size);
	}


}
