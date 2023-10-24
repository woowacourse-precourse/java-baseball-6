package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

  private static final int INPUT_LENGTH = 3;
  private static final int MIN_RANGE = 1;
  private static final int MAX_RANGE = 9;

  public List<Integer> getInput() {
    System.out.print("숫자를 입력해주세요 : ");
    String userInput = Console.readLine();

    validateUserInput(userInput);

    List<Integer> playerNumbers = new ArrayList<>();
    for (char c : userInput.toCharArray()) {
      playerNumbers.add(Character.getNumericValue(c));
    }

    return playerNumbers;
  }

  private static void validateUserInput(String userInput) {
    if (isEmpty(userInput)) {
      throw new IllegalArgumentException("Input cannot be empty");
    }
    if (!isCorrectLength(userInput)) {
      throw new IllegalArgumentException("입력값은 3자리입니다.");
    }
    if (!containsOnlyValidNumbers(userInput)) {
      throw new IllegalArgumentException("Number should be between 1 and 9");
    }
    if (!hasUniqueCharacters(userInput)) {
      throw new IllegalArgumentException("All numbers should be unique");
    }
  }

  private static boolean isEmpty(String userInput) {
    return userInput == null || userInput.trim().isEmpty();
  }

  private static boolean isCorrectLength(String userInput) {
    return userInput.length() == INPUT_LENGTH;
  }

  private static boolean containsOnlyValidNumbers(String userInput) {
    for (char c : userInput.toCharArray()) {
      int num = Character.getNumericValue(c);
      if (num < MIN_RANGE || num > MAX_RANGE) {
        return false;
      }
    }
    return true;
  }

  private static boolean hasUniqueCharacters(String userInput) {
    Set<Character> uniqueChars = new HashSet<>();
    for (char c : userInput.toCharArray()) {
      uniqueChars.add(c);
    }
    return uniqueChars.size() == INPUT_LENGTH;
  }
}
