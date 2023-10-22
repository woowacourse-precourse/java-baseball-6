package baseball.controller;

import baseball.domain.TargetNumber;

public class GameController {
	private static int NUMBER_SIZE = 3;
	private TargetNumber targetNumber;

	public void run() {
		targetNumber = TargetNumber.create(NUMBER_SIZE);
	}
}
