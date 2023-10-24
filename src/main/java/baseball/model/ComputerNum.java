package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNum {
  public List<Integer> ComputerNumber(){

    List<Integer> computerNumber = new ArrayList<>();
    while (computerNumber.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computerNumber.contains(randomNumber)) {
        computerNumber.add(randomNumber);
      }
    }
    return computerNumber;
  }
}