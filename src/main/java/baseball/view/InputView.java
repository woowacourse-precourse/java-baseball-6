package baseball.view;

import baseball.utils.InputValidation;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
	private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";


	public String readNumber() {
		System.out.print(INPUT_NUMBER);
		return Console.readLine();
	}


}