package baseball.domain.ball;

import baseball.domain.dto.GuessResult;
import java.util.List;
import java.util.Objects;

public final class Answer extends BallNumbers {

  private Answer(final List<Integer> numbers) {
    super(numbers);
  }

  public static Answer of(final List<Integer> numbers) {
    return new Answer(numbers);
  }

  public GuessResult guess(final Guess guess) {
    return new GuessResult(
        getBallCount(guess),
        getStrikeCount(guess)
    );
  }

  private int getStrikeCount(final Guess guess) {
    int strikeCount = 0;
    for (int i = 0; i < BALL_COUNT; i++) {
      if (isStrikeAt(i, guess)) {
        strikeCount++;
      }
    }
    return strikeCount;
  }

  private int getBallCount(final Guess guess) {
    int ballCount = 0;
    for (int i = 0; i < BALL_COUNT; i++) {
      if (isBallAt(i, guess)) {
        ballCount++;
      }
    }
    return ballCount;
  }

  private boolean isStrikeAt(
      final int index,
      final Guess guess
  ) {
    final int answerNumber = get(index).number();
    final int guessNumber = guess.get(index).number();

    return Objects.equals(answerNumber, guessNumber);
  }

  private boolean isBallAt(
      final int index,
      final Guess guess
  ) {
    return
        !isStrikeAt(index, guess) &&
            ballNumbers
                .stream()
                .anyMatch(n ->
                    Objects.equals(
                        n.number(),
                        guess.get(index).number()
                    )
                );
  }


}
