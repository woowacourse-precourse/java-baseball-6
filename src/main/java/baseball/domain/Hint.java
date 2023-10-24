package baseball.domain;

import static baseball.domain.Number.NUMBER_SIZE;

import baseball.view.Parser;

public class Hint {
	private int strike;
	private int ball;

	public static Hint create(TargetNumber targetNumber, InputNumber inputNumber) {
		Hint hint = new Hint();
		hint.compare(targetNumber, inputNumber);
		return hint;
	}

	public String getHint() {
		return Parser.parseHintToString(strike, ball);
	}

	public boolean isWin() {
		return strike == NUMBER_SIZE;
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

			checkPosition(target, targetDigit, inputDigit);
		}
	}

	private void checkPosition(String target, char targetDigit, char inputDigit) {
		if (inputDigit == targetDigit) {
			strike++;
			return;
		}

		if (target.contains(String.valueOf(inputDigit))) {
			ball++;
		}
	}
 }
