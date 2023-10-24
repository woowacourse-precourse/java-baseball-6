package baseball;

public class BallExtractor extends IntegerExtractor{
	int ball;
	public Balls extract(String input) {
		str = input;
		Balls balls = new Balls();

		validateNumber();

		while (number > 0) {
			ball = number % 10;
			number = number / 10;

			if (validateRange()) {
				balls.add(ball);
			}
		}

		balls.reverse();
		return balls;
	}
	private boolean validateRange() {
		// 1에서 9까지의 수인지 검증
		if (ball < 1 || ball > 9) {
			throw new IllegalArgumentException();
		}
		return true;
	}
}

