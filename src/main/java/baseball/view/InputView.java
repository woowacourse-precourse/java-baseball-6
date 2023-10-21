package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static String inputNumber() {
		System.out.print(INPUT_NUMBER_MESSAGE);
		String number = Console.readLine();
		return number;
	}

	public static String restartOrEndNumber() {
		System.out.print(RESTART_OR_END_MESSAGE);
		String number = Console.readLine();
		return number;
	}
}
