package baseball.controller;

import baseball.domain.Hint;
import baseball.domain.InputNumber;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import baseball.domain.TargetNumber;
import baseball.view.InputView;

public class GameController {
	private static int NUMBER_SIZE = 3;
	private TargetNumber targetNumber;
	private InputNumber inputNumber;
	private Hint hint = new Hint();

	public void run() {
		targetNumber = TargetNumber.create(NUMBER_SIZE);
		InputView.askNumber();
		inputNumber = InputNumber.create(Console.readLine(),NUMBER_SIZE);
		OutputView.printResult(hint.createHint(targetNumber,inputNumber));
	}
}
