package baseball.view;

import static baseball.controller.GameController.END;
import static baseball.controller.GameController.RESTART;

public class InputView {
	private static final String ASK_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String ASK_RESTART_MESSAGE = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", RESTART, END);

	public static void askNumber() {
		System.out.print(ASK_INPUT_MESSAGE);
	}

	public static void askRestart() {
		System.out.println(ASK_RESTART_MESSAGE);
	}
}
