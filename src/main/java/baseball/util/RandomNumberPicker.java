package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberPicker {

  private final int startInclusive;
  private final int endInclusive;

  public RandomNumberPicker(
      final int startInclusive,
      final int endInclusive
  ) {
    this.startInclusive = startInclusive;
    this.endInclusive = endInclusive;
  }

  public int pick() {
    return Randoms.pickNumberInRange(startInclusive, endInclusive);
  }
}
