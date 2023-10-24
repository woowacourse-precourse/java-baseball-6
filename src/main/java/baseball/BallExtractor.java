package baseball;

public class BallExtractor {
	String inputString;
	int number;

	public Balls extract(String input) {
		inputString = input;
		Balls balls = new Balls();

		int inputNumber = validateNumber();

		while (inputNumber > 0) {
			number = inputNumber % 10;
			inputNumber = inputNumber /10;

			if (validateRange()) {
				balls.add(number);
			}
		}

		balls.reverse();
		return balls;
	}

	private int validateNumber() {
		// 숫자 검증
		try {
			number = Integer.parseInt(inputString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		return number;
	}
	private boolean validateRange() {
		// 1에서 9까지의 수인지 검증
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException();
		}
		return true;
	}
}

