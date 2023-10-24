package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import baseball.view.OutputView;

public class InputView {
	public int userInputNumber() {
		OutputView.printInputNumberMessage();
		String userInput = Console.readLine();

		return Integer.parseInt(userInput);
	}

	public int gameRestartFlag() {
		OutputView.printGameRestartMessage();
		String userInput = Console.readLine();

		return Integer.parseInt(userInput);
	}
}
