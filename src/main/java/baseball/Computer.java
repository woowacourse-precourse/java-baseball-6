package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
  private static final int INPUT_SIZE = 3;
  public static List<Integer> createAnswer() {
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < INPUT_SIZE) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }

    return computer;
  }
}
