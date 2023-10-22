package baseball.domain;

public class TargetNumber extends Number {
	private TargetNumber(String number) {
		super(number);
	}

	public static TargetNumber create(int size) {
		String randomNumbers = NumberFactory.createRandomNumbers(size);
		return new TargetNumber(randomNumbers);
	}
}
