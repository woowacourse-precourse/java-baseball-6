package baseball.input;

import baseball.game.GameMessages;
import baseball.util.ConsoleUtil;
import baseball.validators.NumberValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

	private static final String PLAY_AGAIN_NUMBER = "1";
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
		ConsoleUtil.printMsg_newLine(GameMessages.PLAY_AGAIN.getMessage());

		String input = getUserInput();

		numberValidator.isValidPlayAgain(input);

		return input.equals(PLAY_AGAIN_NUMBER);
	}

	public String getUserInput() {
		return Console.readLine();
	}
}