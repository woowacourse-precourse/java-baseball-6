package baseball.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import baseball.console.constant.GameConstant;
import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import baseball.controller.constant.NumberConstant;
import baseball.dto.BaseBallResult;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallController {
	private final ConsoleInput consoleInput;
	private final ConsoleOutput consoleOutput;
	private String targetNumber;

	public BaseBallController() {
		consoleInput = new ConsoleInput();
		consoleOutput = new ConsoleOutput();
	}

	public void run() {
		while (true) {
			playGame();
			if (consoleInput.getEndInput().equals(GameConstant.FINISH.getValue())) {
				return;
			}
		}
	}

	private void playGame() {
		consoleOutput.printInit();
		generateTargetNumber();
		while (true) {
			consoleOutput.printReq();
			BaseBallResult result = getResult(consoleInput.getGameInput());
			if (result.getStrikeCount() == NumberConstant.PICK_COUNT.getValue()) {
				consoleOutput.printEnd();
				return;
			}
			consoleOutput.printResult(result);
		}
	}

	private void generateTargetNumber() {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < NumberConstant.PICK_COUNT.getValue()) {
			int randomNumber = Randoms.pickNumberInRange(NumberConstant.MIN_NUMBER.getValue(), NumberConstant.MAX_NUMBER.getValue());
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}
		targetNumber = numbers.stream().map(String::valueOf).collect(Collectors.joining());
	}

	private BaseBallResult getResult(String input) {
		int ballCount = 0, strikeCount = 0;
		for (int i = 0; i < targetNumber.length(); i++) {
			char targetDigit = targetNumber.charAt(i);
			char inputDigit = input.charAt(i);
			if (targetDigit == inputDigit) {
				strikeCount++;
			} else if (targetNumber.contains(String.valueOf(inputDigit))) {
				ballCount++;
			}
		}
		return new BaseBallResult(ballCount, strikeCount);
	}
}
