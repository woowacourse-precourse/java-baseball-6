package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
  public static void main(String[] args) {
    List<Integer> randomNumbers = GenerateAnswer.generate();
    System.out.print("숫자를 입력해 주세요 : ");
    String userInput = Console.readLine();

    try {
      validateUserInput(userInput);
      System.out.println("맞음");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    System.out.println(randomNumbers);
  }

  private static void validateUserInput(String userInput) {
    if (userInput.length() != 3) {
      throw new IllegalArgumentException("3자리 수를 입력해 주세요.");
    }

    for (char c : userInput.toCharArray()) {
      int num = Character.getNumericValue(c);
      if (num < 1 || num > 9) {
        throw new IllegalArgumentException("입력값은 1~9 사이의 숫자만 포함해야 합니다.");
      }
    }
  }

}
