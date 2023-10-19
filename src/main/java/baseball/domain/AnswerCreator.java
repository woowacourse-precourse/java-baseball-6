package baseball.domain;

import baseball.util.RandomNumberPicker;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class AnswerCreator {

  private final RandomNumberPicker numberPicker = new RandomNumberPicker(1, 9);

  public BallNumbers create() {
    final Set<Integer> set = new HashSet<>();

    while (set.size() < BallNumbers.BALL_COUNT) {
      set.add(numberPicker.pick());
    }

    return BallNumbers.of(new ArrayList<>(set));
  }
}
