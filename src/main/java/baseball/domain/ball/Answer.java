package baseball.domain.ball;

import baseball.domain.dto.GuessResult;
import java.util.List;

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
      final boolean isStrike = ballNumbers.get(i).equals(guess.get(i));
      if (isStrike) {
        strikeCount++;
      }
    }
    return strikeCount;
  }

  private int getBallCount(final Guess guess) {
    int ballCount = 0;
    for (int i = 0; i < BALL_COUNT; i++) {
      final boolean isNotStrike = !ballNumbers.get(i).equals(guess.get(i));
      final boolean isBall = ballNumbers.contains(guess.get(i));
      if (isNotStrike && isBall) {
        ballCount++;
      }
    }
    return ballCount;
  }


}
