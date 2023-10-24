package baseball.model;

import baseball.model.Score;
import baseball.util.Constant;

public class Calculator {
	public static Score calculateScore(String input, String answer) {
		int strike = 0;
		int ball = 0;

		for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
			if (input.charAt(i) == answer.charAt(i)) {
				strike++;
			} else if (answer.contains(String.valueOf(input.charAt(i)))) {
				ball++;
			}
		}
		return new Score(strike, ball);
	}
}
