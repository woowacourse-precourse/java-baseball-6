package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

  private List<Integer> ComputerNum = new ArrayList<>();

  public Computer() {
    GenerateRandomComputerNum();
  }

  public void GenerateRandomComputerNum() {
    while (ComputerNum.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!ComputerNum.contains(randomNumber)) {
        ComputerNum.add(randomNumber);
      }
    }
    System.out.println(ComputerNum);
  }

  public List<Integer> getComputerNum() {
    return ComputerNum;
  }
}
