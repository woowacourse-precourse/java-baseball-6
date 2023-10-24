package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import baseball.util.Message;

public class InputView {
	public int userInputNumber() {
		System.out.print(Message.INPUT_NUMBER_MESSAGE);
		String userInput = Console.readLine();

		return Integer.parseInt(userInput);
	}
}
