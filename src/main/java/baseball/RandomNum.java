package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNum {

    public List<Integer> makeRandomNum() {
        List<Integer> randomNum = new ArrayList<>();
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
        return randomNum;
    }
}