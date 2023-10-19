package baseball.domain.ball;

import baseball.util.NumberPicker;
import java.util.Queue;

public final class FixedNumberPicker implements NumberPicker {

  private final Queue<Integer> numbers;

  public FixedNumberPicker(final Queue<Integer> numbers) {
    this.numbers = numbers;
  }

  @Override
  public int pick() {
    return numbers.poll();
  }
}
