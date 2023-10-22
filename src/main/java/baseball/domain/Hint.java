package baseball.domain;

import baseball.util.Parser;

public class Hint {
	private int strike;
	private int ball;

	public static Hint create(TargetNumber targetNumber, InputNumber inputNumber) {
		Hint hint = new Hint();
		hint.compare(targetNumber, inputNumber);
		return hint;
	}

	public String getResult() {
		return Parser.parseHintToString(strike, ball);
	}

	public boolean isWin(int size) {
		return strike == size;
	}

	private void compare(TargetNumber targetNumber, InputNumber inputNumber) {
		String input = inputNumber.getNumber();
		String target = targetNumber.getNumber();

		for (int i = 0; i < input.length(); i++) {
			char inputDigit = input.charAt(i);
			char targetDigit = target.charAt(i);

			if (inputDigit == targetDigit) {
				strike++;
				continue;
			}

			if (target.contains(String.valueOf(inputDigit))) {
				ball++;
			}
		}
	}
}
