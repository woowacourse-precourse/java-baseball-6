package baseball;

import java.util.ArrayList;
import java.util.List;

public class Referee {

  List<Integer> numbers = new ArrayList<>();
  int ball;
  int strike;

  public Referee() {

  }

  public void startGameMessage() {
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  public void setGivenNumbers(List<Integer> givenNumbers) {
    numbers = givenNumbers;
  }

  public int determine(String input) {
    ball = 0;
    strike = 0;
    for (int i = 0; i < input.length(); i++) {
      if (numbers.get(i) == (input.charAt(i) - '0')) {
        strike++;
      } else {
        if (numbers.toString().contains(String.valueOf(input.charAt(i)))) {
          ball++;
        }
      }
    }
    if (strike + ball == 0) {
      System.out.println("낫싱");
    } else if (strike == 0 && ball != 0) {
      System.out.println(ball + "볼");
    } else if (ball == 0 && strike != 0) {
      System.out.println(strike + "스트라이크");
    } else {
      System.out.println(ball + "볼 " + strike + "스트라이크");
    }
    if (strike == 3) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      return 0;
    }
    return 1;
  }
}
