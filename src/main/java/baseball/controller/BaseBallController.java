package baseball.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import baseball.console.BaseBallConstant;
import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import baseball.console.NumberConstant;
import baseball.dto.BaseBallResult;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallController {
	private final ConsoleInput consoleInput = new ConsoleInput();
	private final ConsoleOutput consoleOutput = new ConsoleOutput();
	private final String targetNumber;

	public BaseBallController() {
		this.targetNumber = generateRandomNumber();
	}

	private String generateRandomNumber() {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < NumberConstant.PICK_COUNT.getValue()) {
			int num = Randoms.pickNumberInRange(NumberConstant.MIN_NUMBER.getValue(),
				NumberConstant.MAX_NUMBER.getValue());
			if (!numbers.contains(num)) {
				numbers.add(num);
			}
		}
		return numbers.stream().map(String::valueOf).collect(Collectors.joining());
	}

	public boolean playGame() {
		consoleOutput.printInit();
		while (true) {
			consoleOutput.printReq();
			String input = consoleInput.getGameInput();
			BaseBallResult result = getResult(input);
			if (result.getStrikeCount() == NumberConstant.PICK_COUNT.getValue()) {
				consoleOutput.printEnd();
				return consoleInput.getEndInput().equals(BaseBallConstant.RESTART.getValue());
			}
			consoleOutput.printResult(result);
		}
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
