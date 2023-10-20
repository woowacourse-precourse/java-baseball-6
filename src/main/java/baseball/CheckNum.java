package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckNum {

  String result = ".";
  List<Integer> ComputerNum = new ArrayList<>();
  List<Integer> playerNum = new ArrayList<>();

  public CheckNum(List<Integer> ComputerNum, List<Integer> playerNum) {
    this.playerNum = playerNum;
    this.ComputerNum = ComputerNum;
  }


  public String Check() {
    int ball = 0;
    int strike = 0;

    for (int i = 0; i < 3; i++) {
      if (Objects.equals(playerNum.get(i), ComputerNum.get(i))) {
        strike++;
        continue;
      }
      for (int j = 0; j < 3; j++) {
        if (Objects.equals(playerNum.get(i), ComputerNum.get(j))) {
          ball++;
        }
      }
    }

    if (ball == 0 && strike == 0) {
      result = "낫싱";
    } else if (ball > 0 && strike > 0) {
      result = ball + "볼 " + strike + "스트라이크";
    } else if (strike > 0) {
      result = strike + "스트라이크";
    } else {
      result = ball + "볼";
    }

    return result;
  }
}
