package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

  private List<Integer> Num = new ArrayList<>();

  public Computer() {
    GenerateRandomNum();
  }

  public void GenerateRandomNum() {
    while (Num.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!Num.contains(randomNumber)) {
        Num.add(randomNumber);
      }
    }
    System.out.println(Num);
  }

  public List<Integer> getNum() {
    return Num;
  }
}
