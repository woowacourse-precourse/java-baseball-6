package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {

	private static final String DELIMITER = "";
	public static final String NUMBER_FORMAT = "\\d+";
	public static final String NOT_NUMBER_ERROR_MESSAGE = "숫자가 아닙니다.";

	private final Balls balls;

	public Player(final String numbers) {
		validate(numbers);
		this.balls = new Balls(mapToList(numbers));
	}

	public Player updateBalls(final String numbers) {
		return new Player(numbers);
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
