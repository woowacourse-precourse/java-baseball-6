package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

  private static final int START_NUMBER = 1;
  private static final int END_NUMBER = 9;
  private static final int NUMBER_SIZE = 3;

  public List<Integer> generateUniqueNumbers() {
    List<Integer> numbers = new ArrayList<>();

    while (numbers.size() < NUMBER_SIZE) {
      int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
      if (!numbers.contains(randomNumber)) {
        numbers.add(randomNumber);
      }
    }

    return numbers;
  }
}
