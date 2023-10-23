package baseball;

import java.util.List;

public class Game {
  private Player player;
  private Computer computer;
  private Score score;
  protected boolean isGameOver;

  public Game() {
    player = new Player();
    computer = new Computer();
    score = new Score();
    isGameOver = false;
  }

  public void start() {
    System.out.println("숫자 야구 게임을 시작합니다.");
    List<Integer> computerNumbers = computer.generateNumbers();
    while (!isGameOver) {
      List<Integer> playerNumbers = player.inputNumbers();
      int[] result = score.calculateScore(playerNumbers, computerNumbers); //result[0] = ballCount, result[1] = strikeCount
      printResult(result);
      System.out.println("실행됨 1");
      if (result[1] == 3) {
        System.out.println("실행됨 2");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        isGameOver = true;
      }
    }
  }

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
}