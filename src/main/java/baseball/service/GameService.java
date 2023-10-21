package baseball.service;

import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import baseball.dto.GameResult;
import baseball.service.constant.NumberConstant;
import baseball.service.constant.PlayConstant;
import baseball.service.util.RandomNumberGenerator;

public class GameService {
	private final ConsoleInput consoleInput;
	private final ConsoleOutput consoleOutput;
	private final RandomNumberGenerator randomNumberGenerator;
	private String targetNumber;

	public GameService() {
		consoleInput = new ConsoleInput();
		consoleOutput = new ConsoleOutput();
		randomNumberGenerator = new RandomNumberGenerator();
	}

	public void run() {
		consoleOutput.printInit();
		while (true) {
			playGame();
			if (consoleInput.getEndInput().equals(PlayConstant.FINISH.getValue())) {
				return;
			}
		}
	}

	private void playGame() {
		targetNumber = randomNumberGenerator.getRandomNumber();
		while (true) {
			consoleOutput.printReq();
			GameResult result = getResult(consoleInput.getGameInput());
			if (result.strikeCount() == NumberConstant.PICK_COUNT.getValue()) {
				consoleOutput.printEnd();
				return;
			}
			consoleOutput.printResult(result);
		}
	}

	private GameResult getResult(String inputNumber) {
		int ballCount = 0, strikeCount = 0;
		for (int i = 0; i < targetNumber.length(); i++) {
			if (targetNumber.charAt(i) == inputNumber.charAt(i)) {
				strikeCount++;
			} else if (targetNumber.contains(String.valueOf(inputNumber.charAt(i)))) {
				ballCount++;
			}
		}
		return new GameResult(ballCount, strikeCount);
	}
}
