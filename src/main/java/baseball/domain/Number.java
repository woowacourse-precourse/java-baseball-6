package baseball.domain;

import baseball.utils.Convertor;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class Number {

  private static final int MAX_NUMBER = 9;
  private static final int MIN_NUMBER = 1;
  private static final int NUMBER_OF_DIGITS = 3;
  private static final int ALL_STRIKE = 3;

  private int[] numbers;

  public Number() {
    this.numbers = new int[NUMBER_OF_DIGITS];
  }

  public void generateComputerNumbers() {
    this.numbers = createComputerNumbers();
  }

  public void changePlayerNumbers(int[] playerNumbers) {
    this.numbers = playerNumbers;
  }

  private int[] createComputerNumbers() {
    Set<Integer> generatedNumbers = new LinkedHashSet<>(NUMBER_OF_DIGITS);

    while (generatedNumbers.size() < NUMBER_OF_DIGITS) {
      generatedNumbers.add(getRandomNumber());
    }

    return Convertor.convertIntegerToInt(generatedNumbers);
  }

  private int getRandomNumber() {
    return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
  }
}
