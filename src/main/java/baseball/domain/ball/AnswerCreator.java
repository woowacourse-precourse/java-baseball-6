package baseball.domain.ball;

import baseball.util.NumberPicker;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class AnswerCreator {

  private final NumberPicker numberPicker;

  public AnswerCreator(final NumberPicker numberPicker) {
    this.numberPicker = numberPicker;
  }

  public Answer create() {
    final Set<Integer> set = new HashSet<>();

    while (set.size() < BallNumbers.BALL_COUNT) {
      set.add(numberPicker.pick());
    }

    return Answer.of(new ArrayList<>(set));
  }
}
