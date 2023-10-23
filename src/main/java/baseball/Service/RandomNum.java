package baseball.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNum {
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 1;
    private static final int NUM_LEN = 3;

    public List<Integer> creatRandomNum() {
        List<Integer> RandomNum = new ArrayList<>();
        while (RandomNum.size() < NUM_LEN) {
            RandomNum.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
            if (!RandomNum.contains(randomNumber)) {
                RandomNum.add(randomNumber);
            }
        }
        return RandomNum;
    }
}
