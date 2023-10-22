package baseball;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    public static List<Integer> createRandomNumber() {
        List<Integer> nums = new ArrayList<>();
        while (nums.size() < 3) {
            int num = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9);
            if (!nums.contains(num)) {
                nums.add(num);
            }
        }
        return nums;
    }
}
