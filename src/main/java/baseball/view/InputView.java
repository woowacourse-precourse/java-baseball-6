package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

	public void readNumber() {
		System.out.print(INPUT_NUMBER);
		System.out.print(Console.readLine());
	}
}
