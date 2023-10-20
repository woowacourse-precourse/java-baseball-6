package baseball.view;

import static baseball.model.Constant.MESSAGE_GAME_END;
import static baseball.model.Constant.MESSAGE_GAME_START;
import static baseball.model.Constant.MESSAGE_INPUT_NUMBER;

public class OutputView {

	public void printGameStart() {
		System.out.println(MESSAGE_GAME_START.getMessage());
	}
	public void printGameEnd() {
		System.out.println(MESSAGE_GAME_END.getMessage());
	}
	public static void printInputNumber() {
		System.out.print(MESSAGE_INPUT_NUMBER.getMessage());
	}

}
