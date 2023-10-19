package baseball.domain;

import java.util.List;
import java.util.Objects;

public final class BallNumbers {

  private static final int BALL_COUNT = 3;

  private final List<Integer> numbers;

  private final int index = 0;

  private BallNumbers(final List<Integer> numbers) {
    this.numbers = numbers;
  }

  public static BallNumbers of(final List<Integer> numbers) {
    validateNumbersCount(numbers);
    validateNumbers(numbers);
    return new BallNumbers(numbers);
  }

  private static void validateNumbersCount(final List<Integer> numbers) {
    if (numbers.size() != BALL_COUNT) {
      throw new IllegalArgumentException("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");
    }
  }

  private static void validateNumbers(final List<Integer> numbers) {
    for (final Integer number : numbers) {
      if (number < 1 || number > 9) {
        throw new IllegalArgumentException("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
      }
    }
  }

  public int getStrikeCount(final BallNumbers other) {
    int strikeCount = 0;
    for (int i = 0; i < BALL_COUNT; i++) {
      if (isStrikeAt(i, other)) {
        strikeCount++;
      }
    }
    return strikeCount;
  }

  public int getBallCount(final BallNumbers other) {
    int ballCount = 0;
    for (int i = 0; i < BALL_COUNT; i++) {
      if (isBallAt(i, other)) {
        ballCount++;
      }
    }
    return ballCount;
  }

  private boolean isStrikeAt(
      final int index,
      final BallNumbers other
  ) {
    return Objects.equals(numbers.get(index), other.numbers.get(index));
  }

  private boolean isBallAt(
      final int index,
      final BallNumbers other
  ) {
    return
        !isStrikeAt(index, other) &&
            numbers
                .stream()
                .anyMatch(n -> Objects.equals(n, other.numbers.get(index)));
  }
}
