package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
  private List<Integer> computer;

  public Computer(List<Integer> computer) {
    this.computer = computer;
  }

  public List<Integer> getComputer() {
    return computer;
  }

  public void makeRandomNumber() {
    while (computer.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }
  }

}
