package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RandomNum {
    public static final int LENGTH = 3;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    private ArrayList<Integer> nums = new ArrayList<>();

    public RandomNum() {
        while (nums.size() < LENGTH) {
            int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!nums.contains(randomNum)) {
                nums.add(randomNum);
            }
        }
    }

    public ArrayList<Integer> getNums() {
        return nums;
    }
}
