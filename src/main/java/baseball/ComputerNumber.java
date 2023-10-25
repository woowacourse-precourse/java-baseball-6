package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumber {
  public List<Integer> ComputerNumber(){

    List<Integer> com_num = new ArrayList<>();
    while (com_num.size() < Application.size) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!com_num.contains(randomNumber)) {
            com_num.add(randomNumber);
        }
    }
    return com_num;
}
}
