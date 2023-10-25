package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Game {
  private static final String RESTART_OPTION = "1";
  private static final String QUIT_OPTION = "2";

  private List<Integer> computerNumbers;

  public Game() {
    computerNumbers = generateRandomNumbers(3, 1, 9);
  }

  public void playGame() {
    System.out.println("숫자 야구 게임을 시작합니다.");

    while (true) {
      System.out.print("숫자를 입력해주세요 : ");
      String guessInput = Console.readLine();
      List<Integer> guessNumbers = parseGuessNumber(guessInput);

      if (guessNumbers.size() != 3) {
        throw new IllegalArgumentException("잘못된 입력입니다.");
      }

      int strikeCount = countStrikes(guessNumbers);
      int ballCount = countBalls(guessNumbers);
      int checkEnd = calculateResult(strikeCount, ballCount);
      if (checkEnd == 1) {
        restartGame();
      } else if (checkEnd == 2) {
        break;
      }
    }
  }

  private List<Integer> generateRandomNumbers(int count, int min, int max) {
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < count) {
      int randomNumber = Randoms.pickNumberInRange(min, max);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }
    return computer;
  }

  private List<Integer> parseGuessNumber(String guessNumber) {
    List<Integer> guessNumberList = new ArrayList<>();
    for (int i = 0; i < guessNumber.length(); i++) {
      char digitChar = guessNumber.charAt(i);
      if (Character.isDigit(digitChar)) {
        int digit = Character.getNumericValue(digitChar);
        guessNumberList.add(digit);
      } else {
        throw new IllegalArgumentException("입력이 숫자가 아닙니다.");
      }
    }
    return guessNumberList;
  }

  private int countStrikes(List<Integer> guessNumbers) {
    int strikeCount = 0;
    for (int i = 0; i < guessNumbers.size(); i++) {
      if (computerNumbers.get(i).equals(guessNumbers.get(i))) {
        strikeCount++;
      }
    }
    return strikeCount;
  }

  private int countBalls(List<Integer> guessNumbers) {
    int ballCount = 0;
    for (int i = 0; i < guessNumbers.size(); i++) {
      int guess = guessNumbers.get(i);
      if (computerNumbers.contains(guess) && !computerNumbers.get(i).equals(guess)) {
        ballCount++;
      }
    }
    return ballCount;
  }

  private int calculateResult(int strikeCount, int ballCount) {
    if (strikeCount == 3) {
      System.out.println("3스트라이크");
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      return restartOption();
    } else if (strikeCount == 0 && ballCount == 0) {
      System.out.println("낫싱");
      return 0;
    } else if (strikeCount != 0 && ballCount != 0) {
      String result = String.format("%d볼 %d스트라이크", ballCount, strikeCount);
      System.out.println(result);
      return 0;
    } else if (strikeCount != 0) {
      String result = String.format("%d스트라이크", strikeCount);
      System.out.println(result);
      return 0;
    } else {
      String result = String.format("%d볼", ballCount);
      System.out.println(result);
      return 0;
    }
  }

  private int restartOption() {
    String restart = Console.readLine();
    while (true) {
      if (!restart.equals(RESTART_OPTION) && !restart.equals(QUIT_OPTION)) {
        System.out.println("잘못된 값을 입력했습니다. 다시 입력해주십시오.");
        restart = Console.readLine();
      } else {
        break;
      }
    }
    return Character.getNumericValue(restart.charAt(0));
  }

  private void restartGame() {
    computerNumbers = generateRandomNumbers(3, 1, 9);
  }
}