package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import baseball.domain.balls.Balls;

public class Player {

	private static final String DELIMITER = "";
	private static final String NUMBER_FORMAT = "\\d+";
	private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자가 아닙니다.";

	private final Balls balls;

	public Player(final String numbers) {
		validate(numbers);
		this.balls = new Balls(mapToList(numbers));
	}

	private List<Integer> mapToList(final String numbers) {
		return Arrays.stream(numbers.split(DELIMITER))
					 .map(Integer::parseInt)
					 .toList();
	}

	private void validate(final String numbers) {
		validateNumber(numbers);
	}

	private void validateNumber(final String numbers) {
		Pattern pattern = Pattern.compile(NUMBER_FORMAT);
		Matcher matcher = pattern.matcher(numbers);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
		}
	}

	public Balls getBalls() {
		return balls;
	}

}
