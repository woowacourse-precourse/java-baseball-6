package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    public static int[] pickRandomNum(int start, int end, int size) {

        List<Integer> randomNum = new ArrayList<>();
        while (randomNum.size() < size) {
            int temp = Randoms.pickNumberInRange(start, end);
            if (!randomNum.contains(temp)) {
                randomNum.add(temp);
            }
        }
        return randomNum.stream().mapToInt(i->i).toArray();
    }
}
