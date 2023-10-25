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
    while (ComputerNum.size() < Constant.SIZE) {
      int randomNumber = Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER);
      if (!ComputerNum.contains(randomNumber)) {
        ComputerNum.add(randomNumber);
      }
    }
    //확인을 위한 코드
    System.out.println(ComputerNum);
  }

  public List<Integer> getComputerNum() {
    return ComputerNum;
  }
}
