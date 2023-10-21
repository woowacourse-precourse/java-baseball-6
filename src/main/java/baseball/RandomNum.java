package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RandomNum {
    private static final int LENGTH = 3;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private ArrayList<Integer> nums = new ArrayList<>();

    public RandomNum() {
        while (nums.size() < LENGTH) {
            int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!nums.contains(randomNum)) {
                nums.add(randomNum);
            }
        }
    }
}
