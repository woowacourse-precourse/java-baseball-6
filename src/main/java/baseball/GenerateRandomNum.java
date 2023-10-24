package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNum {

    public static List<Integer> generate() {
        List<Integer> nums = new ArrayList<>();

        while(nums.size() < 3) {
            int r = Randoms.pickNumberInRange(1,9);
            if(!nums.contains(r)) {
                nums.add(r);
            }
        }
        return nums;
    }

}
