package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BallNumber {
  private List<Integer> computer;

  public BallNumber() {
    makeBallNumber();
  }

  private void makeBallNumber() {  // 랜덤 숫자 만들기
    computer = new ArrayList<>(); // computer 숫자 (정답)
    while (computer.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }
  }

  public List<Integer> getComputer() {
    return computer;
  }
}
