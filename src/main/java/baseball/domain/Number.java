package baseball.domain;

import baseball.handler.OutputHandler;
import baseball.utils.Convertor;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
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

  public int[] getNumbers() {
    return Arrays.copyOf(numbers, numbers.length);
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

  public boolean compareWithPlayerNumbers(int[] playerNumbers) {
    int strike = 0;
    int ball = 0;

    for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
      if (isStrike(playerNumbers[i], i)) {
        strike++;
        continue;
      }
      if (isBall(playerNumbers[i])) {
        ball++;
      }
    }

    OutputHandler.printGuessNumberResult(strike, ball);

    return strike == ALL_STRIKE;
  }

  private boolean isStrike(Integer playerNumber, int index) {
    return this.numbers[index] == playerNumber;
  }

  private boolean isBall(Integer playerNumber) {
    return Arrays.stream(numbers).anyMatch(number -> number == playerNumber);
  }
}
