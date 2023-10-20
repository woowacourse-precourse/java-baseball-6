package baseball.game;

import static baseball.game.GameMessages.printAskToPlayAgain;

import baseball.validators.NumberValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

	private final NumberValidator numberValidator = new NumberValidator();

	public List<Integer> getNumbers() {
		List<Integer> numbers = new ArrayList<>();
		String input = getUserInput();

		numberValidator.isValidPlayGame(input);

		for (int i = 0; i < input.length(); i++) {
			numbers.add(Character.getNumericValue(input.charAt(i)));
		}

		return numbers;
	}

	public boolean askToPlayAgain() {
		printAskToPlayAgain();

		String input = getUserInput();

		numberValidator.isValidPlayAgain(input);

		return input.equals("1");
	}

	public String getUserInput() {
		return Console.readLine();
	}
}