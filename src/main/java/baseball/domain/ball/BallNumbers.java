package baseball.domain.ball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class BallNumbers {

  public static final int BALL_COUNT = 3;

  private final List<BallNumber> ballNumbers;

  private BallNumbers(final List<BallNumber> ballNumbers) {
    this.ballNumbers = ballNumbers;
  }

  public static BallNumbers of(final List<Integer> numbers) {
    validateNumbersCount(numbers);
    return new BallNumbers(intoBallNumbers(numbers));
  }

  private static List<BallNumber> intoBallNumbers(final List<Integer> numbers) {
    final List<BallNumber> ballNumbers = new ArrayList<>();

    for (final Integer number : numbers) {
      ballNumbers.add(new BallNumber(number));
    }
    return ballNumbers;
  }

  private static void validateNumbersCount(final List<Integer> numbers) {
    if (numbers.size() != BALL_COUNT) {
      throw new IllegalArgumentException("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");
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
    final int answerNumber = ballNumbers.get(index).number();
    final int guessNumber = other.ballNumbers.get(index).number();

    return Objects.equals(answerNumber, guessNumber);
  }

  private boolean isBallAt(
      final int index,
      final BallNumbers other
  ) {
    return
        !isStrikeAt(index, other) &&
            ballNumbers
                .stream()
                .anyMatch(n ->
                    Objects.equals(
                        n.number(),
                        other.ballNumbers.get(index).number()
                    )
                );
  }
}
