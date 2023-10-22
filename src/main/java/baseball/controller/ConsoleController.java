package baseball.controller;

import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import baseball.utils.StringUtils;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ConsoleController {

	private final ConsoleInput consoleInput;

	private final ConsoleOutput consoleOutput;

	public ConsoleController(ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
		this.consoleInput = consoleInput;
		this.consoleOutput = consoleOutput;
	}

	public void printGameStart() {
		consoleOutput.printGameStart();
	}

	public void printInputMessage() {
		consoleOutput.printInputMessage();
	}

	public void printResultMessage(int ball, int strike) { consoleOutput.printResultMessage(ball, strike); }

	public void printFinishMessage() {
		consoleOutput.printFinishMessage();
	}
	public String getUserNumber() {
		printInputMessage();
		return consoleInput.getUserNumber();
	}

	public int[] getUserNumberArray() {
		return StringUtils.parseStringToIntArray(getUserNumber());
	}

	public int[] getComputerNumberArray() {
		List<Integer> list = new ArrayList<>();
		while (list.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!list.contains(randomNumber)) {
				list.add(randomNumber);
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

	public boolean getResumeOption() {
		consoleOutput.printResumeMessage();
		String inputString = consoleInput.getResumeOption();
		if (inputString.equals("1")) {
			return true;
		} else {
			return false;
		}
	}

}
