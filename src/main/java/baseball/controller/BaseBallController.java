package baseball.controller;

import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallController {
	private final ConsoleInput consoleInput = new ConsoleInput();
	private final ConsoleOutput consoleOutput = new ConsoleOutput();
	private final String targetNumber;
	private static final int MIN_NUMBER = 1, MAX_NUMBER = 9, PICK_COUNT = 3;

	public BaseBallController() {
		this.targetNumber = generateRandomNumber();
	}

	private String generateRandomNumber() {
		StringBuilder randomNumber = new StringBuilder();
		for (int digit : Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_COUNT)) {
			randomNumber.append(digit);
		}
		return randomNumber.toString();
	}
}
