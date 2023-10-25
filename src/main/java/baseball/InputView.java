package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

	private InputView() {
	}

	public static List<Integer> selectNumbers(){
		String input = Console.readLine();
		return Arrays.stream(input.split(""))
				.map(Integer::parseInt)
				.toList();
	}

	public static Integer selectDone(){
		String input = Console.readLine();
		int source = Integer.parseInt(input);
		InputValidator.validateOption(source);
        return source;
	}
}

