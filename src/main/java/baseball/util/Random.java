package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Random {
    public List<Integer> createRandomNumberList(int size, int min, int max) {
        List<Integer> result = new ArrayList<>();
        int num = 0;

        while (num < size) {
            int randomNum = Randoms.pickNumberInRange(min, max);

            if (!result.contains(randomNum)) {
                result.add(randomNum);
                num++;
            }
        }
        return result;
    }
}
