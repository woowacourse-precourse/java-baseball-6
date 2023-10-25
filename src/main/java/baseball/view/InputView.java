package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public String userInputNumber() {
		OutputView.printInputNumberMessage();

		return Console.readLine();
	}

	public int gameRestartFlag() {
		OutputView.printGameRestartMessage();
		String userInput = Console.readLine();

		return Integer.parseInt(userInput);
	}
}
