package baseball;

public class BaseBall {
	private final String number;
	private static final int NUMBER_LENGTH = 3;

	public BaseBall(final String number) {
		if (number.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException("Number must have a length of " + NUMBER_LENGTH);
		}

		for (int i = 0; i < NUMBER_LENGTH; i++) {
			char digit = number.charAt(i);
			if (digit < '1' || digit > '9') {
				throw new IllegalArgumentException("Invalid Number is " + number);
			}
		}
		this.number = number;
	}

	public int countBalls(final BaseBall inputBaseBall) {
		int balls = 0;
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			for (int j = 0; j < NUMBER_LENGTH; j++) {
				if (i != j && this.number.charAt(i) == inputBaseBall.number.charAt(j)) {
					balls += 1;
				}
			}
		}
		return balls;
	}

	public int countStrikes(final BaseBall inputBaseBall) {
		int strikes = 0;
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			if (this.number.charAt(i) == inputBaseBall.number.charAt(i)) {
				strikes += 1;
			}
		}
		return strikes;
	}

	public boolean isNothing(final BaseBall inputBaseBall) {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			for (int j = 0; j < NUMBER_LENGTH; j++) {
				if (this.number.charAt(i) == inputBaseBall.number.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}
