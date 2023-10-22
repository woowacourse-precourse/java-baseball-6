package baseball.domain.number;

import static baseball.domain.number.Number.MAX_NUMERICAL_VALUE;
import static baseball.domain.number.Number.MIN_NUMERICAL_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumbers {

  private static final int RANDOM_NUMBER_LENGTH = 3;

  private final List<Number> randomNumbers;

  private RandomNumbers() {
    this.randomNumbers = generateNewRandomNumbers();
  }

  public static RandomNumbers create() {
    return new RandomNumbers();
  }

  private List<Number> generateNewRandomNumbers() {
    return Stream.generate(
            () -> Randoms.pickNumberInRange(MIN_NUMERICAL_VALUE, MAX_NUMERICAL_VALUE))
        .distinct()
        .limit(RANDOM_NUMBER_LENGTH)
        .map(Number::new)
        .collect(Collectors.toList());
  }

  public boolean contains(final Number number) {
    return randomNumbers.contains(number);
  }

  public Number get(final int index) {
    return randomNumbers.get(index);
  }
}
