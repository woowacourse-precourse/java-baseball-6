package baseball.service;

import baseball.domain.Hint;
import baseball.domain.InputNumber;
import baseball.domain.TargetNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
	private static int NUMBER_SIZE = 3;
	private TargetNumber targetNumber;
	private InputNumber inputNumber;
	private Hint hint;

	public void start() {
		setTargetNumber();
		do {
			askInput();
			printOutput(getResult());
		} while(!checkWin());
	}

	private void askInput() {
		InputView.askNumber();
		inputNumber = InputNumber.create(Console.readLine(),NUMBER_SIZE);
	}

	private void printOutput(String result) {
		OutputView.printResult(result);
	}

	private boolean checkWin() {
		return hint.isWin(NUMBER_SIZE);
	}

	private void setTargetNumber() {
		targetNumber = TargetNumber.create(NUMBER_SIZE);
	}

	private String getResult() {
		hint = Hint.create(targetNumber, inputNumber);
		return hint.getResult();
	}
}
