package baseball.domain;

import baseball.util.Parser;

public class TargetNumber extends Number {
	private TargetNumber(String number) {
		super(number);
	}

	public static TargetNumber create(int size) {
		String randomNumbers = Parser.parseNumberListToString(NumberFactory.createRandomNumbers(size));
		return new TargetNumber(randomNumbers);
	}

}
