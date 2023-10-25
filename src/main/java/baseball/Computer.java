package baseball;

import static baseball.BaseBallConst.NUM_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Computer {
    public HashMap<Integer, Integer> nums;

    public List<Integer> checkNums(List<Integer> nums) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUM_SIZE; i++) {
            int index = getIndexOfNum(nums.get(i));
            if (index == i + 1) {
                strike++;
            } else if (index > 0) {
                ball++;
            }
        }
        return Arrays.asList(strike, ball);
    }

    public Integer getIndexOfNum(Integer num) {
        if (nums.containsKey(num)) {
            return nums.get(num);
        }
        return 0;
    }

    public void generateNums() {
        nums = new HashMap<>();
        List<Integer> createNums = new ArrayList<>();
        while (createNums.size() < NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!createNums.contains(randomNumber)) {
                createNums.add(randomNumber);
            }
        }
        for (int index = 0; index < NUM_SIZE; index++) {
            System.out.println(createNums.get(index));
            nums.put(createNums.get(index), index + 1);
        }
    }
}
