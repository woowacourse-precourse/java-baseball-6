package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final List<Integer> nums = new ArrayList<>();

    public void generateRandomNums() {
        while (nums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!nums.contains(randomNumber)) {
                nums.add(randomNumber);
            }
        }
    }

    public List<Integer> getNums() {
        return this.nums;
    }
}