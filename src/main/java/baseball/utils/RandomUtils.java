package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {

    private RandomUtils() {}

    public static List<Integer> generateDistinctNumbers(int numberLength) {

        List<Integer> distinctNumberList = new ArrayList<>();

        while (distinctNumberList.size() < numberLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!distinctNumberList.contains(randomNumber)) {
                distinctNumberList.add(randomNumber);
            }
        }
        return distinctNumberList;
    }
}
