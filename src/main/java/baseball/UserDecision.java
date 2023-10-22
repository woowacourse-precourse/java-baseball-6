package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDecision {

  public static String userDecision(Scanner sc) {
    displayEndMessage();
    String input = sc.next();
    checkUserDecision(input);
    return input;

  }

  private static void displayEndMessage() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }

  private static void checkUserDecision(String input) throws IllegalArgumentException {
    if (!(input.equals("1") || input.equals("2"))) {
      throw new IllegalArgumentException();
    }
  }

}
