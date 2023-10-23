package baseball;

import static baseball.Constants.IN_GAME;

import java.util.ArrayList;
import java.util.List;

public class Referee {

  public Player player;
  List<Integer> numbers = new ArrayList<>();
  int ball;
  int strike;

  public Referee(Player player) {
    this.player = player;
  }

  public void announceGameStart() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }
  private void announceGameFinish() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }

  private void announceNothing() {
    System.out.println("낫싱");
  }
  public void inputGameNumbersMessage() {
    System.out.print("숫자를 입력해주세요 : ");
  }

  public void setGivenNumbers(List<Integer> givenNumbers) {
    numbers = givenNumbers;
  }

  public int determine(Player player) {

    ball = 0;
    strike = 0;
    for (int i = 0; i < IN_GAME[0]; i++) {
      if (player.checkSwingResult(numbers.get(i), i)) {
        strike++;
      } else {
        if (player.findBallAfterSwing(numbers.toString(), i)) {
          ball++;
        }
      }
    }
    if (strike + ball == 0) {
      announceNothing();
    } else if (strike == 0 && ball != 0) {
      System.out.println(ball + "볼");
    } else if (ball == 0 && strike != 0) {
      System.out.println(strike + "스트라이크");
    } else {
      System.out.println(ball + "볼 " + strike + "스트라이크");
    }
    if (strike == 3) {
      announceGameFinish();
      return 0;
    }
    return 1;
  }
}
