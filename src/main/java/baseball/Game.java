package baseball;

import java.util.List;

public class Game {
  Player player = new Player();
  Computer computer = new Computer();

  public void startGame() {
    boolean restart = true;
    System.out.println("숫자 야구 게임을 시작합니다.");
    while (restart) {
      play();
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      restart = player.getRestart();
    }
  }

  public void play() {
    Result result = new Result();
    computer.makeAnswer();
    while (result.getStrike() != 3) {
      System.out.println("숫자를 입력해주세요 : ");
      List<Integer> input = player.getInput();
      result = computer.getResult(input);
      System.out.println(result.toString());
    }
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    computer.makeAnswer();
  }

}
