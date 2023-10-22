package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

  int randomNumber;

  public Computer() {
    //TODO: 난수 생성 로직 리팩토링 필요
    List<Integer> computer = new ArrayList<>();
    String computerRandom = "";
    while (computer.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
        computerRandom += String.valueOf(randomNumber);
      }
    }
    this.randomNumber = Integer.parseInt(computerRandom);
  }


}
