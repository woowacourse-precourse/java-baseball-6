package baseball.service;

import static baseball.domain.Number.NUMBER_SIZE;

import baseball.domain.Hint;
import baseball.domain.InputNumber;
import baseball.domain.TargetNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
	private TargetNumber targetNumber;
	private InputNumber inputNumber;
	private Hint hint;

	public void start() {
		setTargetNumber();
		do {
			askInput();
			printOutput(getHint());
		} while(!checkWin());
	}

	private void askInput() {
		InputView.askNumber();
		inputNumber = InputNumber.create(Console.readLine());
	}

	private void printOutput(String result) {
		OutputView.printResult(result);
	}

	private boolean checkWin() {
		return hint.isWin();
	}

	private void setTargetNumber() {
		targetNumber = TargetNumber.create(NUMBER_SIZE);
	}

	private String getHint() {
		hint = Hint.create(targetNumber, inputNumber);
		return hint.getHint();
	}
}
