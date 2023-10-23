package baseball.domain;

import static baseball.controller.GameController.NUMBER_SIZE;

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

	private void compare(TargetNumber target, InputNumber input) {
		String targetNumber = target.getNumber();
		String inputNumber = input.getNumber();

		compare(targetNumber, inputNumber);
	}

	private void compare(String target, String input) {
		for (int i = 0; i < NUMBER_SIZE; i++) {
			char targetDigit = target.charAt(i);
			char inputDigit = input.charAt(i);

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
