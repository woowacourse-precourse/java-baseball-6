package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Computer {

  static final int NUMBER_LENGTH = 3;
  static final int DIGIT_MAX = 9;
  static final int DIGIT_MIN = 1;
  int randomNumber;

  public Computer() {
  }

  public int getRandomNumber() {
    return randomNumber;
  }

  public void setRandomNumber() {
    this.randomNumber = generateRandomNumber();
  }

  private int generateRandomNumber() {
    String number = Stream.generate(() -> Randoms.pickNumberInRange(DIGIT_MIN, DIGIT_MAX))
        .map(String::valueOf)
        .distinct()
        .limit(NUMBER_LENGTH)
        .collect(Collectors.joining(""));
    return Integer.parseInt(number);
  }
}
