package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private final static int MAX_LENGTH = 3;
    private final static int START_INCLUSIVE = 1;
    private final static int END_INCLUSIVE = 9;
    private final List<Integer> nums;

    RandomNumbers() {
        nums = new ArrayList<>();

        while (true) {
            if (nums.size() == MAX_LENGTH) {
                break;
            }
            int target = pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);

            if (nums.contains(target)) {
                continue;
            }
            nums.add(target);
        }
    }

    public List<Integer> getNums() {
        return nums;
    }
}
