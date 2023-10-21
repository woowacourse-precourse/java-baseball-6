package baseball.domain;

public class BaseballReferee {

	private static final int MAX_SIZE = 3;

	public Hint compare(BaseballNumber computerNumbers, BaseballNumber playerNumbers) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < MAX_SIZE; i++) {
			if (computerNumbers.getComputerNumberByIndex(i) == playerNumbers.getComputerNumberByIndex(i)) {
				strike++;
				continue;
			}
			if (computerNumbers.isComputerNumberContainsPlayerNumber(playerNumbers.getComputerNumberByIndex(i))) {
				ball++;
			}
		}
		return new Hint(strike, ball);
	}
}
