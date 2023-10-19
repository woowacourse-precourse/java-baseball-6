package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    List<Integer> nums = new ArrayList<>();

    public void pickRandomNumber(int count) {
        nums.clear();
        while (nums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!nums.contains(randomNumber)) {
                nums.add(randomNumber);
            }
        }
    }
}