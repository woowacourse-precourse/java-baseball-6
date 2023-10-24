package baseball.domain;

import baseball.global.constant.Common;
import baseball.global.utils.ConsoleUtil;
import baseball.global.utils.validator.ClientInputValidator;
import baseball.global.utils.validator.InputValidator;
import java.util.ArrayList;
import java.util.List;

public class Client {

	List<Integer> numbers;
	private int ball;
	private int strike;

	public Client() {
		String input = getInput();
		initializeNumbers(input);
	}

	private void initializeNumbers(String input) {
		numbers = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			numbers.add(Character.getNumericValue(input.charAt(i)));
		}
	}

	private String getInput() {
		String input = ConsoleUtil.input();

		InputValidator inputValidator = new ClientInputValidator();
		inputValidator.validate(input);
		return input;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public void increaseBallCount() {
		this.ball++;
	}

	public void increaseStrikeCount() {
		this.strike++;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public boolean gameEnd() {
		return strike == Common.MAXIMUM_COUNT.getNumber();
	}
}
