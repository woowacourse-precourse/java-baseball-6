package baseball;

import java.util.Scanner;

import static baseball.NumberBaseball.baseballGame;
import static baseball.StartGame.createThreeNums;
import static baseball.UserInput.userInput;

public class PlayGame {

  public static void playGame(Scanner sc) {
    String answer = createThreeNums();

    // 정답 확인용 출력 코드
    System.out.println("answer : " + answer);

    String message = "";
    do {
      String input = getUserInput(sc);
      message = baseballGame(input, answer);
      System.out.println(message);
    }
    while (!message.equals("3스트라이크"));
    displayEndMessage();
  }

  private static String getUserInput(Scanner sc) {
    return userInput(sc);
  }

  private static void displayEndMessage() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }


}
