package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

	public static List<Integer> getUserInput() {
		List<Integer> numbers = new ArrayList<>();
		String input = Console.readLine();

		for (int i = 0; i < input.length(); i++) {
			numbers.add(Character.getNumericValue(input.charAt(i)));
		}

		return numbers;
	}
}