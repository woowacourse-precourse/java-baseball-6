package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
  public static void main(String[] args) {
    List<Integer> randomNumbers = GenerateAnswer.generate();
    System.out.println(randomNumbers);
    boolean isAgain;

    do {
      System.out.print("숫자를 입력해 주세요 : ");
      String userInput = Console.readLine();

      try {
        validateUserInput(userInput);
        System.out.println("맞음");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }

      System.out.print("새 게임을 시작하려면 1을 입력하고, 종료하려면 2를 입력하세요: ");
      String againNumber = Console.readLine();

      isAgain = "1".equals(againNumber);

    } while (isAgain);
  }

  private static void validateUserInput(String userInput) {
    if (userInput.length() != 3) {
      throw new IllegalArgumentException("3자리 수를 입력해 주세요.");
    }

    Set<Character> uniqueChars = new HashSet<>();
    for (char c : userInput.toCharArray()) {
      int num = Character.getNumericValue(c);
      if (num < 1 || num > 9) {
        throw new IllegalArgumentException("입력값은 1~9 사이의 숫자만 포함해야 합니다.");
      }
      uniqueChars.add(c);
    }

    if (uniqueChars.size() != 3) {
      throw new IllegalArgumentException("입력값은 서로 다른 숫자여야 합니다.");
    }
  }
}
