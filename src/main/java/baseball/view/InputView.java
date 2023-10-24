package baseball.view;

import baseball.utils.InputValidation;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

	public String readNumber() {
		OutputView.printInputNumber();
		return Console.readLine();
	}
	public String readRestart() {
		OutputView.printRestart();
		return Console.readLine();
	}


}