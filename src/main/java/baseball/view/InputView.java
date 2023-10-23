package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

	public String enterGameNumber() {
		System.out.println(INPUT_NUMBER_MESSAGE);
		return Console.readLine();
	}

}
