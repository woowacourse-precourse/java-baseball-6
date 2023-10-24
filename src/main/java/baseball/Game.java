package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

  private List<Integer> answer;

  public Game() {
    this.answer = new ArrayList<>();
  }

  public void generateRandomNumber() {

    answer.clear();

    while (answer.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!answer.contains(randomNumber)) {
        answer.add(randomNumber);
      }
    }
  }

  public boolean checkNumber(List<Integer> player) {
    int strike = 0;
    int ball = 0;

    for (int i = 0; i < answer.size(); i++) {
      int now = player.get(i);
      if (answer.contains(now)) {
        if (i == answer.indexOf(now)) {
          strike++;
        } else {
          ball++;
        }
      }
    }

    if (strike > 0 && ball > 0) {
      System.out.println(ball + "볼 " + strike + "스트라이크");
    } else if (strike > 0 && ball == 0) {
      System.out.println(strike + "스트라이크");
    } else if (strike == 0 && ball > 0) {
      System.out.println(ball + "볼");
    } else if (strike == 0 && ball == 0) {
      System.out.println("낫싱");
    }

    return strike == 3;
  }

  public boolean restart(String input) {
    if (input.equals("1")) {
      return false;
    } else if (input.equals("2")) {
      return true;
    } else {
      throw new IllegalArgumentException();
    }
  }

}
