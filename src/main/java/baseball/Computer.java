package baseball;

import java.util.HashSet;
import java.util.Set;

public class Computer {

  static final int NUMBER_LENGTH = 3;
  static final int MAX_DIGIT = 9;
  static final int MIN_DIGIT = 1;

  private int randomNumber;

  public Computer() {
    this.randomNumber = generateUniqueRandomNumber();
  }


  public int getRandomNumber() {
    return randomNumber;
  }


  private int generateUniqueRandomNumber() {
    Set<Integer> randomDigitSet = generateRandomDigits();
    return convertSetToNumber(randomDigitSet);
  }

  private Set<Integer> generateRandomDigits() {
    Set<Integer> randomDigitSet = new HashSet<>();
    while (randomDigitSet.size() < NUMBER_LENGTH) {
      int number = (int) (Math.random() * MAX_DIGIT) + MIN_DIGIT;
      randomDigitSet.add(number);
    }
    return randomDigitSet;
  }

  private int convertSetToNumber(Set<Integer> digits) {
    var randomNumberString = new StringBuilder();
    digits.forEach(randomNumberString::append);
    return Integer.parseInt(randomNumberString.toString());
  }
}
