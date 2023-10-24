package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> inputList;

    public Computer() {
        inputList = new ArrayList<Integer>();
        while (inputList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!inputList.contains(randomNumber)) {
                inputList.add(randomNumber);
            }
        }
    }
}