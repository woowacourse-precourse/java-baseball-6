package baseball.model;

import baseball.util.Constant;
import baseball.util.Message;

import java.util.stream.Stream;

public class Calculator {
	public static Score calculateScore(ListNumber userNumber, ListNumber computerNumber) {
		return new Score(strikeCount(userNumber, computerNumber), ballCount(userNumber, computerNumber));
	}

	private static int strikeCount(ListNumber userNumber, ListNumber computerNumber) {
		if (userNumber == null || computerNumber == null)
			throw new IllegalArgumentException(Message.INPUT_ERROR_MESSAGE);
		return (int) Stream.iterate(0, i -> i + 1)
				.limit(Constant.NUMBER_LENGTH)
				.filter(i -> userNumber.getIndex(i) == computerNumber.getIndex(i))
				.count();
	}

	private static int ballCount(ListNumber userNumber, ListNumber computerNumber) {
		if (userNumber == null || computerNumber == null)
			throw new IllegalArgumentException(Message.INPUT_ERROR_MESSAGE);
		return (int) Stream.iterate(0, i -> i + 1)
				.limit(Constant.NUMBER_LENGTH)
				.filter(i -> userNumber.contains(computerNumber.getIndex(i)))
				.filter(i -> userNumber.getIndex(i) != computerNumber.getIndex(i))
				.count();
	}
}
