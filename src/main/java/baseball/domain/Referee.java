package baseball.domain;

import java.util.List;

public class Referee {

	private final Numbers answerNumbers;

	public Referee(Numbers randomNumbers) {
		this.answerNumbers = randomNumbers;
	}

	public int countStrike(Numbers playerNumbers) {
		int position = 0;
		int strike = 0;
		for(int i = 0; i < 3; i++) {
			if(answerNumbers.isSamePosition(playerNumbers,position)) {
				strike++;
			}
			position++;
		}
		return strike;
	}
}
