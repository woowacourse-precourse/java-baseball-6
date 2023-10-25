package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

  private final static int NUMBER = 3;
  private final static int MIN_NUMBER = 1;
  private final static int MAX_NUMBER = 9;

  private List<Integer> ComputerNum = new ArrayList<>();

  public Computer() {
    GenerateRandomComputerNum();
  }

  public void GenerateRandomComputerNum() {
    while (ComputerNum.size() < NUMBER) {
      int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
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
