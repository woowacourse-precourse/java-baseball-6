package baseball;

import baseball.Exception.NumberValidator;
import baseball.utils.Score;
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

  /** 숫자 야구 게임을 시작하는 메소드 */
  public void start() {
    System.out.println("숫자 야구 게임을 시작합니다.");

    boolean isRestart = true;
    while (isRestart) {
      List<Integer> computerNumbers = computer.generateNumbers();
      NumberValidator.validateLength(computerNumbers);

      boolean isEnd = false;

      while (!isEnd) {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> playerNumbers = player.inputNumbers();
        NumberValidator.validateLength(playerNumbers);
        NumberValidator.validateRange(playerNumbers);
        int[] result = score.calculateScore(playerNumbers, computerNumbers);
        printResult(result);
        isEnd = isGameOver(result);
      }

      isRestart = askRestart();
    }

    System.out.println("게임을 종료합니다.");
  }

  /**
   * 볼과 스트라이크 결과에 따라 결과를 출력하는 메소드.
   *
   * @param result 볼과 스트라이크의 개수를 담은 int 배열. 배열의 첫 번째 요소는 볼의 개수, 두 번째 요소는 스트라이크의 개수
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
   * 게임이 종료되었는지를 확인하는 메소드.
   *
   * @param result 볼과 스트라이크의 개수를 담은 int 배열. 배열의 첫 번째 요소는 볼의 개수, 두 번째 요소는 스트라이크의 개수
   * @return 게임이 종료되었으면 true, 아니면 false
   */
  private boolean isGameOver(int[] result) {
    if (result[1] == 3) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      return true;
    }
    return false;
  }

  /**
   * 게임 재시작 여부를 확인합니다.
   *
   * @return 게임을 새로 시작할 경우 true, 종료할 경우 false를 반환합니다.
   */
  private boolean askRestart() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    int choice = player.inputNumbers().get(0);
    NumberValidator.checkResetNumber(choice);
    return choice == 1;
  }
}
