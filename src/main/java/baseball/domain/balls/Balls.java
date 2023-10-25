package baseball.domain.balls;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import baseball.domain.GameResult;

public class Balls {

	private static final String NUMBER_RANGE_ERROR_MESSAGE = "1 부터 9 사이의 숫자가 아닙니다.";
	private static final String NUMBERS_SIZE_ERROR_MESSAGE = "3개의 숫자가 아닙니다.";
	private static final String NUMBERS_DUPLICATION_ERROR_MESSAGE = "중복된 숫자가 존재합니다.";

	private final List<Ball> balls;

	public Balls(final List<Integer> numbers) {
		validate(numbers);
		this.balls = mapToBalls(numbers);
	}

	private void validate(final List<Integer> numbers) {
		validateNumberRange(numbers);
		validateNumbersSize(numbers);
		validateDuplication(numbers);
	}

	private void validateNumberRange(final List<Integer> numbers) {
		numbers.stream()
			   .filter(BallsRule::isNumberOutOfRange)
			   .forEach(number -> {
				   throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
			   });
	}

	private void validateNumbersSize(final List<Integer> numbers) {
		if (BallsRule.isNotCorrectSize(numbers.size())) {
			throw new IllegalArgumentException(NUMBERS_SIZE_ERROR_MESSAGE);
		}
	}

	private void validateDuplication(final List<Integer> numbers) {
		int sizeWithoutDuplication = getSizeWithoutDuplication(numbers);
		if (BallsRule.isNotCorrectSize(sizeWithoutDuplication)) {
			throw new IllegalArgumentException(NUMBERS_DUPLICATION_ERROR_MESSAGE);
		}
	}

	private int getSizeWithoutDuplication(final List<Integer> numbers) {
		return new HashSet<>(numbers).size();
	}

	private List<Ball> mapToBalls(final List<Integer> numbers) {
		return IntStream.rangeClosed(BallsRule.MIN_POSITION.getValue(), BallsRule.MAX_POSITION.getValue())
						.mapToObj(position -> new Ball(numbers.get(position), position))
						.toList();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Balls otherBalls = (Balls)o;
		return Objects.equals(balls, otherBalls.balls);
	}

	@Override
	public int hashCode() {
		return Objects.hash(balls);
	}

	public GameResult compareBalls(final Balls otherBalls) {
		GameResult gameResult = new GameResult();
		this.balls.forEach(ball -> {
			compareBall(otherBalls, ball, gameResult);
		});
		return gameResult;
	}

	private void compareBall(final Balls otherBalls, final Ball ball, final GameResult gameResult) {
		otherBalls.balls.forEach(otherBall -> {
			if (ball.isStrike(otherBall)) {
				gameResult.addStrikeCount();
			}
			if (ball.isBall(otherBall)) {
				gameResult.addBallCount();
			}
		});
	}

}
