package baseball;

import baseball.Exception.NumberValidator;
import java.util.List;

public class Game {

  private final Computer computer;
  private final Player player;
  private final Score score;

  public Game() {
    this.computer = new Computer();
    this.player = new Player();
    this.score = new Score();
  }

  /** 숫자 야구 게임을 시작합니다. */
  public void start() {
    System.out.println("숫자 야구 게임을 시작합니다.");

    boolean isRestart = true;
    while (isRestart) {
      List<Integer> computerNumbers = computer.generateNumbers();
      NumberValidator.validate(computerNumbers);

      boolean isEnd = false;

      while (!isEnd) {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> playerNumbers = player.inputNumbers();
        NumberValidator.validate(playerNumbers);
        int[] result = score.calculateScore(playerNumbers, computerNumbers);
        printResult(result);
        isEnd = isGameOver(result);
      }

      isRestart = askRestart();
    }

    System.out.println("게임을 종료합니다.");
  }
  /**
   CLI 콘솔창에 스트라이크와 볼의 갯수를 출력합니다.
   @param result 볼과 스트라이크 개수를 담고 있는 정수 배열입니다.
   */
  private void printResult(int[] result) {
    if (result[0] == 0 && result[1] == 0) {
      System.out.println("낫싱");
    }
    if (result[0] != 0 && result[1] == 0) {
      System.out.println(result[0] + "볼");
    }
    if (result[0] == 0 && result[1] != 0) {
      System.out.println(result[1] + "스트라이크");
    }
    if (result[0] != 0 && result[1] != 0) {
      System.out.printf("%d볼 %d스트라이크\n", result[0], result[1]);
    }
  }

  /**
   숫자야구 게임이 종료되었는지 여부를 확인합니다.
   @param result 볼과 스트라이크 개수를 담고 있는 정수 배열입니다.
   @return 게임이 종료되었으면 true, 아니면 false를 반환합니다.
   */
  private boolean isGameOver(int[] result) {
    if (result[1] == 3) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      return true;
    }
    return false;
  }

  /**
   게임 재시작 여부를 확인합니다.
   @return 게임을 새로 시작할 경우 true, 종료할 경우 false를 반환합니다.
   */
  private boolean askRestart() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    int choice = player.inputNumbers().get(0);
    return choice == 1;
  }
}
