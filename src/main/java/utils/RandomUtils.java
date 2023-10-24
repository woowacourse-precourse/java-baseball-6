package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {
    public static List<Integer> getRandomNumberList(int startInclusive, int endInclusive, int count) {

        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }

        return randomNumberList;
    }

}
