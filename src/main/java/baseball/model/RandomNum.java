package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {
    public List<Integer> RandomNumber() {

        List<Integer> comNum = new ArrayList<>();
        while (comNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNum.contains(randomNumber)) {
                comNum.add(randomNumber);
            }

        }
        return comNum;
    }
}