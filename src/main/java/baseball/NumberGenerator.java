package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer> generateNumberList() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

}
