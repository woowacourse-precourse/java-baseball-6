package baseball.domain.ball;

import java.util.List;

public class Guess extends BallNumbers {

  private Guess(final List<Integer> numbers) {
    super(numbers);
  }

  public static Guess of(final List<Integer> numbers) {
    return new Guess(numbers);
  }

}
