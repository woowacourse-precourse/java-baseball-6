package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Player {

	private static final String DELIMITER = "";

	private Balls balls;

	public Player(final String numbers) {
		this.balls = new Balls(mapToList(numbers));
	}

	private List<Integer> mapToList(final String numbers) {
		return Arrays.stream(numbers.split(DELIMITER))
					 .map(Integer::parseInt)
					 .toList();
	}

}
