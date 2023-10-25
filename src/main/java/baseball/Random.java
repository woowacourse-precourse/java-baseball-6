package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Random {
    public List<Integer> createNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {

            int num = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(num)) {
                randomNumber.add(num);
            }
        }
        return randomNumber;
    }
}
