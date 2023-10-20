package baseball.game;

import static baseball.game.GameMessages.printAskToPlayAgain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

	public List<Integer> getNumbers() {
		List<Integer> numbers = new ArrayList<>();
		String input = getUserInput();

		for (int i = 0; i < input.length(); i++) {
			numbers.add(Character.getNumericValue(input.charAt(i)));
		}

		return numbers;
	}

	public boolean askToPlayAgain() {
		printAskToPlayAgain();

		String input = getUserInput();

		return input.equals("1");
	}

	public String getUserInput() {
		return Console.readLine();
	}
}