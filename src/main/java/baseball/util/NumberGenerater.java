package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerater {


    public static List<Integer> getRandomNumbers(int size) {

        List<Integer> nums = new ArrayList<>();

        for (int i=0; i < size; i++) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!nums.contains(randomNumber)) {
                nums.add(randomNumber);
            }
        }
        return nums;
    }


}
